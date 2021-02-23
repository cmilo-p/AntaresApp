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
@Table(name = "ordenProduccion")
public class OrdenProduccion implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrdenProduccion;

    @Column(name = "fechaProduccion")
    @Temporal(TemporalType.DATE)
    private Date fechaProduccion;

    @ManyToOne
    @JoinColumn(name = "maquina", nullable = false)
    private Maquina maquina;

    @Column(name = "observaciones")
    private String observacion;
    
    @ManyToOne
    @JoinColumn(name = "noPedido", nullable = false)
    private Pedido noPedido;

    @ManyToOne
    @JoinColumn(name = "productor", nullable = false)
    private Productor productor;

    public int getIdOrdenProduccion() {
        return idOrdenProduccion;
    }

    public void setIdOrdenProduccion(int idOrdenProduccion) {
        this.idOrdenProduccion = idOrdenProduccion;
    }

    public Date getFechaProduccion() {
        return fechaProduccion;
    }

    public void setFechaProduccion(Date fechaProduccion) {
        this.fechaProduccion = fechaProduccion;
    }

    public Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
    public Pedido getNoPedido() {
        return noPedido;
    }

    public void setNoPedido(Pedido noPedido) {
        this.noPedido = noPedido;
    }

    public Productor getProductor() {
        return productor;
    }

    public void setProductor(Productor productor) {
        this.productor = productor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + this.idOrdenProduccion;
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
        final OrdenProduccion other = (OrdenProduccion) obj;
        if (this.idOrdenProduccion != other.idOrdenProduccion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OrdenProduccion{" + "idOrdenProduccion=" + idOrdenProduccion + '}';
    }

}
