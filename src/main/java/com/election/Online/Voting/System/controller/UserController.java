package com.election.Online.Voting.System.controller;

import com.election.Online.Voting.System.dto.UserUpdateDto;
import com.election.Online.Voting.System.model.User;
import com.election.Online.Voting.System.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/users")
public class UserController {
    //to link autowired used
    @Autowired
    private UserService userService;
    @GetMapping
    public List<User> getAll(){
        return  userService.getAllUsers();
    }

    @GetMapping("/{id}")//to read
    public User findById(@PathVariable int id){
        return userService.findById(id);
    }
    @PostMapping//to add
    public User addUser(@RequestBody @Valid User user){
        return userService.addUser(user);
    }
    @PutMapping //to update
    public User updateUser(@RequestBody @Valid UserUpdateDto user){
        //  return userService.updateUser(user);

        User updatedUser =userService.updateUser(user);
        return updatedUser;

    }
    @DeleteMapping("/{id}")
    public  String deleteUser(@PathVariable int id){
        return userService.deleteUser(id);
    }

}
