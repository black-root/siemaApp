/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.prn335.sessions;

import java.util.List;
import javax.ejb.Local;
import ues.edu.sv.prn335.entities.ProfesionalSalud;

/**
 *
 * @author debianyisus
 */
@Local
public interface ProfesionalSaludFacadeLocal {

    void create(ProfesionalSalud profesionalSalud);

    void edit(ProfesionalSalud profesionalSalud);

    void remove(ProfesionalSalud profesionalSalud);

    ProfesionalSalud find(Object id);

    List<ProfesionalSalud> findAll();

    List<ProfesionalSalud> findRange(int[] range);

    int count();
    
}
