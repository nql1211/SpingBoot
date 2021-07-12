package com.ifisolution.project1.repository;

import com.ifisolution.project1.entity.LineItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineItemRepository extends JpaRepository<LineItems, Long> {
}
