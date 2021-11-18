package com.mycompany.apiresttl.dao;
import com.mycompany.apiresttl.db.Conexion;
import com.mycompany.apiresttl.models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


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
    //metodos CRUD
    //GETTODOS
    public List<Usuario> getUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();

        try {
            String sql = "SELECT * FROM usuarios";
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
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
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return usuarios;
    }
    //GET UNO
    public Usuario getUsuario(int id) {
        Usuario usuario = new Usuario();

        try {
            String sql = "SELECT * FROM usuarios WHERE id = ?";
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
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
                return u;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return usuario;
    }
    //POST AGREGAR
    public Usuario addUsuario(Usuario usuario) {
        try {
            String sql = "INSERT INTO usuarios VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = this.conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
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
            if (filas > 0) {
                ResultSet rs = pst.getGeneratedKeys();
                while(rs.next()){
                    usuario.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return usuario;
    }
    //Editar PUT
    public boolean editUsuario(Usuario usuario) {
        boolean resultado =false;
        try {
            String sql = "UPDATE usuarios SET nombre = ?, apellido = ?, fecha_nacimiento = ?, edad = ?, signo_zodiaco = ?, idioma_nativo = ?, idioma_aprender = ?, usuario = ?, password = ?, tipo_de_cliente = ?, tipo_usuario = ?  WHERE id = ?";
            PreparedStatement pst = this.conexion.prepareStatement(sql); 
            pst.setString(1, usuario.getNombre());
            pst.setString(2, usuario.getApellido());
            pst.setString(3, usuario.getFecha_nacimiento());
            pst.setInt(4, usuario.getEdad());
            pst.setString(5, usuario.getSigno_zodiaco());
            pst.setString(6, usuario.getIdioma_nativo());
            pst.setString(7, usuario.getIdioma_aprender());
            pst.setString(8, usuario.getUsuario());
            pst.setString(9, usuario.getPassword());
            pst.setInt(10, usuario.getTipo_de_cliente());
            pst.setInt(11, usuario.getTipo_usuario());
            pst.setInt(12, usuario.getId());
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
    public boolean deleteUsuario(int id) {
        boolean resultado =false;
        try {
            String sql = "DELETE FROM usuarios WHERE id = ?";
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
