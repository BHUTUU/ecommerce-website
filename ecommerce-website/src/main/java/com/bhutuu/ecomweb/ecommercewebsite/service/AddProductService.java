package com.bhutuu.ecomweb.ecommercewebsite.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bhutuu.ecomweb.ecommercewebsite.entity.AddProduct;
import com.bhutuu.ecomweb.ecommercewebsite.dao.AddProductDao;

@Service
public class AddProductService {
    private final AddProductDao addProductDao;

    @Autowired
    public AddProductService(AddProductDao addProductDao) {
        this.addProductDao = addProductDao;
    }

    public void saveProduct(AddProduct product) {
        addProductDao.save(product);
    }
}