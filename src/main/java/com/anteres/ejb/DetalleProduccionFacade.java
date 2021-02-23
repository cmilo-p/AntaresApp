package com.anteres.ejb;

import com.antares.model.DetalleProduccion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DetalleProduccionFacade extends AbstractFacade<DetalleProduccion> implements DetalleProduccionFacadeLocal {

    @PersistenceContext(unitName = "antaresPoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleProduccionFacade() {
        super(DetalleProduccion.class);
    }
    
}
