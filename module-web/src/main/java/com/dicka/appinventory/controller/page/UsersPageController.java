package com.dicka.appinventory.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersPageController {

    @RequestMapping(value = "/users")
    public ModelAndView getUsersInfo(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("content/users-content");
        modelAndView.addObject("title", "Users Info");
        return modelAndView;
    }

}
