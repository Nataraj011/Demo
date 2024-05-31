package com.project.cmsproject.repsoitories;



import org.springframework.data.jpa.repository.JpaRepository;
import com.project.cmsproject.entities.Quotation;

public interface QuotationRepository extends JpaRepository<Quotation, Long> {
}