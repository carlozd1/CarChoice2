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

import com.example.carloszamora.carchoice.Preguntas;
import com.example.carloszamora.carchoice.R;
import com.example.carloszamora.carchoice.Utils.CustomViewPager;
import com.example.carloszamora.carchoice.Utils.Global;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class PreguntaActualmente extends Fragment {


    TextView txt_pregunta;
    Button siguientePag;
    Button anteriorPag;
    Integer currentitem;
    CustomViewPager viewPager;
    Spinner elemento_respuesta;

    RadioGroup rg,rg2;
    RadioButton rb_si,rb_no;
    RadioButton rb_si2,rb_no2;
    LinearLayout layout_continuacion;
    TextView txt_pregunta2;

    public PreguntaActualmente() {
        // Required empty public constructor
    }

    public static PreguntaActualmente newInstance() {
        PreguntaActualmente fragment = new PreguntaActualmente();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pregunta_actualmente, container, false);

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

        rg2 = (RadioGroup) view.findViewById(R.id.rg_grupo2);
        rb_si2 = (RadioButton) view.findViewById(R.id.rb_si2);
        rb_no2 = (RadioButton) view.findViewById(R.id.rb_no2);



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
            }
            if (rb_no.isChecked()){
                layout_continuacion.setVisibility(View.GONE);
            }
        }
    };

    View.OnClickListener avanzar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (rb_no.isChecked()){
                try {
                    Global.jsonRespuesta.put("carroactual","no");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Global.puntero ++;
                Preguntas.moveViewPager(Global.puntero);
            } else if (rb_si.isChecked()){
                String respuesta = elemento_respuesta.getSelectedItem().toString();
                if (respuesta.trim().length() != 0) {
                    try {
                        if (rb_si2.isChecked()){
                            Global.jsonRespuesta.put("mismagama","no");
                        }
                        if (rb_no2.isChecked()){
                            Global.jsonRespuesta.put("mismagama","si");
                        }
                        Global.jsonRespuesta.put("carroactual","si");
                        Global.jsonRespuesta.put("gama",respuesta);
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

}
