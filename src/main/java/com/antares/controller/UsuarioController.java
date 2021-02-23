package com.antares.controller;

import com.antares.model.Rol;
import com.antares.model.Usuario;
import com.anteres.ejb.UsuarioFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class UsuarioController implements Serializable {
    
    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    
    @Inject
    private Usuario usuario;
    private List<Usuario> usuarioList;

    @Inject
    private Rol rol;
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @PostConstruct
    public void init(){
        usuarioList = usuarioEJB.findAll();
    }
    
    public void registrar(){
        try {
            usuario.setRol(rol);
            usuarioEJB.create(usuario);
            //msj jsf (info)
        } catch (Exception e) {
            //mss jsf (warning)
        }
    }
    
    public void leer(Usuario usuarioUpdate){
        usuario = usuarioUpdate;
    }
    
    public void modificar(){
        try {
            usuario.setRol(rol);
            usuarioEJB.edit(usuario);
            //msj jsf (info)
        } catch (Exception e) {
            //mss jsf (warning)
        }
    }
    
    public String restablecerContraseña(){
        try {
            usuarioEJB.edit(usuario);
            //msj jsf (info)
        } catch (Exception e) {
            //mss jsf (warning)
        }
        return "/vistas/login?faces-redirect=true";
    }
    
    public void eliminar(){
        try {
            usuarioEJB.remove(usuario);
            //msj jsf (info)
        } catch (Exception e) {
            //mss jsf (warning)
        }
    }
    
    public String iniciarSesion(){
        Usuario us;
        String redireccion = null;
        try {
            us = usuarioEJB.iniciarSesion(usuario);
            if(us != null){
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
                switch (us.getRol().getIdRol()) {
                    case 1:
                        redireccion = "adminPanel?faces-redirect=true";
                        break;
                    case 2:
                        redireccion = "almacen/moduloAlmacen?faces-redirect=true";
                        break;
                    case 3:
                        redireccion = "produccion/moduloProduccion?faces-redirect=true";
                        break;
                    case 4:
                        redireccion = "ventas/moduloVentas?faces-redirect=true";
                        break;
                }
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Antares", "¡Bienbenido!"));
            }else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Mensaje del Sistema", "Credenciales Incorrectas!"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Mensaje del Sistema", "Error Conexion!"));
        }
        return redireccion;
        
    }
    
}
