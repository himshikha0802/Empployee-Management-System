package com.election.Online.Voting.System.service;

import com.election.Online.Voting.System.dto.EmployeeUpdateDto;
import com.election.Online.Voting.System.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee findById(int id);
    Employee findByName(String name);
    Employee addEmployee(Employee employee);
    Employee updateEmployee(EmployeeUpdateDto employee);
    String deleteEmployee(int id);
}
