package com.example.carloszamora.carchoice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.carloszamora.carchoice.APIConsumer.RestApiClient;
import com.example.carloszamora.carchoice.Adapters.ResultadosAdapter;
import com.example.carloszamora.carchoice.Objects.Propuesta;
import com.example.carloszamora.carchoice.Utils.Global;
import com.wang.avi.AVLoadingIndicatorView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Resultado extends AppCompatActivity {
    AVLoadingIndicatorView loader;
    TextView cargando;
    ProgressBar progreso;
    ArrayList<Propuesta> optionsArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        consultaAPI();
    }

    public void consultaAPI(){
        String param1 = Global.param1+"";
        String param2 = Global.param2;
        String param3 = Global.param3+"";
        String param4 = Global.param4+"";
        String param5 = Global.param5;
        String param6 = Global.param6+"";
        optionsArray = new ArrayList<>();
        String URL = ""+param1+param2+param3+param4+param5+param6;
        loader = (AVLoadingIndicatorView)findViewById(R.id.avi_loader);

        new RestApiClient(Global.URL_D ,null, null, null, RestApiClient.METHOD.GET, new RestApiClient.RestInterface() {

            @Override
            public void onFinish(final String Result) {
                if (Result != null) {
                    stopAnim();
                    String resultado = Result.replaceAll("\\(", "").replaceAll("\\)", "").replaceAll("\\?", "").replaceAll("\\;","");
                    try {
                        JSONObject jsonElement;
                        JSONObject jsonResult = new JSONObject(resultado);
                        JSONArray propuestas = new JSONArray(jsonResult.getString("Trims"));
                        Integer size = propuestas.length();
                        for (int i = 0; i < size; i++) {
                            jsonElement = new JSONObject(propuestas.getString(i));
                            String marca = jsonElement.getString("make_display");
                            String gama = jsonElement.getString("model_body");
                            String modelo = jsonElement.getString("model_name");
                            String motor = jsonElement.getString("model_engine_cyl");
                            String plazas = jsonElement.getString("model_seats");
                            String puertas = jsonElement.getString("model_doors");
                            optionsArray.add(new Propuesta(modelo,marca,puertas,plazas,motor,gama));
                        }
                        RecyclerView principalRecycler = (RecyclerView)findViewById(R.id.recycler_propuestas);
                        principalRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        ResultadosAdapter resultadosAdapter = new ResultadosAdapter(getApplicationContext(), optionsArray);
                        principalRecycler.setAdapter(resultadosAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }else{
                    stopAnim();
                }
            }
            @Override
            public void onBefore() {
                startAnim();
            }
        }).execute();
    }


    public void startAnim(){
        loader.show();
    }

    public void stopAnim(){
        loader.smoothToHide();
    }

}
