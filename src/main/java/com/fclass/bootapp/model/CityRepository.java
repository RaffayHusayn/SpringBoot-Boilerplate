package com.fclass.bootapp.model;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CityRepository extends CrudRepository<City, Integer> {
    /*
    ======================================================================================
    These are the functions that you have to just mention without giving any
    function body. If the function is named in a certain way as required by Spring
    then Spring will take care of the function body
    ======================================================================================
     */
    List<City> getCityByCityCountry(String country);
    List<City> findByCityIdGreaterThan(int Id);
    List<City> findByCityNameStartingWith(String prefix);
    List<City> findByCityCountryOrderByCityName(String city);


    /*
    ======================================================================================
    For more complex queries we can use @Query annotation and just
    write down a query in JPQL by default but we can also use native SQL
    ======================================================================================
     */
    // JPQL query with 1 Index query parameter
    @Query("select cityName from City where cityCountry like ?1")
    List<String> findCityNameWithCountryPattern(String pattern);

    // JPQL query with 2 Index query Parameter
    @Query("select cityId from City where cityName = ?1 and cityCountry = ?2")
    int findCityIdWithCityAndCountry(String cityName, String cityCountry);

    //JPQL query with named query parameter
    @Query("from City where cityCountry = :country")
    List<City> findCityByCountry(@Param("country") String country);//named query param and @Param should be same, String variable can be anything


}
