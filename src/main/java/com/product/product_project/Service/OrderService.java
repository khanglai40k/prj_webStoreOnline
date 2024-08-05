package com.product.product_project.Service;

import com.product.product_project.Repository.OrderRepository;
import com.product.product_project.Repository.ProductRepository;
import com.product.product_project.Repository.UserRepository;
import com.product.product_project.dto.request.RequestOrderProduct;
import com.product.product_project.entity.Product;
import com.product.product_project.entity.PurchaseOrder;
import com.product.product_project.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;


    public PurchaseOrder createOrder(RequestOrderProduct requestOrderProduct) {
        Long userId = Long.parseLong(requestOrderProduct.getIdUser());
        Long productId = Long.parseLong(requestOrderProduct.getIdProduct());
        Double amount = requestOrderProduct.getAmount();
        // Lấy đối tượng User từ ID
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Lấy đối tượng Product từ ID
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Double totalPrice = product.getPrice() * amount; // lấy giá nhân số lượng theo cái product id kia
        // Tạo đối tượng PurchaseOrder
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setUser(user);
        purchaseOrder.setProduct(product);
        purchaseOrder.setAmount(amount);
        purchaseOrder.setTotal_counter(totalPrice); // tính tiền

        // Lưu đối tượng vào cơ sở dữ liệu
        return orderRepository.save(purchaseOrder);
    }

}
