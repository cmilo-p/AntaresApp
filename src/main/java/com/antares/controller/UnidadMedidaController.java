package com.antares.controller;

import com.antares.model.UnidadMedida;
import com.anteres.ejb.UnidadMedidaFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class UnidadMedidaController implements Serializable{
    
    @EJB
    private UnidadMedidaFacadeLocal unidadMedidaEJB;

    @Inject
    private UnidadMedida unidadMedida;
    private List<UnidadMedida> unidadMedidaList;

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public List<UnidadMedida> getUnidadMedidaList() {
        return unidadMedidaList;
    }

    public void setUnidadMedidaList(List<UnidadMedida> unidadMedidaList) {
        this.unidadMedidaList = unidadMedidaList;
    }
    
    @PostConstruct
    public void init(){
        unidadMedidaList = unidadMedidaEJB.findAll();
    }
    
}
