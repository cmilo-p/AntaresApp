package com.antares.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "almacenistas")
public class Almacenista implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAlmacenista;
    
    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario idUsuario;
    
    public int getIdAlmacenista() {
        return idAlmacenista;
    }

    public void setIdAlmacenista(int idAlmacenista) {
        this.idAlmacenista = idAlmacenista;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.idAlmacenista);
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
        final Almacenista other = (Almacenista) obj;
        if (!Objects.equals(this.idAlmacenista, other.idAlmacenista)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Almacenista{" + "idAlmacenista=" + idAlmacenista + '}';
    }

}
