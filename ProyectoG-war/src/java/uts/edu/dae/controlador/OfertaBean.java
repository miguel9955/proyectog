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
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import uts.edu.dae.ejb.AspiranteFacade;
import uts.edu.dae.ejb.OfertaFacade;
import uts.edu.dae.entidades.Aspirante;
import uts.edu.dae.entidades.Empresa;
import uts.edu.dae.entidades.Oferta;

/**
 *
 * @author Asus
 */
@ManagedBean
@RequestScoped
public class OfertaBean {
    @EJB
    private AspiranteFacade aspiranteFacade;
    private Aspirante aspirante;
    @EJB
    private OfertaFacade ofertaFacade;
    private Oferta oferta;
    private List <Oferta> Listaoferta;
    private List <Oferta> ListaofertaEmpresa;
    private List <Oferta> ListaofertaAspirante;
    private List <Oferta> ListaAE;
    private String msj;
    private Empresa empresa;
   private Integer codigoOferta;
   @ManagedProperty("#{loginBean}")
   private LoginBean loginBean;

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public List<Oferta> getListaAE() {
        ListaAE = ofertaFacade.ListaAspi();
        return ListaAE;
    }

    public void setListaAE(List<Oferta> ListaAE) {
        this.ListaAE = ListaAE;
    }
   
    public List<Oferta> getListaofertaEmpresa() {
        //Prueba
       String  CORREOEMPRESA="CORREP@GMAIL.COM";
       String P;
       P=loginBean.getCorreoUsuario();
        ListaofertaEmpresa=ofertaFacade.ListaEmpresa(P);
        System.out.println(""+CORREOEMPRESA);
        return ListaofertaEmpresa;
    }
   

    public void setListaofertaEmpresa(List<Oferta> ListaofertaEmpresa) {
        this.ListaofertaEmpresa = ListaofertaEmpresa;
    }

    public List<Oferta> getListaofertaAspirante() {
        ListaofertaAspirante= ofertaFacade.ListaOfer();
        return ListaofertaAspirante;
    }

    public void setListaofertaAspirante(List<Oferta> ListaofertaAspirante) {
        this.ListaofertaAspirante = ListaofertaAspirante;
    }
   
    public Integer getCodigoOferta() {
        return codigoOferta;
    }

    public void setCodigoOferta(Integer codigoOferta) {
        this.codigoOferta = codigoOferta;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }


    public String getMsj() {
        return msj;
    }

    public void setMsj(String msj) {
        this.msj = msj;
    }

    public Oferta getOferta() {
        return oferta;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }

    public List<Oferta> getListaoferta() {
        Listaoferta = ofertaFacade.findAll();
        return Listaoferta;
    }

    public void setListaoferta(List<Oferta> Listaoferta) {
        this.Listaoferta = Listaoferta;
    }
    @PostConstruct
    public void init() {
      oferta = new Oferta();
        empresa = new Empresa();
        
    }
    public void cargarDatos(Aspirante me) {
        this.aspirante = me;
    }
    public void guardar1() {
        try {
            this.oferta.setNitEmpresa(empresa);
            this.ofertaFacade.create(oferta);
            this.msj = "Registro Creado Correctamente";
            this.empresa = new Empresa();
            this.oferta = new Oferta();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
     public void limpiar() {
        this.oferta = new Oferta();
    }
     public void cargarDatosO(Oferta me) {
        this.oferta = me;
    }
     public void actualizar() {
        try {
            this.ofertaFacade.edit(oferta);
            this.msj = "Registro Actualizado Correctamente";
            this.oferta = new Oferta();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
     public void eliminar(Oferta meli) {
        try {
            this.ofertaFacade.remove(meli);
            this.msj = "Registro Eliminado Correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
     
    
    public OfertaBean() {
    }
    
}
