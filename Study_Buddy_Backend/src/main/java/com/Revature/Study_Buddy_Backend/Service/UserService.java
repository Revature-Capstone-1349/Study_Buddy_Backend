package com.Revature.Study_Buddy_Backend.Service;

import com.Revature.Study_Buddy_Backend.Model.User;
import com.Revature.Study_Buddy_Backend.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public List<User>getAllUser(){
       return userRepo.findAll();
    }

    public User getUserById(Long id){
        return userRepo.findById(id).get();
    }

    public User addUser(User user){
        return userRepo.save(user);
    }

    public User updateUser(User user ){
//        User Study_Buddy=userRepo.findById(user.getUserid()).get();

       return userRepo.save(user);
    }

    public void deleteUser(Long id){
        userRepo.deleteById(id);
    }

}
