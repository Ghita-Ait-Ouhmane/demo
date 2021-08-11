package com.devoir.demo.service;

import com.devoir.demo.bo.PersonBO;
import com.devoir.demo.dao.PersonDao;
import com.devoir.demo.dto.PersonDTO;
import com.devoir.demo.mapper.PersonMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileWriter;
import java.util.List;

@Service
public class PersonService {

    //@Autowired
    private PersonDao personDao ;

    //@Autowired
    private final PersonMap personMapper;

    @Value("${fileInsert.path}")
    private String pathToFile ;

    public PersonService(PersonDao personDao, PersonMap personMapper) {
        this.personDao = personDao;
        this.personMapper = personMapper;
    }

    /*
    public PersonService(PersonDao personDao) {
        this.personDao = personDao;Q
    }

     */

    @Transactional
    public PersonDTO insertion(PersonBO person){
        person.getCarList().forEach(car->car.setOwner(person));
        PersonBO bo = personDao.save(person);
        /* Manual Mapping
        PersonMapper personMapper = new PersonMapper();
        return personMapper.toDTO(bo);
         */
        return personMapper.personBOToDTO(bo);
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
