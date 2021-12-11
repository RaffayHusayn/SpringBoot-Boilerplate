package com.fclass.bootapp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class City {
    @Id
    int cityId;
    String cityName;
    String cityCountry;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCountry() {
        return cityCountry;
    }

    public void setCityCountry(String cityCountry) {
        this.cityCountry = cityCountry;
    }


    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", cityCountry='" + cityCountry + '\'' +
                '}';
    }
}
