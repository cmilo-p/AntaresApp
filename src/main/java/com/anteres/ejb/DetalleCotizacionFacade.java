package com.anteres.ejb;

import com.antares.model.DetalleCotizacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DetalleCotizacionFacade extends AbstractFacade<DetalleCotizacion> implements DetalleCotizacionFacadeLocal {

    @PersistenceContext(unitName = "antaresPoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleCotizacionFacade() {
        super(DetalleCotizacion.class);
    }
    
}
