/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.api2018.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ues.edu.api2018.entities.MedicamentosPorReceta;

/**
 *
 * @author debianyisus
 */
@Stateless
public class MedicamentosPorRecetaFacade extends AbstractFacade<MedicamentosPorReceta> implements MedicamentosPorRecetaFacadeLocal {

    @PersistenceContext(unitName = "ues.edu.sv.prn335_SiemaApp-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MedicamentosPorRecetaFacade() {
        super(MedicamentosPorReceta.class);
    }
    
}
