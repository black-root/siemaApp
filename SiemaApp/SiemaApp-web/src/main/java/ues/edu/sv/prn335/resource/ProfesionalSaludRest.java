package ues.edu.sv.prn335.resource;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;
import ues.edu.sv.prn335.sessions.AbstractFacadeInterface;
import ues.edu.sv.prn335.sessions.ProfesionalSaludFacadeLocal;
import ues.edu.sv.prn335.entities.ProfesionalSalud;

/**
 *
 * @author debianyisus
 */
@Stateless
@Path("/profesionalsalud")
public class ProfesionalSaludRest extends AbstractResource<ProfesionalSalud> {

    @EJB
    private ProfesionalSaludFacadeLocal ejb;

    @Override
    public AbstractFacadeInterface<ProfesionalSalud> entity() {
        return ejb;
    }

    @Override
    protected ProfesionalSalud nuevo() {
        return new ProfesionalSalud();
    }

}
