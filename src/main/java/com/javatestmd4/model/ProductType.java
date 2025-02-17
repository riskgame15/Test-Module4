package com.javatestmd4.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "product_type")
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}