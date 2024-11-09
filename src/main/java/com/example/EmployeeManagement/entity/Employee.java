package com.example.EmployeeManagement.entity;

import jakarta.persistence.*;
import lombok.*;




@Entity
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "emp_id",nullable = false)
    private  Long id;
    @Column(name = "emp_name")
    private  String name;
    @Column(name = "emp_age")
    private Integer age;
    @Column(name = "emp_dept")
    private String dept;
    @Column(name = "emp_salary")
    private Long salary;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    public Employee() {
    }

//    public Employee(Long id, String name, Integer age, String dept, Long salary,String username,String password) {
//        this.id = id;
//        this.name = name;
//        this.age = age;
//        this.dept = dept;
//        this.salary = salary;
//        this.username=username;
//        this.password=password;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public String getDept() {
//        return dept;
//    }
//
//    public Long getSalary() {
//        return salary;
//    }
//    public String getUsername() {
//        return username;
//    }
//    public String getPassword() {
//        return password;
//    }
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public void setDept(String dept) {
//        this.dept = dept;
//    }
//
//    public void setSalary(Long salary) {
//        this.salary = salary;
//    }
//    public void setUsername(String username) {
//        this.username= username;
//    }
//    public void setPassword() {
//        this.username=username;
//    }
}
