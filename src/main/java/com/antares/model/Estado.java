package com.antares.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estados")
public class Estado implements Serializable {
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstados;
    
    @Column(name = "estado")
    private String estado;

    public int getIdEstados() {
        return idEstados;
    }

    public void setIdEstados(int idEstados) {
        this.idEstados = idEstados;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.idEstados;
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
        final Estado other = (Estado) obj;
        if (this.idEstados != other.idEstados) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Estado{" + "idEstados=" + idEstados + '}';
    }
         
}
