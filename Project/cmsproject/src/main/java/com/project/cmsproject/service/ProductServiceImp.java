package com.project.cmsproject.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.cmsproject.entities.Product;
import com.project.cmsproject.exceptions.ProductNotFoundException;
import com.project.cmsproject.repsoitories.ProductRepository;
@Service
public class ProductServiceImp implements ProductService {

	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImp.class);
	@Autowired
	private ProductRepository repo;
	
	
	@Override
	public Product createproduct(Product product) {
		// TODO Auto-generated method stub
		
		
		return repo.save(product);
	}


	@Override
	public Product getProductById(Long productId) throws  ProductNotFoundException {
		Optional<Product> product = repo.findById(productId);
		if(product.isPresent()) {
			logger.info("Product "+productId+" exists in record");
			return product.get();
		}else {
			logger.error("Product "+productId+" doesn't exists");
			throw new ProductNotFoundException("Product "+productId+"doesn't exists");

		}
	}


	@Override
	public Product getProductByName(String name) throws ProductNotFoundException {
		Optional<Product> product = repo.findByName(name);
		if(product.isPresent()) {
			logger.info("Product "+ name+" exists in record");
			return product.get();
		}else {
			logger.error("Product "+name+" doesn't exists");
			throw new ProductNotFoundException("Product "+name+"doesn't exists");

		}
	}

}
