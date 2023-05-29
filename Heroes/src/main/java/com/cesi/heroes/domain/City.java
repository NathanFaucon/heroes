package com.cesi.heroes.domain;

import jakarta.persistence.*;


@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_city;
    private String nom;
    /*public City(String nom) {
        this.id = id;
        this.nom = nom;
        id++;
    }*/

    public Long getId() {
        return id_city;
    }

    public void setId(Long id) {
        this.id_city = id;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id_city +
                ", nom='" + nom + '\'' +
                '}';
    }
}
