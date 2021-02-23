package com.anteres.ejb;

import com.antares.model.Productor;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProductorFacade extends AbstractFacade<Productor> implements ProductorFacadeLocal {

    @PersistenceContext(unitName = "antaresPoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductorFacade() {
        super(Productor.class);
    }
    
}
