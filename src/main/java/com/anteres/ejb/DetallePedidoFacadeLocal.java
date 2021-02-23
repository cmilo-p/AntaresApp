package com.anteres.ejb;

import com.antares.model.DetallePedido;
import java.util.List;
import javax.ejb.Local;

@Local
public interface DetallePedidoFacadeLocal {

    void create(DetallePedido detallePedido);

    void edit(DetallePedido detallePedido);

    void remove(DetallePedido detallePedido);

    DetallePedido find(Object id);

    List<DetallePedido> findAll();

    List<DetallePedido> findRange(int[] range);

    int count();
    
}
