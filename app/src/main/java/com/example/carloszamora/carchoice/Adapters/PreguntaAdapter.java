package com.example.carloszamora.carchoice.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.carloszamora.carchoice.Fragments.PreguntaEdad;
import com.example.carloszamora.carchoice.Fragments.PreguntaNombre;
import com.example.carloszamora.carchoice.Fragments.PreguntaSexo;

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
            default:
                return PreguntaEdad.newInstance();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
