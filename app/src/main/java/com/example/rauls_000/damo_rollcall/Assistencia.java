package com.example.rauls_000.damo_rollcall;

/**
 * Created by thelaser on 31/12/17.
 */

public class Assistencia {
    // There are 3 possible types, A temps, Retard, Falta.
    protected String tipus;
    protected int tipus_val;

    public Assistencia() {
        tipus = "Buit";
        tipus_val = 0;
    }
}

/* To check if object of class is from certain type we can use:

    if (a instanceof Atemps) {
        // do something
    }

    or

    if (a.getClass() == Retard.class) {
        // do something
    }
    */


