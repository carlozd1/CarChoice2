package com.example.carloszamora.carchoice.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
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
public class PreguntaMotor extends Fragment {

    TextView txt_pregunta;
    Spinner elemento_respuesta;
    Button siguientePag;
    Button anteriorPag;
    Integer currentitem;
    CustomViewPager viewPager;

    public PreguntaMotor() {
        // Required empty public constructor
    }


    public static PreguntaMotor newInstance() {
        PreguntaMotor fragment = new PreguntaMotor();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pregunta_motor, container, false);

        siguientePag = (Button) view.findViewById(R.id.btn_siguiente);
        anteriorPag = (Button) view.findViewById(R.id.btn_anterior);
        viewPager = (CustomViewPager) getActivity().findViewById(R.id.viewpager);
        txt_pregunta = (TextView) getActivity().findViewById(R.id.txt_title);
        elemento_respuesta = (Spinner) view.findViewById(R.id.personal_drop_state);

        currentitem = viewPager.getCurrentItem();
        siguientePag.setOnClickListener(avanzar);
        anteriorPag.setOnClickListener(regresar);

        return view;
    }

    View.OnClickListener avanzar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String respuesta = elemento_respuesta.getSelectedItem().toString();
            if (respuesta.trim().length() != 0) {
                try {
                    Global.jsonRespuesta.put("motor",respuesta);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Global.puntero ++;
                Preguntas.moveViewPager(Global.puntero);
            }else {
                Toast toast = Toast.makeText(getContext(),"Debes llenar todos los campos, para poder continuar",Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    };

    View.OnClickListener regresar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (Global.puntero > 0){
                Global.puntero --;
                Preguntas.moveViewPager(Global.puntero);
            }
        }
    };

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            JSONObject glbal = Global.jsonRespuesta;
            Log.d("TAAAAG", "Global: " + glbal);
        }
    }
}
