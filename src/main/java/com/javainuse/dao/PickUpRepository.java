package com.javainuse.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javainuse.model.PickUp;


public interface PickUpRepository extends JpaRepository<PickUp,Long> {
	
}
