package com.example.motoposadapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.motoposadapp.Data.Modelo;
import com.example.motoposadapp.Data.Usuarios;

public class RegistroPosada extends AppCompatActivity {

    DrawerLayout drawerLayout;

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

        drawerLayout = findViewById(R.id.drawer_layout);
    }

    public void ClickMenu(View view){
        DrawerActivity.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view){
        DrawerActivity.closeDrawer(drawerLayout);
    }

    public void ClickHome(View view){
        DrawerActivity.redirectActivity(this, RegistroPosada.class);
    }

    public void ClickDashboard(View view){
        recreate();
    }

    public void ClickAboutUs(View view){
        DrawerActivity.redirectActivity(this, MenuActivity.class);
    }

    public void ClickLogOut(View view){
        DrawerActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        DrawerActivity.closeDrawer(drawerLayout);
    }

}