package com.mycompany.monoliticareto3.models.dao;

import com.mycompany.monoliticareto3.db.Conexion;
import com.mycompany.monoliticareto3.models.entidades.Servicio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServicioDAO {

    private Conexion conexion;
    
    public ServicioDAO(Conexion conexion) {
        this.conexion = conexion;
    }
    
    //Metodos CRUD
    //Agregar
    public Servicio add(Servicio servicio){
    
        try{
            String sql = "INSERT INTO servicios VALUES (?,?,?)";
            PreparedStatement pst = this.conexion.getConexion().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setInt(1, 0);
            pst.setString(2, servicio.getTipo_string());
            pst.setFloat(3, servicio.getPrecio());
            int filas = pst.executeUpdate();
            if(filas>0){
                ResultSet rs = pst.getGeneratedKeys();
                while(rs.next()){
                    servicio.setId(rs.getInt(1));
                }
            }
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return servicio;        
    }
    //Buscar todos los productos
    public ArrayList<Servicio> list(){
        ArrayList<Servicio> servicios = new ArrayList<>();
        
        try{
            String sql = "SELECT * FROM servicios";
            PreparedStatement pst = this.conexion.getConexion().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Servicio s = new Servicio();
                s.setId(rs.getInt("id"));
                s.setTipo_string(rs.getString("tipo_string"));
                s.setPrecio(rs.getFloat("precio"));              
                servicios.add(s);
                
            }
           
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return servicios;
    }
    //Buscar un solo servicio
    public Servicio obtenerServicio(int id) {
        Servicio servicio = new Servicio();

        try {
            String sql = "SELECT * FROM servicios WHERE id = ?";
            PreparedStatement pst = this.conexion.getConexion().prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                servicio.setId(rs.getInt("id"));
                servicio.setTipo_string(rs.getString("tipo_string"));
                servicio.setPrecio(rs.getFloat("precio"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return servicio;
    }
    //Eliminar los productos
    public boolean delete(int id){
        boolean resultado = false;
        try{
            String sql = "DELETE FROM servicios WHERE id = ?";
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
    
    //Editar Priductos
    public boolean edit(Servicio servicio) {
        boolean resultado =false;
        try {
            String sql = "UPDATE servicios SET tipo_string = ?, precio = ? WHERE id = ?";
            PreparedStatement pst = this.conexion.getConexion().prepareStatement(sql);
            pst.setString(1, servicio.getTipo_string());
            pst.setFloat(2, servicio.getPrecio());
            pst.setInt(3, servicio.getId());
            int filas = pst.executeUpdate();
            if (filas > 0) {
                resultado = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

}
