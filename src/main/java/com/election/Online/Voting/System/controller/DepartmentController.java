package com.election.Online.Voting.System.controller;


import com.election.Online.Voting.System.dto.DepartmentUpdateDto;
import com.election.Online.Voting.System.dto.UserUpdateDto;
import com.election.Online.Voting.System.model.Department;
import com.election.Online.Voting.System.model.User;
import com.election.Online.Voting.System.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Department> getAll(){
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable int id){
        return  departmentService.findById(id);
    }

    @PostMapping
    public Department addDepartment(@RequestBody Department department){
        return  departmentService.addDepartment(department);
    }

    @PutMapping //to update
    public Department updateDepartment(@RequestBody @Valid DepartmentUpdateDto department){
        //  return userService.updateUser(user);

        Department updatedDepartment =departmentService.updateDepartment(department);
        return updatedDepartment;

    }
    @DeleteMapping("/{id}")
    public  String deleteDepartment(@PathVariable int id){
        return  departmentService.deleteDepartment(id);
    }
}
