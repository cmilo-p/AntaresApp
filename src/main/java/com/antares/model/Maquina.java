package com.antares.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "maquinas")
public class Maquina implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMaquina;
    
    @Column(name = "maquina")
    private String maquina;

    public int getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(int idMaquina) {
        this.idMaquina = idMaquina;
    }

    public String getMaquina() {
        return maquina;
    }

    public void setMaquina(String maquina) {
        this.maquina = maquina;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + this.idMaquina;
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
        final Maquina other = (Maquina) obj;
        if (this.idMaquina != other.idMaquina) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Maquina{" + "idMaquina=" + idMaquina + '}';
    }
            
}
