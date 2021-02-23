package com.anteres.ejb;

import com.antares.model.Ciudad;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CiudadFacadeLocal {

    void create(Ciudad ciudad);

    void edit(Ciudad ciudad);

    void remove(Ciudad ciudad);

    Ciudad find(Object id);

    List<Ciudad> findAll();

    List<Ciudad> findRange(int[] range);

    int count();
    
}
