package com.anteres.ejb;

import com.antares.model.TipoPQRS;
import java.util.List;
import javax.ejb.Local;

@Local
public interface TipoPQRSFacadeLocal {

    void create(TipoPQRS tipoPQRS);

    void edit(TipoPQRS tipoPQRS);

    void remove(TipoPQRS tipoPQRS);

    TipoPQRS find(Object id);

    List<TipoPQRS> findAll();

    List<TipoPQRS> findRange(int[] range);

    int count();
    
}
