package com.example.rauls_000.damo_rollcall;

/**
 * Created by thelaser on 28/12/17.
 */

import android.util.Log;

import com.example.rauls_000.damo_rollcall.Alumne;

import java.util.ArrayList;

public class Grup {

    private CharSequence nom_grup="sense_nom";
    private ArrayList<Alumne> alumnes;
    private int classes_totals;

    public Grup(CharSequence nom, int class_tot){
        nom_grup = nom;
        classes_totals = class_tot;
        alumnes = new ArrayList<Alumne>();
    }

    public void add_alumne(Alumne alumne){
        Log.d("alumne", String.valueOf(alumne.view_nom()));
        alumnes.add(alumne);
    }

    public void remove_alumne(CharSequence nom) {
        Boolean found = false;
        Integer i = 0;
        while(i < alumnes.size() && !found){
            if (alumnes.get(i).view_nom() == nom) {
                alumnes.remove(i);
                found = true;
            }
            ++i;
        }
    }

    public CharSequence view_nom_grup() {
        return nom_grup;
    }


}
