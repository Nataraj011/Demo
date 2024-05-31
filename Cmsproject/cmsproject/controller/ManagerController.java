package com.project.cmsproject.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.cmsproject.entities.Product;
import com.project.cmsproject.entities.Quotation;
import com.project.cmsproject.exceptions.ProductNotFoundException;
import com.project.cmsproject.service.ProductService;
import com.project.cmsproject.service.QuotationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/manager")
@Tag(name="InternetService Manager API")
public class ManagerController {

    private static final Logger logger = LoggerFactory.getLogger(ManagerController.class);

    @Autowired
    private ProductService productService;
    
    @Autowired
    private QuotationService quotationService;

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
    
    
    @Operation(summary = "Create Quotation")
    @PostMapping("/createquotation")
    public ResponseEntity<?> createQuotation(@RequestBody Quotation quotation) {
        logger.info("Inside createQuotation " + ManagerController.class.getName());
        try {
            Quotation savedQuotation =quotationService.createQuotation(quotation);
            logger.info("Quotation created successfully");
            return new ResponseEntity<Quotation>(savedQuotation, HttpStatus.CREATED);
        } catch (Exception ex) {
            logger.error("Exception: " + ex.getMessage());
            return new ResponseEntity<String>("Error creating quotation: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    @Operation(summary = "Get Quotation By ID")
    @GetMapping("/getquotationbyid")
    public ResponseEntity<?> getQuotationById(@RequestParam("id") Long quotationId) {
        logger.info("Inside getQuotationById " + ManagerController.class.getName());
        try {
            Optional<Quotation> quotation = quotationService.findQuotationById(quotationId);
            if (quotation.isPresent()) {
                logger.info("Call to service layer method is success");
                return new ResponseEntity<Quotation>(quotation.get(), HttpStatus.OK);
            } else {
                logger.info("Quotation not found");
                return new ResponseEntity<String>("Quotation not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            logger.error("Exception: " + ex.getMessage());
            return new ResponseEntity<String>("Error retrieving quotation: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    
    
    
   
}

