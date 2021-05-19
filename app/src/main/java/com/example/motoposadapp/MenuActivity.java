package com.example.motoposadapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void mapa(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        //intent.putExtra(EXTRA_USUARIO, txtnombre);
        startActivity(intent);

    }
    public void lista(View view){
        startActivity(new Intent(this, ListadoActivity.class));
    }
}