package com.example.rauls_000.damo_rollcall;

/**
 * Created by thelaser on 28/12/17.
 */

import com.example.rauls_000.damo_rollcall.Alumne;

import java.util.ArrayList;

public class Grup {

    public CharSequence nom_grup;
    public ArrayList<Alumne> alumnes;
    public int classes_totals;

    public Grup(CharSequence nom, int class_tot){
        nom_grup = nom;
        classes_totals = class_tot;
    }

    public void afegir_alumne(Alumne alumne){
        alumnes.add(alumne);
    }

    public void eliminar_alumne(CharSequence nom) {
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


}
