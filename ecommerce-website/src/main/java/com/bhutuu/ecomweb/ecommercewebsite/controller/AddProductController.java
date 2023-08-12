package com.bhutuu.ecomweb.ecommercewebsite.controller;

// import com.bhutuu.ecomweb.ecommercewebsite.dao.AddProductDao;
// import java.io.IOException;
import com.bhutuu.ecomweb.ecommercewebsite.entity.AddProduct;
import com.bhutuu.ecomweb.ecommercewebsite.entity.ImageUpload;
import com.bhutuu.ecomweb.ecommercewebsite.service.AddProductService;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class AddProductController {

    @Autowired
    private AddProductService addProductService;

    @PostMapping(value={"/saveProduct"},consumes= {MediaType.MULTIPART_FORM_DATA_VALUE})
    public AddProduct saveProduct(@RequestPart("product") AddProduct product, @RequestPart ("imageFile") MultipartFile[] file) {
        try {
            Set<ImageUpload> docs=uploadImage(file);
			product.setProductImage(docs);		
			return addProductService.saveProduct(product);		
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }

    public Set<ImageUpload> uploadImage(MultipartFile[] multipartFiles) throws IOException{
		
		Set<ImageUpload> imageUploads=new HashSet<>();
	
		for(MultipartFile file: multipartFiles) {
		ImageUpload imageUpload= new ImageUpload(
				file.getOriginalFilename(),
				file.getContentType(),
				file.getBytes()
				);
		imageUploads.add(imageUpload);
		}
	return imageUploads;
	}
	@GetMapping({"/getAllProducts"})
	public List<AddProduct> getAllProducts() {
		return addProductService.getAllProducts();
	}
}
