package com.example.carloszamora.carchoice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Inicio extends AppCompatActivity {
    Button btn_comenzar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        btn_comenzar = (Button)findViewById(R.id.btn_comenzar);
        btn_comenzar.setOnClickListener(inicia);
    }


   View.OnClickListener inicia = new View.OnClickListener() {
       @Override
       public void onClick(View v) {
            Intent inicia = new Intent(getApplicationContext(), Preguntas.class);
           startActivity(inicia);
       }
   };
}
