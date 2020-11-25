/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.edu.dae.controlador;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import uts.edu.dae.ejb.EmpresaFacade;
import uts.edu.dae.ejb.UsuarioFacade;
import uts.edu.dae.entidades.Empresa;
import uts.edu.dae.entidades.Usuario;

/**
 *
 * @author Asus
 */
@ManagedBean
@SessionScoped
public class EmpresaBean {

    @EJB
    private EmpresaFacade empresaFacade;
    private List<Empresa> listaempresa;
    private Empresa empresa;
    private Integer nitEmpresa;
    private String nombreEmpresa;
    private String ciudadEmpresa;
    private String direccionEmpresa;
    private String telefonoEmpresa;
    private String correoEmpresa;
    private String msj; 

    @EJB
    private UsuarioFacade usuarioFacade;
    private Usuario usario;
    private String correoUsuario;
    private String tipoUsuario;
    private String contraseña;

    public String getMsj() {
        return msj;
    }

    public void setMsj(String msj) {
        this.msj = msj;
    }

    public Integer getNitEmpresa() {
        return nitEmpresa;
    }

    public void setNitEmpresa(Integer nitEmpresa) {
        this.nitEmpresa = nitEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getCiudadEmpresa() {
        return ciudadEmpresa;
    }

    public void setCiudadEmpresa(String ciudadEmpresa) {
        this.ciudadEmpresa = ciudadEmpresa;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    public String getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    public void setTelefonoEmpresa(String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    public String getCorreoEmpresa() {
        return correoEmpresa;
    }

    public void setCorreoEmpresa(String correoEmpresa) {
        this.correoEmpresa = correoEmpresa;
    }

    public Usuario getUsario() {
        return usario;
    }

    public void setUsario(Usuario usario) {
        this.usario = usario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    public List<Empresa> getListaempresa() {
        this.listaempresa = empresaFacade.findAll();
        return listaempresa;
    }

    public void setListaempresa(List<Empresa> listaempresa) {
        this.listaempresa = listaempresa;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
public void cargarDatosO(Empresa me) {
        this.empresa = me;
    }
 public void limpiar() {
        this.empresa = new Empresa();
    }
    public String guardar() {

        Usuario c = new Usuario();
        c.setContraseña(contraseña);
        tipoUsuario = "EMPRESA";
        c.setTipoUsuario(tipoUsuario);
        c.setCorreoUsuario(correoEmpresa);

        Empresa e = new Empresa();
        e.setCiudadEmpresa(ciudadEmpresa);
        e.setCorreoEmpresa(correoEmpresa);
        e.setDireccionEmpresa(direccionEmpresa);
        e.setNitEmpresa(nitEmpresa);
        e.setNombreEmpresa(nombreEmpresa);
        e.setTelefonoEmpresa(telefonoEmpresa);

        this.usuarioFacade.create(c);
        this.empresaFacade.create(e);

        return "Login";

    }
    public void eliminar(Empresa meli) {
        try {
            this.empresaFacade.remove(meli);
            this.msj = "Registro Eliminado Correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
public void actualizar() {
        try {
            this.empresaFacade.edit(empresa);
            this.msj = "Registro Actualizado Correctamente";
            this.empresa = new Empresa();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
@PostConstruct
    public void init() {
      empresa = new Empresa();
        
        
    }
    public EmpresaBean() {

    }

}
