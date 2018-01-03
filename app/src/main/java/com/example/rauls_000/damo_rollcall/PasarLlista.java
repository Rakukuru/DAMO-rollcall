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

    private final static String[] grupos = { "DAMO01", "DAM02", "DAMO03"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pasar_llista);
        editData = (EditText) findViewById(R.id.editData);
        editData.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                DialogFragment newFragment = new SelectDateFragment();
                newFragment.show(getFragmentManager(), "DatePicker");

            }
        });
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, grupos);
    }

    public void setdate(int year, int month, int day) {
        editData.setText(month+"/"+day+"/"+year);
    }
}