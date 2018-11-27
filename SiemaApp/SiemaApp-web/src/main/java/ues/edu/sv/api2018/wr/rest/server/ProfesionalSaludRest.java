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
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("find/{id}")
    public ProfesionalSalud findById(
            @PathParam("id") int id) {
        try {
            if (profesionalSaludFacade != null) {
                return profesionalSaludFacade.find(id);
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return new ProfesionalSalud();
    }

    /**
     * Crear registros
     *
     * @param registro a crear
     * @return la entidad creada
     */
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public ProfesionalSalud crear(ProfesionalSalud registro) {

        if (registro != null && registro.getIdProfesionalSalud() == null) {
            try {
                if (profesionalSaludFacade != null) {
                    ProfesionalSalud nuevo = profesionalSaludFacade.create(registro);
                    if (nuevo != null) {
                        return nuevo;
                    } else {
                        System.err.println("facade nulo");
                    }
                }
            } catch (Exception e) {
                System.out.println("ex: " + e);
            }
        }
        return new ProfesionalSalud();

    }

    /**
     * Editar registros
     *
     * @param registro, parametroa modificar
     * @return registro modificado
     */
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    public ProfesionalSalud editar(ProfesionalSalud registro) {
        if (registro != null) {
            try {
                if (profesionalSaludFacade != null && profesionalSaludFacade.find(registro.getIdProfesionalSalud()) != null) {
                    ProfesionalSalud nuevo = profesionalSaludFacade.edit(registro);
                    if (nuevo != null) {
                        return nuevo;
                    }
                } else {
                    System.out.println("no existe ese registro");
                }
            } catch (Exception e) {
                System.out.println("ex: " + e);
            }
        }
        return new ProfesionalSalud();
    }

    /**
     * Eliminar registros
     *
     * @param id identificadir del registro a eliminar
     * @return entidad eliminada
     */
    @DELETE
    @Path("{IdProfesionalSalud}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ProfesionalSalud eliminar(@PathParam("IdProfesionalSalud") int id) {
        if (id > 0) {
            try {
                if (profesionalSaludFacade != null) {
                    ProfesionalSalud die = profesionalSaludFacade.remove(profesionalSaludFacade.find(id));
                    if (die != null) {
                        return die;
                    }
                }
            } catch (Exception e) {
                System.out.println("ex: " + e);
            }
        }
        return new ProfesionalSalud();
    }

}
