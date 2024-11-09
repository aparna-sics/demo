package com.example.EmployeeManagement.mapper;

import com.example.EmployeeManagement.dto.EmployeeDto;
import com.example.EmployeeManagement.entity.Employee;

public class EmployeeMapper {
    public  static EmployeeDto mapToEmployeeDto(Employee employee)
    {
        return  new EmployeeDto(
                employee.getId(),
                employee.getName(),
                employee.getAge(),
                employee.getDept(),
                employee.getSalary(),
                employee.getUsername(),
                employee.getPassword()
        );
    }
    public  static  Employee mapToEmployee(EmployeeDto employeeDto){
        return  new Employee(
                employeeDto.getId(),
                employeeDto.getName(),
                employeeDto.getAge(),
                employeeDto.getDept(),
                employeeDto.getSalary(),
                employeeDto.getUsername(),
                employeeDto.getPassword()
                
        );
    }
}
