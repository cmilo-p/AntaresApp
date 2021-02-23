package com.antares.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipoMaterial")
public class TipoMaterial implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoMaterial;
    
    @Column(name = "tipoMaterial")
    private String tipoMaterial;

    public int getIdTipoMaterial() {
        return idTipoMaterial;
    }

    public void setIdTipoMaterial(int idTipoMaterial) {
        this.idTipoMaterial = idTipoMaterial;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.idTipoMaterial;
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
        final TipoMaterial other = (TipoMaterial) obj;
        if (this.idTipoMaterial != other.idTipoMaterial) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoMaterial{" + "idTipoMaterial=" + idTipoMaterial + '}';
    }
        
}
