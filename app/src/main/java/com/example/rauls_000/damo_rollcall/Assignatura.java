package com.example.rauls_000.damo_rollcall;

/**
 * Created by thelaser on 28/12/17.
 */

import com.example.rauls_000.damo_rollcall.Grup;

import java.util.ArrayList;

public class Assignatura {

    public CharSequence professor;
    public CharSequence nom_assig;
    public CharSequence acronim;
    public ArrayList<Grup> grups;

    public Assignatura(CharSequence prof, CharSequence nom, CharSequence acron) {
        professor = prof;
        nom_assig = nom;
        acronim = acron;
    }

    public CharSequence view_nom() {
        return nom_assig;
    }
}
