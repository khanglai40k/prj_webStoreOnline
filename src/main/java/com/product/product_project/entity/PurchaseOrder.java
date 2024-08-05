package com.product.product_project.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User user;  // Khóa ngoại tham chiếu đến User

    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id")
    private Product product;  // Khóa ngoại tham chiếu đến Product

    private Timestamp time_buy;

    // time update now
    @PrePersist
    public void prePersist() {
        this.time_buy = Timestamp.from(Instant.now());
    }

    @PreUpdate
    public void preUpdate() {
        this.time_buy = Timestamp.from(Instant.now());
    }

    private Double amount;
    private Double total_counter;

}