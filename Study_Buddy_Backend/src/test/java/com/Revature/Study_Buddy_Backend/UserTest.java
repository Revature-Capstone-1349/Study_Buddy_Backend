package com.Revature.Study_Buddy_Backend;

import com.Revature.Study_Buddy_Backend.Model.User;
import com.Revature.Study_Buddy_Backend.Repository.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class UserTest {
	@Autowired
	UserRepo userRepo;

	@Test
	public void testAddUser(){
		User user = new User();
		user.setEmail("c@gmail.com");
		user.setPasswd("testing");
		user.setName("Castella");
		userRepo.save(user);
		assertNotNull(userRepo.findByuserId(3L));
	}

	@Test
	public void testUserList(){
		List<User> userList = userRepo.findAll();
		assertThat(userList).size().isGreaterThan(0);
		System.out.println("User list: " + userList.size());
	}

	@Test
	public void testGetUserId(){
		User user = userRepo.findByuserId(4L);
		assertNotNull(user);
		System.out.println(user);
	}

	@Test
	public void testDeleteUser(){
		User user = userRepo.findByuserId(4L);
		userRepo.delete(user);
		System.out.println(user);
	}

}
