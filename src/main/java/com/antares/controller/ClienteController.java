package com.antares.controller;

import com.antares.model.Ciudad;
import com.antares.model.Cliente;
import com.antares.model.Departamento;
import com.antares.model.Pais;
import com.anteres.ejb.ClienteFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.file.UploadedFile;

@Named
@ViewScoped
public class ClienteController implements Serializable {

    private UploadedFile file;

    @EJB
    private ClienteFacadeLocal clienteEJB;

    @Inject
    private Cliente cliente;
    private List<Cliente> clienteList;

    @Inject
    private Ciudad ciudad;

    @Inject
    private Departamento departamento;

    @Inject
    private Pais pais;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
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

    @PostConstruct
    public void init() {
        clienteList = clienteEJB.findAll();
    }

    public void crear() {
        try {
            cliente.setCiudad(ciudad);
            cliente.setDepartamento(departamento);
            cliente.setPais(pais);
            clienteEJB.create(cliente);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Antares", "Registro Creado"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Antares", "Error de Conexión"));
        }
    }

    public void leer(Cliente clienteUpload) {
        cliente = clienteUpload;
    }

    public void modificar() {
        try {
            cliente.setCiudad(ciudad);
            cliente.setDepartamento(departamento);
            cliente.setPais(pais);
            clienteEJB.edit(cliente);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Antares", "Registro Modicado"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Antares", "Error de Conexión"));
        }

    }

    public void eliminar() {
        try {
            clienteEJB.remove(cliente);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Antares", "Registro Eliminado"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Antares", "Error de Conexión"));
        }
    }

}
