package com.devoir.demo.dao;

import com.devoir.demo.bo.PersonBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonDao extends JpaRepository<PersonBO, Long> {

    List<PersonBO> findByFirstName(String fName);

    List<PersonBO> findByFirstNameAndLastName(String fName, String lName);

    @Query("SELECT  distinct  p FROM PersonBO p JOIN p.carList AS c WHERE c.color=?2 AND p.firstName=?1")
    List<PersonBO> requestFirstnameAndCarColor(String fName, String carColor);

}