package com.election.Online.Voting.System.service.impl;

import com.election.Online.Voting.System.dto.UserUpdateDto;
import com.election.Online.Voting.System.exception.NotFoundException;
import com.election.Online.Voting.System.model.User;
import com.election.Online.Voting.System.repository.UserRepository;
import com.election.Online.Voting.System.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        Optional<User> optionalUser = userRepository.findById(id);//alt+ctrl+v
      //  if(optionalUser.isPresent()){(user -> );}

        return  optionalUser.orElseThrow(()->new NotFoundException(("User not found:")+id));

    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public User addUser(User user) {
       String encodedPassword= bCryptPasswordEncoder.encode(user.getPassword());
       user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(UserUpdateDto updateDto) {
        User user=findById(updateDto.getId());
        user.setFullName(updateDto.getFullName());
        user.setAddress(updateDto.getAddress());
        user.setAge(updateDto.getAge());
        user.setGender(updateDto.getGender());
        return userRepository.save(user);
    }
    @Override
    public String deleteUser(int id) {
        findById(id);
        userRepository.deleteById(id);
        return  "User Deleted Successfully";
    }


}
