package com.ifisolution.project1.service;

import com.ifisolution.project1.entity.Customers;
import com.ifisolution.project1.repository.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;
    private CustomerService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository);
    }

    @Test
    void canGetCustomers() {
        //when
        underTest.getCustomers();
        //them
        verify(customerRepository).findAll();
    }

    @Test
    void canAddNewCustomer() {
        //given
        Customers customers = new Customers("Linh", "0123", "HN");
        //when
        underTest.addNewCustomer(customers);

        //then
        ArgumentCaptor<Customers> customersArgumentCaptor = ArgumentCaptor.forClass(Customers.class);
        verify(customerRepository).save(customersArgumentCaptor.capture());

        Customers captureCustomer = customersArgumentCaptor.getValue();
        assertThat(captureCustomer).isEqualTo(customers);
    }

    @Test
    void deleteCustomer() {
        //given
        /*Customers customers = new Customers("Linh", "012", "hn");
        underTest.addNewCustomer(customers);*/
        Long id  = 1L;
        //when
        underTest.deleteCustomer(id);
        //then
        ArgumentCaptor<Long> idArgumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(customerRepository).deleteById(idArgumentCaptor.capture());

        Long captureId = idArgumentCaptor.getValue();
        assertThat(captureId).isEqualTo(id);
    }


    @Test
    void canUpdateCustomer(){
        Customers customers = new Customers(1L,"A", "1", "B");
        underTest.addNewCustomer(customers);

        underTest.updateCustomer( 1L,"C", "2");

        System.out.println(customers);
        ArgumentCaptor<Customers> customersArgumentCaptor = ArgumentCaptor.forClass(Customers.class);
        verify(customerRepository).save(customersArgumentCaptor.capture());

        Customers captureCustomer = customersArgumentCaptor.getValue();
        assertThat(captureCustomer).isEqualTo(customers);
    }
}