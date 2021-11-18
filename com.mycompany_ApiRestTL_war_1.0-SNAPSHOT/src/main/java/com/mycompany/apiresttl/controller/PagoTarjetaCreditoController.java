package com.mycompany.apiresttl.controller;

import javax.ws.rs.Path;
import com.mycompany.apiresttl.dao.PagoTarjetaCreditoDAO;
import com.mycompany.apiresttl.models.PagoTarjetaCredito;
import com.mycompany.apiresttl.utilidades.Mensaje;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/pagos_tc")
public class PagoTarjetaCreditoController {
    private PagoTarjetaCreditoDAO pagoTarjetaCreditoDAO = new PagoTarjetaCreditoDAO();
    
    //get es para obtener datos
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PagoTarjetaCredito> getPagosTarjetaCredito(){
        List<PagoTarjetaCredito> pagosTarjetaCredito = this.pagoTarjetaCreditoDAO.getPagosTarjetaCredito();
        return pagosTarjetaCredito;
    }
    //post para insertar datos
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public PagoTarjetaCredito addPagoTarjetaCredito(PagoTarjetaCredito pagoTarjetaCredito){
        return this.pagoTarjetaCreditoDAO.addPagoTarjetaCredito(pagoTarjetaCredito);
    }
    //solicitar datos de un solo registro GET
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PagoTarjetaCredito getPagoTarjetaCredito(@PathParam("id")int id){
        return this.pagoTarjetaCreditoDAO.getPagoTarjetaCredito(id);
    }
    //actualizar un registro PUT/PATCH
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje editPagoTarjetaCredito(PagoTarjetaCredito pagoTarjetaCredito){
        Mensaje mensaje = new Mensaje ("ERROR");
        
        boolean resultado = this.pagoTarjetaCreditoDAO.editPagoTarjetaCredito(pagoTarjetaCredito);
        
        if (resultado){
            mensaje.setTexto("OK");
        }
        return mensaje;
    }
    //eliminar un recurso DELETE
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Mensaje deletePagoTarjetaCredito(@PathParam("id") int id){
        Mensaje mensaje = new Mensaje ("ERROR");
        
        boolean resultado = this.pagoTarjetaCreditoDAO.deletePagoTarjetaCredito(id);
        
        if (resultado){
            mensaje.setTexto("OK");
        }
        return mensaje;
    }
   
}
