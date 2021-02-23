package com.anteres.ejb;

import com.antares.model.Telefono_usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class Telefono_usuarioFacade extends AbstractFacade<Telefono_usuario> implements Telefono_usuarioFacadeLocal {

    @PersistenceContext(unitName = "antaresPoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Telefono_usuarioFacade() {
        super(Telefono_usuario.class);
    }
    
}
