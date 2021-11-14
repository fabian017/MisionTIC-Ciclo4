package com.mycompany.apiresttl.dao;

import com.mycompany.apiresttl.db.Conexion;
import com.mycompany.apiresttl.models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsuarioDAO {

    private Connection conexion;

    public UsuarioDAO() {
        this.conexion = Conexion.getInstancia().conectar();
    }
    
    public Usuario login(Usuario usuario) {
        try {
            String sql = "SELECT * FROM usuarios WHERE usuario = ? AND password = ?";
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, usuario.getUsuario());
            pst.setString(2, usuario.getPassword());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                
                usuario.setId(rs.getInt("id"));

                return usuario;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return usuario;
    }     
}
