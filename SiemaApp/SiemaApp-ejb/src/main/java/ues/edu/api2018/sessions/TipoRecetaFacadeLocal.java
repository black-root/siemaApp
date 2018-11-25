/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.api2018.sessions;

import java.util.List;
import javax.ejb.Local;
import ues.edu.api2018.entities.TipoReceta;

/**
 *
 * @author debianyisus
 */
@Local
public interface TipoRecetaFacadeLocal {

    void create(TipoReceta tipoReceta);

    void edit(TipoReceta tipoReceta);

    void remove(TipoReceta tipoReceta);

    TipoReceta find(Object id);

    List<TipoReceta> findAll();

    List<TipoReceta> findRange(int[] range);

    int count();
    
}
