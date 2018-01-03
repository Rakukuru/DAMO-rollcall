package com.example.rauls_000.damo_rollcall;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;



//TODO  Hacer que los elementos de las listas sean clickables e implementar el short y long click
//TODO  Añadir ultimo elemento en todas las listas (+) para que al pulsarlo podamos añadir grupo
/*TODO  Incluir en los elementos de las listas subitems, para indicar informacion de los elementos,
        por ejemplo con los grupos, poner debajo del nombre del grupo el profesor asignado al grupo
        o mierdas varias de este estilo. ESTO PARA EL FINAL
 */
//TODO  Juntar el input con las bases de datos
//TODO  Añadir metodos en las clases Assignatura, Alumne o Grup para interaccionar con Assistencia

// we create a FragmentActivity that will contain fragments in it
public class SlideAssignatures extends FragmentActivity {

    /*
     *   This is the widget which contains the fragments.
     *   It's a layout manager that allows the user to flip left and right through pages of data.
     *
     */
    ViewPager mViewPager;

    // This is the adapter that will manage the fragments inside the activity's ViewPager
    SlidesPagerAdapter mSlidesPagerAdapter;

    // Here we add the subjects we are going to use in the list app
    ArrayList<Assignatura> assignatures;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        assignatures = new ArrayList<Assignatura>();

        // ####################### TEST DATA #####################################


        Assignatura assig1 = new Assignatura("Alguien", "Desarrollo", "DES");

        assig1.add_grup("grup11");
        assig1.add_grup("grup12");

        assig1.add_alumne("dni1","nom1", "grup11");
        assig1.add_alumne("dni2","nom2", "grup11");
        assig1.add_alumne("dni3","nom3", "grup11");
        assig1.add_alumne("dni4","nom4", "grup11");


        assig1.add_alumne("dni10","nom10", "grup12");
        assig1.add_alumne("dni9","nom9", "grup12");
        assig1.add_alumne("dni8","nom8", "grup12");




        Assignatura assig2 = new Assignatura("Otro Alguien", "Penisima", "PEN");

        assig2.add_grup("grup11213");
        assig2.add_grup("grup1251");


        Assignatura assig3 = new Assignatura("masuno", "Otramas", "MAS");

        assig3.add_grup("grup11551");
        assig3.add_grup("grup12231");

        assignatures.add(assig1);
        assignatures.add(assig2);
        assignatures.add(assig3);



        Log.d("sumthin", String.valueOf(assig1.quantity_grups()));
        Log.d("sumthin", String.valueOf(assig1.get_grup(0)));

        // ########################################################################

        // we create a fragment manager to handle fragment transactions
        FragmentManager frag_manager = getSupportFragmentManager();

        /* Create the adapter that will return a fragment for each of the three
           primary sections of the app. */
        // We pass to it the assignatures so it can handle them, although it's probably not the best approach.
        mSlidesPagerAdapter = new SlidesPagerAdapter(frag_manager, assignatures);

        // Set up the ViewPager with the slides adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSlidesPagerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the main; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    /*  FragmentPagerAdapter:
     *  This version of the pager is best for use when there are a handful of typically
     *  more static fragments to be paged through, such as a set of tabs.
     *  The fragment of each page the user visits will be kept in memory,
     *  though its view hierarchy may be destroyed when not visible.
     *
     *  Subclasses only need to implement getItem(int) and getCount() to have a working adapter.
     */
    public class SlidesPagerAdapter extends FragmentPagerAdapter {

        public ArrayList<Assignatura> assignatures;

