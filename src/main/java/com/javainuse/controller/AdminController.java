package com.javainuse.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.dao.AdminRepository;
import com.javainuse.model.Admin;

@RestController
@RequestMapping("/admin")

public class AdminController {
	
	Logger log = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	

	private AdminRepository adminRepository;

	@GetMapping("/getAlladmin")

	public Iterable<Admin> getAlladmin() {
		 log.info("Request for all admin details");

		return adminRepository.findAll();

	}

	@PostMapping("/saveadmin")

	public Admin saveAdmin(@RequestBody Admin admin) {

		System.out.println(admin);

		adminRepository.save(admin);

		return admin;

	}

	@DeleteMapping("/deleteadmin/{adminid}")

	public Boolean deleteAdmin(@PathVariable("adminid") Long adminid) {
		log.info("Request for deleting : " + adminid);
		System.out.println(adminid);
		Optional<Admin> admin = adminRepository.findById(adminid);

		if (admin == null) {

			throw new RuntimeException("No value present");

		}

		adminRepository.delete(admin.get());
		
		return true;

	}

	@GetMapping("/findOneInAll/{adminid}")

	public Admin findoneinall(@PathVariable("adminid") Long adminid) {
		log.info("Request recieved for: " + adminid);
		Optional<Admin> admin = adminRepository.findById(adminid);
		

		
		return admin.get();

	}

}
