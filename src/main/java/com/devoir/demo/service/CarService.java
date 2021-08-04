package com.devoir.demo.service;

import com.devoir.demo.bo.CarBO;
import com.devoir.demo.dao.CarDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    private CarDao carDao ;

    public CarBO insertion(CarBO car){
        return carDao.save(car);
    }
}
