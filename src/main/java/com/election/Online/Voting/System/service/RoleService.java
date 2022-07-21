package com.election.Online.Voting.System.service;

import com.election.Online.Voting.System.dto.RoleUpdateDto;
import com.election.Online.Voting.System.dto.UserUpdateDto;
import com.election.Online.Voting.System.model.Role;
import com.election.Online.Voting.System.model.User;

import java.util.List;

public interface RoleService {
   Role addRole(Role role);
   List<Role> getAllRoles();
   Role findById(int id);
   Role updateRole(RoleUpdateDto role);
   String deleteRole(int id);


}
