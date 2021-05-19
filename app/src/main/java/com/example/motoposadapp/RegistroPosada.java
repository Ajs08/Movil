package com.example.motoposadapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.motoposadapp.Data.Modelo;
import com.example.motoposadapp.Data.Usuarios;

public class RegistroPosada extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_posada);

        Button registroPosada = findViewById(R.id.btnRegistroPosada);
        final TextView nombre = findViewById(R.id.txtNombrePosada);
        final TextView latitud = findViewById(R.id.txtLatitud);
        final TextView longitud = findViewById(R.id.txtLongitud);
        final TextView capacidad = findViewById(R.id.txtCapacidad);
        final TextView descripcion = findViewById(R.id.txtDescripcion);
        final TextView disponibilidad = findViewById(R.id.txtDisponibilidad);
    }
}