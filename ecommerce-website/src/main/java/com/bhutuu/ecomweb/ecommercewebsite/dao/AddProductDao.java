package com.bhutuu.ecomweb.ecommercewebsite.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bhutuu.ecomweb.ecommercewebsite.entity.AddProduct;

@Repository
public interface AddProductDao extends CrudRepository<AddProduct, String> {

}
