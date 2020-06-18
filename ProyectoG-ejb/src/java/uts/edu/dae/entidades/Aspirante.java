/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.edu.dae.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "ASPIRANTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aspirante.findAll", query = "SELECT a FROM Aspirante a"),
    @NamedQuery(name = "Aspirante.findByDocumentoAspirante", query = "SELECT a FROM Aspirante a WHERE a.documentoAspirante = :documentoAspirante"),
    @NamedQuery(name = "Aspirante.findByIdAspirante", query = "SELECT a FROM Aspirante a WHERE a.idAspirante = :idAspirante"),
    @NamedQuery(name = "Aspirante.findByTipodocumentoAspirante", query = "SELECT a FROM Aspirante a WHERE a.tipodocumentoAspirante = :tipodocumentoAspirante"),
    @NamedQuery(name = "Aspirante.findByNombresApitante", query = "SELECT a FROM Aspirante a WHERE a.nombresApitante = :nombresApitante"),
    @NamedQuery(name = "Aspirante.findByApellidosAspirante", query = "SELECT a FROM Aspirante a WHERE a.apellidosAspirante = :apellidosAspirante"),
    @NamedQuery(name = "Aspirante.findByFechaAspirante", query = "SELECT a FROM Aspirante a WHERE a.fechaAspirante = :fechaAspirante"),
    @NamedQuery(name = "Aspirante.findByCarreraAspirante", query = "SELECT a FROM Aspirante a WHERE a.carreraAspirante = :carreraAspirante"),
    @NamedQuery(name = "Aspirante.findBySemestreAspirante", query = "SELECT a FROM Aspirante a WHERE a.semestreAspirante = :semestreAspirante"),
    @NamedQuery(name = "Aspirante.findByTelefonoAspirante", query = "SELECT a FROM Aspirante a WHERE a.telefonoAspirante = :telefonoAspirante"),
    @NamedQuery(name = "Aspirante.findByCorreoAspirante", query = "SELECT a FROM Aspirante a WHERE a.correoAspirante = :correoAspirante"),
    @NamedQuery(name = "Aspirante.findByHojadevidaAspirante", query = "SELECT a FROM Aspirante a WHERE a.hojadevidaAspirante = :hojadevidaAspirante")})
public class Aspirante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DOCUMENTO_ASPIRANTE")
    private Integer documentoAspirante;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ASPIRANTE")
    private int idAspirante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "TIPODOCUMENTO_ASPIRANTE")
    private String tipodocumentoAspirante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRES_APITANTE")
    private String nombresApitante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "APELLIDOS_ASPIRANTE")
    private String apellidosAspirante;
    @Column(name = "FECHA_ASPIRANTE")
    @Temporal(TemporalType.DATE)
    private Date fechaAspirante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CARRERA_ASPIRANTE")
    private String carreraAspirante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 22)
    @Column(name = "SEMESTRE_ASPIRANTE")
    private String semestreAspirante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TELEFONO_ASPIRANTE")
    private String telefonoAspirante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "CORREO_ASPIRANTE")
    private String correoAspirante;
    @Size(max = 200)
    @Column(name = "HOJADEVIDA_ASPIRANTE")
    private String hojadevidaAspirante;
    @OneToMany(mappedBy = "documentoAspirante")
    private List<AspiranteOfertaAplicar> aspiranteOfertaAplicarList;

    public Aspirante() {
    }

    public Aspirante(Integer documentoAspirante) {
        this.documentoAspirante = documentoAspirante;
    }

    public Aspirante(Integer documentoAspirante, int idAspirante, String tipodocumentoAspirante, String nombresApitante, String apellidosAspirante, String carreraAspirante, String semestreAspirante, String telefonoAspirante, String correoAspirante) {
        this.documentoAspirante = documentoAspirante;
        this.idAspirante = idAspirante;
        this.tipodocumentoAspirante = tipodocumentoAspirante;
        this.nombresApitante = nombresApitante;
        this.apellidosAspirante = apellidosAspirante;
        this.carreraAspirante = carreraAspirante;
        this.semestreAspirante = semestreAspirante;
        this.telefonoAspirante = telefonoAspirante;
        this.correoAspirante = correoAspirante;
    }

    public Integer getDocumentoAspirante() {
        return documentoAspirante;
    }

    public void setDocumentoAspirante(Integer documentoAspirante) {
        this.documentoAspirante = documentoAspirante;
    }

    public int getIdAspirante() {
        return idAspirante;
    }

    public void setIdAspirante(int idAspirante) {
        this.idAspirante = idAspirante;
    }

    public String getTipodocumentoAspirante() {
        return tipodocumentoAspirante;
    }

    public void setTipodocumentoAspirante(String tipodocumentoAspirante) {
        this.tipodocumentoAspirante = tipodocumentoAspirante;
    }

    public String getNombresApitante() {
        return nombresApitante;
    }

    public void setNombresApitante(String nombresApitante) {
        this.nombresApitante = nombresApitante;
    }

    public String getApellidosAspirante() {
        return apellidosAspirante;
    }

    public void setApellidosAspirante(String apellidosAspirante) {
        this.apellidosAspirante = apellidosAspirante;
    }

    public Date getFechaAspirante() {
        return fechaAspirante;
    }

    public void setFechaAspirante(Date fechaAspirante) {
        this.fechaAspirante = fechaAspirante;
    }

    public String getCarreraAspirante() {
        return carreraAspirante;
    }

    public void setCarreraAspirante(String carreraAspirante) {
        this.carreraAspirante = carreraAspirante;
    }

    public String getSemestreAspirante() {
        return semestreAspirante;
    }

    public void setSemestreAspirante(String semestreAspirante) {
        this.semestreAspirante = semestreAspirante;
    }

    public String getTelefonoAspirante() {
        return telefonoAspirante;
    }

    public void setTelefonoAspirante(String telefonoAspirante) {
        this.telefonoAspirante = telefonoAspirante;
    }

    public String getCorreoAspirante() {
        return correoAspirante;
    }

    public void setCorreoAspirante(String correoAspirante) {
        this.correoAspirante = correoAspirante;
    }

    public String getHojadevidaAspirante() {
        return hojadevidaAspirante;
    }

    public void setHojadevidaAspirante(String hojadevidaAspirante) {
        this.hojadevidaAspirante = hojadevidaAspirante;
    }

    @XmlTransient
    public List<AspiranteOfertaAplicar> getAspiranteOfertaAplicarList() {
        return aspiranteOfertaAplicarList;
    }

    public void setAspiranteOfertaAplicarList(List<AspiranteOfertaAplicar> aspiranteOfertaAplicarList) {
        this.aspiranteOfertaAplicarList = aspiranteOfertaAplicarList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentoAspirante != null ? documentoAspirante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aspirante)) {
            return false;
        }
        Aspirante other = (Aspirante) object;
        if ((this.documentoAspirante == null && other.documentoAspirante != null) || (this.documentoAspirante != null && !this.documentoAspirante.equals(other.documentoAspirante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uts.edu.dae.entidades.Aspirante[ documentoAspirante=" + documentoAspirante + " ]";
    }
    
}
