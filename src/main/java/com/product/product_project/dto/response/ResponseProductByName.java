package com.product.product_project.dto.response;

import com.product.product_project.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class ResponseProductByName {
    private String name;
   private String category;  // kiểu dữ liệu stirng


}
