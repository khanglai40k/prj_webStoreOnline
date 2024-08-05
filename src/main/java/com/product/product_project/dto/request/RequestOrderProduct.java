package com.product.product_project.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestOrderProduct {
    private String idProduct;
    private String idUser;

    private Double amount;

}
