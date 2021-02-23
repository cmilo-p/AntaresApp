package com.antares.controller;

import com.antares.model.Inventario;
import com.anteres.ejb.InventarioFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class InventarioController implements Serializable {
    
    @EJB
    private InventarioFacadeLocal inventarioEJB;
    
    @Inject
    private Inventario inventario;
    private List<Inventario> inventarioList;

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public List<Inventario> getInventarioList() {
        return inventarioList;
    }

    public void setInventarioList(List<Inventario> inventarioList) {
        this.inventarioList = inventarioList;
    }
    
    @PostConstruct
    public void init(){
        inventarioList = inventarioEJB.findAll();
    }
    
    
}
