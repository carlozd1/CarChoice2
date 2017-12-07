package com.example.carloszamora.carchoice.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carloszamora.carchoice.R;
import com.example.carloszamora.carchoice.Utils.CustomViewPager;
import com.example.carloszamora.carchoice.Utils.Global;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class PreguntaEstudio extends Fragment {

    TextView txt_pregunta;
    Button siguientePag;
    Button anteriorPag;
    Integer currentitem;
    CustomViewPager viewPager;
    Spinner elemento_respuesta;

    RadioGroup rg;
    RadioButton rb_si,rb_no;
    LinearLayout layout_continuacion;
    TextView txt_pregunta2;

    public PreguntaEstudio() {
        // Required empty public constructor
    }

    public static PreguntaEstudio newInstance() {
        PreguntaEstudio fragment = new PreguntaEstudio();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pregunta_estudio, container, false);

        siguientePag = (Button) view.findViewById(R.id.btn_siguiente);
        anteriorPag = (Button) view.findViewById(R.id.btn_anterior);
        viewPager = (CustomViewPager) getActivity().findViewById(R.id.viewpager);
        txt_pregunta = (TextView) getActivity().findViewById(R.id.txt_title);
        elemento_respuesta = (Spinner) view.findViewById(R.id.personal_drop_state);

        rg = (RadioGroup) view.findViewById(R.id.rg_grupo);
        rb_si = (RadioButton) view.findViewById(R.id.rb_si);
        rb_no = (RadioButton) view.findViewById(R.id.rb_no);
        layout_continuacion = (LinearLayout) view.findViewById(R.id.layout_mostrarP);
        txt_pregunta2 = (TextView) getActivity().findViewById(R.id.txt_preguntaEstudio);



        rb_si.setOnClickListener(cambiarEstado);
        rb_no.setOnClickListener(cambiarEstado);

        currentitem = viewPager.getCurrentItem();
        siguientePag.setOnClickListener(avanzar);
        anteriorPag.setOnClickListener(regresar);

        return view;
    }

    View.OnClickListener cambiarEstado = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (rb_si.isChecked()){
                layout_continuacion.setVisibility(View.VISIBLE);
                txt_pregunta2 = (TextView) getActivity().findViewById(R.id.txt_preguntaEstudio);
                txt_pregunta2.setText("Ingresa tu grado de estudios:");
            }
            if (rb_no.isChecked()){
                layout_continuacion.setVisibility(View.GONE);
            }
        }
    };

    View.OnClickListener avanzar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            // ---------------------------------------
            //    aqui validas si el campo esta vacio,
            //   si no, lo agregas al json global
            //   la clase global debe ser la de utils
            // ---------------------------------------
            if (rb_no.isChecked()){
                try {
                    Global.jsonRespuesta.put("estudio","no");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else if (rb_si.isChecked()){
                String respuesta = elemento_respuesta.getSelectedItem().toString();
                if (respuesta.trim().length() != 0) {
                    try {
                        Global.jsonRespuesta.put("estudio",respuesta);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    viewPager.setCurrentItem(currentitem + 1);
                }else {
                    Toast toast = Toast.makeText(getContext(),"Debes llenar todos los campos, para poder continuar",Toast.LENGTH_SHORT);
                    toast.show();
                }
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


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser) {
            currentitem = viewPager.getCurrentItem();
            txt_pregunta.setText("¿Estudias actualmente?");
            JSONObject glbal = Global.jsonRespuesta;
            Log.d("TAAAAG","Global: "+glbal);
        }
    }


}
