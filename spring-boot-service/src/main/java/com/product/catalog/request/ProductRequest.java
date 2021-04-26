package com.product.catalog.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductRequest {

	@JsonProperty("product_code")
	private String productCode;

	@JsonProperty("product_name")
	private String productName;

	@JsonProperty("product_price")
	private Double productPrice;

	@JsonProperty("product_type")
	private ProductTypeRequest productTypeRequest;
}
