package com.dicka.appinventory.service.impl;

import com.dicka.appinventory.entity.Category;
import com.dicka.appinventory.exception.ResourceIsExistingException;
import com.dicka.appinventory.exception.ResourceNotFoundException;
import com.dicka.appinventory.model.RequestCreateCategory;
import com.dicka.appinventory.repository.CategoryRepository;
import com.dicka.appinventory.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ArrayList<Category> listCategory() {
        List<Category> categories = categoryRepository.findAll(Sort.by("createdAt"));
        ArrayList<Category> arrayCategory = new ArrayList<>();
        for (Category category : categories){
            arrayCategory.add(category);
        }
        return arrayCategory;
    }

    @Override
    public Category findById(int categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("id "+categoryId+" not found !"));
    }

    @Override
    public Category create(RequestCreateCategory createCategory) {

        Optional<Category> categoryByName = categoryRepository.findCategoryByName(createCategory.getName());
        if (categoryByName.isPresent()){
            throw new ResourceIsExistingException("sorry "+createCategory.getName()+" " +
                    "category is existing in our database !");
        }

        Category category = Category.builder()
                .name(createCategory.getName()).createdAt(new Date()).updatedAt(new Date())
                .build();
        return categoryRepository.save(category);
    }



    @Override
    public Category update(int categoryId, RequestCreateCategory createCategory) {

        Category category =  categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("category"));

        Optional<Category> categoryByName = categoryRepository.findCategoryByName(createCategory.getName());

        if (categoryByName.isPresent()){
            throw new ResourceIsExistingException("sorry "+createCategory.getName()+" is existing in our database !");
        }

        category.setName(createCategory.getName());
        category.setCreatedAt(category.getCreatedAt());
        category.setUpdatedAt(new Date());
        return categoryRepository.save(category);
    }
}
