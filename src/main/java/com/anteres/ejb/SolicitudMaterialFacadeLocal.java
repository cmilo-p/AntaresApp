package com.anteres.ejb;

import com.antares.model.SolicitudMaterial;
import java.util.List;
import javax.ejb.Local;

@Local
public interface SolicitudMaterialFacadeLocal {

    void create(SolicitudMaterial solicitudMaterial);

    void edit(SolicitudMaterial solicitudMaterial);

    void remove(SolicitudMaterial solicitudMaterial);

    SolicitudMaterial find(Object id);

    List<SolicitudMaterial> findAll();

    List<SolicitudMaterial> findRange(int[] range);

    int count();
    
}
