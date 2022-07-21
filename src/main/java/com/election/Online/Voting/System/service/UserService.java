package com.election.Online.Voting.System.service;

import com.election.Online.Voting.System.dto.UserUpdateDto;
import com.election.Online.Voting.System.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User findById(int id);
    User findByUsername(String username);
    User addUser(User user);

    User updateUser(UserUpdateDto user);

    String deleteUser(int id);
}
