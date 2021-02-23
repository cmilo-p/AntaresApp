package com.anteres.ejb;

import com.antares.model.Pais;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PaisFacade extends AbstractFacade<Pais> implements PaisFacadeLocal {

    @PersistenceContext(unitName = "antaresPoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PaisFacade() {
        super(Pais.class);
    }
    
}
