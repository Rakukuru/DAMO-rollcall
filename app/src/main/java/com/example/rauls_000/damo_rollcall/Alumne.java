package com.example.rauls_000.damo_rollcall;

/**
 * Created by thelaser on 28/12/17.
 */

public class Alumne {

    private CharSequence dni;
    private CharSequence nom_alumn;
    private int assistit;

    public Alumne (CharSequence identif, CharSequence nom) {
        dni = identif;
        nom_alumn = nom;
        assistit = 0;
    }

    public CharSequence view_nom() {
        return nom_alumn;
    }

    public CharSequence view_dni() {
        return dni;
    }

    public void add_assistencia() {
        ++assistit;
    }
}
