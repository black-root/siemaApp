/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.prn335.sessions;

import java.util.List;
import javax.ejb.Local;
import ues.edu.sv.prn335.entities.ExpedienteClinico;

/**
 *
 * @author debianyisus
 */
@Local
public interface ExpedienteClinicoFacadeLocal {

    void create(ExpedienteClinico expedienteClinico);

    void edit(ExpedienteClinico expedienteClinico);

    void remove(ExpedienteClinico expedienteClinico);

    ExpedienteClinico find(Object id);

    List<ExpedienteClinico> findAll();

    List<ExpedienteClinico> findRange(int[] range);

    int count();
    
}
