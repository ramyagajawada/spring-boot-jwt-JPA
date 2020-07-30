package com.javainuse.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javainuse.model.Pet;
@Repository
public interface PetRepository extends CrudRepository<Pet,Long>{
	Iterable<Pet> findAll();
}
