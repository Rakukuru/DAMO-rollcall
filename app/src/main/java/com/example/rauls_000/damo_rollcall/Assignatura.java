package com.example.rauls_000.damo_rollcall;

/**
 * Created by thelaser on 28/12/17.
 */

import com.example.rauls_000.damo_rollcall.Grup;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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

    public void add_grup(CharSequence grup_nom) {
        Grup grup = new Grup(grup_nom);
        grups.add(grup);
    }

    public void add_alumne(CharSequence identif_dni, CharSequence nomAlumne, CharSequence nom_grup){
        Boolean done = false;
        Integer i = 0;
        while ((i < grups.size()) && !done) {
            if (nom_grup == grups.get(i).view_nom_grup()) {
                Alumne alumne = new Alumne(identif_dni, nomAlumne);
                grups.get(i).add_alumne(alumne);
            }
            ++i;
        }
    }

    public void add_sessio(CharSequence nom_grup, Calendar date_arg) {


        Boolean done = false;
        Integer i = 0;

        // The sessions will always have the date in the following format:
        Calendar date = Calendar.getInstance();
        date.set(   date_arg.get(Calendar.YEAR),
                    date_arg.get(Calendar.MONTH),
                    date_arg.get(Calendar.DAY_OF_MONTH),
                    date_arg.get(Calendar.HOUR_OF_DAY),
                    date_arg.get(Calendar.MINUTE));

        while ((i < grups.size()) && !done) {
            if (nom_grup == grups.get(i).view_nom_grup()) {
                grups.get(i).add_sessio_grup(date);
            }
            ++i;
        }
    }

    public void mod_assist(CharSequence nom_alumne, CharSequence nom_grup, Calendar date) {
        Boolean done = false;
        Integer i = 0;
        while ((i < grups.size()) && !done) {
            if (nom_grup == grups.get(i).view_nom_grup()) {

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

    public static Grup get_grup_nom (ArrayList<Grup> grups, CharSequence nom_grup) {
        Boolean done = false;
        Integer i = 0;
        Grup search_target = null;
        while ((i < grups.size()) && !done) {
            if (nom_grup == grups.get(i).view_nom_grup()) {
                search_target = grups.get(i);
                done = true;
            }
            ++i;
        }
        return search_target;
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
