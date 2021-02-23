package com.antares.controller;

import com.antares.model.Maquina;
import com.anteres.ejb.MaquinaFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class MaquinaController implements Serializable {
    
    @EJB
    private MaquinaFacadeLocal maquinaEJB;
    
    @Inject
    private Maquina maquina;
    private List<Maquina> maquinaList;

    public Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

    public List<Maquina> getMaquinaList() {
        return maquinaList;
    }

    public void setMaquinaList(List<Maquina> maquinaList) {
        this.maquinaList = maquinaList;
    }
    
    @PostConstruct
    public void init(){
        maquinaList = maquinaEJB.findAll();
    }
    
}
