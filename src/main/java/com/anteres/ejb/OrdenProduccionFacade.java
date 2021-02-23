package com.anteres.ejb;

import com.antares.model.OrdenProduccion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class OrdenProduccionFacade extends AbstractFacade<OrdenProduccion> implements OrdenProduccionFacadeLocal {

    @PersistenceContext(unitName = "antaresPoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdenProduccionFacade() {
        super(OrdenProduccion.class);
    }
    
}
