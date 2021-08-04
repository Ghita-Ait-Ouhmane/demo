package com.devoir.demo.controller;

import com.devoir.demo.bo.CarBO;
import com.devoir.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping(path = "/car")
    public CarBO insertCar(@RequestBody CarBO car){
        return carService.insertion(car);
    }
}
