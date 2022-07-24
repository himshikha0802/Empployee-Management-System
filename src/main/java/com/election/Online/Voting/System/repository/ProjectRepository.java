package com.election.Online.Voting.System.repository;

import com.election.Online.Voting.System.model.Employee;
import com.election.Online.Voting.System.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectRepository  extends JpaRepository<Project,Integer> {
    Optional<Project> findById(String id);
}
