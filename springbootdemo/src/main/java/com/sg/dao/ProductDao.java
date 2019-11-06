package com.sg.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sg.entity.Product;

//Most functions needed for operations are present in the JpaRepository, Only if you need 
//custom function should we write in this class. Check for existing functions in JpaRepository
//One DAO per table and service should come at the top of a DAO such that DAO is never exposed
public interface ProductDao extends JpaRepository<Product, Integer> {
	//becomes where Category = category, and you can use it like findByAAndB becomes 
	// WHERE A = parameter AND B = parameter2; Note that findBy uses the arguments passed as 
	//equal to for your query A= Parameter1 (not greater or less than). For such queries we use
	//getBy.
	List<Product> findByCategory(String category);
	
	@Query("select p from Product p where p.price >= :pr")
	List<Product> getByPrice(@Param("pr") double price);
}
