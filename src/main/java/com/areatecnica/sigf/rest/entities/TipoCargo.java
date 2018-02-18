/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.sigf.rest.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 * @author ianfrancoconcha
 */
@Entity
@Table(name = "tipo_cargo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCargo.findAll", query = "SELECT t FROM TipoCargo t")
    , @NamedQuery(name = "TipoCargo.findByTipoCargoId", query = "SELECT t FROM TipoCargo t WHERE t.tipoCargoId = :tipoCargoId")
    , @NamedQuery(name = "TipoCargo.findByTipoCargoNombre", query = "SELECT t FROM TipoCargo t WHERE t.tipoCargoNombre = :tipoCargoNombre")
    , @NamedQuery(name = "TipoCargo.findByTipoCargoMontoDefecto", query = "SELECT t FROM TipoCargo t WHERE t.tipoCargoMontoDefecto = :tipoCargoMontoDefecto")})
public class TipoCargo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipo_cargo_id")
    private Integer tipoCargoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_cargo_nombre")
    private String tipoCargoNombre;
    @Column(name = "tipo_cargo_monto_defecto")
    private Integer tipoCargoMontoDefecto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cargoBusIdTipo")
    private Collection<CargoBus> cargoBusCollection;
    @JoinColumn(name = "tipo_cargo_id_cuenta", referencedColumnName = "cuenta_id")
    @ManyToOne(optional = false)
    private Cuenta tipoCargoIdCuenta;

    public TipoCargo() {
    }

    public TipoCargo(Integer tipoCargoId) {
        this.tipoCargoId = tipoCargoId;
    }

    public TipoCargo(Integer tipoCargoId, String tipoCargoNombre) {
        this.tipoCargoId = tipoCargoId;
        this.tipoCargoNombre = tipoCargoNombre;
    }

    public Integer getTipoCargoId() {
        return tipoCargoId;
    }

    public void setTipoCargoId(Integer tipoCargoId) {
        this.tipoCargoId = tipoCargoId;
    }

    public String getTipoCargoNombre() {
        return tipoCargoNombre;
    }

    public void setTipoCargoNombre(String tipoCargoNombre) {
        this.tipoCargoNombre = tipoCargoNombre;
    }

    public Integer getTipoCargoMontoDefecto() {
        return tipoCargoMontoDefecto;
    }

    public void setTipoCargoMontoDefecto(Integer tipoCargoMontoDefecto) {
        this.tipoCargoMontoDefecto = tipoCargoMontoDefecto;
    }

    @XmlTransient
    public Collection<CargoBus> getCargoBusCollection() {
        return cargoBusCollection;
    }

    public void setCargoBusCollection(Collection<CargoBus> cargoBusCollection) {
        this.cargoBusCollection = cargoBusCollection;
    }

    public Cuenta getTipoCargoIdCuenta() {
        return tipoCargoIdCuenta;
    }

    public void setTipoCargoIdCuenta(Cuenta tipoCargoIdCuenta) {
        this.tipoCargoIdCuenta = tipoCargoIdCuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoCargoId != null ? tipoCargoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCargo)) {
            return false;
        }
        TipoCargo other = (TipoCargo) object;
        if ((this.tipoCargoId == null && other.tipoCargoId != null) || (this.tipoCargoId != null && !this.tipoCargoId.equals(other.tipoCargoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.sigf.rest.entities.TipoCargo[ tipoCargoId=" + tipoCargoId + " ]";
    }
    
}
