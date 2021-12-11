package com.fclass.bootapp;

import com.fclass.bootapp.model.City;
import com.fclass.bootapp.model.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//Name could be anything, it doesn't have to be Home to Control the home.jsp View
@Controller
public class HomeController {

    @Autowired
    private CityRepository cityRepository;

    @RequestMapping(value = "home" , method = RequestMethod.GET)
    public ModelAndView showHome(City karachi){
        System.out.println("in the showHome method");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        mv.addObject("objOutput", karachi);
        return mv;
    }

    @RequestMapping("")
    public String showIndex(){
        System.out.println("in the showIndex method");
        return "index";
    }

    @RequestMapping("/addcity")
    public String addCity(City karachi){
        cityRepository.save(karachi);
        return "home";

    }
}
