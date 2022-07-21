package com.election.Online.Voting.System.service.impl;

import com.election.Online.Voting.System.dto.EmployeeUpdateDto;
import com.election.Online.Voting.System.dto.UserUpdateDto;
import com.election.Online.Voting.System.exception.NotFoundException;
import com.election.Online.Voting.System.model.Employee;
import com.election.Online.Voting.System.model.User;
import com.election.Online.Voting.System.repository.EmployeeRepository;
import com.election.Online.Voting.System.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> optionalEmployee=employeeRepository.findById(id);
        return optionalEmployee.orElseThrow(()->new NotFoundException(("Employee not found:")+id));
    }

    @Override
    public Employee findByName(String name) {
        return null;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

//    @Override
//    public Employee updateEmployee(Employee employee) {
//        employeeRepository.findById(employee.getId()).orElseThrow(()->new RuntimeException("Employee not found"));
//        return employeeRepository.save(employee);
//    }
@Override
public Employee updateEmployee(EmployeeUpdateDto updateDto) {
    Employee employee=findById(updateDto.getId());
    employee.setAddress(updateDto.getAddress());
    employee.setAge(updateDto.getAge());
    employee.setDepartment(updateDto.getDepartment());
    employee.setEmail(updateDto.getEmail());
    employee.setGender(updateDto.getGender());
    employee.setImage(updateDto.getImage());
    employee.setMobile(updateDto.getMobile());
    employee.setName(updateDto.getName());
    employee.setSalary(updateDto.getSalary());

    return employeeRepository.save(employee);
}

    @Override
    public String deleteEmployee(int id) {
        employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Employee not found"));
        employeeRepository.deleteById(id);
        return "Employee deleted successfully";
    }
}
