package com.devoir.demo.service;

import com.devoir.demo.bo.PersonBO;
import com.devoir.demo.dao.PersonDao;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {
    @Mock
    private PersonDao personDao ;
    @InjectMocks
    private PersonService ps ;

    @Test
    void getByFirstNameNotNullPerson() {
        PersonBO expectedPerson = new PersonBO();
        expectedPerson.setFirstName("Luffy");
        List<PersonBO> expectedList = new ArrayList<PersonBO>();
        expectedList.add(expectedPerson);

        //when(personDao.findByFirstName("Luffy").thenReturn(expectedList));
        doReturn(expectedList).when(personDao).findByFirstName("Luffy");

        List<PersonBO> gottenPersonList = ps.getPersonFirstName("Luffy");
        assertEquals("Luffy",gottenPersonList.get(0).getFirstName());
    }

    /*
    @BeforeEach
    void init(){
        ps = new PersonService(personDao);
    }
    */
}