package com.devoir.demo.service;

import com.devoir.demo.bo.PersonBO;
import com.devoir.demo.dao.PersonDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class PersonService {

    //@Autowired
    private PersonDao personDao ;

    @Value("${fileInsert.path}")
    private String pathToFile ;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Transactional
    public PersonBO insertion(PersonBO person){
        person.getCarList().forEach(car->car.setOwner(person));
        saveToFile(person);
        //malgrès l'except il a inséré ds la BD
        return personDao.save(person);
    }

    public void saveToFile(PersonBO person) {
        try{
            FileWriter fw=new FileWriter(pathToFile+"file.txt");
            fw.write("FirstName : "+person.getFirstName()+"\n LastName : "+person.getLastName());
            fw.close();
        }catch(Exception e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
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
