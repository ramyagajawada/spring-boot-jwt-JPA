package com.javainuse.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.dao.UserRepository;
import com.javainuse.model.User;
@RestController

@RequestMapping("/user")


public class UserController {
	Logger log = LoggerFactory.getLogger(UserController.class);
	@Autowired

	private UserRepository userRep;

	

	@GetMapping("/getUser")

	public Iterable<User> getUser()

	{
		log.info("Request for all admin details");
		return userRep.findAll();

	}

	@PostMapping("/saveUser")

	public User saveUser(@RequestBody User user)

	{

		System.out.println(user);

		User savedUser=userRep.save(user);

		return savedUser;

	}

	@PutMapping("/putUser/{userid}")

	public User updateUser(@RequestBody User user, @PathVariable("userid") Long userid)

	{
		 log.info("Request for updating : " + userid);
		User foundUser = findOneUser(userid);
		if (foundUser != null) {
			foundUser.setConfirmed(user.getConfirmed());
			foundUser.setEmail(user.getEmail());
			
			foundUser.setUserid(user.getUserid());
			foundUser.setUsername(user.getUsername());
			foundUser.setUserpwd(user.getUserpwd());
		}


		User savedUser=userRep.save(foundUser);

		return savedUser;
	}

	@DeleteMapping("/deleteUser/{userid}")

	public boolean deleteUser(@PathVariable("userid") Long userid)

	{
		log.info("Request for deleting : " + userid);
		System.out.println(userid);
		Optional<User> user = userRep.findById(userid);
		if (user == null) {

			throw new RuntimeException("No value present");

		}
		userRep.deleteById(userid);

		return true;

	}

	@GetMapping("/findOneUser/{userid}")

	public User findOneUser(@PathVariable("userId") Long userid)

	{
		log.info("Request recieved for: " + userid);
		Optional<User> user = userRep.findById(userid);

		return user.get();

	}

	
}
