package com.example.motoposadapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
        if (txtnombre.isEmpty()){
            usuario.setError("El nombre no puede estar en vacio, rellenelo");
        }else{
            if (txtcontra.isEmpty()){
                pass.setError("Contraseña vacia, ingrese algo");
            }else{
                if (txtcontra.equals(contra) && txtnombre.equals(user)){
                    Intent intent = new Intent(this, MenuActivity.class);
                    intent.putExtra(EXTRA_USUARIO, txtnombre);
                    startActivity(intent);
                    //startActivity(new Intent(this, Activity2.class));
                }
                else{
                    pass.setError("Contraseña invalida");
                }
            }
        }
    }
    public void registrarse(View view){
        startActivity(new Intent(this, DrawerActivity.class));
    }
}
