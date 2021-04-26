package com.product.catalog.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.product.catalog.entity.Product;
import com.product.catalog.repository.ProductRepository;
import com.product.catalog.request.ProductRequest;
import com.product.catalog.util.MessageConstants;

@Component
public class ProductValidator {

	@Autowired
	private ProductRepository productRepository;

	public void validateProductCreateRequest(ProductRequest request) throws Exception {
		if (request.getProductCode() == null || request.getProductName() == null || request.getProductPrice() == null
				|| request.getProductTypeRequest() == null) {
			throw new Exception(MessageConstants.EXC_MANDATORY_DATA_CANNOT_BE_EMPTY);
		}
	}
	
	public void validateProductUpdateRequest(ProductRequest request) throws Exception {
		if (request.getProductCode() == null && request.getProductName() == null && request.getProductPrice() == null
				&& request.getProductTypeRequest() == null) {
			throw new Exception(MessageConstants.EXC_MANDATORY_DATA_CANNOT_BE_EMPTY);
		}
	}

	public Optional<Product> validateIsProductCodeDuplicate(String code) throws Exception {

		Optional<Product> productOptional = this.productRepository.findByProductCodeIgnoreCase(code);
		if (productOptional.isPresent()) {
			throw new Exception(MessageConstants.EXC_PRODUCT_CODE_CANNOT_BE_DUPLICATE);
		}
		return productOptional;
	}

	public Optional<Product> validateIsProductNameDuplicate(String name) throws Exception {

		Optional<Product> productOptional = this.productRepository.findByProductNameIgnoreCase(name);
		if (productOptional.isPresent()) {
			throw new Exception(MessageConstants.EXC_PRODUCT_NAME_CANNOT_BE_DUPLICATE);
		}
		return productOptional;
	}

	public Optional<Product> validateProductCode(String code) throws Exception {

		if (code == null) {
			throw new Exception(MessageConstants.EXC_MANDATORY_DATA_CANNOT_BE_EMPTY);
		}
		Optional<Product> productOptional = this.productRepository.findByProductCodeIgnoreCase(code);
		if (!productOptional.isPresent()) {
			throw new Exception(MessageConstants.EXC_PRODUCT_NOT_EXIST);
		}
		return productOptional;
	}

}
