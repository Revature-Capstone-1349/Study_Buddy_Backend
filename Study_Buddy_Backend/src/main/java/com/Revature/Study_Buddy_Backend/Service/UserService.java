package com.Revature.Study_Buddy_Backend.Service;

import com.Revature.Study_Buddy_Backend.Exceptions.UserNotFoundException;
import com.Revature.Study_Buddy_Backend.Model.User;
import com.Revature.Study_Buddy_Backend.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

// hello
@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    public User getUserById(Long userId) {
        return userRepo.findByuserId(userId).orElseThrow(() -> new UserNotFoundException("User Id" + userId + "not found"));
    }

    public User addUser(User user) {
        return userRepo.save(user);
    }

    public User updateUser(User user) {
        return userRepo.save(user);
    }

    public ResponseEntity<?> deleteUser(Long userId) {
        User userexist1 = getUserById(userId);
        try {
            userRepo.delete(userexist1);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Error error) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    public User findUserByEmailAndPasswd(User user) {
        User user1 = userRepo.findUserByEmailAndPasswd(user.getEmail(), user.getPasswd())
                .orElseThrow(() -> new UserNotFoundException("login failed"));
        return user1;
    }
}