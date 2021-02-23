package com.antares.controller;

import com.antares.model.TipoMaterial;
import com.anteres.ejb.TipoMaterialFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class TipoMaterialController implements Serializable {
    
    @EJB
    private TipoMaterialFacadeLocal tipoMaterialEJB;
    
    @Inject
    private TipoMaterial tipoMaterial;
    private List<TipoMaterial> tipoMaterialList;            

    public TipoMaterial getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(TipoMaterial tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public List<TipoMaterial> getTipoMaterialList() {
        return tipoMaterialList;
    }

    public void setTipoMaterialList(List<TipoMaterial> tipoMaterialList) {
        this.tipoMaterialList = tipoMaterialList;
    }
    
    @PostConstruct
    public void init(){
        tipoMaterialList = tipoMaterialEJB.findAll();
    }
    
}
