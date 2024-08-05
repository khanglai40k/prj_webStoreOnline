package com.product.product_project.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor  // hafm tao ko tham so
@AllArgsConstructor // ham tao 1 tham so

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //random id
    private Long id;
    private String name;
    private String password;

}
