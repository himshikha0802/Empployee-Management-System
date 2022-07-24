package com.election.Online.Voting.System.service;

import com.election.Online.Voting.System.dto.ProjectUpdateDto;
import com.election.Online.Voting.System.model.Employee;
import com.election.Online.Voting.System.model.Project;

import java.util.List;

public interface ProjectService
{
    List<Project> getAllProjects();
    Project findById(int id);
    Project findByName(String pname);
    Project addProject(Project project);
    Project updateProject(ProjectUpdateDto project);
    String deleteProject(int id);

}
