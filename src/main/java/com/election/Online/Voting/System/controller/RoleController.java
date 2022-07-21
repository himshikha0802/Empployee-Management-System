package com.election.Online.Voting.System.controller;

import com.election.Online.Voting.System.dto.RoleUpdateDto;
import com.election.Online.Voting.System.dto.UserUpdateDto;
import com.election.Online.Voting.System.model.Role;
import com.election.Online.Voting.System.model.User;
import com.election.Online.Voting.System.service.RoleService;
import com.election.Online.Voting.System.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

    @RestController
    @RequestMapping("/roles")
    public class RoleController {
        //to link autowired used
        @Autowired
        private RoleService roleService;
        @GetMapping
        public List<Role> getAll(){
            return  roleService.getAllRoles();
        }

       @GetMapping("/{id}")
        public Role getById(@PathVariable int id){
            return roleService.findById(id);
        }

        @PostMapping
        public Role addRole(@RequestBody Role role){
            return roleService.addRole(role);
        }

        @PutMapping //to update
        public Role updateRole(@RequestBody @Valid RoleUpdateDto role){
            //  return userService.updateUser(user);

            Role updatedRole =roleService.updateRole(role);
            return updatedRole;

        }
        @DeleteMapping("/{id}")
        public String deleteRole(@PathVariable int id){
            return roleService.deleteRole(id);
        }



    }
