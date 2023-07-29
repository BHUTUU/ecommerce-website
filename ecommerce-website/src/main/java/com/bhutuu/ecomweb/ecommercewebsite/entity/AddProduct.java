package com.bhutuu.ecomweb.ecommercewebsite.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
// import jakarta.persistence.Lob;

@Entity
public class AddProduct {
    @Id
    private String productName;
    private String productBrand;
    private String productPrice;
    private String productCategory;
    private String productQuantity;
    private String productDescription;
    // @Lob
    // private byte[] productImage;
    // public String getProductName() {
    //     return productName;
    // }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductBrand() {
        return productBrand;
    }
    public String getProductQuantity() {
        return productQuantity;
    }
    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }
    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }
    public String getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
    public String getProductCategory() {
        return productCategory;
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
    // public byte[] getProductImage() {
    //     return productImage;
    // }
    // public void setProductImage(byte[] productImage) {
    //     this.productImage = productImage;
    // }
   
}