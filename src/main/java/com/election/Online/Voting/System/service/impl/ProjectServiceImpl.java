package com.election.Online.Voting.System.service.impl;

import com.election.Online.Voting.System.dto.ProjectUpdateDto;
import com.election.Online.Voting.System.exception.NotFoundException;
import com.election.Online.Voting.System.model.Employee;
import com.election.Online.Voting.System.model.Project;
import com.election.Online.Voting.System.repository.ProjectRepository;
import com.election.Online.Voting.System.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project findById(int id) {
        Optional<Project> optionalProject=projectRepository.findById(id);
        return optionalProject.orElseThrow(()->new NotFoundException(("Project not found:")+id));
    }

    @Override
    public Project findByName(String pname) {
        return null;
    }

    @Override
    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project updateProject(ProjectUpdateDto updateDto) {
        Project project1=findById(updateDto.getId());
        project1.setPname(updateDto.getPname());
        project1.setDescription(updateDto.getDescription());

        project1.setPhr(updateDto.getPhr());
        project1.setPamount(updateDto.getPamount());
        project1.setTmembers(updateDto.getTmembers());

        return projectRepository.save(project1);
    }

    @Override
    public String deleteProject(int id) {
        projectRepository.findById(id).orElseThrow(()->new RuntimeException("Project not found"));
        projectRepository.deleteById(id);
        return "Project deleted successfully";
    }
}

