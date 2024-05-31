package com.project.cmsproject.repsoitories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.cmsproject.entities.Features;
import com.project.cmsproject.entities.Product;



@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	public Optional<Product> findById(Long Id);
	public Optional<Product> findByName(String name);
}