package com.example.rauls_000.damo_rollcall;

/**
 * Created by thelaser on 28/12/17.
 */

import com.example.rauls_000.damo_rollcall.Grup;

import java.util.ArrayList;

public class Assignatura {

    private CharSequence professor;
    private CharSequence nom_assig;
    private CharSequence acronim;
    private ArrayList<Grup> grups;

    public Assignatura(CharSequence prof, CharSequence nom, CharSequence acron) {
        professor = prof;
        nom_assig = nom;
        acronim = acron;
        grups = new ArrayList<Grup>();
    }

    public void add_grup(Grup grup) {
        grups.add(grup);
    }

    public void add_alumne(CharSequence nom_grup, Alumne alumne){
        Boolean done = false;
        Integer i = 0;
        while ((i < grups.size()) && !done) {
            if (nom_grup == grups.get(i).view_nom_grup()) {
                grups.get(i).add_alumne(alumne);
            }
            ++i;
        }
    }

    public void add_alumne_list(CharSequence nom_grup, ArrayList<Alumne> alumnes_nous) {
        Boolean done = false;
        Integer i = 0;
        while ((i < grups.size()) && !done) {
            if (nom_grup == grups.get(i).view_nom_grup()) {
                for (Integer j = 0; j < alumnes_nous.size(); ++j){
                    grups.get(i).add_alumne(alumnes_nous.get(j));
                }
            }
            ++i;
        }

    }

    public void add_grup_list(ArrayList<Grup> grups_nous) {
        for (Integer i = 0; i < grups_nous.size(); ++i){
            grups.add(grups_nous.get(i));
        }
    }

    public void delete_grup(CharSequence nom_grup) {
        Boolean done = false;
        Integer i = 0;
        while ((i < grups.size()) && !done) {
            if (nom_grup == grups.get(i).view_nom_grup()) {
                grups.remove(i);
            }
            ++i;
        }
    }

    public CharSequence view_nom() {
        return nom_assig;
    }
    public CharSequence view_acronim() { return acronim; }
    public CharSequence view_prof() {
        return professor;
    }
    public Grup get_grup(int position) {
        return grups.get(position);
    }
    public int quantity_grups(){
        return grups.size();
    }

}
