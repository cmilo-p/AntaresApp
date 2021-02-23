package com.anteres.ejb;

import com.antares.model.Factura;
import java.util.List;
import javax.ejb.Local;

@Local
public interface FacturaFacadeLocal {

    void create(Factura factura);

    void edit(Factura factura);

    void remove(Factura factura);

    Factura find(Object id);

    List<Factura> findAll();

    List<Factura> findRange(int[] range);

    int count();
    
}
