package com.example.motoposadapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.motoposadapp.Data.Modelo;
import com.example.motoposadapp.Data.Posadas;
import com.example.motoposadapp.Data.Usuarios;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegistroFragmento#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegistroFragmento extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RegistroFragmento() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegistroFragmento.
     */
    // TODO: Rename and change types and number of parameters
    public static RegistroFragmento newInstance(String param1, String param2) {
        RegistroFragmento fragment = new RegistroFragmento();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_registro_fragmento, container, false);

        Button registro = v.findViewById(R.id.btnRegistroPosada);
        final TextView nombre = v.findViewById(R.id.txtNombrePosada);
        final TextView latitud = v.findViewById(R.id.txtApellidos);
        final TextView longitud = v.findViewById(R.id.txtCorreo);
        final TextView capacidad = v.findViewById(R.id.txtContrasena);
        final TextView descripcion = v.findViewById(R.id.txtTelefono);
        final TextView disponibilidad = v.findViewById(R.id.txtTelefono);
        TextView btn = (TextView)v.findViewById(R.id.YaTieneCuenta);

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Modelo modelo = new Modelo();
                Posadas user= new Posadas();
                user.setId(1);
                user.setNombre(nombre.getText().toString());
                user.setLatitud(latitud.getText().toString());
                user.setLongitud(longitud.getText().toString());
                user.setCapacidad(Integer.parseInt(capacidad.getText().toString()));
                user.setDescripcion(descripcion.getText().toString());
                user.setDisponibilidad(disponibilidad.getText().toString());
                user.setEstado("Activo");

                boolean insertarUsuario = modelo.insertarPosada(getContext(), user);
                if (insertarUsuario == true){

                    Toast.makeText(getContext(), "OK, Posada registrada", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getContext(), "NO", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return v;
    }
}