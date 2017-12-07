package com.example.carloszamora.carchoice.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carloszamora.carchoice.Preguntas;
import com.example.carloszamora.carchoice.R;
import com.example.carloszamora.carchoice.Utils.CustomViewPager;
import com.example.carloszamora.carchoice.Utils.Global;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class PreguntaPlazas extends Fragment {

    TextView txt_pregunta;
    EditText edit_respuesta;
    Button siguientePag;
    Button anteriorPag;
    Integer currentitem;
    CustomViewPager viewPager;

    public PreguntaPlazas() {
        // Required empty public constructor
    }

    public static PreguntaPlazas newInstance() {
        PreguntaPlazas fragment = new PreguntaPlazas();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pregunta_plazas, container, false);
        siguientePag = (Button) view.findViewById(R.id.btn_siguiente);
        anteriorPag = (Button) view.findViewById(R.id.btn_anterior);
        viewPager = (CustomViewPager) getActivity().findViewById(R.id.viewpager);

        edit_respuesta = (EditText) view.findViewById(R.id.edit_respuesta);

        siguientePag.setOnClickListener(avanzar);
        anteriorPag.setOnClickListener(regresar);

        return view;
    }

    View.OnClickListener avanzar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String respuesta = edit_respuesta.getText().toString();
            int plazas = Integer.parseInt(edit_respuesta.getText().toString());
            Log.d("TAAAAG",">>>>>: "+ Global.puntero);
            if (respuesta.trim().length() != 0) {
                if (plazas > 6){
                    Toast toast = Toast.makeText(getContext(),"Buscas automovil o transporte publico?",Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    try {
                        Global.jsonRespuesta.put("plazas",respuesta);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Global.puntero ++;
                    Preguntas.moveViewPager(Global.puntero);
                }
            }else {
                Toast toast = Toast.makeText(getContext(),"Debes llenar todos los campos, para poder continuar",Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    };

    View.OnClickListener regresar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (Global.puntero != 0){
                Global.puntero --;
                Preguntas.moveViewPager(Global.puntero);
            }else{
                Preguntas.moveViewPager(Global.puntero);
            }
        }
    };



    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser) {
            JSONObject glbal = Global.jsonRespuesta;
            Log.d("TAAAAG","Global: "+glbal);
        }
    }

}
