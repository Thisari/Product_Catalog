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
public class ProductTypeRequest {

	@JsonProperty("product_type_code")
	private String productTypeCode;

	@JsonProperty("product_type_name")
	private String productTypeName;

}
