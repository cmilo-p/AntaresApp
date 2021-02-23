package com.anteres.ejb;

import com.antares.model.SolicitudMaterial;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class SolicitudMaterialFacade extends AbstractFacade<SolicitudMaterial> implements SolicitudMaterialFacadeLocal {

    @PersistenceContext(unitName = "antaresPoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SolicitudMaterialFacade() {
        super(SolicitudMaterial.class);
    }
    
}
