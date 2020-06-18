/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.edu.dae.controlador;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import uts.edu.dae.ejb.UsuarioFacade;
import uts.edu.dae.entidades.Usuario;

/**
 *
 * @author Asus
 */
@ManagedBean
@RequestScoped
public class LoginBean {

    @EJB
    private UsuarioFacade usuarioFacade;
    private Usuario usarios;    
    private String correoUsuario;    
    private String contraseña;
    private String tipoUsuario;

    public Usuario getUsarios() {
        return usarios;
    }

    public void setUsarios(Usuario usarios) {
        this.usarios = usarios;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
public String autenticar(){
       usarios = usuarioFacade.encontrarUsuarioNombre(correoUsuario);
       if (usarios != null) {
           if (usarios.getTipoUsuario().equals("EMPRESA")) {
               
           
           if (usarios.getContraseña().equals(contraseña) ) {
                return "empresa";
           }
                  
           }else if (usarios.getTipoUsuario().equals("ASPIRANTE")){
               if (usarios.getContraseña().equals(contraseña) ) {
                return "aspirante";
           }
           }
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"El Contraseña no existe","El Contraseña no existe"));
                  return null;
       }
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"El usuario no existe","El usuario no existe"));
       return null;
   }
    public LoginBean() {
    }
    
}
