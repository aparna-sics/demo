package com.example.EmployeeManagement.repository;

import com.example.EmployeeManagement.dto.LoginDto;
import com.example.EmployeeManagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query("SELECT e FROM Employee e WHERE e.username = :username AND e.password = :password")
    Employee findEmployeeByUserOrPass(@Param("username") String username, @Param("password") String password);

    @Query("SELECT COUNT(username) FROM Employee e WHERE e.username = :username")
    int countByUsername(@Param("username") String username);

}
