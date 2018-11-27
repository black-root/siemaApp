/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.api2018.sessions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ues.edu.api2018.entities.ProfesionalSalud;

/**
 *
 * @author debianyisus
 */
@Stateless
public class ProfesionalSaludFacade extends AbstractFacade<ProfesionalSalud> implements ProfesionalSaludFacadeLocal {

    @PersistenceContext(unitName = "ues.edu.sv.prn335_SiemaApp-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProfesionalSaludFacade() {
        super(ProfesionalSalud.class);
    }
   
    /*
    public List<ProfesionalSalud> buscarPorUsuario(String usuario) {
        EntityManager em = null;
        em = getEntityManager();
        List<ProfesionalSalud> lista = new ArrayList<>();
        try {
            if (!usuario.isEmpty()) {
                Query query = em.createQuery("SELECT a FROM ProfesionalSalud AS a WHERE a.usuario = '"+usuario+"'");
                lista = query.getResultList();
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return lista;
    }
*/
}
