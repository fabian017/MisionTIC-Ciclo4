package com.mycompany.apiresttl.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Conexion instancia;
    private static Connection conexion;
    
    private Conexion(){
    }
    
    public static Conexion getInstancia(){
        if(instancia==null){
            instancia = new Conexion();
        }
        return instancia;
    }
    
    public Connection conectar(){
        if(conexion==null){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexion = DriverManager.getConnection("jdbc:mysql://localhost:3310/tl", "root", "");
            }catch(ClassNotFoundException e){
                System.out.println("Error de Driver "+e.getMessage());
            }
            catch(SQLException e){
                System.out.println("Error Conexion SQL: "+e.getMessage());
            }
        }
        return conexion;
    }
}
