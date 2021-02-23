package com.anteres.ejb;

import com.antares.model.Pais;
import java.util.List;
import javax.ejb.Local;

@Local
public interface PaisFacadeLocal {

    void create(Pais pais);

    void edit(Pais pais);

    void remove(Pais pais);

    Pais find(Object id);

    List<Pais> findAll();

    List<Pais> findRange(int[] range);

    int count();
    
}
