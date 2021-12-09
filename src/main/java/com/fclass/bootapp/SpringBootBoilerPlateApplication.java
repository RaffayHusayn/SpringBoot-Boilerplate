package com.fclass.bootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.springframework.boot.SpringApplication.*;

@SpringBootApplication
public class SpringBootBoilerPlateApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = run(SpringBootBoilerPlateApplication.class, args);
        HomeController homeController = context.getBean(HomeController.class);
        homeController.showHome();
    }

}
