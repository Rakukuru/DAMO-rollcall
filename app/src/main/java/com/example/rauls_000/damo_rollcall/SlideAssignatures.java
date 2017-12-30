package com.example.rauls_000.damo_rollcall;


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
import android.widget.Button;
import android.widget.TextView;

public class SlideAssignatures extends FragmentActivity {

    SectionsPagerAdapter mSectionsPagerAdapter;

    ViewPager mViewPager;

    ArrayList<Assignatura> assignatures;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        assignatures = new ArrayList<Assignatura>();
        Assignatura assig1 = new Assignatura("Alguien", "Desarrollo", "DES");
        Assignatura assig2 = new Assignatura("Otro Alguien", "Penisima", "PEN");
        Assignatura assig3 = new Assignatura("masuno", "Otramas", "MAS");
        assignatures.add(assig1);
        assignatures.add(assig2);
        assignatures.add(assig3);

        /* Create the adapter that will return a fragment for each of the three
           primary sections of the app. */
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), assignatures);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the main; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public ArrayList<Assignatura> assignatures;

        public SectionsPagerAdapter(FragmentManager fm, ArrayList<Assignatura> assigs) {
            super(fm);
            assignatures = assigs;
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PopulatedSectionFragment (defined as a static inner class
            // below) with the page number as its lone argument.
            Fragment fragment = new PopulatedSectionFragment();
            Bundle args = new Bundle();
            //PopulatedSectionFragment.ARG_SECTION_NUMBER replace test string line below
            args.putInt("test" , position + 1);
            fragment.setArguments(args);
            Log.d("CHECK", "gets items");
            return fragment;
        }

        @Override
        public int getCount() {
            // Show 4 total pages.
            return assignatures.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if (!assignatures.isEmpty()) {
                return assignatures.get(position).view_nom();
            }
            else {
                return null;
            }
        }
    }

    public static class PopulatedSectionFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */

        public PopulatedSectionFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_populated, container,  false);
            TextView dummyTextView = (TextView) rootView.findViewById(R.id.section_label);
            dummyTextView.setText("This is a populated section");
            return rootView;
        }
    }
    
    public static class CreationSectionFragment extends Fragment implements Button.OnClickListener{

        Button add_button;

        public CreationSectionFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_creation, container,  false);
            add_button = (Button) rootView.findViewById(R.id.add_button);
            add_button.setOnClickListener(this);
            return rootView;
        }

        public void onClick(View v){

        }


    }
    
    

}