/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.api2018.wr.rest.server;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ues.edu.api2018.entities.ProfesionalSalud;
import ues.edu.api2018.sessions.ProfesionalSaludFacadeLocal;

/**
 *
 * @author debianyisus
 */
@Path("profesionalsalud")
public class ProfesionalSaludRest implements Serializable {

    @EJB
    private ProfesionalSaludFacadeLocal profesionalSaludFacade;

    @GET
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<ProfesionalSalud> findAll() {
        List salida = null;
        try {
            if (profesionalSaludFacade != null) {
                salida = profesionalSaludFacade.findAll();
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {
            if (salida == null) {
                salida = new ArrayList();
            }
        }
        return salida;
    }
    
    @GET
    @Path("count")
    @Produces({MediaType.APPLICATION_JSON})
    public Response count() {
        if (profesionalSaludFacade != null) {
            try {
                int totalRegistros = profesionalSaludFacade.count();
                if (totalRegistros != 0) {
                    return Response.status(Response.Status.OK)
                            .entity(totalRegistros).build();
                }
            } catch (Exception e) {
            }

        }
        return Response.status(Response.Status.NOT_FOUND)
                .header("No se encontraron Registros", profesionalSaludFacade)
                .build();
    }

    /*
   @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response findId(@PathParam("id") Integer identificador) {    

         ProfesionalSalud buscado = profesionalSaludFacade.find(identificador);

        try {
            if (identificador >= 0 && buscado != null) {
                return Response.status(Response.Status.OK).entity(buscado).build();
            }
        } catch (Exception e) {
        }

        return Response.status(Response.Status.BAD_REQUEST).header("no se encontro registro:", identificador).build();
    }*/
}
