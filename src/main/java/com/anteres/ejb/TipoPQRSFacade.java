package com.anteres.ejb;

import com.antares.model.TipoPQRS;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TipoPQRSFacade extends AbstractFacade<TipoPQRS> implements TipoPQRSFacadeLocal {

    @PersistenceContext(unitName = "antaresPoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoPQRSFacade() {
        super(TipoPQRS.class);
    }
    
}
