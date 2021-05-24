package com.example.motoposadapp.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.security.PublicKey;
import java.util.ArrayList;

public class Modelo {
    SQLiteDatabase sql;
    public SQLiteDatabase getConn(Context context){
        MotoPosadAppHelper conn = new MotoPosadAppHelper(context);
        SQLiteDatabase db = conn.getWritableDatabase();
        return db;
    }
    public boolean insertaUsuario(Context context, Usuarios u){
          //String sql="INSERT INTO usuarios (id, nombres, apellidos, telefono, fecha_nacimiento, correo, contrasena, perfil, estado) VALUES("+
//        u.getId()+",'"+u.getNombres()+"','"+u.getApellidos()+"','"+u.getTelefono()+"','"+u.getFecha_nacimiento()+"','"+u.getCorreo()+
//                "','"+u.getContrasena()+"','"+u.getPerfil()+"','"+u.getEstado()+"')";
//        try{
//            db.execSQL(sql);
//            res = true;
//        }catch (Exception e){
//
//        }
        SQLiteDatabase db = this.getConn(context);
        if (buscarUsuario(context, u.getCorreo())== 0){
            ContentValues cv= new ContentValues();
            cv.put("nombres",u.getNombres());
            cv.put("apellidos",u.getApellidos());
            cv.put("telefono",u.getTelefono());
            cv.put("fecha_nacimiento",u.getFecha_nacimiento());
            cv.put("correo",u.getCorreo());
            cv.put("contrasena",u.getContrasena());
            cv.put("perfil",u.getPerfil());
            cv.put("placa_moto",u.getPlaca_moto());
            cv.put("modelo_moto",u.getModelo_moto());
            cv.put("marca_moto",u.getMarca_moto());
            cv.put("estado",u.getEstado());
            return (db.insert("usuarios", null,cv)>0);
        }else {
            return false;
        }
    }
    public boolean insertarPosada(Context context, Posadas u){
        //String sql="INSERT INTO usuarios (id, nombres, apellidos, telefono, fecha_nacimiento, correo, contrasena, perfil, estado) VALUES("+
//        u.getId()+",'"+u.getNombres()+"','"+u.getApellidos()+"','"+u.getTelefono()+"','"+u.getFecha_nacimiento()+"','"+u.getCorreo()+
//                "','"+u.getContrasena()+"','"+u.getPerfil()+"','"+u.getEstado()+"')";
//        try{
//            db.execSQL(sql);
//            res = true;
//        }catch (Exception e){
//
//        }
        SQLiteDatabase db = this.getConn(context);

            ContentValues cv= new ContentValues();
            cv.put("nombres",u.getNombre());
            cv.put("latitud",u.getLatitud());
            cv.put("longitud",u.getLongitud());
            cv.put("capacidad",u.getCapacidad());
            cv.put("descripcion",u.getDescripcion());
            cv.put("disponibilidad",u.getDisponibilidad());
            cv.put("estado",u.getEstado());

            return (db.insert("posadas", null,cv)>0);

    }
    public int buscarUsuario(Context context, String correo){
        int x = 0;
        ArrayList<Usuarios> lista =selecUsuarios(context);
        for (Usuarios us:lista){
            if(us.getCorreo().equals(correo)){
                x++;
            }
        }
        return x;
    }
    public ArrayList<Usuarios> selecUsuarios(Context context){
        ArrayList<Usuarios> lista = new ArrayList<Usuarios>();
        lista.clear();
        SQLiteDatabase db = this.getConn(context);
        Cursor cr= db.rawQuery("select * from usuarios where estado = 'activo'",null);
        if (cr!=null && cr.moveToFirst()){
            do{
                Usuarios u=new Usuarios();
                u.setId(cr.getInt(0));
                u.setNombres(cr.getString(1));
                u.setApellidos(cr.getString(2));
                u.setTelefono(cr.getString(3));
                u.setFecha_nacimiento(cr.getString(4));
                u.setCorreo(cr.getString(5));
                u.setContrasena(cr.getString(6));
                u.setPerfil(cr.getString(7));
                u.setPlaca_moto(cr.getString(8));
                u.setModelo_moto(cr.getString(9));
                u.setMarca_moto(cr.getString(10));
                u.setEstado(cr.getString(11));
                lista.add(u);

            }while(cr.moveToNext());
        }
        return lista;
    }

