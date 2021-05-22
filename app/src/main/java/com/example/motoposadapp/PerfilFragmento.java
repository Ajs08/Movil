package com.example.motoposadapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.motoposadapp.Data.Modelo;
import com.example.motoposadapp.Data.Usuarios;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PerfilFragmento#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PerfilFragmento extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String userName;
    public PerfilFragmento() {
        // Required empty public constructor
    }

    public PerfilFragmento(String userName) {
        // Required empty public constructor
        this.userName = userName;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PerfilFragmento.
     */
    // TODO: Rename and change types and number of parameters
    public static PerfilFragmento newInstance(String param1, String param2) {
        PerfilFragmento fragment = new PerfilFragmento();
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

        View m = inflater.inflate(R.layout.fragment_perfil_fragmento,container, false);
        final Modelo modelo = new Modelo();
        Button actualizarInf = m.findViewById(R.id.btnActualizar);
        final TextView nombreActualizado = m.findViewById(R.id.txtNombres);
        final TextView apellidoActualizado = m.findViewById(R.id.txtApellidos);
        final TextView telefonoActualizado = m.findViewById(R.id.txtTelefono);
        final TextView correoActualizado = m.findViewById(R.id.txtCorreo);
        final  TextView contrasenaActualizada = m.findViewById(R.id.txtContrasena);
        final String currentUserEmail = this.userName;

        //Buscar el usuario logeado y settear sus datos
        Usuarios currentUser = modelo.buscarU(getActivity(), currentUserEmail);
        Log.d("usuarios", currentUser.toString());

        nombreActualizado.setText(currentUser.getNombres());
        apellidoActualizado.setText(currentUser.getApellidos());
        telefonoActualizado.setText(currentUser.getTelefono());
        contrasenaActualizada.setText(currentUser.getContrasena());

        actualizarInf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Usuarios user= new Usuarios();
                user.setNombres(nombreActualizado.getText().toString());
                user.setApellidos(apellidoActualizado.getText().toString());
                user.setTelefono(telefonoActualizado.getText().toString());
                user.setCorreo(correoActualizado.getText().toString());
                user.setContrasena(contrasenaActualizada.getText().toString());

                int res = modelo.actualizar(getContext(), currentUserEmail, user);
                if (res > 0){
                    Toast.makeText(getActivity(), "OK, Usuario registrado", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity(), "NO", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return inflater.inflate(R.layout.fragment_perfil_fragmento, container, false);
    }
}