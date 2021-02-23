package com.antares.controller;

import com.antares.model.Factura;
import com.anteres.ejb.FacturaFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class FacturaController implements Serializable {
    
    @EJB
    private FacturaFacadeLocal facturaEJB;
    
    @Inject
    private Factura factura;
    private List<Factura> facturaList;

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    @PostConstruct
    public void init(){
        facturaList = facturaEJB.findAll();
    }
    
    public void leer(Factura facturaUpdate){
        factura = facturaUpdate;
    }
    
    public void crear(){
        
    }
    
    public void modificar(){
        try {
            facturaEJB.edit(factura);
            //msj jsf info
        } catch (Exception e) {
            //msj jsf warning
        }
    }
    
    public void eliminar(){
        try {
            facturaEJB.remove(factura);
            //msj jsf info
        } catch (Exception e) {
            //msj jsf warning
        }
    }
    
}
