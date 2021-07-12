package com.ifisolution.project1.repository;

import com.ifisolution.project1.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
}
