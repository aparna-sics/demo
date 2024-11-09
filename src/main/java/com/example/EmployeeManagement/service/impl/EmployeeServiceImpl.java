package com.example.EmployeeManagement.service.impl;

import com.example.EmployeeManagement.Exception.EmployeeNotFoundException;
import com.example.EmployeeManagement.Exception.InvalidCredentials;
import com.example.EmployeeManagement.dto.EmployeeDto;

import com.example.EmployeeManagement.dto.LoginDto;
import com.example.EmployeeManagement.entity.Employee;
import com.example.EmployeeManagement.mapper.EmployeeMapper;
import com.example.EmployeeManagement.repository.EmployeeRepository;
import com.example.EmployeeManagement.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private  EmployeeRepository employeeRepository;
    @Autowired
    //private FileDbRepository fileDbRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee=EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee=employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee=employeeRepository.findById(id)
                .orElseThrow(()->new EmployeeNotFoundException("Id not Exist"));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employee=employeeRepository.findAll();
        return employee.stream().map((employee1)->
                EmployeeMapper.mapToEmployeeDto(employee1)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto updatedEmployee) {
        Employee employee=employeeRepository.findById(id).orElseThrow(
                ()-> new EmployeeNotFoundException("Id not exist")
        );
        employee.setName(updatedEmployee.getName());
        employee.setAge(updatedEmployee.getAge());
        employee.setDept(updatedEmployee.getDept());
        employee.setSalary(updatedEmployee.getSalary());
        Employee update=employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(update);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee=employeeRepository.findById(id).orElseThrow(
                ()-> new EmployeeNotFoundException("Not Exist")
        );

        employeeRepository.deleteById(id);
    }

    @Override
    public void getEmployeeByUserOrPass(LoginDto loginDto) {
        int count = employeeRepository.countByUsername(loginDto.getUsername());
        if (count == 0) {
            throw new InvalidCredentials("Username does not exist");
        }

        Employee employee = employeeRepository.findEmployeeByUserOrPass(loginDto.getUsername(), loginDto.getPassword());
        if (employee == null) {
            throw new InvalidCredentials("Invalid password");
        }


    }


}

