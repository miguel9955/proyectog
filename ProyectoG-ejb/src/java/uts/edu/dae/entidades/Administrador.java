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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "ADMINISTRADOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrador.findAll", query = "SELECT a FROM Administrador a"),
    @NamedQuery(name = "Administrador.findByDocumentoAdministrador", query = "SELECT a FROM Administrador a WHERE a.documentoAdministrador = :documentoAdministrador"),
    @NamedQuery(name = "Administrador.findByIdAdministrador", query = "SELECT a FROM Administrador a WHERE a.idAdministrador = :idAdministrador"),
    @NamedQuery(name = "Administrador.findByTipodocumentoAdministrador", query = "SELECT a FROM Administrador a WHERE a.tipodocumentoAdministrador = :tipodocumentoAdministrador"),
    @NamedQuery(name = "Administrador.findByNombreAdministrador", query = "SELECT a FROM Administrador a WHERE a.nombreAdministrador = :nombreAdministrador"),
    @NamedQuery(name = "Administrador.findByApellidoAdministrador", query = "SELECT a FROM Administrador a WHERE a.apellidoAdministrador = :apellidoAdministrador"),
    @NamedQuery(name = "Administrador.findByCorreoAdministrador", query = "SELECT a FROM Administrador a WHERE a.correoAdministrador = :correoAdministrador"),
    @NamedQuery(name = "Administrador.findByTelefonoAdministrador", query = "SELECT a FROM Administrador a WHERE a.telefonoAdministrador = :telefonoAdministrador")})
public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DOCUMENTO_ADMINISTRADOR")
    private Integer documentoAdministrador;
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Basic(optional = false)
    @Column(name = "ID_ADMINISTRADOR")
    private int idAdministrador;
    @Size(max = 4)
    @Column(name = "TIPODOCUMENTO_ADMINISTRADOR")
    private String tipodocumentoAdministrador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE_ADMINISTRADOR")
    private String nombreAdministrador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "APELLIDO_ADMINISTRADOR")
    private String apellidoAdministrador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CORREO_ADMINISTRADOR")
    private String correoAdministrador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TELEFONO_ADMINISTRADOR")
    private String telefonoAdministrador;

    public Administrador() {
    }

    public Administrador(Integer documentoAdministrador) {
        this.documentoAdministrador = documentoAdministrador;
    }

    public Administrador(Integer documentoAdministrador, int idAdministrador, String nombreAdministrador, String apellidoAdministrador, String correoAdministrador, String telefonoAdministrador) {
        this.documentoAdministrador = documentoAdministrador;
        this.idAdministrador = idAdministrador;
        this.nombreAdministrador = nombreAdministrador;
        this.apellidoAdministrador = apellidoAdministrador;
        this.correoAdministrador = correoAdministrador;
        this.telefonoAdministrador = telefonoAdministrador;
    }

    public Integer getDocumentoAdministrador() {
        return documentoAdministrador;
    }

    public void setDocumentoAdministrador(Integer documentoAdministrador) {
        this.documentoAdministrador = documentoAdministrador;
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getTipodocumentoAdministrador() {
        return tipodocumentoAdministrador;
    }

    public void setTipodocumentoAdministrador(String tipodocumentoAdministrador) {
        this.tipodocumentoAdministrador = tipodocumentoAdministrador;
    }

    public String getNombreAdministrador() {
        return nombreAdministrador;
    }

    public void setNombreAdministrador(String nombreAdministrador) {
        this.nombreAdministrador = nombreAdministrador;
    }

    public String getApellidoAdministrador() {
        return apellidoAdministrador;
    }

    public void setApellidoAdministrador(String apellidoAdministrador) {
        this.apellidoAdministrador = apellidoAdministrador;
    }

    public String getCorreoAdministrador() {
        return correoAdministrador;
    }

    public void setCorreoAdministrador(String correoAdministrador) {
        this.correoAdministrador = correoAdministrador;
    }

    public String getTelefonoAdministrador() {
        return telefonoAdministrador;
    }

    public void setTelefonoAdministrador(String telefonoAdministrador) {
        this.telefonoAdministrador = telefonoAdministrador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentoAdministrador != null ? documentoAdministrador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrador)) {
            return false;
        }
        Administrador other = (Administrador) object;
        if ((this.documentoAdministrador == null && other.documentoAdministrador != null) || (this.documentoAdministrador != null && !this.documentoAdministrador.equals(other.documentoAdministrador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uts.edu.dae.entidades.Administrador[ documentoAdministrador=" + documentoAdministrador + " ]";
    }

}
