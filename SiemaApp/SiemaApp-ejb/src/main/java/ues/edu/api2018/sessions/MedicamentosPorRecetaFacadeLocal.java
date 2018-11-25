/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.api2018.sessions;

import java.util.List;
import javax.ejb.Local;
import ues.edu.api2018.entities.MedicamentosPorReceta;

/**
 *
 * @author debianyisus
 */
@Local
public interface MedicamentosPorRecetaFacadeLocal {

    void create(MedicamentosPorReceta medicamentosPorReceta);

    void edit(MedicamentosPorReceta medicamentosPorReceta);

    void remove(MedicamentosPorReceta medicamentosPorReceta);

    MedicamentosPorReceta find(Object id);

    List<MedicamentosPorReceta> findAll();

    List<MedicamentosPorReceta> findRange(int[] range);

    int count();
    
}
