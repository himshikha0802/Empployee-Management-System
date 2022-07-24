package com.election.Online.Voting.System.service.impl;

import com.election.Online.Voting.System.dto.DepartmentUpdateDto;
import com.election.Online.Voting.System.dto.UserUpdateDto;
import com.election.Online.Voting.System.model.Department;
import com.election.Online.Voting.System.model.User;
import com.election.Online.Voting.System.repository.DepartmentRepository;
import com.election.Online.Voting.System.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findById(int id) {
        Optional<Department> optionalDepartment=departmentRepository.findById(id);
        return optionalDepartment.orElseThrow(null);
    }

    @Override
    public Department findByName(String Departmentname) {
        return null;
    }

    @Override
    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

//    @Override
//    public Department updateDepartment(Department department) {
//        departmentRepository.findById(department.getId()).orElseThrow(()->new RuntimeException("Department not found"));
//        return departmentRepository.save(department);
//    }
    @Override
    public Department updateDepartment(DepartmentUpdateDto updateDto) {
        Department department=findById(updateDto.getId());
        department.setDepartmentname(updateDto.getDepartmentname());
        department.setDescription(updateDto.getDescription());
        department.setLocation(updateDto.getLocation());

        return departmentRepository.save(department);
    }

    @Override
    public String deleteDepartment(int id) {
        departmentRepository.findById(id).orElseThrow(()->new RuntimeException("Department not found"));
        departmentRepository.deleteById(id);
        return "Department deleted Successfully";
    }
}
