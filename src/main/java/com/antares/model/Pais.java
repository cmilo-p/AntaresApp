package com.antares.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "paises")
public class Pais implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoPais;

    @Column(name = "paises")
    private String paises;

    public int getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(int codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getPaises() {
        return paises;
    }

    public void setPaises(String paises) {
        this.paises = paises;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.codigoPais;
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
        final Pais other = (Pais) obj;
        if (this.codigoPais != other.codigoPais) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pais{" + "codigoPais=" + codigoPais + '}';
    }
        
}
