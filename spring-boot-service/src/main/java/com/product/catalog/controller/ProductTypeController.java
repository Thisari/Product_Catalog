package com.product.catalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.catalog.request.ProductTypeRequest;
import com.product.catalog.response.ProductTypeResponse;
import com.product.catalog.service.ProductTypeService;
import com.product.catalog.util.MessageConstants;
import com.product.catalog.util.URIPathVariable;
import com.product.catalog.util.URIPrefix;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(URIPrefix.V1 + URIPrefix.CATALOG + URIPrefix.PRODUCT_TYPE)
public class ProductTypeController {

	@Autowired
	private ProductTypeService productTypeService;

	/*-----------------------------------------------------------------------------------------------*/
	/** Create Product Type **/
	@ApiOperation(value = "Create Product Type", nickname = "CreateProductTypeV1")
	@PostMapping(value = "")
	public ResponseEntity<ProductTypeResponse> createProductType(@RequestBody ProductTypeRequest request) {

		ProductTypeResponse response;
		try {
			response = this.productTypeService.createProductType(request);
		} catch (Exception e) {

			e.printStackTrace();
			return new ResponseEntity(e.getMessage(), HttpStatus.valueOf(500));

		}
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	/*-----------------------------------------------------------------------------------------------*/
	/** Edit Product Type **/
	@ApiOperation(value = "Update Product Type", nickname = "UpdateProductTypeV1")
	@PutMapping(value = URIPrefix.BY_CODE)
	public ResponseEntity<ProductTypeResponse> updateProductType(
			@PathVariable(name = URIPathVariable.CODE, required = true) String code,
			@RequestBody ProductTypeRequest request) {

		ProductTypeResponse response;
		try {
			response = this.productTypeService.updateProductType(code, request);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(e.getMessage(), HttpStatus.valueOf(500));
		}
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	/*-----------------------------------------------------------------------------------------------*/
	/** Delete Product Type **/
	@ApiOperation(value = "Delete Product Type", nickname = "DeleteProductTypeV1")
	@DeleteMapping(value = URIPrefix.BY_CODE)
	public ResponseEntity<ProductTypeResponse> deleteProductType(
			@PathVariable(name = URIPathVariable.CODE, required = true) String code) {

		try {
			this.productTypeService.deleteProductType(code);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(e.getMessage(), HttpStatus.valueOf(500));
		}
		return new ResponseEntity<>(HttpStatus.OK);

	}

	/*-----------------------------------------------------------------------------------------------*/
	/** Get All Product Types **/
	@ApiOperation(value = "Get All Product Types", nickname = "GetAllProductTypesV1")
	@GetMapping(value = URIPrefix.ALL)
	public ResponseEntity<List<ProductTypeResponse>> getAllProductTypes(
			@ApiParam(value = MessageConstants.PAGENUMBER_OPTIONAL_MSG) @RequestParam(required = false, defaultValue = "1") Integer pageNumber,
			@ApiParam(value = MessageConstants.PAGESIZE_OPTIONAL_MSG) @RequestParam(required = false, defaultValue = ""
					+ Integer.MAX_VALUE) Integer pageSize) {

		List<ProductTypeResponse> responseList = this.productTypeService.getAllProductTypes(pageNumber, pageSize);
		return new ResponseEntity<>(responseList, HttpStatus.OK);

	}

}
