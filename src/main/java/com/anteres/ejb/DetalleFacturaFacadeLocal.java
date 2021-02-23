package com.anteres.ejb;

import com.antares.model.DetalleFactura;
import java.util.List;
import javax.ejb.Local;

@Local
public interface DetalleFacturaFacadeLocal {

    void create(DetalleFactura detalleFactura);

    void edit(DetalleFactura detalleFactura);

    void remove(DetalleFactura detalleFactura);

    DetalleFactura find(Object id);

    List<DetalleFactura> findAll();

    List<DetalleFactura> findRange(int[] range);

    int count();
    
}
