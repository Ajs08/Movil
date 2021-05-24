package com.example.motoposadapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.motoposadapp.Data.Departamentos;
import com.example.motoposadapp.Data.Modelo;
import com.example.motoposadapp.Data.Posadas;
import com.example.motoposadapp.Data.Usuarios;

public class RegistroPosada extends AppCompatActivity {
    Modelo modelo;
    Posadas posad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_posada);

        Button guardardepa = findViewById(R.id.btnRegistroPosada);
        final TextView nombre = findViewById(R.id.txtNombrePosada_final);
        final TextView latitud = findViewById(R.id.txtLatitud_final);
        final TextView longitud = findViewById(R.id.txtLongitud_final);
        final TextView capacidad = findViewById(R.id.txtCapacidad_final);
        final TextView descripcion = findViewById(R.id.txtDescripcion_final);
        final TextView disponibilidad = findViewById(R.id.txtDisponibilidad_final);

        guardardepa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Modelo modelo = new Modelo();
                Posadas posad = new Posadas();
                posad.setId(1);
                posad.setNombre(nombre.getText().toString());
                posad.setLatitud(latitud.getText().toString());
                posad.setLongitud(longitud.getText().toString());
                posad.setCapacidad(Integer.parseInt(capacidad.getText().toString()));
                posad.setDescripcion(descripcion.getText().toString());
                posad.setDisponibilidad(disponibilidad.getText().toString());
                posad.setEstado("Activo");
                boolean insertaPosada = modelo.insertaPosada(RegistroPosada.this, posad);
                if (insertaPosada == true){
                    Toast.makeText(RegistroPosada.this, "Ok, Posada registrada", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(RegistroPosada.this, "NO", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}