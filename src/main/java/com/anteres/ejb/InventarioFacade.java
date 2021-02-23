package com.anteres.ejb;

import com.antares.model.Inventario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class InventarioFacade extends AbstractFacade<Inventario> implements InventarioFacadeLocal {

    @PersistenceContext(unitName = "antaresPoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InventarioFacade() {
        super(Inventario.class);
    }
    
}
