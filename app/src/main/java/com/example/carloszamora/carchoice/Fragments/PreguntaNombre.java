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


/**
 * A simple {@link Fragment} subclass.
 */
public class PreguntaNombre extends Fragment {
    Button siguientePag;
    Button anteriorPag;
    CustomViewPager viewPager;
    EditText edit_nombre;
    TextView txt_pregunta;
    Integer currentitem;

    public PreguntaNombre() {
    }

    public static PreguntaNombre newInstance() {
        PreguntaNombre fragment = new PreguntaNombre();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pregunta_nombre, container, false);
        viewPager = (CustomViewPager) getActivity().findViewById(R.id.viewpager);
        siguientePag = (Button) view.findViewById(R.id.btn_siguiente);
        anteriorPag = (Button) view.findViewById(R.id.btn_anterior);
        edit_nombre = (EditText) view.findViewById(R.id.edit_respuesta);

        txt_pregunta = (TextView) getActivity().findViewById(R.id.txt_title);

        siguientePag.setOnClickListener(avanzar);

        return view;
    }

    View.OnClickListener avanzar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Global.puntero ++;
            String respuesta = edit_nombre.getText().toString();
            Log.d("TAAAAG","--->: "+Global.puntero);
            if (respuesta.trim().length() != 0) {
                try {
                    Global.jsonRespuesta.put("nombre",respuesta);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Preguntas.moveViewPager(Global.puntero);
            }else {
                Toast toast = Toast.makeText(getContext(),"Debes llenar todos los campos, para poder continuar",Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    };

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser) {

        }
    }

}
