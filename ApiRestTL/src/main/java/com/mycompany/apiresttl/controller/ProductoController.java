package com.mycompany.apiresttl.controller;

import com.mycompany.apiresttl.dao.ProductoDAO;
import com.mycompany.apiresttl.models.Producto;
import com.mycompany.apiresttl.utilidades.Mensaje;
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

@Path("/productos")
public class ProductoController {
    private ProductoDAO productoDAO = new ProductoDAO();
    
    //get es para obtener datos
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Producto> getProductos(){
        List<Producto> productos = this.productoDAO.getProductos();
        return productos;
    }
    //post para insertar datos
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Producto addProducto(Producto producto){
        return this.productoDAO.addProducto(producto);
    }
    //solicitar datos de un solo registro GET
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Producto getProducto(@PathParam("id") int id){
        return this.productoDAO.getProducto(id);
    }
       
    //actualizar un registro PUT/PATCH
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje editProducto(Producto producto){
        Mensaje mensaje = new Mensaje("ERROR");
        
        boolean resultado = this.productoDAO.editProducto(producto);
        
        if(resultado){
            mensaje.setTexto("OK");
        }
       
        return mensaje;
    }
    //eliminar un recurso DELETE
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Mensaje deleteProducto(@PathParam("id") int id){
        Mensaje mensaje = new Mensaje("ERROR");
        
        boolean resultado = this.productoDAO.deleteProducto(id);
        
        if(resultado){
            mensaje.setTexto("OK");
        }
       
        return mensaje;
    }
    
}
