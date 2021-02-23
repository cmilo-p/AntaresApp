package com.antares.controller;

import com.antares.model.Departamento;
import com.anteres.ejb.DepartamentoFacadeLocal;
import com.csvreader.CsvReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class DepartamentoController implements Serializable  {
    
    private UploadedFile file;
    
    @EJB
    private DepartamentoFacadeLocal departamentoEJB;
    
    @Inject
    private Departamento departamento;
    private List<Departamento> departamentosList;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Departamento> getDepartamentosList() {
        return departamentosList;
    }

    public void setDepartamentosList(List<Departamento> departamentosList) {
        this.departamentosList = departamentosList;
    }
    
    @PostConstruct
    public void init(){
        departamentosList = departamentoEJB.findAll();
    }
    
    public void insertar(){
        try {
            if(file.getSize() > 0){
                CsvReader leerArchivos;
                leerArchivos = new CsvReader(new InputStreamReader(file.getInputStream()));
                leerArchivos.readHeaders();
                
                while(leerArchivos.readRecord()){
                    int codigo = Integer.parseInt(leerArchivos.get(0));
                    departamento = new Departamento();
                    departamento.setCodigoDepartamento(codigo);
                    departamento.setDepartamento(leerArchivos.get(1));
                    
                    departamentoEJB.create(departamento);
                    addMessage("System Message", "CSV Cargado al Sistema");
                }
                
            }
        } catch (IOException | NumberFormatException e) {
             
            addMessage("System Message", "Error al generar CSV");
        }
    }
    
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    
}
