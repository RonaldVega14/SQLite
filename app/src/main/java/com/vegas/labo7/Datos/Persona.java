package com.vegas.labo7.Datos;

/**
 * Created by uca on 05-17-18.
 */

public class Persona {
    private String dui;
    private String nombre;

    public Persona(){

    }

    public Persona(String dui, String nombre){
        this.dui = dui;
        this.nombre = nombre;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
