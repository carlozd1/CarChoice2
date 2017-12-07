package com.example.carloszamora.carchoice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.carloszamora.carchoice.Adapters.PreguntaAdapter;
import com.example.carloszamora.carchoice.Utils.CustomViewPager;
import com.example.carloszamora.carchoice.Utils.Global;


public class Preguntas extends AppCompatActivity {
    static TextView txt_pregunta;
    static CustomViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);


        viewPager = (CustomViewPager) findViewById(R.id.viewpager);
        txt_pregunta = (TextView)findViewById(R.id.txt_title);
        PreguntaAdapter adapter = new PreguntaAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setPagingEnabled(true);
        moveViewPager(0);
    }

    public static void moveViewPager(int page){

        Log.d("TAAAAG","de ahorita : "+ Global.puntero);

        viewPager.setCurrentItem(page);
        Log.d("TAAAAG","aqui ando en: "+page);
        switch (page){
            case 0:
                Log.d("TAAAAG","aqui ando en: 0"+page);
                txt_pregunta.setText("Ingresa tu nombre: ");
                break;
            case 1:
                Log.d("TAAAAG","aqui ando en: 1"+page);
                txt_pregunta.setText("Ingresa tu edad: ");
                break;
            case 2:
                Log.d("TAAAAG","aqui ando en: 2"+page);
                txt_pregunta.setText("Ingresa tu sexo: ");
                break;
            case 3:
                Log.d("TAAAAG","aqui ando en: 3"+page);
                txt_pregunta.setText("Lugar donde vives: ");
                break;
            case 4:
                Log.d("TAAAAG","aqui ando en: 3"+page);
                txt_pregunta.setText("¿Estudias?");
                break;
            case 5:
                Log.d("TAAAAG","aqui ando en: 3"+page);
                txt_pregunta.setText("¿Trabajas?");
                break;
            case 6:
                Log.d("TAAAAG","aqui ando en: 3"+page);
                txt_pregunta.setText("¿Con cuanto dinero cuentas actualmente?");
                break;
            case 7:
                Log.d("TAAAAG","aqui ando en: 3"+page);
                txt_pregunta.setText("Estado civil: ");
                break;
            case 8:
                Log.d("TAAAAG","aqui ando en: 3"+page);
                txt_pregunta.setText("¿Tienes hijos?");
                break;
            case 9:
                Log.d("TAAAAG","aqui ando en: 3"+page);
                txt_pregunta.setText("¿Tienes mascota?");
                break;
            case 10:
                Log.d("TAAAAG","aqui ando en: 3"+page);
                txt_pregunta.setText("¿Cuantas plazas necesitas?");
                break;
            case 11:
                Log.d("TAAAAG","aqui ando en: 3"+page);
                txt_pregunta.setText("¿Cuantas puertas necesitas?");
                break;
            case 12:
                Log.d("TAAAAG","aqui ando en: 3"+page);
                txt_pregunta.setText("¿Que tipo de motor?");
                break;
            case 13:
                Log.d("TAAAAG","aqui ando en: 3"+page);
                txt_pregunta.setText("¿Tienes un vehiculo actualmente?");
                break;
            case 14:
                Log.d("TAAAAG","aqui ando en: 3"+page);
                txt_pregunta.setText("Elige una gama: ");
                break;
            default:
                Log.d("TAAAAG","aqui ando en: def"+page);
                break;
        }
    }
}
