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
import uts.edu.dae.ejb.AspiranteOfertaAplicarFacade;
import uts.edu.dae.entidades.Aspirante;
import uts.edu.dae.entidades.AspiranteOfertaAplicar;
import uts.edu.dae.entidades.Oferta;

/**
 *
 * @author Asus
 */
@ManagedBean
@SessionScoped
public class AplicarOfertaBean {

   @EJB
    private AspiranteOfertaAplicarFacade aspiranteOfertaAplicarFacade;
    private AspiranteOfertaAplicar aplicar;
    private Oferta oferta;
    private Aspirante aspirante;
    private String msj;
    private List <AspiranteOfertaAplicar> ver;
    public String a(int ID){
    ver = aspiranteOfertaAplicarFacade.ListaVer(ID);
    return "/empresa/ver";
    }
    public List<AspiranteOfertaAplicar> getVer( ) {
        ver = aspiranteOfertaAplicarFacade.findAll();
        return ver;
    }

    public void setVer(List<AspiranteOfertaAplicar> ver) {
        this.ver = ver;
    }
    

    public AspiranteOfertaAplicar getAplicar() {
        return aplicar;
    }

    public void setAplicar(AspiranteOfertaAplicar aplicar) {
        this.aplicar = aplicar;
    }

    public Oferta getOferta() {
        return oferta;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }

    public Aspirante getAspirante() {
        return aspirante;
    }

    public void setAspirante(Aspirante aspirante) {
        this.aspirante = aspirante;
    }

    public String getMsj() {
        return msj;
    }

    public void setMsj(String msj) {
        this.msj = msj;
    }
    @PostConstruct
    public void init() {
        this.aplicar = new AspiranteOfertaAplicar();
        this.aspirante = new Aspirante();
        this.oferta = new Oferta();
    }
    public void guardar() {
        try {
            this.aplicar.setDocumentoAspirante(aspirante);
            this.aplicar.setCodigoOferta(oferta);
            this.aspiranteOfertaAplicarFacade.create(aplicar);
            this.msj = "Registro Creado Correctamente";
            this.aspirante = new Aspirante();
            this.oferta = new Oferta();
            this.aplicar = new AspiranteOfertaAplicar();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    public void cargarDatos(AspiranteOfertaAplicar re) {
        this.oferta.setCodigoOferta(re.getCodigoOferta().getCodigoOferta());
        this.aplicar = re;
    }
    public void limpiar() {
        this.aplicar = new AspiranteOfertaAplicar();
        this.aspirante = new Aspirante();
        this.oferta = new Oferta();
    }
    public AplicarOfertaBean() {
    }
    
}
