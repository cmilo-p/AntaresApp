package com.antares.controller;

import com.antares.model.Producto;
import com.antares.model.TipoMaterial;
import com.anteres.ejb.ProductoFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class ProductoController implements Serializable {
    
    @EJB
    private ProductoFacadeLocal productoEJB;
    
    @Inject
    private Producto producto;
    private List<Producto> productoList;

    @Inject
    private TipoMaterial material;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    public TipoMaterial getMaterial() {
        return material;
    }

    public void setMaterial(TipoMaterial material) {
        this.material = material;
    }
    
    @PostConstruct
    public void init(){
        productoList = productoEJB.findAll();
    }
    
    public void registrar(){
        try {
            producto.setTipoMaterial(material);
            productoEJB.create(producto);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Antares", "Registro Realizado"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Antares", "Error al registrar"));
        }
    }
    
    public void leer(Producto productoUpdate){
        producto = productoUpdate;
    }
    
    public void modificar(){
        try {
            producto.setTipoMaterial(material);
            productoEJB.edit(producto);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Antares", "Registro Modificado"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Antares", "Error al registrar"));
        }
    }
    
}
