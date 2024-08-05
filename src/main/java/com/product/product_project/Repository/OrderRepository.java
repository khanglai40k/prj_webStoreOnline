package com.product.product_project.Repository;

import com.product.product_project.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<PurchaseOrder,Long> {
}
