package com.antares.controller;

import com.antares.model.Ciudad;
import com.anteres.ejb.CiudadFacadeLocal;
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
public class CiudadController implements Serializable {
    
    private UploadedFile file;

    @EJB
    private CiudadFacadeLocal ciudadEJB;

    @Inject
    private Ciudad ciudad;
    private List<Ciudad> ciudadList;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public List<Ciudad> getCiudadList() {
        return ciudadList;
    }

    public void setCiudadList(List<Ciudad> ciudadList) {
        this.ciudadList = ciudadList;
    }
    
    @PostConstruct
    public void init(){
        ciudadList = ciudadEJB.findAll();
    }
    
    public void insertar(){
        try {
            if(file.getSize() > 0){
                CsvReader leerArchivos;
                leerArchivos = new CsvReader(new InputStreamReader(file.getInputStream()));
                leerArchivos.readHeaders();
                
                while(leerArchivos.readRecord()){
                    int codigo = Integer.parseInt(leerArchivos.get(0));
                    ciudad = new Ciudad();
                    ciudad.setCodigoCiudad(codigo);
                    ciudad.setCiudad(leerArchivos.get(1));
                    
                    ciudadEJB.create(ciudad);
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
