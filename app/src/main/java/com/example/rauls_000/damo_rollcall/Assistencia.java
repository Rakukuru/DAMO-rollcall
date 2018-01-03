package com.example.rauls_000.damo_rollcall;

import java.util.Calendar;

/**
 * Created by thelaser on 31/12/17.
 */

public class Assistencia {
    // There are 3 possible types Buida(0), A temps(1), Retard(2), Falta(3).
    protected int tipus_val;
    protected CharSequence nom_alumne;
    private Calendar data;

    public Assistencia(CharSequence nom, Calendar data_assist) {
        tipus_val = 0;
        nom_alumne = nom;
        data = data_assist;
    }

    public void change_tipus() {
        if (tipus_val == 3) {
            tipus_val = 0;
        }
        else {
            tipus_val++;
        }
    }

    public int getAssist() {
        return tipus_val;
    }

    public CharSequence getNom() {
        return nom_alumne;
    }

    public Calendar getDateAssist() {
        return data;
    }
}

