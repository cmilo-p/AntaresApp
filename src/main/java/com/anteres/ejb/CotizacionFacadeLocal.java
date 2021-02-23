package com.anteres.ejb;

import com.antares.model.Cotizacion;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CotizacionFacadeLocal {

    void create(Cotizacion cotizacion);

    void edit(Cotizacion cotizacion);

    void remove(Cotizacion cotizacion);

    Cotizacion find(Object id);

    List<Cotizacion> findAll();

    List<Cotizacion> findRange(int[] range);

    int count();
    
}
