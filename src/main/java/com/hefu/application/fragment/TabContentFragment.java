package com.hefu.application.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hefu.application.R;


/**
     * A placeholder fragment containing a simple view.
     */
    public  class TabContentFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public TabContentFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static TabContentFragment newInstance(String name) {
            TabContentFragment fragment = new TabContentFragment();
            Bundle args = new Bundle();
            args.putString(ARG_SECTION_NUMBER, name);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_work, container, false);

           String  index =  getArguments().getString(ARG_SECTION_NUMBER);


            return rootView;


        }
    }
