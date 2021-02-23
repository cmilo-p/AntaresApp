package com.antares.controller;

import com.antares.model.Estado;
import com.anteres.ejb.EstadoFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class EstadoController implements Serializable{
    
    @EJB
    private EstadoFacadeLocal estadoEJB;
    
    @Inject
    private Estado estado;
    private List<Estado> estadoList;

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Estado> getEstadoList() {
        return estadoList;
    }

    public void setEstadoList(List<Estado> estadoList) {
        this.estadoList = estadoList;
    }
    
    @PostConstruct
    public void init(){
        estadoList = estadoEJB.findAll();
    }
    
}
