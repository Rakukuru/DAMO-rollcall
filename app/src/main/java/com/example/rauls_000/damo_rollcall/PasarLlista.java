package com.example.rauls_000.damo_rollcall;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by rauls_000 on 03/01/2018.
 */

public class PasarLlista extends Activity {

    public EditText editData;
    public EditText editHora;
    public ListView llistaalum;
    public Button saveButton;
    ListAlumneAdapter adaptador;
    public ArrayList<Assistencia> sessio;
    public Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // ####################### TEST DATA #####################################

        Assistencia alumne1 = new Assistencia("nom1", null);
        Assistencia alumne2 = new Assistencia("nom2", null);
        Assistencia alumne3 = new Assistencia("nom3", null);
        Assistencia alumne4 = new Assistencia("nom4", null);
        Assistencia alumne5 = new Assistencia("nom5", null);
        Assistencia alumne6 = new Assistencia("nom6", null);
        Assistencia alumne7 = new Assistencia("nom7", null);

        // PLEASE NOTE: Sessio es una arraylit de assistencias creadas localmente
        // Si queremos guardar las asistencias modificadas tendremos que guardar dentro del DB la sessio
        // o modificar el "onItemClick" para que guarde directamente
        sessio = new ArrayList<Assistencia>();
        sessio.add(alumne1);
        sessio.add(alumne2);
        sessio.add(alumne3);
        sessio.add(alumne4);
        sessio.add(alumne5);
        sessio.add(alumne6);
        sessio.add(alumne7);

        // ####################### TEST DATA #####################################

        super.onCreate(savedInstanceState);
        setContentView(R.layout.pasar_llista);
        // Ens guardem referencies als butons i la llista
        editData = (EditText) findViewById(R.id.editData);
        editHora = (EditText) findViewById(R.id.editHora);
        saveButton = (Button) findViewById(R.id.savebutton);
        llistaalum = (ListView) findViewById(R.id.llistaAlum);
        // Creem un calendar
        calendar = Calendar.getInstance();
        // Creem un adaptador
        adaptador = new ListAlumneAdapter(
                this, // Context
                sessio // Font de dades
        );
        // Assignem l’adaptador al listView
        llistaalum.setAdapter(adaptador);

        llistaalum.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Assistencia selectedFromList = (Assistencia) adaptador.getItem(position);
                selectedFromList.change_tipus();
                // ######  AQUI ########
                sessio.set(position, selectedFromList);
                // Notifiquem al adapter per a que refresqui la view
                adaptador.notifyDataSetChanged();
            }
        });

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

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Guardem la llista d'assistencies

                // Tornem al menu principal

            }
        });
    }

    // Methods cridats pels Custom Fragments
    // Cambien els TEXTVIEW y es d'aqui on ens guardem els valors de data y hora
    // Guardem la data i l'hora en el calendar
    public void setdate(int year, int month, int day) {
        editData.setText(month+"/"+day+"/"+year);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.YEAR, year);

    }

    public void settime(int hora, int min){
        editHora.setText(hora+":"+min);
        calendar.set(Calendar.MINUTE, min);
        calendar.set(Calendar.HOUR, hora);
    }
}