package com.election.Online.Voting.System.service;

import com.election.Online.Voting.System.dto.DepartmentUpdateDto;
import com.election.Online.Voting.System.model.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartments();
    Department findById(int id);
    Department findByName(String Departmentname);
    Department addDepartment(Department department);
    Department updateDepartment(DepartmentUpdateDto department);
    String deleteDepartment(int id);
}
