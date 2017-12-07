package com.example.carloszamora.carchoice.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.carloszamora.carchoice.Fragments.PreguntaActualmente;
import com.example.carloszamora.carchoice.Fragments.PreguntaCapital;
import com.example.carloszamora.carchoice.Fragments.PreguntaEdad;
import com.example.carloszamora.carchoice.Fragments.PreguntaEstadoCivil;
import com.example.carloszamora.carchoice.Fragments.PreguntaEstudio;
import com.example.carloszamora.carchoice.Fragments.PreguntaGama;
import com.example.carloszamora.carchoice.Fragments.PreguntaHijos;
import com.example.carloszamora.carchoice.Fragments.PreguntaMascota;
import com.example.carloszamora.carchoice.Fragments.PreguntaMotor;
import com.example.carloszamora.carchoice.Fragments.PreguntaNombre;
import com.example.carloszamora.carchoice.Fragments.PreguntaPlazas;
import com.example.carloszamora.carchoice.Fragments.PreguntaPoblacion;
import com.example.carloszamora.carchoice.Fragments.PreguntaPuertas;
import com.example.carloszamora.carchoice.Fragments.PreguntaSexo;
import com.example.carloszamora.carchoice.Fragments.PreguntaTrabajo;

public class PreguntaAdapter extends FragmentPagerAdapter {
    public PreguntaAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return PreguntaNombre.newInstance();
            case 1:
                return PreguntaEdad.newInstance();
            case 2:
                return PreguntaSexo.newInstance();
            case 3:
                return PreguntaPoblacion.newInstance();
            case 4:
                return PreguntaEstudio.newInstance();
            case 5:
                return PreguntaTrabajo.newInstance();
            case 6:
                return PreguntaCapital.newInstance();
            case 7:
                return PreguntaEstadoCivil.newInstance();
            case 8:
                return PreguntaHijos.newInstance();
            case 9:
                return PreguntaMascota.newInstance();
            case 10:
                return PreguntaPlazas.newInstance();
            case 11:
                return PreguntaPuertas.newInstance();
            case 12:
                return PreguntaMotor.newInstance();
            case 13:
                return PreguntaActualmente.newInstance();
            case 14:
                return PreguntaGama.newInstance();
            default:
                return PreguntaGama.newInstance();
        }
    }

    @Override
    public int getCount() {
        return 15;
    }
}
