package com.Revature.Study_Buddy_Backend.Repository;

import com.Revature.Study_Buddy_Backend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

     Optional <User> findUserByEmailAndPasswd(String email, String password);
      Optional<User>findByuserId(Long userId);

}
