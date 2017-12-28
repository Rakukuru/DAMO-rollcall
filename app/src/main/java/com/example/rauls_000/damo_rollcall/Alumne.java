package com.example.rauls_000.damo_rollcall;

/**
 * Created by thelaser on 28/12/17.
 */

public class Alumne {

    public CharSequence dni;
    public CharSequence nom_alumn;
    public int assistit=0;

    public Alumne (CharSequence identif, CharSequence nom) {
        dni = identif;
        nom_alumn = nom;
    }

    public CharSequence view_nom() {
        return nom_alumn;
    }

    public CharSequence view_dni() {
        return dni;
    }

    public void add_assistencia() {

    }
}
