package com.product.catalog.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.product.catalog.entity.ProductType;
import com.product.catalog.repository.ProductTypeRepository;
import com.product.catalog.request.ProductTypeRequest;
import com.product.catalog.response.ProductTypeResponse;
import com.product.catalog.service.ProductTypeService;
import com.product.catalog.validator.ProductTypeValidator;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

	@Autowired
	private ProductTypeRepository productTypeRepository;

	@Autowired
	private ProductTypeValidator productTypeValidator;

	/**
	 * Create Product Type
	 * 
	 * @throws Exception
	 **/

	@Override
	@Transactional(rollbackFor = Exception.class)
	public ProductTypeResponse createProductType(ProductTypeRequest request) throws Exception {

		this.productTypeValidator.validateProductTypeRequest(request);

		this.productTypeValidator.validateIsProductTypeCodeDuplicate(request.getProductTypeCode());
		this.productTypeValidator.validateIsProductTypeNameDuplicate(request.getProductTypeName());

		ProductType productTypeEntity = new ProductType();
		productTypeEntity.setProductTypeCode(request.getProductTypeCode());
		productTypeEntity.setProductTypeName(request.getProductTypeName());
		productTypeEntity.setCreatedBy(1);
		productTypeEntity.setModifiedBy(1);
		ProductType data = this.productTypeRepository.save(productTypeEntity);

		return buildProductTypeResponse(data);
	}

	/*-----------------------------------------------------------------------------------------*/
	/**
	 * Edit Product Type
	 * 
	 * @throws Exception
	 **/
	@Override
	@Transactional(rollbackFor = Exception.class)
	public ProductTypeResponse updateProductType(String code, ProductTypeRequest request) throws Exception {

		Optional<ProductType> optionalProductType = this.productTypeValidator.validateProductTypeCode(code);
		ProductType productType = optionalProductType.get();

		this.productTypeValidator.validateProductTypeRequest(request);

		if (request.getProductTypeCode() != null) {
			this.productTypeValidator.validateIsProductTypeCodeDuplicate(request.getProductTypeCode());
			productType.setProductTypeCode(request.getProductTypeCode());
		}
		if (request.getProductTypeName() != null) {
			this.productTypeValidator.validateIsProductTypeNameDuplicate(request.getProductTypeName());
			productType.setProductTypeName(request.getProductTypeName());
		}

		productType.setModifiedBy(1);
		ProductType data = this.productTypeRepository.save(productType);

		return buildProductTypeResponse(data);
	}

	/*----------------------------------------------------------------------------------------*/
	/**
	 * Delete Product Type
	 * 
	 * @throws Exception
	 **/
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteProductType(String code) throws Exception {

		Optional<ProductType> optionalProductType = this.productTypeValidator.validateProductTypeCode(code);

		ProductType productType = optionalProductType.get();
		this.productTypeRepository.delete(productType);

	}

	/*----------------------------------------------------------------------------------------*/
	/** Get All Product Types **/
	@Override
	public List<ProductTypeResponse> getAllProductTypes(Integer pageNumber, Integer pageSize) {

		List<ProductTypeResponse> responseList = new ArrayList<>();

		Pageable pageable = PageRequest.of((pageNumber - 1), pageSize, Sort.by("createdDateTime").descending());

		Page<ProductType> dataList = this.productTypeRepository.findAll(pageable);
		if (!ObjectUtils.isEmpty(dataList)) {
			responseList = buildProductTypeResponseList(dataList.getContent());
		}
		return responseList;

	}

	/*---------------------------------------------------------------------------------------*/
	private ProductTypeResponse buildProductTypeResponse(ProductType productType) {
		return ProductTypeResponse.builder().productTypeId(productType.getProductTypeId())
				.productTypeCode(productType.getProductTypeCode()).productTypeName(productType.getProductTypeName())
				.createdDateTime(productType.getCreatedDateTime()).createdBy(productType.getCreatedBy())
				.modifiedDateTime(productType.getModifiedDateTime()).modifiedBy(productType.getModifiedBy()).build();
	}

	private List<ProductTypeResponse> buildProductTypeResponseList(List<ProductType> productTypes) {
		List<ProductTypeResponse> responses = new ArrayList<>();
		productTypes.forEach(productType -> responses.add(buildProductTypeResponse(productType)));
		return responses;
	}

}
