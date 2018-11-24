/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.prn335.sessions;

import java.util.List;
import javax.ejb.Local;
import ues.edu.sv.prn335.entities.EspecialidadPorProfesional;

/**
 *
 * @author debianyisus
 */
@Local
public interface EspecialidadPorProfesionalFacadeLocal {

    void create(EspecialidadPorProfesional especialidadPorProfesional);

    void edit(EspecialidadPorProfesional especialidadPorProfesional);

    void remove(EspecialidadPorProfesional especialidadPorProfesional);

    EspecialidadPorProfesional find(Object id);

    List<EspecialidadPorProfesional> findAll();

    List<EspecialidadPorProfesional> findRange(int[] range);

    int count();
    
}
