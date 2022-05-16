package com.spring.andre.demo.repository;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.andre.demo.model.Home;

@Repository
public interface HomeRepository extends JpaRepository<Home, Serializable> {

	Home findByLocation(String location);

	@Transactional
	@Query("select h from Home h where id = :id")
	Home findOne(int id);

	// it will be resposible to returning the image by searching from is name
	Home findByTitle(String imageName);

}
