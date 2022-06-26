package com.Revature.Study_Buddy_Backend.Controller;

import com.Revature.Study_Buddy_Backend.Exceptions.UserNotFoundException;
import com.Revature.Study_Buddy_Backend.Model.User;
import com.Revature.Study_Buddy_Backend.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserResource {

    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);

    }

    @GetMapping("/{userid}")
    public ResponseEntity<User> getUserById(@PathVariable("userid") Long userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        List<User> userList = userService.getAllUser();
        for(User findUser : userList){
            if(findUser.getEmail() == user.getEmail()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        try {
            userService.getUserById(user.getUserId());
            return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);

        } catch (Exception err) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/delete/{userid}")
    public ResponseEntity<?> deleteUser(@PathVariable("userid") Long userId) {
        try {
            userService.deleteUser(userId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception err) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    //finding user by email and password
    @PostMapping("/finduser")
    public ResponseEntity<User> findUserbyemailANDpasswd(@RequestBody User user) {
        try {
            return new ResponseEntity<>(userService.findUserByEmailAndPasswd(user), HttpStatus.OK);
        } catch (Exception err) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
