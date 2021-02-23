package com.anteres.ejb;

import com.antares.model.DetallePedido;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DetallePedidoFacade extends AbstractFacade<DetallePedido> implements DetallePedidoFacadeLocal {

    @PersistenceContext(unitName = "antaresPoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetallePedidoFacade() {
        super(DetallePedido.class);
    }
    
}
