/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.api2018.sessions;

import java.util.List;
import javax.ejb.Local;
import ues.edu.api2018.entities.TipoEstadoReceta;

/**
 *
 * @author debianyisus
 */
@Local
public interface TipoEstadoRecetaFacadeLocal {

    void create(TipoEstadoReceta tipoEstadoReceta);

    void edit(TipoEstadoReceta tipoEstadoReceta);

    void remove(TipoEstadoReceta tipoEstadoReceta);

    TipoEstadoReceta find(Object id);

    List<TipoEstadoReceta> findAll();

    List<TipoEstadoReceta> findRange(int[] range);

    int count();
    
}
