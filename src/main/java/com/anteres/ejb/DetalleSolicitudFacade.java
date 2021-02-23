package com.anteres.ejb;

import com.antares.model.DetalleSolicitud;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DetalleSolicitudFacade extends AbstractFacade<DetalleSolicitud> implements DetalleSolicitudFacadeLocal {

    @PersistenceContext(unitName = "antaresPoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleSolicitudFacade() {
        super(DetalleSolicitud.class);
    }
    
}
