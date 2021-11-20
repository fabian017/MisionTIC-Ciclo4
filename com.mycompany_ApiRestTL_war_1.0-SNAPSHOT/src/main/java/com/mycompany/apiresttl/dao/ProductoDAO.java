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
    //GETTODOS
    public List<Producto> getProductos() {
        List<Producto> productos = new ArrayList<>();

        try {
            String sql = "SELECT * FROM servicios";
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getInt("id"));
                p.setTipo_string(rs.getString("tipo_string"));
                p.setPrecio(rs.getFloat("precio"));
                productos.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return productos;
    }
    //GET UNO
    public Producto getProducto(int id) {
        Producto producto = new Producto();

        try {
            String sql = "SELECT * FROM servicios WHERE id = ?";
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getInt("id"));
                p.setTipo_string(rs.getString("tipo_string"));
                p.setPrecio(rs.getFloat("precio"));
                return p;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return producto;
    }
    //POST AGREGAR
    public Producto addProducto(Producto producto) {
        try {
            String sql = "INSERT INTO servicios VALUES(?, ?, ?)";
            PreparedStatement pst = this.conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setInt(1, 0);
            pst.setString(2, producto.getTipo_string());
            pst.setFloat(4, producto.getPrecio());
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
    //Editar PUT
    public boolean editProducto(Producto producto) {
        boolean resultado =false;
        try {
            String sql = "UPDATE servicios SET tipo_string = ?, tipo_int = ?, precio = ? WHERE id = ?";
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, producto.getTipo_string());
            pst.setFloat(2, producto.getPrecio());
            pst.setInt(3, producto.getId());
            int filas = pst.executeUpdate();
            if (filas > 0) {
                resultado = true;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return resultado;
    }
    //Eliminar DELETE
    public boolean deleteProducto(int id) {
        boolean resultado =false;
        try {
            String sql = "DELETE FROM servicios WHERE id = ?";
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
