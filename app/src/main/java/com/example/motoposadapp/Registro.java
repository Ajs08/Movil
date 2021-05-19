package com.example.motoposadapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.motoposadapp.Data.Modelo;
import com.example.motoposadapp.Data.Usuarios;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        Button registro = findViewById(R.id.btnRegistro);
        final TextView nombre = findViewById(R.id.txtNombres);
        final TextView apellidos = findViewById(R.id.txtApellidos);
        final TextView correo = findViewById(R.id.txtCorreo);
        final TextView contra = findViewById(R.id.txtContrasena);
        final TextView telefono = findViewById(R.id.txtTelefono);
        TextView btn = (TextView)findViewById(R.id.YaTieneCuenta);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registro.this, MainActivity.class));
            }
        });
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Modelo modelo = new Modelo();
                Usuarios user= new Usuarios();
                user.setId(1);
                user.setNombres(nombre.getText().toString());
                user.setApellidos(apellidos.getText().toString());
                user.setCorreo(correo.getText().toString());
                user.setContrasena(contra.getText().toString());
                user.setFecha_nacimiento("Null");
                user.setTelefono(telefono.getText().toString());
                user.setPerfil("Motero");
                user.setEstado("Activo");
                boolean insertarUsuario = modelo.insertaUsuario(Registro.this, user);
                if (insertarUsuario == true){
                    Toast.makeText(Registro.this, "OK, Usuario registrado", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Registro.this, "NO", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}