package com.cesi.heroes.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;

@Entity
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_hero;
    private String name;

    private EIncident incident1;

    private EIncident incident2;

    private EIncident incident3;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="id_city")
    private City city;
    private String phone;
    private double longitude;
    private double latitude;

    public Long getId() {
        return id_hero;
    }

    public void setId(Long id) {
        this.id_hero = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public EIncident getIncident1() {
        return incident1;
    }

    public void setIncident1(EIncident incident1) {
        this.incident1 = incident1;
    }

    public EIncident getIncident2() {
        return incident2;
    }

    public void setIncident2(EIncident incident2) {
        this.incident2 = incident2;
    }

    public EIncident getIncident3() {
        return incident3;
    }

    public void setIncident3(EIncident incident3) {
        this.incident3 = incident3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hero hero = (Hero) o;

        return Objects.equals(id_hero, hero.id_hero);
    }

    @Override
    public int hashCode() {
        return id_hero != null ? id_hero.hashCode() : 0;
    }

    @Override
    public String toString() {
        String res;
        res = "Hero{" +
                "id=" + id_hero +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
        /*for(Incident i : incidents){
            res+=i.toString();
        };*/
        return res;

    }
}
