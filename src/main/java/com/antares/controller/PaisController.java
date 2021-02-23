package com.antares.controller;

import com.antares.model.Pais;
import com.anteres.ejb.PaisFacadeLocal;
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
public class PaisController implements Serializable {
    
    private UploadedFile file;

    @EJB
    private PaisFacadeLocal paisEJB;

    @Inject
    private Pais pais;
    private List<Pais> paisList;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Pais> getPaisList() {
        return paisList;
    }

    public void setPaisList(List<Pais> paisList) {
        this.paisList = paisList;
    }
    
    @PostConstruct
    public void init(){
        paisList = paisEJB.findAll();
    }
    
    public void insertar(){
        try {
            if(file.getSize() > 0){
                CsvReader leerArchivos;
                leerArchivos = new CsvReader(new InputStreamReader(file.getInputStream()));
                leerArchivos.readHeaders();
                
                while(leerArchivos.readRecord()){
                    int codigo = Integer.parseInt(leerArchivos.get(0));
                    pais = new Pais();
                    pais.setCodigoPais(codigo);
                    pais.setPaises(leerArchivos.get(1));
                    
                    paisEJB.create(pais);
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
