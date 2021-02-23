package com.anteres.ejb;

import com.antares.model.Vendedor;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class VendedorFacade extends AbstractFacade<Vendedor> implements VendedorFacadeLocal {

    @PersistenceContext(unitName = "antaresPoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VendedorFacade() {
        super(Vendedor.class);
    }
    
}
