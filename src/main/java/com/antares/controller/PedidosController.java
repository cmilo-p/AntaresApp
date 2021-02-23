package com.antares.controller;

import com.antares.model.Cliente;
import com.antares.model.DetallePedido;
import com.antares.model.Estado;
import com.antares.model.Pedido;
import com.antares.model.Producto;
import com.antares.model.UnidadMedida;
import com.anteres.ejb.DetallePedidoFacadeLocal;
import com.anteres.ejb.PedidoFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class PedidosController implements Serializable {
    
    @EJB
    private PedidoFacadeLocal pedidoEJB;
    
    @Inject
    private Pedido pedido;
    private List<Pedido> pedidoList;
    
    @EJB
    private DetallePedidoFacadeLocal detalleEJB;
    
    @Inject
    private DetallePedido detalle;
    private List<DetallePedido> detalleList;
    
    @Inject
    private Producto producto;
    
    private double cantidad;
    
    @Inject
    private UnidadMedida unidad;
        
    @Inject
    private Estado estado;
    
    @Inject
    private Cliente cliente;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public DetallePedido getDetalle() {
        return detalle;
    }

    public void setDetalle(DetallePedido detalle) {
        this.detalle = detalle;
    }

    public List<DetallePedido> getDetalleList() {
        return detalleList;
    }

    public void setDetalleList(List<DetallePedido> detalleList) {
        this.detalleList = detalleList;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public UnidadMedida getUnidad() {
        return unidad;
    }

    public void setUnidad(UnidadMedida unidad) {
        this.unidad = unidad;
    }

    

    @PostConstruct
    public void init() {
        pedidoList = pedidoEJB.findAll();
    }
    
    public void leer(Pedido pedidoUpdate){
        pedido = pedidoUpdate;
    }
    
    public void modificar(){
        try {
            pedido.setEstado(estado);
            pedido.setCliente(cliente);
            pedidoEJB.edit(pedido);
            //msj jsf info
        } catch (Exception e) {
            //msj jsf warning
        }
    }
    
    public void eliminar(){
        try {
            pedidoEJB.remove(pedido);
            //msj jsf info
        } catch (Exception e) {
            //msj jsf warning
        }
    }

    public void tabla(){
        detalle.setProducto(producto);
        detalle.setCantidad(cantidad);
        detalle.setUnidadMedida(unidad);
                        
        detalleList.add(detalle);

    }
    
    
    
}
