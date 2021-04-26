package com.product.catalog.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.product.catalog.entity.ProductType;
import com.product.catalog.repository.ProductTypeRepository;
import com.product.catalog.request.ProductTypeRequest;
import com.product.catalog.util.MessageConstants;

@Component
public class ProductTypeValidator {

	@Autowired
	private ProductTypeRepository productTypeRepository;

	public void validateProductTypeRequest(ProductTypeRequest request) throws Exception {
		if (request.getProductTypeCode() == null && request.getProductTypeName() == null) {
			throw new Exception(MessageConstants.EXC_MANDATORY_DATA_CANNOT_BE_EMPTY);
		}
	}

	public Optional<ProductType> validateIsProductTypeCodeDuplicate(String code) throws Exception {

		Optional<ProductType> productTypeOptional = this.productTypeRepository.findByProductTypeCodeIgnoreCase(code);
		if (productTypeOptional.isPresent()) {
			throw new Exception(MessageConstants.EXC_PRODUCT_TYPE_CODE_CANNOT_BE_DUPLICATE);
		}
		return productTypeOptional;
	}

	public Optional<ProductType> validateIsProductTypeNameDuplicate(String name) throws Exception {

		Optional<ProductType> productTypeOptional = this.productTypeRepository.findByProductTypeNameIgnoreCase(name);
		if (productTypeOptional.isPresent()) {
			throw new Exception(MessageConstants.EXC_PRODUCT_TYPE_NAME_CANNOT_BE_DUPLICATE);
		}
		return productTypeOptional;
	}

	public Optional<ProductType> validateProductTypeCode(String code) throws Exception {

		if (code == null) {
			throw new Exception(MessageConstants.EXC_MANDATORY_DATA_CANNOT_BE_EMPTY);
		}
		Optional<ProductType> productTypeOptional = this.productTypeRepository.findByProductTypeCodeIgnoreCase(code);
		if (!productTypeOptional.isPresent()) {
			throw new Exception(MessageConstants.EXC_PRODUCT_TYPE_NOT_EXIST);
		}
		return productTypeOptional;
	}

}
