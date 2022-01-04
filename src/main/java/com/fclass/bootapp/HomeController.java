package com.fclass.bootapp;

import com.fclass.bootapp.model.City;
import com.fclass.bootapp.model.CityRepository;
import net.bytebuddy.matcher.StringMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.lang.module.ModuleFinder;
import java.util.List;
import java.util.Optional;

//Name could be anything, it doesn't have to be Home to Control the home.jsp View
@Controller
@CrossOrigin("https://www.codepunker.com")
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
        return "home";
    }

    @RequestMapping("/login")
    public String loginPage(){
        System.out.println("in the login page");
        return "login";
    }

    @RequestMapping("logout-success")
    public String logoutPage(){
        System.out.println("log out success");
        return "logout";
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


    @RequestMapping("/findcitybygreaterid")
    public ModelAndView findCityIdGreaterThan(@RequestParam int cityId){
        List<City> idsGreaterThan = cityRepository.findByCityIdGreaterThan(cityId);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("getcity");
        mv.addObject("cityidsgreaterthan", idsGreaterThan);
        return mv;
    }


    @RequestMapping("/findcitybynamestartingwith")
    public ModelAndView findByCityNameStartingWith(@RequestParam String prefix){

        List<City> cityNamesStartingWith = cityRepository.findByCityNameStartingWith(prefix);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("getcity");
        mv.addObject("citynamesstartingwith", cityNamesStartingWith);
        return mv;
    }

    @RequestMapping("/findbycountrynameorderedbycityname")
    public ModelAndView findByCountryOrderByCity(@RequestParam String cityCountry){
        List<City> countriesOrderByCity = cityRepository.findByCityCountryOrderByCityName(cityCountry);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("getcity");
        mv.addObject("countryorderbycity", countriesOrderByCity);
        return mv;
    }

   @RequestMapping("/findcitynamewithcountrypattern")
    public ModelAndView findCityNameWithCountryPattern(@RequestParam String pattern){
        List<String> cityNames = cityRepository.findCityNameWithCountryPattern(pattern);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("getcity");
        mv.addObject("cityNamesWithCountryPattern", cityNames);
        return mv;
   }


   @RequestMapping("/findcityidwithcityandcountry")
    public ModelAndView findCityIdWithCityAndCountry(@RequestParam String cityName,@RequestParam String cityCountry){
        int cityId = cityRepository.findCityIdWithCityAndCountry(cityName, cityCountry);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("getcity");
        mv.addObject("cityId", cityId);
        return mv;
   }


   @RequestMapping("/findcitieswithcountry")
    public ModelAndView findCityWithCountry(@RequestParam String cityCountry){
        List<City> citiesWithCountry = cityRepository.findCityByCountry(cityCountry);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("getcity");
        mv.addObject("citieswithcountry", citiesWithCountry);
        return mv;
   }
}
