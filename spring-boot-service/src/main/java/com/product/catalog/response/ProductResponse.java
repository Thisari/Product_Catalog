package com.product.catalog.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponse {

	@JsonProperty("product_id")
	private int productId;

	@JsonProperty("product_code")
	private String productCode;

	@JsonProperty("product_name")
	private String productName;

	@JsonProperty("product_price")
	private Double productPrice;

	@JsonProperty("product_type")
	private ProductTypeResponse productTypeResponse;

	@JsonProperty("created_date_time")
	private LocalDateTime createdDateTime;

	@JsonProperty("created_by")
	private int createdBy;

	@JsonProperty("modified_date_time")
	private LocalDateTime modifiedDateTime;

	@JsonProperty("modified_by")
	private int modifiedBy;
}
