package com.antares.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "unidadMedida")
public class UnidadMedida implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUnidadMedida;

    @Column(name = "unidadMedida")
    private String unidadMedida;

    public int getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(int idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.idUnidadMedida;
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
        final UnidadMedida other = (UnidadMedida) obj;
        if (this.idUnidadMedida != other.idUnidadMedida) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UnidadMedida{" + "idUnidadMedida=" + idUnidadMedida + '}';
    }

}
