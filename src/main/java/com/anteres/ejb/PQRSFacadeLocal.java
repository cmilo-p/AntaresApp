package com.anteres.ejb;

import com.antares.model.PQRS;
import java.util.List;
import javax.ejb.Local;

@Local
public interface PQRSFacadeLocal {

    void create(PQRS pQRS);

    void edit(PQRS pQRS);

    void remove(PQRS pQRS);

    PQRS find(Object id);

    List<PQRS> findAll();

    List<PQRS> findRange(int[] range);

    int count();
    
}
