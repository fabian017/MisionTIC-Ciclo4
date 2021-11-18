package com.mycompany.apiresttl.dao;

import com.mycompany.apiresttl.db.Conexion;
import com.mycompany.apiresttl.models.PagoTarjetaCredito;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PagoTarjetaCreditoDAO {
    private Connection conexion;
    
    public PagoTarjetaCreditoDAO(){
        this.conexion = Conexion.getInstancia().conectar();
    }
    
    //metodos CRUD
    //GETTODOS
    public List<PagoTarjetaCredito> getPagosTarjetaCredito(){
        List<PagoTarjetaCredito> pagosTarjetaCredito = new ArrayList<>();
        
        try{
            String sql = "SELECT * FROM pagos_tc";
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                PagoTarjetaCredito ptc = new PagoTarjetaCredito();
                ptc.setId(rs.getInt("id"));
                ptc.setNombre(rs.getString("nombre"));
                ptc.setNumero(rs.getString("numero"));
                ptc.setFecha_venci(rs.getString("fecha_venci"));
                ptc.setCodigo(rs.getString("codigo"));
                pagosTarjetaCredito.add(ptc);
            }
        }catch(SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
        return pagosTarjetaCredito;
    }
    
    //GET UNO
    public PagoTarjetaCredito getPagoTarjetaCredito(int id){
        PagoTarjetaCredito pagoTarjetaCredito = new PagoTarjetaCredito();
        
        try{
            String sql = "SELECT * FROM pagos_tc WHERE id = ?";
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                PagoTarjetaCredito ptc = new PagoTarjetaCredito();
                ptc.setId(rs.getInt("id"));
                ptc.setNombre(rs.getString("nombre"));
                ptc.setNumero(rs.getString("numero"));
                ptc.setFecha_venci(rs.getString("fecha_venci"));
                ptc.setCodigo(rs.getString("codigo"));
                return ptc;
            }
        }catch(SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
        return pagoTarjetaCredito;
    }
    //POST AGREGAR
    public PagoTarjetaCredito addPagoTarjetaCredito (PagoTarjetaCredito pagoTarjetaCredito){
        try{
            String sql = "INSERT INTO pagos_tc VALUES(?, ?, ?, ?, ?)";
            PreparedStatement pst = this.conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setInt(1, 0);
            pst.setString(2, pagoTarjetaCredito.getNombre());
            pst.setString(3, pagoTarjetaCredito.getNumero());
            pst.setString(4, pagoTarjetaCredito.getFecha_venci());
            pst.setString(5, pagoTarjetaCredito.getCodigo());
            int filas = pst.executeUpdate();
            if(filas > 0){
                ResultSet rs = pst.getGeneratedKeys();
                while(rs.next()){
                    pagoTarjetaCredito.setId(rs.getInt(1));
                }
            }
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        
        return pagoTarjetaCredito;
    }
    //Editar PUT
    public boolean editPagoTarjetaCredito (PagoTarjetaCredito pagoTarjetaCredito){
        boolean resultado = false;
        try{
            String sql = "UPDATE pagos_tc SET nombre = ?, numero = ?, fecha_venci = ?, codigo = ? WHERE id = ?";
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, pagoTarjetaCredito.getNombre());
            pst.setString(2, pagoTarjetaCredito.getNumero());
            pst.setString(3, pagoTarjetaCredito.getFecha_venci());
            pst.setString(4, pagoTarjetaCredito.getCodigo());
            pst.setInt(5, pagoTarjetaCredito.getId());
            int filas = pst.executeUpdate();
            if(filas > 0){
                resultado = true;
            }
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        
        return resultado;
    }
     //Eliminar DELETE
    public boolean deletePagoTarjetaCredito (int id){
        boolean resultado = false;
        try{
            String sql = "DELETE FROM pagos_tc WHERE id = ?";
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, id);
            int filas = pst.executeUpdate();
            if(filas > 0){
                resultado = true;
            }
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        
        return resultado;
    }
}
