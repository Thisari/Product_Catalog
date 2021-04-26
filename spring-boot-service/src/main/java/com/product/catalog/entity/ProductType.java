// Generated with g9.

package com.product.catalog.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="product_type", indexes={@Index(name="product_type_product_type_code_IX", columnList="product_type_code", unique=true), @Index(name="product_type_product_type_name_IX", columnList="product_type_name", unique=true)})
public class ProductType implements Serializable {

    /** Primary key. */
    protected static final String PK = "productTypeId";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="product_type_id", unique=true, nullable=false, precision=10)
    private int productTypeId;
    @Column(name="product_type_code", unique=true, nullable=false, length=10)
    private String productTypeCode;
    @Column(name="product_type_name", unique=true, nullable=false, length=100)
    private String productTypeName;
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
    @OneToMany(mappedBy="productType")
    private Set<Product> product;

    /** Default constructor. */
    public ProductType() {
        super();
    }

    /**
     * Access method for productTypeId.
     *
     * @return the current value of productTypeId
     */
    public int getProductTypeId() {
        return productTypeId;
    }

    /**
     * Setter method for productTypeId.
     *
     * @param aProductTypeId the new value for productTypeId
     */
    public void setProductTypeId(int aProductTypeId) {
        productTypeId = aProductTypeId;
    }

    /**
     * Access method for productTypeCode.
     *
     * @return the current value of productTypeCode
     */
    public String getProductTypeCode() {
        return productTypeCode;
    }

    /**
     * Setter method for productTypeCode.
     *
     * @param aProductTypeCode the new value for productTypeCode
     */
    public void setProductTypeCode(String aProductTypeCode) {
        productTypeCode = aProductTypeCode;
    }

    /**
     * Access method for productTypeName.
     *
     * @return the current value of productTypeName
     */
    public String getProductTypeName() {
        return productTypeName;
    }

    /**
     * Setter method for productTypeName.
     *
     * @param aProductTypeName the new value for productTypeName
     */
    public void setProductTypeName(String aProductTypeName) {
        productTypeName = aProductTypeName;
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
     * Access method for product.
     *
     * @return the current value of product
     */
    public Set<Product> getProduct() {
        return product;
    }

    /**
     * Setter method for product.
     *
     * @param aProduct the new value for product
     */
    public void setProduct(Set<Product> aProduct) {
        product = aProduct;
    }

    /**
     * Compares the key for this instance with another ProductType.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class ProductType and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof ProductType)) {
            return false;
        }
        ProductType that = (ProductType) other;
        if (this.getProductTypeId() != that.getProductTypeId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another ProductType.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ProductType)) return false;
        return this.equalKeys(other) && ((ProductType)other).equalKeys(this);
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
        i = getProductTypeId();
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
        StringBuffer sb = new StringBuffer("[ProductType |");
        sb.append(" productTypeId=").append(getProductTypeId());
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
        ret.put("productTypeId", Integer.valueOf(getProductTypeId()));
        return ret;
    }

}
