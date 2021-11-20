package com.mycompany.monoliticareto3.models.dao;

import com.mycompany.monoliticareto3.db.Conexion;
import com.mycompany.monoliticareto3.models.entidades.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO {
    
    private Conexion conexion;
    
    public UsuarioDAO(Conexion conexion) {
        this.conexion = conexion;
    }
    //Login
    public Usuario login(String usuario, String password){
        Usuario u = new Usuario();

        try{
            String sql = "SELECT * FROM usuarios WHERE usuario = ? AND password = ?";
            PreparedStatement pst = this.conexion.getConexion().prepareStatement(sql);
            pst.setString(1, usuario);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                u.setId(rs.getInt("id"));
                u.setUsuario(rs.getString("usuario"));
                u.setPassword(rs.getString("password"));  
            }
    
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return u;
    }
    
    
    
    
    //Metodos CRUD
    //Agregar
    public Usuario add(Usuario usuario){
    
        try{
            String sql = "INSERT INTO usuarios VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = this.conexion.getConexion().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setInt(1, 0);
            pst.setString(2, usuario.getNombre());
            pst.setString(3, usuario.getApellido());
            pst.setString(4, usuario.getFecha_nacimiento());
            pst.setInt(5, usuario.getEdad());
            pst.setString(6, usuario.getSigno_zodiaco());
            pst.setString(7, usuario.getIdioma_nativo());
            pst.setString(8, usuario.getIdioma_aprender());
            pst.setString(9, usuario.getUsuario());
            pst.setString(10, usuario.getPassword());
            pst.setInt(11, usuario.getTipo_de_cliente());
            pst.setInt(12, usuario.getTipo_usuario());
            int filas = pst.executeUpdate();
            if(filas>0){
                ResultSet rs = pst.getGeneratedKeys();
                while(rs.next()){
                    usuario.setId(rs.getInt(1));
                }
            }
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return usuario;        
    }
    //Buscar todos los productos
    public ArrayList<Usuario> list(){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        
        try{
            String sql = "SELECT * FROM usuarios";
            PreparedStatement pst = this.conexion.getConexion().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNombre(rs.getString("nombre"));
                u.setApellido(rs.getString("apellido"));
                u.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
                u.setEdad(rs.getInt("edad"));
                u.setSigno_zodiaco(rs.getString("signo_zodiaco"));
                u.setIdioma_nativo(rs.getString("idioma_nativo"));
                u.setIdioma_aprender(rs.getString("idioma_aprender"));
                u.setUsuario(rs.getString("usuario"));
                u.setPassword(rs.getString("password"));
                u.setTipo_de_cliente(rs.getInt("tipo_de_cliente"));
                u.setTipo_usuario(rs.getInt("tipo_usuario"));
                usuarios.add(u);    
            }
    
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return usuarios;
    }
    //Eliminar los productos
    public boolean delete(int id){
        boolean resultado = false;
        try{
            String sql = "DELETE FROM usuarios WHERE id = ?";
            PreparedStatement pst = this.conexion.getConexion().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setInt(1, id);
            int filas = pst.executeUpdate();
            if(filas>0){
                resultado = true;
            }
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return resultado;        
    }
 
}
