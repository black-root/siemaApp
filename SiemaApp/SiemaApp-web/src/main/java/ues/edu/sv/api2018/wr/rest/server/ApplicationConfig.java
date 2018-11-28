/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.api2018.wr.rest.server;

import javax.ws.rs.core.Application;
import java.util.Set;
/**
 *
 * @author debianyisus
 */
@javax.ws.rs.ApplicationPath("ws")
public class ApplicationConfig extends Application{
    
    @Override
    public Set<Class<?>> getClasses(){
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }
    
    private void addRestResourceClasses(Set<Class<?>> resources){
        resources.add(ues.edu.sv.api2018.wr.rest.server.ExpedienteClinicoRest.class);
        resources.add(ues.edu.sv.api2018.wr.rest.server.PacienteRest.class);
        resources.add(ues.edu.sv.api2018.wr.rest.server.ProfesionalSaludRest.class);
    }
}
