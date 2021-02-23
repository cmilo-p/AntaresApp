package com.anteres.ejb;

import com.antares.model.Productor;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ProductorFacadeLocal {

    void create(Productor productor);

    void edit(Productor productor);

    void remove(Productor productor);

    Productor find(Object id);

    List<Productor> findAll();

    List<Productor> findRange(int[] range);

    int count();
    
}
