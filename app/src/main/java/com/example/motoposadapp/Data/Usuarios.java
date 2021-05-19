package com.example.motoposadapp.Data;

public class Usuarios {
    private int id;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String fecha_nacimiento;
    private String correo;
    private String contrasena;
    private String perfil;
    private String placa_moto;
    private String modelo_moto;
    private String marca_moto;
    private String estado;

    public Usuarios(String nombres, String apellidos, String telefono, String fecha_nacimiento, String correo, String contrasena, String perfil, String placa_moto, String modelo_moto, String marca_moto, String estado) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
        this.correo = correo;
        this.contrasena = contrasena;
        this.perfil = perfil;
        this.placa_moto = placa_moto;
        this.modelo_moto = modelo_moto;
        this.marca_moto = marca_moto;
        this.estado = estado;
    }
    public Usuarios(){

    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "id=" + id +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fecha_nacimiento='" + fecha_nacimiento + '\'' +
                ", correo='" + correo + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", perfil='" + perfil + '\'' +
                ", placa_moto='" + placa_moto + '\'' +
                ", modelo_moto='" + modelo_moto + '\'' +
                ", marca_moto='" + marca_moto + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getPlaca_moto() {
        return placa_moto;
    }

    public void setPlaca_moto(String placa_moto) {
        this.placa_moto = placa_moto;
    }

    public String getModelo_moto() {
        return modelo_moto;
    }

    public void setModelo_moto(String modelo_moto) {
        this.modelo_moto = modelo_moto;
    }

    public String getMarca_moto() {
        return marca_moto;
    }

    public void setMarca_moto(String marca_moto) {
        this.marca_moto = marca_moto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
