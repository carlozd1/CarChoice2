package com.example.carloszamora.carchoice.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

//        hay que asignar el "inflater" a la variable "view"
        View view = inflater.inflate(R.layout.fragment_pregunta_nombre, container, false);
        viewPager = (CustomViewPager) getActivity().findViewById(R.id.viewpager);
        siguientePag = (Button) view.findViewById(R.id.btn_siguiente);
        anteriorPag = (Button) view.findViewById(R.id.btn_anterior);
        edit_nombre = (EditText) view.findViewById(R.id.edit_respuesta);

        // ---------------------------------------
        //    Set de la pregunta en cada fragment
        //   es el texto que esta en el activity
        //   cada vez que se crea un fragment
        // ---------------------------------------
        txt_pregunta = (TextView) getActivity().findViewById(R.id.txt_title);
        txt_pregunta.setText("Ingresa tu nombre:");

        currentitem = viewPager.getCurrentItem();
        siguientePag.setOnClickListener(avanzar);
        anteriorPag.setOnClickListener(regresar);

        //       despues de asignar el inflater a view, haces el return de la variable
        return view;
    }

    View.OnClickListener avanzar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            // ---------------------------------------
            //    aqui validas si el campo esta vacio,
            //   si no, lo agregas al json global
            //   la clase global debe ser la de utils
            // ---------------------------------------
            String nombre = edit_nombre.getText().toString();
            if (nombre.trim().length() != 0) {
                try {
                    Global.jsonRespuesta.put("nombre",nombre);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                viewPager.setCurrentItem(currentitem + 1);
            }else {
                Toast toast = Toast.makeText(getContext(),"Debes llenar todos los campos, para poder continuar",Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    };

    View.OnClickListener regresar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (currentitem > 0){
                viewPager.setCurrentItem(currentitem - 1);
            }
        }
    };


// ---------------------------------------
//    Cuando sea visible para el usuario
// ---------------------------------------
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser) {

        }
    }

}
