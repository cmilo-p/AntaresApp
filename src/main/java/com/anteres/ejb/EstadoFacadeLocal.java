package com.anteres.ejb;

import com.antares.model.Estado;
import java.util.List;
import javax.ejb.Local;

@Local
public interface EstadoFacadeLocal {

    void create(Estado estado);

    void edit(Estado estado);

    void remove(Estado estado);

    Estado find(Object id);

    List<Estado> findAll();

    List<Estado> findRange(int[] range);

    int count();
    
}
