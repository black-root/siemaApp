/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.api2018.sessions;

import java.util.List;
import javax.ejb.Local;
import ues.edu.api2018.entities.ContactoProfesionalSalud;

/**
 *
 * @author debianyisus
 */
@Local
public interface ContactoProfesionalSaludFacadeLocal {

    void create(ContactoProfesionalSalud contactoProfesionalSalud);

    void edit(ContactoProfesionalSalud contactoProfesionalSalud);

    void remove(ContactoProfesionalSalud contactoProfesionalSalud);

    ContactoProfesionalSalud find(Object id);

    List<ContactoProfesionalSalud> findAll();

    List<ContactoProfesionalSalud> findRange(int[] range);

    int count();
    
}
