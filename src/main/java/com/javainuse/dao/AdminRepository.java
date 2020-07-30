package com.javainuse.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javainuse.model.Admin;
@Repository
public interface AdminRepository extends CrudRepository<Admin,Long> {
	Iterable<Admin> findAll();
}
