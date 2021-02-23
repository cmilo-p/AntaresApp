package com.antares.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detallePedido")
public class DetallePedido implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name = "idPedido", nullable = false)
    private Pedido idPedido;

    @ManyToOne
    @JoinColumn(name = "producto", nullable = false)
    private Producto producto;

    @Column(name = "cantidad")
    private double cantidad;

    @ManyToOne
    @JoinColumn(name = "unidadMedida", nullable = false)
    private UnidadMedida unidadMedida;

    public Pedido getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedido idPedido) {
        this.idPedido = idPedido;
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

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.idPedido);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DetallePedido other = (DetallePedido) obj;
        if (!Objects.equals(this.idPedido, other.idPedido)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DetallePedido{" + "idPedido=" + idPedido + '}';
    }
 
}