        public SlidesPagerAdapter(FragmentManager fm, ArrayList<Assignatura> assigs) {
            super(fm);
            assignatures = assigs;
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PopulatedSlideFragment (defined as a static inner class
            // below) with the page number as its lone argument.
            
            Fragment fragment;
            Bundle args;

            Log.d("some", Integer.toString(position));
            Log.d("some1", Integer.toString((assignatures.size()+1)));


            if(position == (assignatures.size())){
                fragment = new CreationSlideFragment();
            }
            
            else {
                fragment = new PopulatedSlideFragment();
                args = new Bundle();
                CharSequence name_key = "nomgrup";
                // This method is easier than using Serializables or Parcelables
                // although simpler and maybe a bit less structured


                for (Integer i=0; i < assignatures.get(position).quantity_grups(); ++i){
                    String key = name_key + i.toString();
                    Log.d("keys", key);
                    Log.d("values", String.valueOf(assignatures.get(position).get_grup(i).view_nom_grup()));
                    args.putCharSequence(key, assignatures.get(position).get_grup(i).view_nom_grup());
                }

                fragment.setArguments(args);
            }


            return fragment;
        }

        @Override
        public int getCount() {
            // Show 4 total pages.
            // We add 1 to the total size because we will have the populated screens
            // plus the creation button screen.
            return assignatures.size()+1;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if (!assignatures.isEmpty()) {
                if(position == assignatures.size()) {
                    return "+";
                }
                else {
                    return assignatures.get(position).view_nom();
                }
            }
            else {
                return "+";
            }
        }
    }

    public static class PopulatedSlideFragment extends Fragment {

        Context context;
        ListView grup_list;
        ImageButton button_add;


        public PopulatedSlideFragment() {

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_populated, container,  false);
            ArrayList<CharSequence> groups = new ArrayList<CharSequence>();

            Bundle args = getArguments();

            Log.d("faileo", Boolean.toString(savedInstanceState == null));
            Log.d("faileo2", Boolean.toString(args == null));

            if (savedInstanceState != null) {
                for (String key : savedInstanceState.keySet()) {
                    groups.add(savedInstanceState.getCharSequence(key));
                }
            }
            else if (args != null){
                for (String key: args.keySet()) {
                    groups.add(args.getCharSequence(key));
                }
            }

            // ArrayAdapter needs as parameters the activity context, a layout xml with a single
            // TextView in it which will be used to portray the CharSequences, and the arraylist itself
            // that will be used.
            ArrayAdapter<CharSequence> grups_adapter = new ArrayAdapter<CharSequence>(getActivity(), R.layout.grups_list, groups);

            grup_list = (ListView) rootView.findViewById(R.id.grup_list);

            grup_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                }
            });

            grup_list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                    return false;
                }
            });

            grup_list.setAdapter(grups_adapter);


            button_add = (ImageButton) rootView.findViewById(R.id.imageButton);

            button_add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    obreCreacioGrup();
                }
            });



            return rootView;
        }

        public void obreCreacioGrup() {
            Intent intent = new Intent(getActivity(), add_assig_button_stub.class);
            startActivity(intent);
        }

    }

    /*

    UNUSED CUSTOM ADAPTER, SAVED FOR POSSIBLE FUTURE REFERENCE

    public class GrupListAdapter extends ArrayAdapter<Grup> {

        public GrupListAdapter (Context context, ArrayList<Grup> grups) {
            super(context, 0, grups);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position
            Grup grup = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.grups_list, parent, false);
            }
            // Lookup view for data population
            TextView nom = (TextView) convertView.findViewById(R.id.nom_grup);
            // Populate the data into the template view using the data object
            nom.setText(grup.view_nom_grup());
            // Return the completed view to render on screen
            return convertView;
        }
    }
    */

    public static class CreationSlideFragment extends Fragment{

        Button add_button;

        public CreationSlideFragment() {

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_creation, container,  false);
            add_button = (Button) rootView.findViewById(R.id.add_button);
            add_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    creacioAssignatura();
                }
            });
            return rootView;
        }


        public void creacioAssignatura() {
            Intent intent = new Intent(getActivity(), add_assig_button_stub.class);
            startActivity(intent);
        }


    }
    
    

}