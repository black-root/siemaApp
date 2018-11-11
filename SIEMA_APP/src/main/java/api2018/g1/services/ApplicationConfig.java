/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api2018.g1.services;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author sig
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(api2018.g1.services.CitaFacadeREST.class);
        resources.add(api2018.g1.services.ContactoProfesionalSaludFacadeREST.class);
        resources.add(api2018.g1.services.EspecialidadFacadeREST.class);
        resources.add(api2018.g1.services.EspecialidadPorProfesionalFacadeREST.class);
        resources.add(api2018.g1.services.ExpedienteClinicoFacadeREST.class);
        resources.add(api2018.g1.services.HistoriaClinicaFacadeREST.class);
        resources.add(api2018.g1.services.MedicamentoFacadeREST.class);
        resources.add(api2018.g1.services.MedicamentosPorRecetaFacadeREST.class);
        resources.add(api2018.g1.services.PacienteFacadeREST.class);
        resources.add(api2018.g1.services.ProfesionFacadeREST.class);
        resources.add(api2018.g1.services.ProfesionalSaludFacadeREST.class);
        resources.add(api2018.g1.services.RecetaFacadeREST.class);
        resources.add(api2018.g1.services.TipoEstadoRecetaFacadeREST.class);
        resources.add(api2018.g1.services.TipoMedicamentoFacadeREST.class);
        resources.add(api2018.g1.services.TipoRecetaFacadeREST.class);
        resources.add(api2018.g1.services.TratamientoMedicoFacadeREST.class);
    }
    
}
