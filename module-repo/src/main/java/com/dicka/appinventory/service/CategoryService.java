package com.dicka.appinventory.service;

import com.dicka.appinventory.entity.Category;
import com.dicka.appinventory.model.RequestCreateCategory;

import java.util.ArrayList;

public interface CategoryService {

    ArrayList<Category> listCategory();
    Category findById(int categoryId);
    Category create(RequestCreateCategory createCategory);
    Category update(int categoryId, RequestCreateCategory createCategory);

}
