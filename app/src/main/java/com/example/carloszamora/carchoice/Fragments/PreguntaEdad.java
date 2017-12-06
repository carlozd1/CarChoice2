package com.example.carloszamora.carchoice.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.carloszamora.carchoice.R;
import com.example.carloszamora.carchoice.Utils.Global;

import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class PreguntaEdad extends Fragment {
    TextView txt_pregunta;


    public PreguntaEdad() {
        // Required empty public constructor
    }

    public static PreguntaEdad newInstance() {
        PreguntaEdad fragment = new PreguntaEdad();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pregunta_edad, container, false);

        txt_pregunta = (TextView) getActivity().findViewById(R.id.txt_title);
        txt_pregunta.setText("Ingresa tu edad:");

        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser) {
            JSONObject glbal = Global.jsonRespuesta;
            Log.d("TAAAAG","Global: "+glbal);
        }
    }

}
