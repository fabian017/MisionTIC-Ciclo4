package com.mycompany.apiresttl.models;

public class Usuario {
    private int id;
    private String usuario;
    private String password;
    private int tipo;
    private String hash;

    public Usuario() {
    }

    public Usuario(int id, String usuario, String password, int tipo, String hash) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.tipo = tipo;
        this.hash = hash;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }


    
    
}
