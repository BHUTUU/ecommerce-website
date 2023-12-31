package com.bhutuu.ecomweb.ecommercewebsite.service;
import com.bhutuu.ecomweb.ecommercewebsite.dao.AddProductDao;
import com.bhutuu.ecomweb.ecommercewebsite.entity.AddProduct;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AddProductService {
    @Autowired
    private  AddProductDao addProductDao;

    public AddProduct saveProduct(AddProduct product) {

        return addProductDao.save(product);
    }

    public List<AddProduct> getAllProducts() {
        return (List<AddProduct>) addProductDao.findAll();
    }
}