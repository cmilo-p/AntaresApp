package com.anteres.ejb;

import com.antares.model.Inventario;
import java.util.List;
import javax.ejb.Local;

@Local
public interface InventarioFacadeLocal {

    void create(Inventario inventario);

    void edit(Inventario inventario);

    void remove(Inventario inventario);

    Inventario find(Object id);

    List<Inventario> findAll();

    List<Inventario> findRange(int[] range);

    int count();
    
}
