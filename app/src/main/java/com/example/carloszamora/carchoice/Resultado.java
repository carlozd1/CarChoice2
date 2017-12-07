package com.example.carloszamora.carchoice;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.carloszamora.carchoice.APIConsumer.RestApiClient;
import com.example.carloszamora.carchoice.Utils.Global;

import org.json.JSONException;
import org.json.JSONObject;

public class Resultado extends AppCompatActivity {
    TextView cargando;
    ProgressBar progreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        progreso = (ProgressBar)findViewById(R.id.progreso);
        cargando = (TextView)findViewById(R.id.txt_progreso);

        consultaAPI();
    }

    public void consultaAPI(){
        String URL = "";

        new RestApiClient(Global.URL_D ,null, null, null, RestApiClient.METHOD.GET, new RestApiClient.RestInterface() {
            @Override
            public void onFinish(final String Result) {
                if (Result != null) {
                    SystemClock.sleep(5000);
                    progreso.setVisibility(View.GONE);
                    cargando.setVisibility(View.GONE);
                    String resultado = Result.replaceAll("\\(", "").replaceAll("\\)", "").replaceAll("\\?", "").replaceAll("\\;","");
                    Log.d("TAAAG","json: "+Result);
                    try {
                        JSONObject jsonResult = new JSONObject(resultado);
                        Log.d("TAAG","esto es: "+jsonResult.getString("Trims"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }else{
                    SystemClock.sleep(5000);
                    progreso.setVisibility(View.GONE);
                    cargando.setVisibility(View.GONE);
                }
            }
            @Override
            public void onBefore() {
                progreso.setVisibility(View.VISIBLE);
                cargando.setVisibility(View.VISIBLE);
            }
        }).execute();
    }
}
