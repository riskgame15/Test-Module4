package com.javatestmd4.repository;


import com.javatestmd4.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IProductTypeRepository extends JpaRepository<ProductType, Long> {
}