package com.product.product_project.controller;

import com.product.product_project.Service.OrderService;
import com.product.product_project.dto.request.RequestOrderProduct;
import com.product.product_project.entity.PurchaseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestBody RequestOrderProduct requestOrderProduct) {
        PurchaseOrder purchaseOrder = orderService.createOrder(requestOrderProduct);
        return ResponseEntity.ok(purchaseOrder);
    }


}
