package com.fclass.bootapp.model;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CityRepository extends CrudRepository<City, Integer> {
    /*
    These are the functions that you have to just mention without giving any
    function body. If the function is named in a certain way as required by Spring
    then Spring will take care of the function body
     */
    List<City> getCityByCityCountry(String Country);
    List<City> findByCityIdGreaterThan(int Id);

}
