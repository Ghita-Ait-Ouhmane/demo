package com.devoir.demo.bo;

import org.apache.catalina.LifecycleState;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="PERSONNE")
public class PersonBO {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private long id;

    @Column(name="PRENOM")
    private String firstName;

    @Column(name="NOM")
    private String lastName;

    @OneToMany(mappedBy = "owner",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<CarBO> carList ;

    public List<CarBO> getCarList() {
        return carList;
    }

    public void setCarList(List<CarBO> carList) {
        this.carList = carList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
