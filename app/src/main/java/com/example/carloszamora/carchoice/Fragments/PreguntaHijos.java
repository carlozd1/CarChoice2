package com.example.carloszamora.carchoice.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
public class PreguntaHijos extends Fragment {


    TextView txt_pregunta;
    Button siguientePag;
    Button anteriorPag;
    Integer currentitem;
    CustomViewPager viewPager;
    EditText elemento_respuesta;

    RadioGroup rg;
    RadioButton rb_si,rb_no;
    LinearLayout layout_continuacion;
    TextView txt_pregunta2;

    public PreguntaHijos() {
        // Required empty public constructor
    }

    public static PreguntaHijos newInstance() {
        PreguntaHijos fragment = new PreguntaHijos();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pregunta_hijos, container, false);

        siguientePag = (Button) view.findViewById(R.id.btn_siguiente);
        anteriorPag = (Button) view.findViewById(R.id.btn_anterior);
        viewPager = (CustomViewPager) getActivity().findViewById(R.id.viewpager);
        txt_pregunta = (TextView) getActivity().findViewById(R.id.txt_title);
        elemento_respuesta = (EditText) view.findViewById(R.id.edit_respuesta);

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

    View.OnClickListener avanzar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (rb_no.isChecked()){
                try {
                    Global.jsonRespuesta.put("hijos",0);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Global.puntero ++;
                Preguntas.moveViewPager(Global.puntero);
            } else if (rb_si.isChecked()){
                String respuesta = elemento_respuesta.getText().toString();
                if (respuesta.trim().length() != 0) {
                    try {
                        Global.jsonRespuesta.put("hijos",respuesta);
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
        if(isVisibleToUser) {
            JSONObject glbal = Global.jsonRespuesta;
            Log.d("TAAAAG","Global: "+glbal);
        }
    }

    View.OnClickListener cambiarEstado = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (rb_si.isChecked()){
                layout_continuacion.setVisibility(View.VISIBLE);
                txt_pregunta2 = (TextView) getActivity().findViewById(R.id.txt_preguntaHijos);
                txt_pregunta2.setText("Cuantos:");
            }
            if (rb_no.isChecked()){
                layout_continuacion.setVisibility(View.GONE);
            }
        }
    };

}
