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
@Table(name = "detalleCotizacion")
public class DetalleCotizacion implements Serializable {
    
    @Id
    @OneToOne
    @JoinColumn(name = "idCotizacion", nullable = false)
    private Cotizacion idCotizacion;

    @ManyToOne
    @JoinColumn(name = "producto", nullable = false)
    private Producto producto;

    @Column(name = "cantidad")
    private double cantidad;

    @ManyToOne
    @JoinColumn(name = "unidadMedida", nullable = false)
    private UnidadMedida unidadMedida;

    @Column(name = "precioUnitario")
    private double precioUnitario;

    public Cotizacion getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(Cotizacion idCotizacion) {
        this.idCotizacion = idCotizacion;
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

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.idCotizacion);
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
        final DetalleCotizacion other = (DetalleCotizacion) obj;
        if (!Objects.equals(this.idCotizacion, other.idCotizacion)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DetalleCotizacion{" + "idCotizacion=" + idCotizacion + '}';
    }

}
