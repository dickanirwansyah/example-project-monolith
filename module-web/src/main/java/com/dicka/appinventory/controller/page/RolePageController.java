package com.dicka.appinventory.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RolePageController {

    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public ModelAndView getRoleInfo(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("content/role-content");
        modelAndView.addObject("title", "Role Information");
        return modelAndView;
    }
}
