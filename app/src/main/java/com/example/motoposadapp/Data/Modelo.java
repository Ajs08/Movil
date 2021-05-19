package com.example.motoposadapp.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Modelo {

    public SQLiteDatabase getConn(Context context){
        MotoPosadAppHelper conn = new MotoPosadAppHelper(context);
        SQLiteDatabase db = conn.getWritableDatabase();
        return db;
    }
    public boolean insertaUsuario(Context context, Usuarios u){
        boolean res=false;
        String sql="INSERT INTO usuarios (id, nombres, apellidos, telefono, fecha_nacimiento, correo, contrasena, perfil, estado) VALUES("+
        u.getId()+",'"+u.getNombres()+"','"+u.getApellidos()+"','"+u.getTelefono()+"','"+u.getFecha_nacimiento()+"','"+u.getCorreo()+
                "','"+u.getContrasena()+"','"+u.getPerfil()+"','"+u.getEstado()+"')";
        SQLiteDatabase db = this.getConn(context);
        try{
            db.execSQL(sql);
            res = true;
        }catch (Exception e){

        }
        return res;
    }
    public boolean login(Context context, String usuario, String clave){
        boolean res=false;
        String sql="SELECT estado from usuarios where correo = '"+usuario+"' and contrasena = '"+clave+"'";
        SQLiteDatabase db = this.getConn(context);
        try{
            db.execSQL(sql);
            res = true;
        }catch (Exception e){

        }
        return res;
    }

}
