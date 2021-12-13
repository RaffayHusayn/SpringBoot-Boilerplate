package com.fclass.bootapp;

import com.fclass.bootapp.model.City;
import com.fclass.bootapp.model.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.lang.module.ModuleFinder;
import java.util.List;
import java.util.Optional;

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

    @RequestMapping("/allcity")
    public @ResponseBody Iterable<City> allCity(){
        return cityRepository.findAll();

    }

    @RequestMapping("/getcity")
    public ModelAndView getCity(@RequestParam int cityId){
        ModelAndView mv = new ModelAndView();
        Optional<City> city = cityRepository.findById(cityId);//can use optional<city> so don't have to deal with null objects from database
        System.out.println(city);
        mv.setViewName("getcity");
        mv.addObject ("city", city);
        return mv;
    }

    @RequestMapping("/deletecity")
    public ModelAndView deleteCity(@RequestParam int cityId){

        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        System.out.println("in delete city controller");
        if(cityRepository.existsById(cityId)) {
            cityRepository.deleteById(cityId);
            mv.addObject("deletecity", "city with id : "+ cityId+ " is deleted");
            return mv;
        }else{
            mv.addObject("deletecity", "the city with id : "+cityId+ " doesn't exist");
            return mv;
        }

    }


    @RequestMapping("/updatecity")
    public ModelAndView updateCity( City city){
        System.out.println("in the update city method");

        ModelAndView mv =new ModelAndView();
        mv.setViewName("home");

        if(cityRepository.existsById(city.getCityId())){
            cityRepository.save(city);
            mv.addObject("updatecity", "city updated");
            return mv;

        }else{
           mv.addObject("updatecity", "City with id : "+ city.getCityId()+ " doesn't exist so can't update");
           return mv;
        }

    }


    @RequestMapping("/findcitybycountry")
    public ModelAndView findCityByCountry(@RequestParam String cityCountry){

        List<City> cityByCountry =  cityRepository.getCityByCityCountry(cityCountry);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("getcity");
        System.out.println(cityByCountry);
        mv.addObject("citybycountry", cityByCountry);
        return mv;
    }
}
