package com.election.Online.Voting.System.controller;

import com.election.Online.Voting.System.dto.EmployeeUpdateDto;
import com.election.Online.Voting.System.dto.ProjectUpdateDto;
import com.election.Online.Voting.System.model.Employee;
import com.election.Online.Voting.System.model.Project;
import com.election.Online.Voting.System.model.Role;
import com.election.Online.Voting.System.service.ProjectService;
import com.election.Online.Voting.System.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<Project> getAll() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public Project getById(@PathVariable int id) {
        return projectService.findById(id);
    }

    @PostMapping
    public Project addProject(@RequestBody Project project) {
        return projectService.addProject(project);
    }

    @PutMapping //to update
    public Project updateProject(@RequestBody @Valid ProjectUpdateDto project) {
        //  return userService.updateUser(user);
        Project updatedProject = projectService.updateProject(project);
        return updatedProject;
    }

    @DeleteMapping
    public String deleteProject(@PathVariable int id) {
        return projectService.deleteProject(id);
    }
}
