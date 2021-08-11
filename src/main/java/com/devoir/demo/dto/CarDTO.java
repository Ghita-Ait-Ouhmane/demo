package com.devoir.demo.dto;

import com.devoir.demo.bo.PersonBO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class CarDTO {

    private long id;

    private String color;

    private String brand ;


    private boolean principal ;

    public boolean isPrincipal() {
        return principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }



    //private PersonBO owner ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    /*
    public PersonBO getOwner() {
        return owner;
    }

    public void setOwner(PersonBO owner) {
        this.owner = owner;
    }
    */

}
