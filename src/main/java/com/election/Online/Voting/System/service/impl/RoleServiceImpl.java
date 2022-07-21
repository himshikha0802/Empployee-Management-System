package com.election.Online.Voting.System.service.impl;

import com.election.Online.Voting.System.dto.RoleUpdateDto;
import com.election.Online.Voting.System.dto.UserUpdateDto;
import com.election.Online.Voting.System.exception.NotFoundException;
import com.election.Online.Voting.System.model.Role;
import com.election.Online.Voting.System.model.User;
import com.election.Online.Voting.System.repository.RoleRepository;
import com.election.Online.Voting.System.repository.UserRepository;
import com.election.Online.Voting.System.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(int id) {
        return roleRepository.findById(id).orElseThrow(()->new NotFoundException("Role not found"+id));
    }

    @Override
    public Role updateRole(RoleUpdateDto updateDto) {
        Role role=findById(updateDto.getId());
        role.setName(updateDto.getName());
        return roleRepository.save(role);
    }

    @Override
    public String deleteRole(int id) {
       // roleRepository.findById(id).orElseThrow(()->new NotFoundException("Role not found"+id));
        findById(id);
        roleRepository.deleteById(id);
        return "Role Deleted Successfully";
    }
}
