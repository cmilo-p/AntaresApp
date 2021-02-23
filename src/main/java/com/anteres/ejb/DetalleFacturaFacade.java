package com.anteres.ejb;

import com.antares.model.DetalleFactura;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DetalleFacturaFacade extends AbstractFacade<DetalleFactura> implements DetalleFacturaFacadeLocal {

    @PersistenceContext(unitName = "antaresPoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleFacturaFacade() {
        super(DetalleFactura.class);
    }
    
}
