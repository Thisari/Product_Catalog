package com.product.catalog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.product.catalog.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product>  {

	Optional<Product> findByProductCodeIgnoreCase(String code);

	Optional<Product> findByProductNameIgnoreCase(String name);

}
