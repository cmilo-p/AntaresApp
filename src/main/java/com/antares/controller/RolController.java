package com.antares.controller;

import com.antares.model.Rol;
import com.anteres.ejb.RolFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class RolController implements Serializable {
    
    @EJB
    private RolFacadeLocal rolEJB;
    
    @Inject
    private Rol rol;
    private List<Rol> rolesList;

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Rol> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<Rol> rolesList) {
        this.rolesList = rolesList;
    }
    
    @PostConstruct
    public void init(){
        rolesList = rolEJB.findAll();
    }
    
}
