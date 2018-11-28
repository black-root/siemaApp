package ues.edu.sv.api2018.wr.rest.server;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ues.edu.api2018.entities.ExpedienteClinico;
import ues.edu.api2018.sessions.ExpedienteClinicoFacadeLocal;

/**
 *
 * @author debianyisus
 */
@Path("expedienteclinico")
public class ExpedienteClinicoRest implements Serializable{
    
    @EJB
    private ExpedienteClinicoFacadeLocal  exClinicoEjb;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<ExpedienteClinico> findAll() {
        List salida = null;
        try {
            if (exClinicoEjb != null) {
                salida = exClinicoEjb.findAll();
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
        if (exClinicoEjb != null) {
            try {
                int totalRegistros = exClinicoEjb.count();
                if (totalRegistros != 0) {
                    return Response.status(Response.Status.OK)
                            .entity(totalRegistros).build();
                }
            } catch (Exception e) {
            }

        }
        return Response.status(Response.Status.NOT_FOUND)
                .header("No se encontraron Registros", exClinicoEjb)
                .build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("find/{id}")
    public ExpedienteClinico findById(
            @PathParam("id") int id) {
        try {
            if (exClinicoEjb != null) {
                return exClinicoEjb.find(id);
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return new ExpedienteClinico();
    }

    /**
     * Crear registros
     *
     * @param registro a crear
     * @return la entidad creada
     */
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public ExpedienteClinico crear(ExpedienteClinico registro) {

        if (registro != null && registro.getIdExpedienteClinico()== null) {
            try {
                if (exClinicoEjb != null) {
                    ExpedienteClinico nuevo = exClinicoEjb.create(registro);
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
        return new ExpedienteClinico();

    }

    /**
     * Editar registros
     *
     * @param registro, parametroa modificar
     * @return registro modificado
     */
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    public ExpedienteClinico editar(ExpedienteClinico registro) {
        if (registro != null) {
            try {
                if (exClinicoEjb != null && exClinicoEjb.find(registro.getIdExpedienteClinico()) != null) {
                    ExpedienteClinico nuevo = exClinicoEjb.edit(registro);
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
        return new ExpedienteClinico();
    }

    /**
     * Eliminar registros
     *
     * @param id identificadir del registro a eliminar
     * @return entidad eliminada
     */
    @DELETE
    @Path("{IdExpedienteClinico}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ExpedienteClinico eliminar(@PathParam("IdExpedienteClinico") int id) {
        if (id > 0) {
            try {
                if (exClinicoEjb != null) {
                    ExpedienteClinico die = exClinicoEjb.remove(exClinicoEjb.find(id));
                    if (die != null) {
                        return die;
                    }
                }
            } catch (Exception e) {
                System.out.println("ex: " + e);
            }
        }
        return new ExpedienteClinico();
    }

}
