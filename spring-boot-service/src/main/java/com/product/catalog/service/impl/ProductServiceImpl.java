package com.product.catalog.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.product.catalog.entity.Product;
import com.product.catalog.entity.ProductType;
import com.product.catalog.repository.ProductRepository;
import com.product.catalog.request.ProductRequest;
import com.product.catalog.response.ProductResponse;
import com.product.catalog.response.ProductTypeResponse;
import com.product.catalog.service.ProductService;
import com.product.catalog.validator.ProductTypeValidator;
import com.product.catalog.validator.ProductValidator;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductValidator productValidator;

	@Autowired
	private ProductTypeValidator productTypeValidator;

	/**
	 * Create Product
	 * 
	 * @throws Exception
	 **/
	@Override
	@Transactional(rollbackFor = Exception.class)
	public ProductResponse createProduct(ProductRequest request) throws Exception {

		this.productValidator.validateProductCreateRequest(request);

		this.productValidator.validateIsProductCodeDuplicate(request.getProductCode());
		this.productValidator.validateIsProductNameDuplicate(request.getProductName());

		ProductType productType = this.productTypeValidator
				.validateProductTypeCode(request.getProductTypeRequest().getProductTypeCode()).get();

		Product productEntity = new Product();
		productEntity.setProductCode(request.getProductCode());
		productEntity.setProductName(request.getProductName());
		productEntity.setProductPrice(request.getProductPrice());
		productEntity.setProductType(productType);
		productEntity.setCreatedBy(1);
		productEntity.setModifiedBy(1);
		Product data = this.productRepository.save(productEntity);

		return buildProductResponse(data);
	}

	/*-----------------------------------------------------------------------------------------*/
	/**
	 * Edit Product
	 * 
	 * @throws Exception
	 **/
	@Override
	@Transactional(rollbackFor = Exception.class)
	public ProductResponse updateProduct(String code, ProductRequest request) throws Exception {

		Optional<Product> optionalProduct = this.productValidator.validateProductCode(code);
		Product product = optionalProduct.get();

		this.productValidator.validateProductUpdateRequest(request);

		if (request.getProductCode() != null) {
			this.productValidator.validateIsProductCodeDuplicate(request.getProductCode());
			product.setProductCode(request.getProductCode());
		}
		if (request.getProductName() != null) {
			this.productValidator.validateIsProductNameDuplicate(request.getProductName());
			product.setProductName(request.getProductName());
		}
		if (request.getProductPrice() != null) {
			product.setProductPrice(request.getProductPrice());
		}
		if (request.getProductTypeRequest() != null) {
			Optional<ProductType> optionalProductTypeCode = this.productTypeValidator
					.validateProductTypeCode(request.getProductTypeRequest().getProductTypeCode());
			product.setProductType(optionalProductTypeCode.get());
		}
		product.setModifiedBy(1);
		Product data = this.productRepository.save(product);

		return buildProductResponse(data);
	}

	/*-----------------------------------------------------------------------------------------*/
	/**
	 * Delete Product Type
	 * 
	 * @throws Exception
	 **/
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteProduct(String code) throws Exception {

		Optional<Product> optionalProduct = this.productValidator.validateProductCode(code);

		Product product = optionalProduct.get();
		this.productRepository.delete(product);
	}

	@Override
	public List<ProductResponse> getAllProducts(String productTypeCode, Integer pageNumber, Integer pageSize) {

		List<ProductResponse> responseList = new ArrayList<>();

		Pageable pageable = PageRequest.of((pageNumber - 1), pageSize, Sort.by("createdDateTime").descending());

		Page<Product> dataList = this.productRepository.findAll(new Specification<Product>() {

			@Override
			public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();

				if ((productTypeCode != null) && (!"".equals(productTypeCode))
						&& (!"null".equalsIgnoreCase(productTypeCode))) {
					predicates.add(criteriaBuilder.and(
							criteriaBuilder.equal(root.get("productType").get("productTypeCode"), productTypeCode)));
				}

				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		}, pageable);

		if (!ObjectUtils.isEmpty(dataList)) {
			responseList = buildProductResponseList(dataList.getContent());
		}
		return responseList;

	}
	/*------------------------------------------------------------------------------------------------*/

	private ProductResponse buildProductResponse(Product product) {
		return ProductResponse.builder().productId(product.getProductId()).productCode(product.getProductCode())
				.productName(product.getProductName()).productPrice(product.getProductPrice())
				.productTypeResponse(buildProductTypeResponse(product.getProductType()))
				.createdDateTime(product.getCreatedDateTime()).createdBy(product.getCreatedBy())
				.modifiedDateTime(product.getModifiedDateTime()).modifiedBy(product.getModifiedBy()).build();
	}

	private List<ProductResponse> buildProductResponseList(List<Product> products) {
		List<ProductResponse> responses = new ArrayList<>();
		products.forEach(product -> responses.add(buildProductResponse(product)));
		return responses;
	}

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
