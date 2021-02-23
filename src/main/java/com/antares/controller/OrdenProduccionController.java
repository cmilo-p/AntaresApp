package com.antares.controller;

import com.antares.model.DetalleProduccion;
import com.antares.model.Maquina;
import com.antares.model.OrdenProduccion;
import com.antares.model.Pedido;
import com.antares.model.Productor;
import com.antares.model.TipoMaterial;
import com.antares.model.Usuario;
import com.anteres.ejb.OrdenProduccionFacadeLocal;
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
public class OrdenProduccionController implements Serializable {
    
    @EJB
    private OrdenProduccionFacadeLocal ordenEJB;
    
    @Inject
    private OrdenProduccion orden;
    private List<OrdenProduccion> ordenList;
    
    @Inject
    private DetalleProduccion detalle;
    private List<DetalleProduccion> detalleList;
    
    @Inject
    private Usuario usuario;
    
    @Inject
    private Productor productor;
    
    @Inject
    private Pedido pedido;
    
    @Inject
    private Maquina maquina;
    
    @Inject
    private TipoMaterial material;

    public OrdenProduccion getOrden() {
        return orden;
    }

    public void setOrden(OrdenProduccion orden) {
        this.orden = orden;
    }

    public List<OrdenProduccion> getOrdenList() {
        return ordenList;
    }

    public void setOrdenList(List<OrdenProduccion> ordenList) {
        this.ordenList = ordenList;
    }

    public DetalleProduccion getDetalle() {
        return detalle;
    }

    public void setDetalle(DetalleProduccion detalle) {
        this.detalle = detalle;
    }

    public List<DetalleProduccion> getDetalleList() {
        return detalleList;
    }

    public void setDetalleList(List<DetalleProduccion> detalleList) {
        this.detalleList = detalleList;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

    public TipoMaterial getMaterial() {
        return material;
    }

    public void setMaterial(TipoMaterial material) {
        this.material = material;
    }

    public Productor getProductor() {
        return productor;
    }

    public void setProductor(Productor productor) {
        this.productor = productor;
    }

    
    

    @PostConstruct
    public void init(){
        ordenList = ordenEJB.findAll();
    }
    
    public void leer(OrdenProduccion ordenUpdate) {
        orden = ordenUpdate;
    }

    public void modificar() {
        try {
            orden.setMaquina(maquina);
            ordenEJB.edit(orden);
            //msj jsf (info)
        } catch (Exception e) {
            //mss jsf (warning)
        }
    }
    
    public void eliminar() {
        try {
            ordenEJB.remove(orden);
            //msj jsf (info)
        } catch (Exception e) {
            //mss jsf (warning)
        }
    }
    
    
  
    public void registrar(){
        try {
            orden.setNoPedido(pedido);
            orden.setProductor(productor);
            orden.setMaquina(maquina);
            ordenEJB.create(orden);
            addMessage("System Message", "Orden Registrada."); 
        } catch (Exception e) {
           addMessage("System Message", "Error de Registro.");  
        }
       
    }
    

    

    

     
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}
