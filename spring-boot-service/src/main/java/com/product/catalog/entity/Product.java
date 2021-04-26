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
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="product", indexes={@Index(name="product_product_code_IX", columnList="product_code", unique=true), @Index(name="product_product_name_IX", columnList="product_name", unique=true)})
public class Product implements Serializable {

    /** Primary key. */
    protected static final String PK = "productId";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="product_id", unique=true, nullable=false, precision=10)
    private int productId;
    @Column(name="product_code", unique=true, nullable=false, length=10)
    private String productCode;
    @Column(name="product_name", unique=true, nullable=false, length=100)
    private String productName;
    @Column(name="product_price", nullable=false, precision=22)
    private double productPrice;
    @Column(name="created_date_time", nullable=false)
    @CreationTimestamp
    private LocalDateTime createdDateTime;
    @Column(name="created_by", nullable=false, precision=10)
    private int createdBy;
    @Column(name="modified_date_time", nullable=false)
    @UpdateTimestamp
    private LocalDateTime modifiedDateTime;
    @Column(name="modified_by", nullable=false, precision=10)
    private int modifiedBy;
    @ManyToOne(optional=false)
    @JoinColumn(name="product_type_product_type_id", nullable=false)
    private ProductType productType;

    /** Default constructor. */
    public Product() {
        super();
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
     * Access method for modifiedDateTime.
     *
     * @return the current value of modifiedDateTime
     */
    public LocalDateTime getModifiedDateTime() {
        return modifiedDateTime;
    }

    /**
     * Setter method for modifiedDateTime.
     *
     * @param aModifiedDateTime the new value for modifiedDateTime
     */
    public void setModifiedDateTime(LocalDateTime aModifiedDateTime) {
        modifiedDateTime = aModifiedDateTime;
    }

    /**
     * Access method for modifiedBy.
     *
     * @return the current value of modifiedBy
     */
    public int getModifiedBy() {
        return modifiedBy;
    }

    /**
     * Setter method for modifiedBy.
     *
     * @param aModifiedBy the new value for modifiedBy
     */
    public void setModifiedBy(int aModifiedBy) {
        modifiedBy = aModifiedBy;
    }

    /**
     * Access method for productType.
     *
     * @return the current value of productType
     */
    public ProductType getProductType() {
        return productType;
    }

    /**
     * Setter method for productType.
     *
     * @param aProductType the new value for productType
     */
    public void setProductType(ProductType aProductType) {
        productType = aProductType;
    }

    /**
     * Compares the key for this instance with another Product.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Product and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Product)) {
            return false;
        }
        Product that = (Product) other;
        if (this.getProductId() != that.getProductId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Product.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Product)) return false;
        return this.equalKeys(other) && ((Product)other).equalKeys(this);
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
        i = getProductId();
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[Product |");
        sb.append(" productId=").append(getProductId());
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
        ret.put("productId", Integer.valueOf(getProductId()));
        return ret;
    }

}
