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

import com.product.catalog.request.ProductRequest;
import com.product.catalog.response.ProductResponse;
import com.product.catalog.response.ProductTypeResponse;
import com.product.catalog.service.ProductService;
import com.product.catalog.util.MessageConstants;
import com.product.catalog.util.URIPathVariable;
import com.product.catalog.util.URIPrefix;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(URIPrefix.V1 + URIPrefix.CATALOG + URIPrefix.PRODUCT)
public class ProductController {

	@Autowired
	private ProductService productService;

	/*-----------------------------------------------------------------------------------------------*/
	/** Create Product **/
	@ApiOperation(value = "Create Product ", nickname = "CreateProductV1")
	@PostMapping(value = "")
	public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest request) {

		ProductResponse response;
		try {
			response = this.productService.createProduct(request);
		} catch (Exception e) {

			e.printStackTrace();
			return new ResponseEntity(e.getMessage(), HttpStatus.valueOf(500));

		}
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	/*-----------------------------------------------------------------------------------------------*/
	/** Edit Product **/
	@ApiOperation(value = "Update Product", nickname = "UpdateProductV1")
	@PutMapping(value = URIPrefix.BY_CODE)
	public ResponseEntity<ProductResponse> updateProduct(
			@PathVariable(name = URIPathVariable.CODE, required = true) String code,
			@RequestBody ProductRequest request) {

		ProductResponse response;
		try {
			response = this.productService.updateProduct(code, request);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(e.getMessage(), HttpStatus.valueOf(500));
		}
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	/*-----------------------------------------------------------------------------------------------*/
	/** Delete Product **/
	@ApiOperation(value = "Delete Product", nickname = "DeleteProductV1")
	@DeleteMapping(value = URIPrefix.BY_CODE)
	public ResponseEntity<ProductTypeResponse> deleteProduct(
			@PathVariable(name = URIPathVariable.CODE, required = true) String code) {

		try {
			this.productService.deleteProduct(code);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(e.getMessage(), HttpStatus.valueOf(500));
		}
		return new ResponseEntity<>(HttpStatus.OK);

	}

	/*-----------------------------------------------------------------------------------------------*/
	/** Get All Products **/
	@ApiOperation(value = "Get All Products", nickname = "GetAllProductsV1")
	@GetMapping(value = URIPrefix.ALL)
	public ResponseEntity<List<ProductResponse>> getAllProducts(
			@ApiParam(value = MessageConstants.PAGENUMBER_OPTIONAL_MSG) @RequestParam(required = false, defaultValue = "1") Integer pageNumber,
			@ApiParam(value = MessageConstants.PAGESIZE_OPTIONAL_MSG) @RequestParam(required = false, defaultValue = ""
					+ Integer.MAX_VALUE) Integer pageSize,
			@RequestParam(name = URIPathVariable.CODE, required = false) String code) {

		List<ProductResponse> responseList = this.productService.getAllProducts(code, pageNumber, pageSize);
		return new ResponseEntity<>(responseList, HttpStatus.OK);

	}

}
