package com.devoir.demo.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="VOITURE")
public class CarBO {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private long id;
    
    @Column(name="COULEUR")
    private String color;

    @Column(name="MARQUE")
    private String brand ;

    @ManyToOne
    @JoinColumn(name = "PERSONNE_ID", referencedColumnName = "ID")
    @JsonIgnore
    private PersonBO owner ;

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

    public PersonBO getOwner() {
        return owner;
    }

    public void setOwner(PersonBO owner) {
        this.owner = owner;
    }
}
