/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.api2018.sessions;

import java.util.List;
import javax.ejb.Local;
import ues.edu.api2018.entities.Profesion;

/**
 *
 * @author debianyisus
 */
@Local
public interface ProfesionFacadeLocal {

    void create(Profesion profesion);

    void edit(Profesion profesion);

    void remove(Profesion profesion);

    Profesion find(Object id);

    List<Profesion> findAll();

    List<Profesion> findRange(int[] range);

    int count();
    
}
