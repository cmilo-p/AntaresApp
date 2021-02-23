package com.anteres.ejb;

import com.antares.model.Maquina;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MaquinaFacade extends AbstractFacade<Maquina> implements MaquinaFacadeLocal {

    @PersistenceContext(unitName = "antaresPoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MaquinaFacade() {
        super(Maquina.class);
    }
    
}
