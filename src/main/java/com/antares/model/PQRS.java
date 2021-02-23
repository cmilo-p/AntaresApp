package com.antares.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pqrs")
public class PQRS implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPQRS;

    @ManyToOne
    @JoinColumn(name = "tipoPQRS", nullable = false)
    private TipoPQRS tipoPQRS;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "cliente", nullable = false)
    private Cliente cliente;

    public int getIdPQRS() {
        return idPQRS;
    }

    public void setIdPQRS(int idPQRS) {
        this.idPQRS = idPQRS;
    }

    public TipoPQRS getTipoPQRS() {
        return tipoPQRS;
    }

    public void setTipoPQRS(TipoPQRS tipoPQRS) {
        this.tipoPQRS = tipoPQRS;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.idPQRS;
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
        final PQRS other = (PQRS) obj;
        if (this.idPQRS != other.idPQRS) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PQRS{" + "idPQRS=" + idPQRS + '}';
    }

}
