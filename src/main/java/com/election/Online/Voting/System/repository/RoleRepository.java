package com.election.Online.Voting.System.repository;

import com.election.Online.Voting.System.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RoleRepository  extends JpaRepository<Role,Integer> {

}
