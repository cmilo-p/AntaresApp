package com.anteres.ejb;

import com.antares.model.Catalogo;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CatalogoFacadeLocal {

    void create(Catalogo catalogo);

    void edit(Catalogo catalogo);

    void remove(Catalogo catalogo);

    Catalogo find(Object id);

    List<Catalogo> findAll();

    List<Catalogo> findRange(int[] range);

    int count();
    
}
