package com.example.motoposadapp.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MotoPosadAppHelper extends SQLiteOpenHelper{
    private static final String NOMBRE_BD="MotoPosada";
    private static final int VERSION_DB=1;

    final String tabla_Usuario = "CREATE TABLE usuarios (id INTEGER, nombres TEXT, apellidos TEXT,"+
            "telefono TEXT, fecha_nacimiento TEXT, correo TEXT, contrasena TEXT, perfil TEXT," +
            "estado TEXT)";

    public MotoPosadAppHelper(Context context){
        super(context, NOMBRE_BD,null,VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabla_Usuario);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    //private static final String TABLA=""

}
