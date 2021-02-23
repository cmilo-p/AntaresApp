package com.anteres.ejb;

import com.antares.model.TipoMaterial;
import java.util.List;
import javax.ejb.Local;

@Local
public interface TipoMaterialFacadeLocal {

    void create(TipoMaterial tipoMaterial);

    void edit(TipoMaterial tipoMaterial);

    void remove(TipoMaterial tipoMaterial);

    TipoMaterial find(Object id);

    List<TipoMaterial> findAll();

    List<TipoMaterial> findRange(int[] range);

    int count();
    
}
