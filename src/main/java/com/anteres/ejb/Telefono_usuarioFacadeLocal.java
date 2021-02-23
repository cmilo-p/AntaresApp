package com.anteres.ejb;

import com.antares.model.Telefono_usuario;
import java.util.List;
import javax.ejb.Local;

@Local
public interface Telefono_usuarioFacadeLocal {

    void create(Telefono_usuario telefono_usuario);

    void edit(Telefono_usuario telefono_usuario);

    void remove(Telefono_usuario telefono_usuario);

    Telefono_usuario find(Object id);

    List<Telefono_usuario> findAll();

    List<Telefono_usuario> findRange(int[] range);

    int count();
    
}
