/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anteres.ejb;

import com.antares.model.Telefono_cliente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ASUS
 */
@Local
public interface Telefono_clienteFacadeLocal {

    void create(Telefono_cliente telefono_cliente);

    void edit(Telefono_cliente telefono_cliente);

    void remove(Telefono_cliente telefono_cliente);

    Telefono_cliente find(Object id);

    List<Telefono_cliente> findAll();

    List<Telefono_cliente> findRange(int[] range);

    int count();
    
}
