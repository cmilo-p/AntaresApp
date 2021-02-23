package com.anteres.ejb;

import com.antares.model.PQRS;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PQRSFacade extends AbstractFacade<PQRS> implements PQRSFacadeLocal {

    @PersistenceContext(unitName = "antaresPoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PQRSFacade() {
        super(PQRS.class);
    }
    
}
