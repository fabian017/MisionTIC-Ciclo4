package com.mycompany.apiresttl.dao;

import com.mycompany.apiresttl.db.Conexion;
import com.mycompany.apiresttl.models.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    private Connection conexion;

    public ProductoDAO() {
        this.conexion = Conexion.getInstancia().conectar();
    }

    //metodos CRUD
    public List<Producto> getProductos() {
        List<Producto> productos = new ArrayList<>();

        try {
            String sql = "SELECT * FROM productos";
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getFloat("precio"));
                p.setCantidad(rs.getInt("cantidad"));

                productos.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return productos;
    }
    
    public Producto getProducto(int id) {
        Producto producto = new Producto();

        try {
            String sql = "SELECT * FROM productos WHERE id = ?";
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getFloat("precio"));
                p.setCantidad(rs.getInt("cantidad"));

                return p;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return producto;
    }

    public Producto addProducto(Producto producto) {
        try {
            String sql = "INSERT INTO productos VALUES(?, ?, ?, ?)";
            PreparedStatement pst = this.conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setInt(1, 0);
            pst.setString(2, producto.getNombre());
            pst.setFloat(3, producto.getPrecio());
            pst.setInt(4, producto.getCantidad());
            int filas = pst.executeUpdate();
            if (filas > 0) {
                ResultSet rs = pst.getGeneratedKeys();
                while(rs.next()){
                    producto.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return producto;
    }
    
    public boolean editProducto(Producto producto) {
        boolean resultado =false;
        try {
            String sql = "UPDATE productos SET nombre = ?, precio = ?, cantidad = ? WHERE id = ?";
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, producto.getNombre());
            pst.setFloat(2, producto.getPrecio());
            pst.setInt(3, producto.getCantidad());
            pst.setInt(4, producto.getId());
            int filas = pst.executeUpdate();
            if (filas > 0) {
                resultado = true;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return resultado;
    }
    
    public boolean deleteProducto(int id) {
        boolean resultado =false;
        try {
            String sql = "DELETE FROM productos WHERE id = ?";
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, id);
            int filas = pst.executeUpdate();
            if (filas > 0) {
                resultado = true;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return resultado;
    }
    
    
}
