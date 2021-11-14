package com.mycompany.apiresttl.controller;

import com.mycompany.apiresttl.dao.UsuarioDAO;
import com.mycompany.apiresttl.models.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
                                .signWith(SignatureAlgorithm.HS256, "12345")
                                .setSubject(u.getUsuario())
                                .setIssuedAt(new Date(tiempo))
                                .setExpiration(new Date (tiempo + 120000))
                                .claim("id", u.getId())
                                .claim("usuario", u.getUsuario())
                                .compact();
            u.setHash(hash);
            
        }
        return u;
        
    }
}
