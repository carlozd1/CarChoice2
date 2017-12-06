package com.example.carloszamora.carchoice.BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "carchoice.db";
    //Declaracion de tablas y columnas
    public static final String TABLE_PREGUNTA = "pregunta";
    public static final String TABLE_RESPUESTA = "respuesta";
    public static final String TABLE_AUTO = "auto";


    SQLiteDatabase db;
    //Creacion de cada tabla de la bd
    private final String CREATE_PREGUNTA = "CREATE TABLE "+TABLE_PREGUNTA+" (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            "texto text not null);";

    private final String CREATE_RESPUESTA = "CREATE TABLE "+TABLE_RESPUESTA+" ( _id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, idpregunta INTEGER NOT NULL REFERENCES pregunta (_id),respuesta TEXT NOT NULL, relacion INTEGER NOT NULL, " +
            ");";

    private final String CREATE_AUTO = "CREATE TABLE "+TABLE_AUTO+" (_id INTEGER PRIMARY KEY NOT NULL, " +
            "tipo TEXT," +
            "puertas TEXT," +
            "plazas TEXT," +
            "motor TEXT," +
            "mensualidad TEXT," +
            "origen TEXT" +
            ");";
    private final String INSERT_PREGUNTA = "INSERT INTO "+TABLE_PREGUNTA+" VALUES" +
            "(1,'Pregunta 1'), " +
            "(2,'Pregunta 2'), " +
            "(3,'Pregunta 3'), " +
            "(4,'Pregunta 4'), " +
            "(5,'Pregunta 5'), " +
            "(6,'Pregunta 6'), " +
            "(7,'Pregunta 7'), " +
            "(8,'Pregunta 8'), " +
            "(9,'Pregunta 9'), " +
            "(10,'Pregunta 10'), " +
            "(11,'Pregunta 11'), " +
            "(12,'Pregunta 12'), " +
            "(13,'Pregunta 13'), " +
            "(14,'Pregunta 14), " +
            "(15,'Pregunta 15'), " +
            "(16,'Pregunta 16'), " +
            "(17,'Pregunta 17'), " +
            "(18,'Pregunta 18'), " +
            "(19,'Pregunta 19'), " +
            "(20,'Pregunta 20')";


    //Constructor
    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PREGUNTA);
        db.execSQL(CREATE_RESPUESTA);
        db.execSQL(CREATE_AUTO);
        db.execSQL(INSERT_PREGUNTA);

        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String query1 = "DROP TABLE IF EXISTS "+ TABLE_PREGUNTA;
        String query2 = "DROP TABLE IF EXISTS "+ TABLE_RESPUESTA;
        String query3 = "DROP TABLE IF EXISTS "+ TABLE_AUTO;
        db.execSQL(query1);
        db.execSQL(query2);
        db.execSQL(query3);
        this.onCreate(db);
    }


}
