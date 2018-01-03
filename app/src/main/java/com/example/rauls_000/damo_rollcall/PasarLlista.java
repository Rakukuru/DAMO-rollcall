package com.example.rauls_000.damo_rollcall;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PasarLlista extends Activity {

    public EditText editData;
    public EditText editHora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // ####################### TEST DATA #####################################

        Alumne alumne1 = new Alumne("dni1", "nom1");
        Alumne alumne2 = new Alumne("dni2", "nom2");
        Alumne alumne3 = new Alumne("dni3", "nom3");
        Alumne alumne4 = new Alumne("dni4", "nom4");

        // ####################### TEST DATA #####################################

        super.onCreate(savedInstanceState);
        setContentView(R.layout.pasar_llista);
        editData = (EditText) findViewById(R.id.editData);
        editHora = (EditText) findViewById(R.id.editHora);
        editData.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                DialogFragment newFragment = new SelectDateFragment();
                newFragment.show(getFragmentManager(), "DatePicker");

            }
        });

        editHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new SelectTimeFragment();
                newFragment.show(getFragmentManager(), "TimePicker");
            }
        });

    }

    public void setdate(int year, int month, int day) {
        editData.setText(month+"/"+day+"/"+year);
    }

    public void settime(int hora, int min){
        editHora.setText(hora+":"+min);
    }
}