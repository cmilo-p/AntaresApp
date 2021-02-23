package com.antares.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipopqrs")
public class TipoPQRS implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoPQRS;

    @Column(name = "detallePQRS")
    private String detallePQRS;

    public int getIdTipoPQRS() {
        return idTipoPQRS;
    }

    public void setIdTipoPQRS(int idTipoPQRS) {
        this.idTipoPQRS = idTipoPQRS;
    }

    public String getDetallePQRS() {
        return detallePQRS;
    }

    public void setDetallePQRS(String detallePQRS) {
        this.detallePQRS = detallePQRS;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.idTipoPQRS;
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
        final TipoPQRS other = (TipoPQRS) obj;
        if (this.idTipoPQRS != other.idTipoPQRS) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoPQRS{" + "idTipoPQRS=" + idTipoPQRS + '}';
    }

}
