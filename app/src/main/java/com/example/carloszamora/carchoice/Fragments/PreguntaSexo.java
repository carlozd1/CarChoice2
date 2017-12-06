package com.example.carloszamora.carchoice.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carloszamora.carchoice.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PreguntaSexo extends Fragment {


    public PreguntaSexo() {
        // Required empty public constructor
    }

    public static PreguntaSexo newInstance() {
        PreguntaSexo fragment = new PreguntaSexo();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pregunta_sexo, container, false);
    }

}