    public boolean login(Context context, String correo, String clave){
        boolean res=false;
        //String sql="SELECT correo, contrasena from usuarios where correo = '"+correo+"' and contrasena = '"+clave+"'";
        SQLiteDatabase db = this.getConn(context);
        Cursor cr = db.rawQuery("select * from usuarios", null);
        if(cr != null && cr.moveToFirst()){
            do{
                if (cr.getString(5).equals(correo) && cr.getString(6).equals(clave)){
                    res=true;
                }
            }while (cr.moveToNext());
        }
        return res;
    }
    public Usuarios getUsuario(Context context, String correo, String clave){
        ArrayList<Usuarios> lista=selecUsuarios(context);
        for (Usuarios u:lista){
            if (u.getCorreo().equals(correo) && u.getContrasena().equals(clave)){
                return u;
            }
        }
        return null;
    }
    public Usuarios getUsuarioById(Context context, int id){
        ArrayList<Usuarios> lista=selecUsuarios(context);
        for (Usuarios u:lista){
            if (u.getId() == id){
                return u;
            }
        }
        return null;
    }
    public ArrayList<Ciudades> getCiudadByDepart(Context context, int id_departamento){
        ArrayList<Ciudades> select=selectCiudades(context);
        ArrayList<Ciudades> lista = new ArrayList<Ciudades>();
        for (Ciudades c:select){
            if (c.getId_departamentos() == id_departamento){
                lista.add(c);
            }
        }
        return lista;
    }
    public ArrayList<Ciudades> selectCiudades(Context context){
        ArrayList<Ciudades> lista = new ArrayList<Ciudades>();
        lista.clear();
        SQLiteDatabase db = this.getConn(context);
        Cursor cr= db.rawQuery("select * from ciudades where estado = 'activo'",null);
        if (cr!=null && cr.moveToFirst()){
            do{
                Ciudades c=new Ciudades();
                c.setId(cr.getInt(0));
                c.setId_departamentos(cr.getInt(1));
                c.setNombre(cr.getString(2));
                c.setEstado(cr.getString(3));
                lista.add(c);

            }while(cr.moveToNext());
        }
        return lista;
    }

    public boolean insertaPosada(Context context, Posadas p){
        SQLiteDatabase db = this.getConn(context);
        if(db!=null){
            ContentValues cv= new ContentValues();
            cv.put("nombre", p.getNombre());
            cv.put("latitud", p.getLatitud());
            cv.put("longitud", p.getLongitud());
            cv.put("capacidad", p.getCapacidad());
            cv.put("descripcion", p.getDescripcion());
            cv.put("disponibilidad", p.getDisponibilidad());
            cv.put("estado", p.getEstado());
            return (db.insert("tabla_Posada", null, cv)>0);
        }else{
            return false;
        }
    }

    public boolean insertarDepartamento(Context context, Departamentos d){
        SQLiteDatabase db = this.getConn(context);
        if (buscarDepartamento(context, d.getNombre())== 0){
            ContentValues cv= new ContentValues();
            cv.put("nombre",d.getNombre());
            cv.put("estado",d.getEstado());
            return (db.insert("departamentos", null,cv)>0);
        }else {
            return false;
        }
    }
    public int buscarDepartamento(Context context, String nombre_Dep){
        int x = 0;
        ArrayList<Departamentos> lista =selectDepartamentos(context);
        for (Departamentos us:lista){
            if(us.getNombre().equals(nombre_Dep)){
                x++;
            }
        }
        return x;
    }
    public ArrayList<Departamentos> selectDepartamentos(Context context){
        ArrayList<Departamentos> lista = new ArrayList<Departamentos>();
        lista.clear();
        SQLiteDatabase db = this.getConn(context);
        Cursor cr= db.rawQuery("select * from departamentos where estado = 'activo'",null);
        if (cr!=null && cr.moveToFirst()){
            do{
                Departamentos d=new Departamentos();
                d.setId(cr.getInt(0));
                d.setNombre(cr.getString(1));
                d.setEstado(cr.getString(2));
                lista.add(d);

            }while(cr.moveToNext());
        }
        return lista;
    }

    public Usuarios buscarU(Context context, String correo){
        Log.d("searching", correo);
        Usuarios u = new Usuarios();
        SQLiteDatabase db = this.getConn(context);
        Cursor cr = db.rawQuery("select * from usuarios where correo = '" + correo + "'", null);
        if(cr != null && cr.moveToFirst()){
            do{
                if (cr.getString(5).equals(correo)){
                    u.setId(cr.getInt(0));
                    u.setNombres(cr.getString(1));
                    u.setApellidos(cr.getString(2));
                    u.setTelefono(cr.getString(3));
                    u.setFecha_nacimiento(cr.getString(4));
                    u.setCorreo(cr.getString(5));
                    u.setContrasena(cr.getString(6));
                    u.setPerfil(cr.getString(7));
                    u.setPlaca_moto(cr.getString(8));
                    u.setModelo_moto(cr.getString(9));
                    u.setMarca_moto(cr.getString(10));
                    u.setEstado(cr.getString(11));
                }
            }while (cr.moveToNext());
        }
        return u;
    }
    public int actualizar(Context context, String correo, Usuarios usuario){
        int respuesta;
        SQLiteDatabase db = this.getConn(context);

        ContentValues cv= new ContentValues();
        cv.put("nombres",usuario.getNombres());
        cv.put("apellidos",usuario.getApellidos());
        cv.put("telefono",usuario.getTelefono());
        cv.put("contrasena",usuario.getContrasena());

        respuesta = db.update("usuarios", cv, "correo = ?", new String[] {usuario.getCorreo()});

        return respuesta;
    }

}
