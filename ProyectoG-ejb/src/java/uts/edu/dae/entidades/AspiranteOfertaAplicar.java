/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.edu.dae.entidades;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "ASPIRANTE_OFERTA_APLICAR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AspiranteOfertaAplicar.findAll", query = "SELECT a FROM AspiranteOfertaAplicar a"),
    @NamedQuery(name = "AspiranteOfertaAplicar.findByIdAspiranteOferta", query = "SELECT a FROM AspiranteOfertaAplicar a WHERE a.idAspiranteOferta = :idAspiranteOferta")})
public class AspiranteOfertaAplicar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ASPIRANTE_OFERTA")
    private Integer idAspiranteOferta;
    @JoinColumn(name = "DOCUMENTO_ASPIRANTE", referencedColumnName = "DOCUMENTO_ASPIRANTE")
    @ManyToOne
    private Aspirante documentoAspirante;
    @JoinColumn(name = "CODIGO_OFERTA", referencedColumnName = "CODIGO_OFERTA")
    @ManyToOne
    private Oferta codigoOferta;

    public AspiranteOfertaAplicar() {
    }

    public AspiranteOfertaAplicar(Integer idAspiranteOferta) {
        this.idAspiranteOferta = idAspiranteOferta;
    }

    public Integer getIdAspiranteOferta() {
        return idAspiranteOferta;
    }

    public void setIdAspiranteOferta(Integer idAspiranteOferta) {
        this.idAspiranteOferta = idAspiranteOferta;
    }

    public Aspirante getDocumentoAspirante() {
        return documentoAspirante;
    }

    public void setDocumentoAspirante(Aspirante documentoAspirante) {
        this.documentoAspirante = documentoAspirante;
    }

    public Oferta getCodigoOferta() {
        return codigoOferta;
    }

    public void setCodigoOferta(Oferta codigoOferta) {
        this.codigoOferta = codigoOferta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAspiranteOferta != null ? idAspiranteOferta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AspiranteOfertaAplicar)) {
            return false;
        }
        AspiranteOfertaAplicar other = (AspiranteOfertaAplicar) object;
        if ((this.idAspiranteOferta == null && other.idAspiranteOferta != null) || (this.idAspiranteOferta != null && !this.idAspiranteOferta.equals(other.idAspiranteOferta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uts.edu.dae.entidades.AspiranteOfertaAplicar[ idAspiranteOferta=" + idAspiranteOferta + " ]";
    }
    
}
