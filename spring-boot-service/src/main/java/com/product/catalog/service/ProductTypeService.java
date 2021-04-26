package com.product.catalog.service;

import java.util.List;

import com.product.catalog.request.ProductTypeRequest;
import com.product.catalog.response.ProductTypeResponse;

public interface ProductTypeService {

	ProductTypeResponse createProductType(ProductTypeRequest request) throws Exception;

	ProductTypeResponse updateProductType(String code, ProductTypeRequest request) throws Exception;

	void deleteProductType(String code) throws Exception;

	List<ProductTypeResponse> getAllProductTypes(Integer pageNumber, Integer pageSize);

}
