package com.ifisolution.project1.repository;

import com.ifisolution.project1.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Long> {
    @Query("" +
            "SELECT CASE WHEN COUNT(c) > 0 THEN " +
            "TRUE ELSE FALSE END " +
            "FROM Customers c " +
            "WHERE c.phone = ?1"
    )
    Boolean selectExitsPhone(String phone);


    @Query("SELECT c from Customers c where c.phone = ?1")
    Optional<Customers> findByCustomerPhone(String phone);

    @Query("SELECT c.id from Customers c where c.phone = ?1")
    Optional<Customers> findIdByPhone(String phone);
}
