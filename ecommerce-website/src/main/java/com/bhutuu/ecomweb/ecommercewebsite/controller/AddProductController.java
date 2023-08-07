package com.bhutuu.ecomweb.ecommercewebsite.controller;

// import com.bhutuu.ecomweb.ecommercewebsite.dao.AddProductDao;
// import java.io.IOException;
import com.bhutuu.ecomweb.ecommercewebsite.entity.AddProduct;
import com.bhutuu.ecomweb.ecommercewebsite.service.AddProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;

@RestController
public class AddProductController {

    @Autowired
    private AddProductService addProductService;

    @PostMapping(value={"/saveProduct"},consumes= {MediaType.MULTIPART_FORM_DATA_VALUE})
    public AddProduct saveProduct(@RequestPart("product") AddProduct product) {
        try {
		
			return addProductService.saveProduct(product);		
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }
}
