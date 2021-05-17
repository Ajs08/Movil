package com.example.motoposadapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        //Cargar nombre usuario
        Intent intent = getIntent();
        String nombre = intent.getStringExtra(MainActivity.EXTRA_USUARIO);
        TextView txtnombre = findViewById(R.id.txtSaludo);
        txtnombre.setText("Hola, como estas, bievenido "+nombre);

    }

    public void mapa(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        //intent.putExtra(EXTRA_USUARIO, txtnombre);

        startActivity(intent);

    }

}
