package com.product.catalog.service;

import java.util.List;

import com.product.catalog.request.ProductRequest;
import com.product.catalog.response.ProductResponse;

public interface ProductService {
	
	ProductResponse createProduct(ProductRequest request) throws Exception;

	ProductResponse updateProduct(String code, ProductRequest request) throws Exception;

	void deleteProduct(String code) throws Exception;

	List<ProductResponse> getAllProducts(String productTypeCode,Integer pageNumber, Integer pageSize);

}
