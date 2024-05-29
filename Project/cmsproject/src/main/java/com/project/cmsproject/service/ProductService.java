package com.project.cmsproject.service;

import com.project.cmsproject.entities.Product;
import com.project.cmsproject.exceptions.ProductNotFoundException;

public interface ProductService {
	public Product createproduct(Product product);
	
	public Product getProductById(Long productId) throws  ProductNotFoundException;
	
	public Product getProductByName(String name) throws  ProductNotFoundException;
}
