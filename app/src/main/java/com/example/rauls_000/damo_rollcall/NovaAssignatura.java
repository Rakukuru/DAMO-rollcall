package com.example.rauls_000.damo_rollcall;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by rauls_000 on 07/01/2018.
 */

public class NovaAssignatura extends Activity {

    public EditText editNom;
    public EditText editAcronim;
    public Button saveButton;
    public Assignatura assig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nova_assignatura);

        // Referencies a xml
        editNom = (EditText) findViewById(R.id.EditNomAssig);
        editAcronim = (EditText) findViewById(R.id.EditAcronimAssig);
        saveButton = (Button) findViewById(R.id.savebuttonNovaAssig);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int duration = Toast.LENGTH_SHORT;
                CharSequence nom;
                CharSequence acronim;

                // Agafem el nom, si esta buït avisem
                nom = editNom.getText();
                if (nom.length() == 0) {
                    CharSequence text = "Siusplau, escrigui un nom";
                    Toast toast = Toast.makeText(getApplicationContext(), text, duration);
                    toast.show();
                } else {
                    // Agafem el acronim, si esta buït avisem
                    acronim = editAcronim.getText();
                    if (acronim.length() == 0) {
                        CharSequence text = "Siusplau, escrigui un acronim";
                        Toast toast = Toast.makeText(getApplicationContext(), text, duration);
                        toast.show();
                    } else {
                        // Guardem la assignatura y tornem al menu principal
                        assig = new Assignatura(nom, acronim);
                    }
                }
            }
        });

    }
}
