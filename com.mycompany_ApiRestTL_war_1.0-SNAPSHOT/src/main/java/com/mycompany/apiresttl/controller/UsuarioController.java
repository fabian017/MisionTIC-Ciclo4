package com.mycompany.apiresttl.controller;
import com.mycompany.apiresttl.dao.UsuarioDAO;
import com.mycompany.apiresttl.models.Usuario;
import com.mycompany.apiresttl.utilidades.Mensaje;
import filtros.Autorizacion;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/usuarios")
public class UsuarioController {
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
       
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/login")
    public Usuario login(Usuario usuario){
        
        Usuario u = this.usuarioDAO.login(usuario);
        if(u.getId() != 0){
            //generacion de un token
            long tiempo = System.currentTimeMillis();
            String hash = Jwts.builder()
                                .signWith(SignatureAlgorithm.HS256, Autorizacion.LLAVE)
                                .setSubject(u.getUsuario())
                                .setIssuedAt(new Date(tiempo))
                                .setExpiration(new Date (tiempo + 300000))
                                .claim("id", u.getId())
                                .claim("usuario", u.getUsuario())
                                .compact();
            u.setHash(hash);   
        }
        return u;   
    }
    
    //get es para obtener datos
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> getUsuarios(){
        List<Usuario> usuarios = this.usuarioDAO.getUsuarios();
        return usuarios;
    }
    //post para insertar datos
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Usuario addUsuario(Usuario usuarios){
        return this.usuarioDAO.addUsuario(usuarios);
    }
    //solicitar datos de un solo registro GET
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario getUsuario(@PathParam("id") int id){
        return this.usuarioDAO.getUsuario(id);
    }
    //actualizar un registro PUT/PATCH
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje editUsuario(Usuario usuario){
        Mensaje mensaje = new Mensaje("ERROR");
        
        boolean resultado = this.usuarioDAO.editUsuario(usuario);
        
        if(resultado){
            mensaje.setTexto("OK");
        }
        return mensaje;
    }
    //eliminar un recurso DELETE
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Mensaje deleteUsuario(@PathParam("id") int id){
        Mensaje mensaje = new Mensaje("ERROR");
        
        boolean resultado = this.usuarioDAO.deleteUsuario(id);
        
        if(resultado){
            mensaje.setTexto("OK");
        }
       
        return mensaje;
    }
}
