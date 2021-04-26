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
public class ProductTypeResponse {

	@JsonProperty("product_type_id")
	private int productTypeId;

	@JsonProperty("product_type_code")
	private String productTypeCode;

	@JsonProperty("product_type_name")
	private String productTypeName;

	@JsonProperty("created_date_time")
	private LocalDateTime createdDateTime;

	@JsonProperty("created_by")
	private int createdBy;

	@JsonProperty("modified_date_time")
	private LocalDateTime modifiedDateTime;

	@JsonProperty("modified_by")
	private int modifiedBy;

}
