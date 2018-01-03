package com.example.rauls_000.damo_rollcall;

/**
 * Created by thelaser on 28/12/17.
 */

import android.util.Log;

import com.example.rauls_000.damo_rollcall.Alumne;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Grup {

    private CharSequence nom_grup="sense_nom";
    private List<Alumne> alumnes;
    private List<Sessio> sessions;

    public Grup(CharSequence nom){
        nom_grup = nom;
        alumnes = new ArrayList<Alumne>();
        sessions = new ArrayList<Sessio>();
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

    public void add_sessio_grup(Calendar date){

        Integer i = 0;
        Boolean found = false;
        while(i < sessions.size() && !found) {
            if(sessions.get(i).getDate() == date) {
                found = true;
            }
        }

        if (!found) {
            Sessio sessio = new Sessio(alumnes, date);
            sessions.add(sessio);
        }

    }

    public Sessio mod_sessio(Calendar date, CharSequence nom_alumne) {
        Integer i = 0;
        Boolean found = false;
        Sessio search_target = null;
        while(i < sessions.size() && !found) {
            if(sessions.get(i).getDate() == date) {
                sessions.get(i).setAssistencia(nom_alumne);
            }
        }

        return search_target;
    }

    public ArrayList<Sessio> getSessions() { return (ArrayList)sessions; }
    public CharSequence view_nom_grup() {
        return nom_grup;
    }
    public int get_classes_tot() {return sessions.size();}


}
