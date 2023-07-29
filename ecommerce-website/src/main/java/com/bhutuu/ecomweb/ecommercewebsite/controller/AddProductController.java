package com.bhutuu.ecomweb.ecommercewebsite.controller;

// import java.io.IOException;
import com.bhutuu.ecomweb.ecommercewebsite.entity.AddProduct;
import com.bhutuu.ecomweb.ecommercewebsite.service.AddProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;

@RestController
public class AddProductController {

    @Autowired
    private AddProductService addProductService;

    @PostMapping("/saveProduct")
    public String saveProduct(@RequestParam("productName") String productName,
                            @RequestParam("productBrand") String productBrand,
                            @RequestParam("productPrice") String productPrice,
                            @RequestParam("productCategory") String productCategory,
                            @RequestParam("productQuantity") String productQuantity,
                            @RequestParam("productDescription") String productDescription) {

        AddProduct product = new AddProduct();
        product.setProductName(productName);
        product.setProductBrand(productBrand);
        product.setProductPrice(productPrice);
        product.setProductCategory(productCategory);
        product.setProductQuantity(productQuantity);
        product.setProductDescription(productDescription);
        addProductService.saveProduct(product);
        return "Product Uploaded successfully";
    }
}
