package com.bhutuu.ecomweb.ecommercewebsite.dao;

import com.bhutuu.ecomweb.ecommercewebsite.entity.AddProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AddProductDao extends CrudRepository<AddProduct, String> {

}
