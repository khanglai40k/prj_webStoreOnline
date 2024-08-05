package com.product.product_project.Repository;

import com.product.product_project.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;
import org.springframework.data.domain.Page;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findByNameContainingIgnoreCase(String name, Pageable pageable); //recomment name  , pageination nữa


}
