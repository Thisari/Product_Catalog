package com.product.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.catalog.entity.ProductHistory;

@Repository	
public interface ProductHistoryRepository extends JpaRepository<ProductHistory, Integer>{

}
