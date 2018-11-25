package ues.edu.sv.prn335.resource;

/**
 *
 * @author debianyisus
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ues.edu.sv.prn335.sessions.AbstractFacadeInterface;


public abstract class AbstractResource<T> implements Serializable {
        private static final long serialVersionUID = 1L;

    public abstract AbstractFacadeInterface<T> entity();

    protected abstract T nuevo();
    private final ArrayList<T> lista = new ArrayList<>();
    private static final String CORSORIGIN = "Access-Control-Allow-Origin";
    private static final String CORSCREDENTIAL = "Access-Control-Allow-Credentials";
    private static final String CORSHEADER = "Access-Control-Allow-Headers";
    private static final String CORSMETHOD = "Access-Control-Allow-Methods";
    private static final String METHODS = "GET, POST, PUT, DELETE, OPTIONS, HEAD";
    private static final String HEADERS = "origin, content-type, accept, authorization";
    private static final String CREDENTIAL = "true";
    private static final String ORIGIN = "*";

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<T> findAll() {

        if (entity() != null) {
            return entity().findAll();
        }
        return lista;
    }

    @GET
    @Path("{id:\\d+}")
    @Produces({MediaType.APPLICATION_JSON})
    public T findById(
            @PathParam("id") int id
    ) {
        if (entity() != null) {
            return entity().find(id);
        }
        return null;
    }

    @GET
    @Path("/findRange")
    @Produces({MediaType.APPLICATION_JSON})
    public List<T> findRange(
            @QueryParam("min") int min,
            @QueryParam("pagesize") int pagesize
    ) {
        if (entity() != null) {
            return entity().findRange(min - 1, pagesize);
        }
        return lista;
    }

    @GET
    @Path("/count")
    @Produces({MediaType.TEXT_PLAIN})
    public int count() {
        if (entity() != null) {
            return entity().count();
        }
        return 0;
    }

    @GET
    @Path("{nombre}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<T> findWithNombre(
            @PathParam("nombre") String nombre
    ) {
        if (entity() != null) {
            return entity().findWithNombre(nombre);

        }
        return lista;
    }

    @DELETE
    @Path("/{id:\\d+}")
    public Response remove(
            @PathParam("id") int id
    ) {
        if (entity() != null && entity().eliminar(entity().find(id))) {

            return Response.status(Response.Status.OK).header(CORSORIGIN, ORIGIN)
                    .header(CORSCREDENTIAL, CREDENTIAL)
                    .header(CORSHEADER, HEADERS)
                    .header(CORSMETHOD, METHODS)
                    .entity("").build();

        } else {
            return Response.status(Response.Status.NOT_FOUND).header(CORSORIGIN, ORIGIN)
                    .header(CORSCREDENTIAL, CREDENTIAL)
                    .header(CORSHEADER, HEADERS)
                    .header(CORSMETHOD, METHODS)
                    .entity("").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(T entity) {
        if (entity() != null && entity().crear(entity)) {
            return Response.status(Response.Status.CREATED).entity(entity).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).header(CORSORIGIN, ORIGIN)
                    .header(CORSCREDENTIAL, CREDENTIAL)
                    .header(CORSHEADER, HEADERS)
                    .header(CORSMETHOD, METHODS)
                    .entity("").build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response edit(T entity) {
        if (entity() != null && entity().modificar(entity)) {
            return Response.status(Response.Status.OK).header(CORSORIGIN, ORIGIN)
                    .header(CORSCREDENTIAL, CREDENTIAL)
                    .header(CORSHEADER, HEADERS)
                    .header(CORSMETHOD, METHODS)
                    .entity(entity).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).header("no se pudo editar", this).build();
        }
    }
}
