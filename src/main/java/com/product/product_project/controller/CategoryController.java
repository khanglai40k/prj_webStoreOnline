package com.product.product_project.controller;


import com.product.product_project.Service.CategoryService;
import com.product.product_project.entity.Category;
import com.product.product_project.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categorys")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

//    get category
@GetMapping
public List<Category> getCategorys() {
    return categoryService.getCategorys();
}


}
