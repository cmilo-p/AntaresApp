package com.anteres.ejb;

import com.antares.model.Catalogo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CatalogoFacade extends AbstractFacade<Catalogo> implements CatalogoFacadeLocal {

    @PersistenceContext(unitName = "antaresPoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CatalogoFacade() {
        super(Catalogo.class);
    }
    
}
