package com.project.cmsproject.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.cmsproject.entities.Product;
import com.project.cmsproject.exceptions.ProductNotFoundException;
import com.project.cmsproject.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/manager")
@Tag(name="InternetService Manager API")
public class ManagerController {

    private static final Logger logger = LoggerFactory.getLogger(ManagerController.class);

    @Autowired
    private ProductService productService;

    @Operation(summary = "Get Product By Name")
    @GetMapping("/getproductbyname")
    public ResponseEntity<?> getProductByName(@RequestParam("name") String name) {
        logger.info("Inside getProductByName " + ManagerController.class.getName());
        try {
            Product product = productService.getProductByName(name);
            logger.info("Call to service layer method is success");
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch (ProductNotFoundException ex) {
            logger.error("ProductNotFoundException: " + ex.getMessage());
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Get Product By ID")
    @GetMapping("/getproductbyid")
    public ResponseEntity<?> getProductById(@RequestParam("id") Long productId) {
        logger.info("Inside getProductById " + ManagerController.class.getName());
        try {
            Product product = productService.getProductById(productId);
            logger.info("Call to service layer method is success");
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch (ProductNotFoundException ex) {
            logger.error("ProductNotFoundException: " + ex.getMessage());
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Get All Products")
    @GetMapping("/getallproducts")
    public ResponseEntity<?> getAllProducts() {
        logger.info("Inside getAllProducts " + ManagerController.class.getName());
        List<Product> products = productService.getAllProducts();
        logger.info("Call to service layer method is success");
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }
}
