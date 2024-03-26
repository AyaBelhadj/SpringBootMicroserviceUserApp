package com.example.userApp.userAPI.service;

import com.example.userApp.userAPI.model.User;
import com.example.userApp.userAPI.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository ;

    public List<User> getUsers(){
        return userRepository.findAll();
    }
    @Transactional
    public void addNewUser(User user){
        userRepository.save(user);
    }
    public User getUserById(String id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }
    @Transactional
    public void updateUser(String id, User user) {
        Optional<User> optionalExistingUser = userRepository.findById(id);
        if (optionalExistingUser.isPresent()) {
            User existingUser = optionalExistingUser.get();
            existingUser.setUsername(user.getUsername());
            existingUser.setEmail(user.getEmail());
            // Update other fields as needed
            userRepository.save(existingUser);
        }
    }

    @Transactional
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
