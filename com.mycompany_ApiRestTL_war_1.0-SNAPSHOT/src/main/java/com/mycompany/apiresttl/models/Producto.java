package com.mycompany.apiresttl.models;

public class Producto {
    private int id;
    private String tipo_string;
    private int tipo_int;
    private float precio;

    public Producto() {
    }

    public Producto(int id, String tipo_string, int tipo_int, float precio) {
        this.id = id;
        this.tipo_string = tipo_string;
        this.tipo_int = tipo_int;
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

    public int getTipo_int() {
        return tipo_int;
    }

    public void setTipo_int(int tipo_int) {
        this.tipo_int = tipo_int;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    
    
}
