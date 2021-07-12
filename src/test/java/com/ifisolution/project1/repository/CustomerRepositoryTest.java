package com.ifisolution.project1.repository;

import com.ifisolution.project1.entity.Customers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository underTest;

    @AfterEach
    void tearDown(){
        underTest.deleteAll();
    }

    @Test
    void itShouldCheckWhenCustomerExistByPhone() {
        //given
        String phone = "1313421";
        Customers customers = new Customers("Linh", phone, "Hanoi");
        underTest.save(customers);
        //when
        boolean expected = underTest.selectExitsPhone(phone);
        //then
        assertThat(expected).isTrue();
    }

    @Test
    void itShouldCheckWhenCustomerDoesNotExistByPhone() {
        //given
        String phone = "1313421";
        //when
        boolean expected = underTest.selectExitsPhone(phone);
        //then
        assertThat(expected).isFalse();
    }

    /*@Test
    void findByCustomerId() {
    }*/
}