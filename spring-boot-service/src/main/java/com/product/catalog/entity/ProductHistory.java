// Generated with g9.

package com.product.catalog.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity(name = "product_history")
public class ProductHistory implements Serializable {

	/** Primary key. */
	protected static final String PK = "productHistoryId";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_history_id", unique = true, nullable = false, precision = 10)
	private int productHistoryId;
	@Column(name = "product_id", nullable = false, precision = 10)
	private int productId;
	@Column(name = "product_code", nullable = false, length = 10)
	private String productCode;
	@Column(name = "product_name", nullable = false, length = 100)
	private String productName;
	@Column(name = "product_price", nullable = false, precision = 22)
	private double productPrice;
	@Column(name = "created_date_time", nullable = false)
	@CreationTimestamp
	private LocalDateTime createdDateTime;
	@Column(name = "created_by", nullable = false, precision = 10)
	private int createdBy;

	/** Default constructor. */
	public ProductHistory() {
		super();
	}

	/**
	 * Access method for productHistoryId.
	 *
	 * @return the current value of productHistoryId
	 */
	public int getProductHistoryId() {
		return productHistoryId;
	}

	/**
	 * Setter method for productHistoryId.
	 *
	 * @param aProductHistoryId the new value for productHistoryId
	 */
	public void setProductHistoryId(int aProductHistoryId) {
		productHistoryId = aProductHistoryId;
	}

	/**
	 * Access method for productId.
	 *
	 * @return the current value of productId
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * Setter method for productId.
	 *
	 * @param aProductId the new value for productId
	 */
	public void setProductId(int aProductId) {
		productId = aProductId;
	}

	/**
	 * Access method for productCode.
	 *
	 * @return the current value of productCode
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * Setter method for productCode.
	 *
	 * @param aProductCode the new value for productCode
	 */
	public void setProductCode(String aProductCode) {
		productCode = aProductCode;
	}

	/**
	 * Access method for productName.
	 *
	 * @return the current value of productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * Setter method for productName.
	 *
	 * @param aProductName the new value for productName
	 */
	public void setProductName(String aProductName) {
		productName = aProductName;
	}

	/**
	 * Access method for productPrice.
	 *
	 * @return the current value of productPrice
	 */
	public double getProductPrice() {
		return productPrice;
	}

	/**
	 * Setter method for productPrice.
	 *
	 * @param aProductPrice the new value for productPrice
	 */
	public void setProductPrice(double aProductPrice) {
		productPrice = aProductPrice;
	}

	/**
	 * Access method for createdDateTime.
	 *
	 * @return the current value of createdDateTime
	 */
	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}

	/**
	 * Setter method for createdDateTime.
	 *
	 * @param aCreatedDateTime the new value for createdDateTime
	 */
	public void setCreatedDateTime(LocalDateTime aCreatedDateTime) {
		createdDateTime = aCreatedDateTime;
	}

	/**
	 * Access method for createdBy.
	 *
	 * @return the current value of createdBy
	 */
	public int getCreatedBy() {
		return createdBy;
	}

	/**
	 * Setter method for createdBy.
	 *
	 * @param aCreatedBy the new value for createdBy
	 */
	public void setCreatedBy(int aCreatedBy) {
		createdBy = aCreatedBy;
	}

	/**
	 * Compares the key for this instance with another ProductHistory.
	 *
	 * @param other The object to compare to
	 * @return True if other object is instance of class ProductHistory and the key
	 *         objects are equal
	 */
	private boolean equalKeys(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProductHistory)) {
			return false;
		}
		ProductHistory that = (ProductHistory) other;
		if (this.getProductHistoryId() != that.getProductHistoryId()) {
			return false;
		}
		return true;
	}

	/**
	 * Compares this instance with another ProductHistory.
	 *
	 * @param other The object to compare to
	 * @return True if the objects are the same
	 */
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof ProductHistory))
			return false;
		return this.equalKeys(other) && ((ProductHistory) other).equalKeys(this);
	}

	/**
	 * Returns a hash code for this instance.
	 *
	 * @return Hash code
	 */
	@Override
	public int hashCode() {
		int i;
		int result = 17;
		i = getProductHistoryId();
		result = 37 * result + i;
		return result;
	}

	/**
	 * Returns a debug-friendly String representation of this instance.
	 *
	 * @return String representation of this instance
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("[ProductHistory |");
		sb.append(" productHistoryId=").append(getProductHistoryId());
		sb.append("]");
		return sb.toString();
	}

	/**
	 * Return all elements of the primary key.
	 *
	 * @return Map of key names to values
	 */
	public Map<String, Object> getPrimaryKey() {
		Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
		ret.put("productHistoryId", Integer.valueOf(getProductHistoryId()));
		return ret;
	}

}
