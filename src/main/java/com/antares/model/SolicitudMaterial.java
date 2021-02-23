package com.antares.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "solicitudMaterial")
public class SolicitudMaterial implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSolicitud;

    @Column(name = "fechaSolicitud")
    @Temporal(TemporalType.DATE)
    private Date fechaSolicitud;

    @ManyToOne
    @JoinColumn(name = "estado", nullable = false)
    private Estado estado;

    @Column(name = "observacion")
    private String observacion;

    @ManyToOne
    @JoinColumn(name = "almacenista", nullable = false)
    private Almacenista almacenista;

    @ManyToOne
    @JoinColumn(name = "producto", nullable = false)
    private Productor producto;

    @ManyToOne
    @JoinColumn(name = "vendedor", nullable = false)
    private Vendedor vendedor;

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Almacenista getAlmacenista() {
        return almacenista;
    }

    public void setAlmacenista(Almacenista almacenista) {
        this.almacenista = almacenista;
    }

    public Productor getProducto() {
        return producto;
    }

    public void setProducto(Productor producto) {
        this.producto = producto;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.idSolicitud;
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
        final SolicitudMaterial other = (SolicitudMaterial) obj;
        if (this.idSolicitud != other.idSolicitud) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Solicitudmaterial{" + "idSolicitud=" + idSolicitud + '}';
    }

}
