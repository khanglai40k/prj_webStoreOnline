package com.product.product_project.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestCreateUpdateProduct {
    private String name;
    private Long categoryId;  // se la key trong posstman


}
