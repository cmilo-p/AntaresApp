package com.antares.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ciudades")
public class Ciudad implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoCiudad;
    
    @Column(name = "ciudad")
    private String ciudad;

    public int getCodigoCiudad() {
        return codigoCiudad;
    }

    public void setCodigoCiudad(int codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.codigoCiudad;
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
        final Ciudad other = (Ciudad) obj;
        if (this.codigoCiudad != other.codigoCiudad) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ciudad{" + "codigoCiudad=" + codigoCiudad + '}';
    }

}
