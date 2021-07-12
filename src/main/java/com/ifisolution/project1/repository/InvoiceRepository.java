package com.ifisolution.project1.repository;

import com.ifisolution.project1.entity.Invoices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoices, Long> {
}
