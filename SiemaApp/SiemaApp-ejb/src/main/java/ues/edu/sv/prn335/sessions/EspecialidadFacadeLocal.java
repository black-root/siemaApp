/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.prn335.sessions;

import java.util.List;
import javax.ejb.Local;
import ues.edu.sv.prn335.entities.Especialidad;

/**
 *
 * @author debianyisus
 */
@Local
public interface EspecialidadFacadeLocal {

    void create(Especialidad especialidad);

    void edit(Especialidad especialidad);

    void remove(Especialidad especialidad);

    Especialidad find(Object id);

    List<Especialidad> findAll();

    List<Especialidad> findRange(int[] range);

    int count();
    
}
