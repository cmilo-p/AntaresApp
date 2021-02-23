package com.anteres.ejb;

import com.antares.model.DetalleSolicitud;
import java.util.List;
import javax.ejb.Local;

@Local
public interface DetalleSolicitudFacadeLocal {

    void create(DetalleSolicitud detalleSolicitud);

    void edit(DetalleSolicitud detalleSolicitud);

    void remove(DetalleSolicitud detalleSolicitud);

    DetalleSolicitud find(Object id);

    List<DetalleSolicitud> findAll();

    List<DetalleSolicitud> findRange(int[] range);

    int count();
    
}
