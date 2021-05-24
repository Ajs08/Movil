package com.example.motoposadapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.motoposadapp.Data.Departamentos;
import com.example.motoposadapp.Data.Modelo;

public class FormDepartamento extends AppCompatActivity {
    Modelo modelo;
    Departamentos dep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_departamento);

        Button guardar = findViewById(R.id.btnGuardar);
        final TextView departamento = findViewById(R.id.txtDepartamento);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Departamentos dep = new Departamentos();
                Modelo modelo = new Modelo();
                dep.setNombre(departamento.getText().toString());
                dep.setEstado("Activo");
                boolean insertarDepartamento = modelo.insertarDepartamento(FormDepartamento.this, dep);
                if (insertarDepartamento == true){
                    Toast.makeText(FormDepartamento.this, "OK, Departamento registrado", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(FormDepartamento.this, "NO", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
