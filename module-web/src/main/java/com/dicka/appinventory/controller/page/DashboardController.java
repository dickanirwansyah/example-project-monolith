package com.dicka.appinventory.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class DashboardController {


    @GetMapping(value = {"/", "/index"})
    public ModelAndView getIndexPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", "Home");
        modelAndView.setViewName("dashboard/index");
        return modelAndView;
    }
}
