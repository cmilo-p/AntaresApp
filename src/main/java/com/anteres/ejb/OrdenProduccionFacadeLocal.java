package com.anteres.ejb;

import com.antares.model.OrdenProduccion;
import java.util.List;
import javax.ejb.Local;

@Local
public interface OrdenProduccionFacadeLocal {

    void create(OrdenProduccion ordenProduccion);

    void edit(OrdenProduccion ordenProduccion);

    void remove(OrdenProduccion ordenProduccion);

    OrdenProduccion find(Object id);

    List<OrdenProduccion> findAll();

    List<OrdenProduccion> findRange(int[] range);

    int count();
    
}
