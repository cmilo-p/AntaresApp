package com.anteres.ejb;

import com.antares.model.Almacenista;
import java.util.List;
import javax.ejb.Local;

@Local
public interface AlmacenistaFacadeLocal {

    void create(Almacenista almacenista);

    void edit(Almacenista almacenista);

    void remove(Almacenista almacenista);

    Almacenista find(Object id);

    List<Almacenista> findAll();

    List<Almacenista> findRange(int[] range);

    int count();
    
}
