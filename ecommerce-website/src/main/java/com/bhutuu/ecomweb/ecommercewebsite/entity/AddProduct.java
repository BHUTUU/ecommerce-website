package com.bhutuu.ecomweb.ecommercewebsite.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.Lob;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class AddProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId;
    private String productName;
    private String productBrand;
    private Double productActualPrice;
    private Double productDiscountedPrice;
    private String productCategory;
    private Integer productQuantity;
    private String productDescription;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="product_image",
joinColumns = {
		@JoinColumn(name="id")
},
inverseJoinColumns= {
		@JoinColumn(name="image_id")
}
)
	
	private Set<ImageUpload> productImage;

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductBrand() {
        return productBrand;
    }
    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }
    public Double getProductActualPrice() {
        return productActualPrice;
    }
    public void setProductActualPrice(Double productActualPrice) {
        this.productActualPrice = productActualPrice;
    }
    public Double getProductDiscountedPrice() {
        return productDiscountedPrice;
    }
    public void setProductDiscountedPrice(Double productDiscountedPrice) {
        this.productDiscountedPrice = productDiscountedPrice;
    }
    public String getProductCategory() {
        return productCategory;
    }
    public Integer getProductQuantity() {
        return productQuantity;
    }
    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }
    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductDescription() {
        return productDescription;
    }
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
    
    public Set<ImageUpload> getProductImage() {
        return productImage;
    }
    public void setProductImage(Set<ImageUpload> productImage) {
        this.productImage = productImage;
    }
    
    public AddProduct() {

    }
    public AddProduct(Integer productId, String productName, String productBrand, Double productActualPrice, Double productDiscountedPrice, String productCategory, Integer productQuantity, String productDescription, Set<ImageUpload> productImage) {
        this.productId = productId;
        this.productName = productName;
		this.productBrand = productBrand;
        this.productActualPrice = productActualPrice;
        this.productDiscountedPrice = productDiscountedPrice;
        this.productQuantity = productQuantity;
        this.productDescription = productDescription;
        this.productImage = productImage;
    }
  
}