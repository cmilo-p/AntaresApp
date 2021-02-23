package com.anteres.ejb;

import com.antares.model.DetalleCotizacion;
import java.util.List;
import javax.ejb.Local;

@Local
public interface DetalleCotizacionFacadeLocal {

    void create(DetalleCotizacion detalleCotizacion);

    void edit(DetalleCotizacion detalleCotizacion);

    void remove(DetalleCotizacion detalleCotizacion);

    DetalleCotizacion find(Object id);

    List<DetalleCotizacion> findAll();

    List<DetalleCotizacion> findRange(int[] range);

    int count();
    
}
