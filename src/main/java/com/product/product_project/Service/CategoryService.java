package com.product.product_project.Service;

import com.product.product_project.Repository.CategoryRepository;
import com.product.product_project.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getCategorys(){
        return categoryRepository.findAll();
    }

}
