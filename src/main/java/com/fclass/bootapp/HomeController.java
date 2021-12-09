package com.fclass.bootapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//Name could be anything, it doesn't have to be Home to Control the home.jsp View
@Controller
public class HomeController {


    @RequestMapping("home")
    public String showHome(){
        System.out.println("in the showHome method");
        return "home";
    }
}
