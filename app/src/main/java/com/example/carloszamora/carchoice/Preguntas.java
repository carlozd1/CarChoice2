package com.example.carloszamora.carchoice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.carloszamora.carchoice.Adapters.PreguntaAdapter;
import com.example.carloszamora.carchoice.Utils.CustomViewPager;


public class Preguntas extends AppCompatActivity {
    Integer counter;
    CustomViewPager viewPager;

    int contador = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);


        viewPager = (CustomViewPager) findViewById(R.id.viewpager);
        PreguntaAdapter adapter = new PreguntaAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setPagingEnabled(true);
        counter = viewPager.getCurrentItem();
    }

    public static void setCounter (Integer currentPage){
        Log.d("TAAAG","Aqui ando");
    }
}
