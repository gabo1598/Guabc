package com.example.login_v1;

public class Usuario {
    int id;
    String Nombre, Password;

    public Usuario() {
    }

    public Usuario(String nombre, String password) {
        Nombre = nombre;
        Password = password;
    }

    public boolean isNull(){
        if(Nombre.equals("")&&Password.equals("")){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", Nombre='" + Nombre + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPassword() {
        return Password;
    }
}
