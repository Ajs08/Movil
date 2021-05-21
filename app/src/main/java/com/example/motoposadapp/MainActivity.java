package com.example.motoposadapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.motoposadapp.Data.Modelo;
import com.example.motoposadapp.Data.Usuarios;

public class MainActivity extends AppCompatActivity {
    private final String contra = "pass123";
    private final String user = "jdcastro";
    public static  final String EXTRA_USUARIO = "com.example.motoposadapp.USUARIO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void ingresarUsuario(View view){
        //Validar campos en blanco
        EditText usuario = findViewById(R.id.edtUsuario);
        EditText pass = findViewById(R.id.edtPassword);
        String txtnombre = usuario.getText().toString();
        String txtcontra = pass.getText().toString();
        Modelo modelo = new Modelo();
        Usuarios user= new Usuarios();
        boolean login = modelo.login(MainActivity.this,txtnombre,txtcontra);
        if (txtnombre.isEmpty()){
            usuario.setError("El nombre no puede estar en vacio, rellenelo");
            Toast.makeText(MainActivity.this, "Usuario vacio", Toast.LENGTH_SHORT).show();
        }else{
            if (txtcontra.isEmpty()){
                pass.setError("Contraseña vacia, ingrese algo");
                Toast.makeText(MainActivity.this, "Contrase Vacia", Toast.LENGTH_SHORT).show();
            }else{
                if(login == true){
                    Toast.makeText(MainActivity.this, "Bienvenido", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, DrawerActivity.class);
                    intent.putExtra(EXTRA_USUARIO, txtnombre);
                    startActivity(intent);
                }
                else{
                    pass.setError("Contraseña invalida");
                    Toast.makeText(MainActivity.this, "Contrase Invalida", Toast.LENGTH_SHORT).show();

                }
            }
        }
    }
    public void registrarse(View view){
        startActivity(new Intent(this, Registro.class));
    }
}
