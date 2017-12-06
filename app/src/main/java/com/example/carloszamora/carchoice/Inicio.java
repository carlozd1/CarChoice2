package com.example.carloszamora.carchoice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.Console;

public class Inicio extends AppCompatActivity implements View.OnClickListener {

    Button btn_comenzar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        btn_comenzar = (Button)findViewById(R.id.btn_comenzar);
        btn_comenzar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view == btn_comenzar){
            Intent i = new Intent(this, Preguntas.class);
            startActivity(i);
        }
    }
}
