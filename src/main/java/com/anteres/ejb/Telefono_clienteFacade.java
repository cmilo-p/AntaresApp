package com.anteres.ejb;

import com.antares.model.Telefono_cliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class Telefono_clienteFacade extends AbstractFacade<Telefono_cliente> implements Telefono_clienteFacadeLocal {

    @PersistenceContext(unitName = "antaresPoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Telefono_clienteFacade() {
        super(Telefono_cliente.class);
    }
    
}
