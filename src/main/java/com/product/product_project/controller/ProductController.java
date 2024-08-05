package com.product.product_project.controller;

import com.product.product_project.Service.ProductService;
import com.product.product_project.dto.request.RequestCreateUpdateProduct;
import com.product.product_project.dto.response.ResponseProductByName;
import com.product.product_project.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

//    get product all

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    // tìm theo tên và phân trang
    @GetMapping("/search")
    public List<ResponseProductByName> searchProductByName(@RequestParam("name") String name, Pageable pageable) {  // tham số thì ?
        return productService.searchProductByName(name, pageable).getContent(); // getcontent trả veef mỗi product ko trả về thông tin phân trang
    }


//    add product
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody RequestCreateUpdateProduct createProduct) {
        Product product = productService.addProduct(createProduct);
        return ResponseEntity.ok(product); // Phương thức ok() là một phương thức tĩnh (static) của ResponseEntity,
        // trả về mã trạng thái HTTP 200 (OK) và có thể bao gồm một đối tượng dữ liệu.
    }

// edit product
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, //path thì /
                                                 @RequestBody RequestCreateUpdateProduct productRequest) {
        Product updatedProduct = productService.updateProduct(id, productRequest);
        return ResponseEntity.ok(updatedProduct);
    }


// delete product
    @DeleteMapping("/delete-product/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return "product has been delete";
    }

}
