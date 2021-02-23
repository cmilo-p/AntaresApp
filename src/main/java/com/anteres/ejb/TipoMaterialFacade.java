package com.anteres.ejb;

import com.antares.model.TipoMaterial;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TipoMaterialFacade extends AbstractFacade<TipoMaterial> implements TipoMaterialFacadeLocal {

    @PersistenceContext(unitName = "antaresPoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoMaterialFacade() {
        super(TipoMaterial.class);
    }
    
}
