package com.example.carloszamora.carchoice.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONObject;

public class Global {

//    public static String URL_D = "https://www.carqueryapi.com/api/0.3/?callback=?&cmd=getTrims&[params]";
    public static String URL_D = "https://www.carqueryapi.com/api/0.3/?callback=?&cmd=getTrims&doors=2&full_results=0&seats=2&max_cylinders=8&model=corvette&year=2000";
    public static JSONObject jsonRespuesta = new JSONObject();
    public static Integer puntero = 0;
    static SharedPreferences preferences;

    public static String mPreference = "Preference";

    public static String NOMBRE(Context ctx) {
        preferences = ctx.getSharedPreferences(mPreference, Context.MODE_PRIVATE);
        return preferences.getString("usuario","");

    }
    public static void EdNOMBRE(Context ctx, String user) {
        preferences = ctx.getSharedPreferences(mPreference, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("usuario", user);
        editor.apply();
    }

    public static String EDAD(Context ctx) {
        preferences = ctx.getSharedPreferences(mPreference, Context.MODE_PRIVATE);
        return preferences.getString("birthday","");

    }
    public static void EdEDAD(Context ctx, String birthday) {
        preferences = ctx.getSharedPreferences(mPreference, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("birthday", birthday);
        editor.apply();
    }

    public static Boolean LOGGED(Context ctx) {
        preferences = ctx.getSharedPreferences(mPreference, Context.MODE_PRIVATE);
        return preferences.getBoolean("LOGGED", false);
    }
    public static void EdLOGGED(Context ctx, Boolean status) {
        preferences = ctx.getSharedPreferences(mPreference, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("LOGGED", status);
        editor.apply();
    }

}
