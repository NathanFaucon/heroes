package com.cesi.heroes.domain;

public enum EIncident {
    Aucun(0, "Aucun"),
    Incendie(1, "Incendie"),
    Accident_routier(2, "Accident routier"),
    Accident_fluvial(3, "Accident fluvial"),
    Accident_aerien(4, "Accident aérien"),
    Eboulement(5, "Eboulement"),
    Invasion_serpent(6, "Invasion de serpents"),
    Fuite_gaz(7, "Fuite de gaz"),
    Manifestation(8, "Manifestation"),
    Braquage(9, "Braquage"),
    Evasion(10, "Evasion d'un prisonnier");

    private final int id;
    private final String nom;


    EIncident(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        if(nom==null) {
            return "";
        }
        return nom;
    }

}
