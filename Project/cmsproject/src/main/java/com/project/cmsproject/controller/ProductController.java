package com.project.cmsproject.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.cmsproject.entities.Features;
import com.project.cmsproject.entities.Parameter;
import com.project.cmsproject.entities.Product;
import com.project.cmsproject.exceptions.ProductNotFoundException;
import com.project.cmsproject.service.FeatureService;
import com.project.cmsproject.service.ParameterService;
import com.project.cmsproject.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/api/v1/productapp")
@Tag(name="InternetService Product API")

public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController .class);
	@Autowired
	private ProductService service;
	
	@Autowired
	private FeatureService service1;
	
	@Autowired
    private ParameterService parameterService;
	
	
	
	@Operation(summary = "Create Product in APP")
	@PostMapping("/addproduct")
	public ResponseEntity<Product> addActor(@RequestBody Product product){
		logger.info("Inside addProduct +"+ ProductController.class.getName());
		Product prd = service.createproduct(product);
		logger.info("Call to service layer method is success");
		return new ResponseEntity<Product>(prd, HttpStatus.CREATED);
	}
	
	@Operation(summary = "Create Feature in APP")
	@PostMapping("/addfeature")
	public ResponseEntity<Features> addfeature(@RequestBody Features feature){
		logger.info("Inside addFeatures +"+ ProductController.class.getName());
		Features features = service1.createFeature(feature);
		logger.info("Call to service layer method is success");
		return new ResponseEntity<Features>(features, HttpStatus.CREATED);
		
	}
	
	@Operation(summary = "Create Parameter in APP")
	@PostMapping("/addparameter")
	public ResponseEntity<Parameter> addparameter(@RequestBody Parameter parameter){
		logger.info("Inside addParameter +"+ ProductController.class.getName());
		Parameter param=parameterService.createParameter(parameter);
		logger.info("Call to service layer method is success");
		return new ResponseEntity<Parameter>(param, HttpStatus.CREATED);
		
	}
	@Operation(summary = "Get Products By id")
	@GetMapping("/getproductsbyId")
	public ResponseEntity<Product> getProductById(@RequestParam("id") Long productId) throws  ProductNotFoundException{
		logger.info("Inside getProductById +"+ ProductController.class.getName());
		Product product = service.getProductById(productId);
		logger.info("Call to service layer method is success");
		return new ResponseEntity<Product>(product, HttpStatus.FOUND);
	}
	
	@Operation(summary = "Get Products By name")
	@GetMapping("/getproductsbyName")
	public ResponseEntity<Product> getProductByName(@RequestParam("name") String name) throws  ProductNotFoundException{
		logger.info("Inside getProductById +"+ ProductController.class.getName());
		Product product = service. getProductByName(name);
		logger.info("Call to service layer method is success");
		return new ResponseEntity<Product>(product, HttpStatus.FOUND);
	}

	







	
	
	
	
	
	

}
