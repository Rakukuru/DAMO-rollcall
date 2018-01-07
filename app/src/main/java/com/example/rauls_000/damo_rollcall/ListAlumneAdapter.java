package com.example.rauls_000.damo_rollcall;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by rauls_000 on 03/01/2018.
 */

public class ListAlumneAdapter extends ArrayAdapter{

    private ArrayList<Assistencia> asistList;

    // Custom adapter creat amb el context y guardant el array d'assistencies com a copia
    public ListAlumneAdapter(Context context, ArrayList<Assistencia> list)
    {
        super(context,0,list);
        asistList = list;
    }

    // Metode cridat per PassarLlista per poder saber quina assistencia del array estem treballant
    public Assistencia getItem(int index) {
        return this.asistList.get(index);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater;

        if(view == null) {
            holder = new ViewHolder();
            inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.row, null);
            holder.nom = (TextView) view.findViewById(R.id.alumnom);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        // L'hi passem el nom de l'alumne al text view
        Assistencia alumne = (Assistencia) asistList.get(position);
        holder.nom.setText(alumne.getNom().toString());
        //Log.d(TAG, "value: " + alumne.getAssist());

        // Segons el tipus d'assitencia, es mostrará el background d'un color diferent
        if (alumne.getAssist() == 1){ view.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.GREEN));
        } else if (alumne.getAssist() == 2){ view.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.ORANGE));
        } else if (alumne.getAssist() == 3){ view.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.RED));
        } else view.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.WHITE));

        return view;
    }

    static class ViewHolder
    {
        TextView nom;
    }
}