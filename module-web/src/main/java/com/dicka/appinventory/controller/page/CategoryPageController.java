package com.dicka.appinventory.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class CategoryPageController {

    @GetMapping(value = "/category")
    public ModelAndView getCategory(){
        ModelAndView view = new ModelAndView();
        view.setViewName("content/category-content");
        view.addObject("title", "Category Product");
        return view;
    }
}
