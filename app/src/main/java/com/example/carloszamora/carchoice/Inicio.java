package com.example.carloszamora.carchoice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.Console;

public class Inicio extends AppCompatActivity {


    Button btn_comenzar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Button btn_comenzar = (Button)findViewById(R.id.btn_comenzar);

    }

    private void comenzar(){
        Log.e("Inicio","Inicio");
    }
}
