package com.devoir.demo.controller;

import com.devoir.demo.bo.PersonBO;
import com.devoir.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping(path = "/person")
    public PersonBO insertPerson(@RequestBody PersonBO person){
        return personService.insertion(person);
    }

    @GetMapping(path="/person/{prenom}")
    public List<PersonBO> getPersonFirstName(@PathVariable String prenom){
        return personService.getPersonFirstName(prenom);
    }

    @GetMapping(path="/person/{prenom}/{nom}")
    public List<PersonBO> getPersonFirstNameAndLastName(@PathVariable String prenom, @PathVariable String nom){
        return personService.getPersonFirstNameAndLastName(prenom,nom);
    }

    @GetMapping(path="/person/{prenom}/car/{color}")
    //@ResponseBody
    public List<PersonBO> getPersonFirstNameAndCarColor(@PathVariable String prenom, @PathVariable String color){
        return personService.getPersonFirstNameAndCarColor(prenom,color);
    }
}
