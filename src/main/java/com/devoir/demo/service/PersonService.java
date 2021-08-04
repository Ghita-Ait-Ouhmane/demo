package com.devoir.demo.service;

import com.devoir.demo.bo.CarBO;
import com.devoir.demo.bo.PersonBO;
import com.devoir.demo.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonDao personDao ;

    public PersonBO insertion(PersonBO person){
        /*
        for(CarBO car : person.getCarList()){
            car.setOwner(person);
        }
        */
        person.getCarList().forEach(car->car.setOwner(person));
        return personDao.save(person);
    }

    public List<PersonBO> getPersonFirstName(String personFirstName) {
        return personDao.findByFirstName(personFirstName);
    }

    public List<PersonBO> getPersonFirstNameAndLastName(String personFirstName, String personLastName) {
        return personDao.findByFirstNameAndLastName(personFirstName,personLastName);
    }

    public List<PersonBO> getPersonFirstNameAndCarColor(String prenom, String color) {
        return personDao.requestFirstnameAndCarColor(prenom,color);
    }
}
