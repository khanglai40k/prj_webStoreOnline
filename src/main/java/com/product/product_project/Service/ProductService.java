package com.product.product_project.Service;

import com.product.product_project.Repository.CategoryRepository;
import com.product.product_project.Repository.ProductRepository;
import com.product.product_project.dto.request.RequestCreateUpdateProduct;
import com.product.product_project.dto.response.ResponseProductByName;
import com.product.product_project.entity.Category;
import com.product.product_project.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;  // mục đích để injject method và attribute của interface product

    @Autowired
    private CategoryRepository categoryRepository; // Repository để lấy category


//get product all

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

// get product by name theo recommend
public Page<ResponseProductByName> searchProductByName(String name, Pageable pageable) {
    Page<Product> products = productRepository.findByNameContainingIgnoreCase(name, pageable);
    return products.map(product -> new ResponseProductByName(product.getName(), product.getCategory().getName()));
    //nó chuyển sang response cái mà mình đã lọc dữ liệu
    // dòng return đang bị lú cần xem lại
}


// add product
    public Product addProduct(RequestCreateUpdateProduct productRequest) {
        // Lấy Category từ ID
        Category category = categoryRepository.findById(productRequest.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));  // chuaw xu li exxcep response

        // Tạo sản phẩm mới (chuaw dung thu vien numsit dau)
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setCategory(category);

        // Lưu sản phẩm vào cơ sở dữ liệu
        return productRepository.save(product);
    }

//    edit product
public Product updateProduct(Long id, RequestCreateUpdateProduct productRequest) {
    // tim theo id và cái orElseThrow  ném cái lỗi not founf
    Product existingProduct = productRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Product not found"));

    // update
    existingProduct.setName(productRequest.getName());

    // tìm vaf sửa cái category
    Category category = categoryRepository.findById(productRequest.getCategoryId())
            .orElseThrow(() -> new RuntimeException("Category not found"));
    existingProduct.setCategory(category);

    return productRepository.save(existingProduct);
}

//delete
public void deleteProduct(Long id) {
    // Check if the product exists
    if (!productRepository.existsById(id)) {
        throw new RuntimeException("Product not found");
    }

    // Delete the product
    productRepository.deleteById(id);
}
}
