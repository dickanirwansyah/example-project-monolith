package com.dicka.appinventory.controller.app;

import com.dicka.appinventory.entity.Category;
import com.dicka.appinventory.model.RequestCreateCategory;
import com.dicka.appinventory.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    private HashMap<String, String> hashMapValidation;

    @PostMapping(value = "")
    public ResponseEntity<Object> createCategory(@RequestBody @Valid RequestCreateCategory createCategory,
                                                 BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            hashMapValidation = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()){
                hashMapValidation.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return new ResponseEntity<>(hashMapValidation, HttpStatus.NOT_ACCEPTABLE);
        }

        Category requestCategory = categoryService.create(createCategory);
        return new ResponseEntity<>(requestCategory, HttpStatus.CREATED);
    }

    @GetMapping(value = "")
    public ResponseEntity<ArrayList<Category>> listCategory(){
        ArrayList<Category> arrayCategory = categoryService.listCategory();
        return new ResponseEntity<>(arrayCategory, HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Object> updateCategory(@RequestParam(value = "categoryId")int categoryId,
                                                   @RequestBody RequestCreateCategory requestCreateCategory,
                                                   BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            hashMapValidation = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()){
                hashMapValidation.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return new ResponseEntity<>(hashMapValidation, HttpStatus.NOT_ACCEPTABLE);
        }

        Category category = categoryService.update(categoryId, requestCreateCategory);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @GetMapping(value = "/{categoryId}")
    public ResponseEntity<Category> getId(@PathVariable("categoryId")int categoryId){
        Category category = categoryService.findById(categoryId);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}
