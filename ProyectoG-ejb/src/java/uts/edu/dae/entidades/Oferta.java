/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.edu.dae.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "OFERTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oferta.findAll", query = "SELECT o FROM Oferta o"),
    @NamedQuery(name = "Oferta.findByCodigoOferta", query = "SELECT o FROM Oferta o WHERE o.codigoOferta = :codigoOferta"),
    @NamedQuery(name = "Oferta.findByTipoOferta", query = "SELECT o FROM Oferta o WHERE o.tipoOferta = :tipoOferta"),
    @NamedQuery(name = "Oferta.findByDescricionOferta", query = "SELECT o FROM Oferta o WHERE o.descricionOferta = :descricionOferta"),
    @NamedQuery(name = "Oferta.findByExperienciaOferta", query = "SELECT o FROM Oferta o WHERE o.experienciaOferta = :experienciaOferta"),
    @NamedQuery(name = "Oferta.findByCantidadAspirantesOferta", query = "SELECT o FROM Oferta o WHERE o.cantidadAspirantesOferta = :cantidadAspirantesOferta"),
    @NamedQuery(name = "Oferta.findByTituloRequerido", query = "SELECT o FROM Oferta o WHERE o.tituloRequerido = :tituloRequerido"),
    @NamedQuery(name = "Oferta.findByEstadoOferta", query = "SELECT o FROM Oferta o WHERE o.estadoOferta = :estadoOferta")})
public class Oferta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODIGO_OFERTA")
    private Integer codigoOferta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "TIPO_OFERTA")
    private String tipoOferta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "DESCRICION_OFERTA")
    private String descricionOferta;
    @Size(max = 300)
    @Column(name = "EXPERIENCIA_OFERTA")
    private String experienciaOferta;
    @Column(name = "CANTIDAD_ASPIRANTES_OFERTA")
    private Integer cantidadAspirantesOferta;
    @Size(max = 10)
    @Column(name = "TITULO_REQUERIDO")
    private String tituloRequerido;
    @Size(max = 20)
    @Column(name = "ESTADO_OFERTA")
    private String estadoOferta;
    @OneToMany(mappedBy = "codigoOferta")
    private List<AspiranteOfertaAplicar> aspiranteOfertaAplicarList;
    @JoinColumn(name = "NIT_EMPRESA", referencedColumnName = "NIT_EMPRESA")
    @ManyToOne(optional = false)
    private Empresa nitEmpresa;

    public Oferta() {
    }

    public Oferta(Integer codigoOferta) {
        this.codigoOferta = codigoOferta;
    }

    public Oferta(Integer codigoOferta, String tipoOferta, String descricionOferta) {
        this.codigoOferta = codigoOferta;
        this.tipoOferta = tipoOferta;
        this.descricionOferta = descricionOferta;
    }

    public Integer getCodigoOferta() {
        return codigoOferta;
    }

    public void setCodigoOferta(Integer codigoOferta) {
        this.codigoOferta = codigoOferta;
    }

    public String getTipoOferta() {
        return tipoOferta;
    }

    public void setTipoOferta(String tipoOferta) {
        this.tipoOferta = tipoOferta;
    }

    public String getDescricionOferta() {
        return descricionOferta;
    }

    public void setDescricionOferta(String descricionOferta) {
        this.descricionOferta = descricionOferta;
    }

    public String getExperienciaOferta() {
        return experienciaOferta;
    }

    public void setExperienciaOferta(String experienciaOferta) {
        this.experienciaOferta = experienciaOferta;
    }

    public Integer getCantidadAspirantesOferta() {
        return cantidadAspirantesOferta;
    }

    public void setCantidadAspirantesOferta(Integer cantidadAspirantesOferta) {
        this.cantidadAspirantesOferta = cantidadAspirantesOferta;
    }

    public String getTituloRequerido() {
        return tituloRequerido;
    }

    public void setTituloRequerido(String tituloRequerido) {
        this.tituloRequerido = tituloRequerido;
    }

    public String getEstadoOferta() {
        return estadoOferta;
    }

    public void setEstadoOferta(String estadoOferta) {
        this.estadoOferta = estadoOferta;
    }

    @XmlTransient
    public List<AspiranteOfertaAplicar> getAspiranteOfertaAplicarList() {
        return aspiranteOfertaAplicarList;
    }

    public void setAspiranteOfertaAplicarList(List<AspiranteOfertaAplicar> aspiranteOfertaAplicarList) {
        this.aspiranteOfertaAplicarList = aspiranteOfertaAplicarList;
    }

    public Empresa getNitEmpresa() {
        return nitEmpresa;
    }

    public void setNitEmpresa(Empresa nitEmpresa) {
        this.nitEmpresa = nitEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoOferta != null ? codigoOferta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oferta)) {
            return false;
        }
        Oferta other = (Oferta) object;
        if ((this.codigoOferta == null && other.codigoOferta != null) || (this.codigoOferta != null && !this.codigoOferta.equals(other.codigoOferta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uts.edu.dae.entidades.Oferta[ codigoOferta=" + codigoOferta + " ]";
    }
    
}
