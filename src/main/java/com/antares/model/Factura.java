package com.antares.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "facturas")
public class Factura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFactura;

    @Column(name = "fechaFactura")
    @Temporal(TemporalType.DATE)
    private Date fechaFactura;

    @ManyToOne
    @JoinColumn(name = "cliente", nullable = false)
    private Cliente cliente;

    @Column(name = "subTotal")
    private double subTotal;

    @Column(name = "iva")
    private double iva;

    @Column(name = "total")
    private double total;
    
    @ManyToOne
    @JoinColumn(name = "noPedido", nullable = false)
    private Pedido noPedido;

    @ManyToOne
    @JoinColumn(name = "vendedor", nullable = false)
    private Vendedor vendedor;

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Pedido getNoPedido() {
        return noPedido;
    }

    public void setNoPedido(Pedido noPedido) {
        this.noPedido = noPedido;
    }
    
    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.idFactura;
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
        final Factura other = (Factura) obj;
        if (this.idFactura != other.idFactura) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Factura{" + "idFactura=" + idFactura + '}';
    }
 
}
