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
@Table(name = "clientes")
public class Cliente implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;
    
    @Column(name = "nit_cedula")
    private String nit_cedula;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "correo")
    private String correo;
    
    @Column(name = "direccion")
    private String direccion;
    
    @ManyToOne
    @JoinColumn(name = "ciudad", nullable = false)
    private Ciudad ciudad;
    
    @ManyToOne
    @JoinColumn(name = "departamento", nullable = false)
    private Departamento departamento;
    
    @ManyToOne
    @JoinColumn(name = "pais", nullable = false)
    private Pais pais;
    
    @ManyToOne
    @JoinColumn(name = "vendedor", nullable = false)
    private Vendedor vendedor;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNit_cedula() {
        return nit_cedula;
    }

    public void setNit_cedula(String nit_cedula) {
        this.nit_cedula = nit_cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.idCliente;
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
        final Cliente other = (Cliente) obj;
        if (this.idCliente != other.idCliente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + '}';
    }

}
