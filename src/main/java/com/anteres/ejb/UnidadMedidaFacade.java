package com.anteres.ejb;

import com.antares.model.UnidadMedida;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UnidadMedidaFacade extends AbstractFacade<UnidadMedida> implements UnidadMedidaFacadeLocal {

    @PersistenceContext(unitName = "antaresPoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UnidadMedidaFacade() {
        super(UnidadMedida.class);
    }
    
}
