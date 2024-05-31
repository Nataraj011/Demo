package com.project.cmsproject.service;

import java.util.Optional;

import com.project.cmsproject.entities.Quotation;

public interface QuotationService {
    Quotation createQuotation(Quotation quotation);
    
    Optional<Quotation> findQuotationById(Long id);
}
