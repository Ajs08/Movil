package com.example.motoposadapp.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MotoPosadAppHelper extends SQLiteOpenHelper{
    private static final String NOMBRE_BD="MotoPosada";
    private static final int VERSION_DB=2;

    final String tabla_Usuario = "CREATE TABLE usuarios (id INTEGER PRIMARY KEY AUTOINCREMENT, nombres TEXT, apellidos TEXT,"+
            "telefono TEXT, fecha_nacimiento TEXT, correo TEXT, contrasena TEXT, perfil TEXT," +
            "placa_moto TEXT, modelo_moto TEXT, marca_moto,estado TEXT)";

    final String tabla_Calificacion = "CREATE TABLE calificaciones (id INTEGER PRIMARY KEY AUTOINCREMENT, calificacion INTEGER, " +
            "id_usuario INTEGER,id_reserva INTEGER, id_posada INTEGER, comentario TEXT, fecha TEXT,estado TEXT)";

    final String tabla_Ciudad = "CREATE TABLE ciudades (id INTEGER PRIMARY KEY AUTOINCREMENT, id_departamento INTEGER,"+
            "nombre TEXT, estado TEXT)";

    final String tabla_Departamento = "CREATE TABLE departamentos (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, estado TEXT)";

    final String tabla_Posada = "CREATE TABLE posadas (id INTEGER PRIMARY KEY AUTOINCREMENT, id_ciudad INTEGER," +
            "id_usuario INTEGER, nombre TEXT, latitud TEXT, longitud TEXT, capacidad INTEGER," +
            "descripcion TEXT, disponibilidad TEXT, estado TEXT)";

    final String tabla_Posada_img = "CREATE TABLE posadas_imagenes (id INTEGER PRIMARY KEY AUTOINCREMENT, id_posada INTEGER," +
            "id_usuario INTEGER, img BLOB, estado TEXT)";

    final String tabla_Reserva = "CREATE TABLE reservas (id INTEGER PRIMARY KEY AUTOINCREMENT, id_posada INTEGER," +
            "id_usuario INTEGER, comentario TEXT, cupos INTEGER, fecha_ingreso TEXT, fecha_salida TEXT," +
            "estado TEXT)";

    final String edit_Usuario = "UPDATE TABLE usuarios (id INTEGER PRIMARY KEY AUTOINCREMENT, nombres TEXT, apellidos TEXT,"+
            "telefono TEXT, fecha_nacimiento TEXT, correo TEXT, contrasena TEXT, perfil TEXT," +
            "placa_moto TEXT, modelo_moto TEXT, marca_moto,estado TEXT)";


    public MotoPosadAppHelper(Context context){
        super(context, NOMBRE_BD,null,VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabla_Usuario);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(tabla_Calificacion);
        db.execSQL(tabla_Ciudad);
        db.execSQL(tabla_Departamento);
        db.execSQL(tabla_Posada);
        db.execSQL(tabla_Posada_img);
        db.execSQL(tabla_Reserva);
        db.execSQL(edit_Usuario);

    }
    //private static final String TABLA=""

}
