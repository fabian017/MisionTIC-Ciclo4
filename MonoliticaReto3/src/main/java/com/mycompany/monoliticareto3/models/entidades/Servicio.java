package com.mycompany.monoliticareto3.models.entidades;

public class Servicio {
    private int id;
    private String tipo_string;
    private float precio;

    public Servicio() {
    }

    public Servicio(int id, String tipo_string, float precio) {
        this.id = id;
        this.tipo_string = tipo_string;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo_string() {
        return tipo_string;
    }

    public void setTipo_string(String tipo_string) {
        this.tipo_string = tipo_string;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    
    
    
}
