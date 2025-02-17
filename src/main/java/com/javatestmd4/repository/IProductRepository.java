package com.javatestmd4.repository;


import com.javatestmd4.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByProductTypeId(Long productTypeId); // Tìm sản phẩm theo loại
}
