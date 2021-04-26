package com.product.catalog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.catalog.entity.ProductType;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Integer> {

	Optional<ProductType> findByProductTypeCodeIgnoreCase(String code);

	Optional<ProductType> findByProductTypeNameIgnoreCase(String name);

}
