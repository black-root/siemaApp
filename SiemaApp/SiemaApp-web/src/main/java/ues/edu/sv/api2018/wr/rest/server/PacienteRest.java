package ues.edu.sv.api2018.wr.rest.server;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import ues.edu.api2018.entities.Paciente;
import ues.edu.api2018.sessions.PacienteFacadeLocal;

/**
 *
 * @author daniel
 */
@Path("pacientes")
public class PacienteRest implements Serializable{
    
    
    @EJB
    private PacienteFacadeLocal pacienteFacade;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<Paciente> findAll(){
       List salida = null;
       try{
           if(pacienteFacade != null){
               salida = pacienteFacade.findAll();
           }
       }catch(Exception ex){
           Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
       } finally{
           if(salida == null){
               salida = new ArrayList();
           }
       }
       for(int i=0; i< salida.size();i++){
           System.out.println("SALIDA" +salida.get(i));
       }
       return salida;
    }
    
    
    
}
