package com.election.Online.Voting.System.repository;

import com.election.Online.Voting.System.model.Employee;
import com.election.Online.Voting.System.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Optional<Employee> findById(String id);
}

