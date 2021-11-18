package com.mycompany.apiresttl.models;

public class PagoTarjetaCredito {
    private int id;
    private String nombre;
    private String numero;
    private String fecha_venci;
    private String codigo;

    public PagoTarjetaCredito() {
    }

    public PagoTarjetaCredito(int id, String nombre, String numero, String fecha_venci, String codigo) {
        this.id = id;
        this.nombre = nombre;
        this.numero = numero;
        this.fecha_venci = fecha_venci;
        this.codigo = codigo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getFecha_venci() {
        return fecha_venci;
    }

    public void setFecha_venci(String fecha_venci) {
        this.fecha_venci = fecha_venci;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    
}


