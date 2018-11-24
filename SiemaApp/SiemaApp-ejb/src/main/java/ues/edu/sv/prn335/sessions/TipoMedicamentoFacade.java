package ues.edu.sv.prn335.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ues.edu.sv.prn335.entities.TipoMedicamento;

/**
 *
 * @author debianyisus
 */
@Stateless
public class TipoMedicamentoFacade extends AbstractFacade<TipoMedicamento> implements TipoMedicamentoFacadeLocal {

    @PersistenceContext(unitName = "ues.edu.sv.prn335_SiemaApp-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoMedicamentoFacade() {
        super(TipoMedicamento.class);
    }
    
}
