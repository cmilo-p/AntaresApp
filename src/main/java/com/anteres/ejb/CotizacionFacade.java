package com.anteres.ejb;

import com.antares.model.Cotizacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CotizacionFacade extends AbstractFacade<Cotizacion> implements CotizacionFacadeLocal {

    @PersistenceContext(unitName = "antaresPoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CotizacionFacade() {
        super(Cotizacion.class);
    }
    
}
