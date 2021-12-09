package com.fclass.bootapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

//Name could be anything, it doesn't have to be Home to Control the home.jsp View
@Controller
public class HomeController {


    @RequestMapping("home")
    public ModelAndView showHome(HttpServletRequest req){
        System.out.println("in the showHome method");
        String name = req.getParameter("name");
        ModelAndView mv = new ModelAndView();
        String output = "this is the output for Homepage for "+ name;
        mv.setViewName("home");
        mv.addObject("outputHome", output);
        System.out.println(output);
        return mv;
    }

    @RequestMapping("")
    public String showIndex(){
        System.out.println("in the showIndex method");
        return "index";
    }
}
