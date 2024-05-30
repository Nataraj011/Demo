package com.project.cmsproject.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.cmsproject.entities.Features;
import com.project.cmsproject.entities.Parameter;
import com.project.cmsproject.entities.Product;
import com.project.cmsproject.exceptions.FeatureNotFoundException;
import com.project.cmsproject.exceptions.ParameterNotFoundException;
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
    private ProductService productService;
    
    @Autowired
    private FeatureService featureService;
    
    @Autowired
    private ParameterService parameterService;
    
    @Operation(summary = "Create Product in APP")
    @PostMapping("/addproduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        logger.info("Inside addProduct +" + ProductController.class.getName());
        Product prd = productService.createproduct(product);
        logger.info("Call to service layer method is success");
        return new ResponseEntity<Product>(prd, HttpStatus.CREATED);
    }
    
    @Operation(summary = "Create Feature in APP")
    @PostMapping("/addfeature")
    public ResponseEntity<Features> addFeature(@RequestBody Features feature){
        logger.info("Inside addFeatures +" + ProductController.class.getName());
        Features features = featureService.createFeature(feature);
        logger.info("Call to service layer method is success");
        return new ResponseEntity<Features>(features, HttpStatus.CREATED);
    }
    
//    @Operation(summary = "Create Parameter in APP")
//    @PostMapping("/addparameter")
//    public ResponseEntity<Parameter> addParameter(@RequestBody Parameter parameter){
//        logger.info("Inside addParameter +" + ProductController.class.getName());
//        Parameter param = parameterService.createParameter(parameter);
//        logger.info("Call to service layer method is success");
//        return new ResponseEntity<Parameter>(param, HttpStatus.CREATED);
//    }
    
    @Operation(summary = "Get Products By id")
    @GetMapping("/getproductsbyId")
    public ResponseEntity<Product> getProductById(@RequestParam("id") Long productId) throws  ProductNotFoundException{
        logger.info("Inside getProductById +" + ProductController.class.getName());
        Product product = productService.getProductById(productId);
        logger.info("Call to service layer method is success");
        return new ResponseEntity<Product>(product, HttpStatus.FOUND);
    }
    
    @Operation(summary = "Get Products By name")
    @GetMapping("/getproductsbyName")
    public ResponseEntity<Product> getProductByName(@RequestParam("name") String name) throws  ProductNotFoundException{
        logger.info("Inside getProductById +" + ProductController.class.getName());
        Product product = productService.getProductByName(name);
        logger.info("Call to service layer method is success");
        return new ResponseEntity<Product>(product, HttpStatus.FOUND);
    }
    
    @Operation(summary = "Get All Products")
    @GetMapping("/getallproducts")
    public ResponseEntity<List<Product>> getAllProducts() {
        logger.info("Inside getAllProducts " + ProductController.class.getName());
        List<Product> products = productService.getAllProducts();
        logger.info("Call to service layer method is success");
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }
    
    
    @Operation(summary = "Update Product in APP")
    @PutMapping("/updateproduct")
    public ResponseEntity<Product> updateProduct(@RequestParam("id") Long id, @RequestBody Product product) throws ProductNotFoundException {
        logger.info("Inside updateProduct " + ProductController.class.getName());
        Product updatedProduct = productService.updateProduct(id, product);
        logger.info("Call to service layer method is success");
        return new ResponseEntity<Product>(updatedProduct, HttpStatus.OK);
    }
    
    
    
    
    
    @Operation(summary="Delete Feature By Id")
	@PostMapping("/deletefeaturebyid")
	public ResponseEntity<String> deleteFeatureById(@RequestParam("featuretId") Long featureId)
			throws FeatureNotFoundException {
		logger.info("Inside DeleteFeatureById +"+ ProductController.class.getName());
		String deletefeature = featureService.deleteFeatureById(featureId);
		logger.info("Call to service layer method is success");
		return new ResponseEntity<String>(deletefeature, HttpStatus.FOUND);
	}
	
    
    @Operation(summary="Delete Parameter By Id")
	@PostMapping("/deleteparameterbyid")
	public ResponseEntity<String> deleteParameterById(@RequestParam("parameterId") Long parameterId)
			throws ParameterNotFoundException {
		logger.info("Inside DeleteParameterById +"+ ProductController.class.getName());
		String deleteparameter = parameterService.deleteParameterById(parameterId);
		logger.info("Call to service layer method is success");
		return new ResponseEntity<String>(deleteparameter, HttpStatus.FOUND);
	}
    
    
    @Operation(summary="Delete Product By Id")
   	@PostMapping("/deleteproductbyid")
   	public ResponseEntity<String> deleteProductById(@RequestParam("productId") Long productId)
   			throws  ProductNotFoundException {
   		logger.info("Inside DeleteProductById +"+ ProductController.class.getName());
   		String deleteproduct =productService.deleteProductid(productId);
   		logger.info("Call to service layer method is success");
   		return new ResponseEntity<String>(deleteproduct, HttpStatus.FOUND);
   	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
