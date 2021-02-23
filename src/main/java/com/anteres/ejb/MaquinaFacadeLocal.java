package com.anteres.ejb;

import com.antares.model.Maquina;
import java.util.List;
import javax.ejb.Local;

@Local
public interface MaquinaFacadeLocal {

    void create(Maquina maquina);

    void edit(Maquina maquina);

    void remove(Maquina maquina);

    Maquina find(Object id);

    List<Maquina> findAll();

    List<Maquina> findRange(int[] range);

    int count();
    
}
