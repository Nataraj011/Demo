package com.project.cmsproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.cmsproject.entities.Quotation;
import com.project.cmsproject.repsoitories.QuotationRepository;


@Service
public class QuotationServiceImpl implements QuotationService{

    @Autowired
    private QuotationRepository quotationRepository;

    public Quotation createQuotation(Quotation quotation) {
        return quotationRepository.save(quotation);
    }
    @Override
    public Optional<Quotation> findQuotationById(Long id) {
        return quotationRepository.findById(id);
    }
}