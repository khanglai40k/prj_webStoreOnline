package com.product.product_project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Data
@NoArgsConstructor  // hafm tao ko tham so
@AllArgsConstructor // ham tao 1 tham so


public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //random id
    private Long id;
    private String name;

    @ManyToOne  // Many products can belong to one category  postman nó sẽ thưc hiện 2 truye vấn
    @JoinColumn(name = "id_category", referencedColumnName = "id")
    private Category category;  // Tham chiếu đến thực thể Category  bắt buộc

    private Double price;


}
