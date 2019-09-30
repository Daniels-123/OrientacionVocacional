package com.orientacionvocacional;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by intel on 5/8/2016.
 */
public class DataBaseManager {

    ahorcadobomb ab= new ahorcadobomb ();
    int ab2=ab.aciertos;

    public static final String TABLE_NAME= "nombreusers";
    public static final String TABLE_NAME2= "puntajes";
    public static final String CN_NOMBRE = "nombre";
    public static final String CN_EDAD = "edad";
    public static final String CN_GENERO = "genero";
    public static final String PUNTOS = "puntos";
    public static final String PROFESION = "profesion";
    public static final String CREATE_TABLE= "create table "+TABLE_NAME+" ("
            +CN_NOMBRE+" text primary key not null,"
            +CN_EDAD+" text not null,"
            +CN_GENERO+" text not null);";

    public static final String CREATE_TABLE2= "create table "+TABLE_NAME2+" ("
            +CN_NOMBRE+" text null,"
            +PUNTOS+" integer not null,"
            +PROFESION+" text not null);";




    private DbHelper helper;
    private SQLiteDatabase db;

    public DataBaseManager(Context context) {
        helper = new DbHelper(context);
        db = helper.getWritableDatabase();
    }

    public ContentValues generarContentValues(String nombre, String edad, String genero){
        ContentValues valores = new ContentValues();
        valores.put(CN_NOMBRE,nombre);
        valores.put(CN_EDAD,edad);
        valores.put(CN_GENERO,genero);




        return valores;


    }

    public ContentValues generarCOntentValues2 (int puntos, String profesion){
        ContentValues valores2=new ContentValues();
        Login lo = new Login();
        String nombre=lo.nombre;
        valores2.put(CN_NOMBRE,nombre);
        valores2.put(PUNTOS,puntos);
        valores2.put(PROFESION,profesion);

        if (ab2!=0){
            String bombero="bombero";
            insertarpuntajeab(nombre,ab2,bombero);
        }

        return valores2;
    }

    public void insertar (String nombre, String edad, String genero){
        db.insert(TABLE_NAME, null, generarContentValues(nombre, edad, genero));
    }

    public void insertar2 (String nombre, String edad, String genero){
        db.execSQL("insert into " + TABLE_NAME + " values ('" + nombre + "','" + edad + "','" + genero + "');");
    }

    public void insertarpuntajeab (String nombre, int puntos, String profesion){
        db.execSQL("insert into "+TABLE_NAME2+" values ('"+nombre+"','"+puntos+"','"+profesion+"');");
    }
}
