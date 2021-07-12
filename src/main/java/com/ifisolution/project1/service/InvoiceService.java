package com.ifisolution.project1.service;

import com.ifisolution.project1.entity.Invoices;
import com.ifisolution.project1.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public List<Invoices> getInvoices(){
        return invoiceRepository.findAll();
    }

    public void addInvoice(Invoices invoices){
        invoiceRepository.save(invoices);
    }
    public void deleteInvoice(Long id){
        invoiceRepository.findById(id);
        boolean exist = invoiceRepository.existsById(id);
        if (!exist){
            throw new IllegalStateException("Invoice with id: " + id + " dose not exist");
        }
        invoiceRepository.deleteById(id);
    }

}
