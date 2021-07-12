package com.ifisolution.project1.controller;

import com.ifisolution.project1.entity.Invoices;
import com.ifisolution.project1.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
    private final InvoiceService invoiceService;


    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    public ResponseEntity<List<Invoices>> getInvoices(){

        List<Invoices> invoice= invoiceService.getInvoices();
        return new ResponseEntity<>(invoice, HttpStatus.OK);
    }

    @PostMapping
    public void addInvoice(@RequestBody Invoices invoices){
        invoiceService.addInvoice(invoices);
    }
    @DeleteMapping("/{id}")
    public void deleteInvoice( @PathVariable("id") Long id){
        invoiceService.deleteInvoice(id);
    }
}
