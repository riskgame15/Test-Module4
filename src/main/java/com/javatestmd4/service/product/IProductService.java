package com.javatestmd4.service.product;


import com.javatestmd4.model.Product;
import com.javatestmd4.service.IGenericService;

import java.util.List;

public interface IProductService extends IGenericService<Product> {

    List<Product> findByProductType(Long typeId);
}
