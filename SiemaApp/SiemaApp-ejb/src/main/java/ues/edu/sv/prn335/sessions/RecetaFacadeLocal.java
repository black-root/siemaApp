/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.prn335.sessions;

import java.util.List;
import javax.ejb.Local;
import ues.edu.sv.prn335.entities.Receta;

/**
 *
 * @author debianyisus
 */
@Local
public interface RecetaFacadeLocal {

    void create(Receta receta);

    void edit(Receta receta);

    void remove(Receta receta);

    Receta find(Object id);

    List<Receta> findAll();

    List<Receta> findRange(int[] range);

    int count();
    
}
