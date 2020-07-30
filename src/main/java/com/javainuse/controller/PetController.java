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

import com.javainuse.dao.PetRepository;
import com.javainuse.model.Pet;

@RestController

@RequestMapping("/pet")
public class PetController {
	Logger log = LoggerFactory.getLogger(PetController.class);
	@Autowired

	private PetRepository petRep;

	@GetMapping("/getPet")

	public Iterable<Pet> getPet()

	{
		log.info("Request for all admin details");
		return petRep.findAll();

	}

	@PostMapping("/savePet")

	public Pet savePet(@RequestBody Pet pet)

	{

		System.out.println(pet);

		petRep.save(pet);

		return pet;

	}

	@PutMapping("/putPet/{petid}")

	public Pet updatePet(@RequestBody Pet pet, @PathVariable("petid") Long petid)

	{
		log.info("Request for updating : " + petid);
		pet.setPetid(petid);

		System.out.println(pet);

		petRep.save(pet);

		return pet;

	}

	@DeleteMapping("/deletePet/{petid}")

	public boolean deletePet(@PathVariable("petid") Long petid)

	{
		log.info("Request for deleting : " + petid);
		System.out.println(petid);
		Optional<Pet> pet = petRep.findById(petid);

		if (pet == null) {

			throw new RuntimeException("No value present");

		}
		petRep.deleteById(petid);

		return true;

	}

	@GetMapping("/findOneInAll/{petid}")

	public Pet findOneInAll(@PathVariable("petid") Long petid)

	{
		log.info("Request recieved for: " + petid);

		Optional<Pet> pet = petRep.findById(petid);

		return pet.get();

	}

	
}
