package com.anteres.ejb;

import com.antares.model.DetalleProduccion;
import java.util.List;
import javax.ejb.Local;

@Local
public interface DetalleProduccionFacadeLocal {

    void create(DetalleProduccion detalleProduccion);

    void edit(DetalleProduccion detalleProduccion);

    void remove(DetalleProduccion detalleProduccion);

    DetalleProduccion find(Object id);

    List<DetalleProduccion> findAll();

    List<DetalleProduccion> findRange(int[] range);

    int count();
    
}
