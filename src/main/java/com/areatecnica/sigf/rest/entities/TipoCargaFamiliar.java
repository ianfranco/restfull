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
@Table(name = "tipo_carga_familiar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCargaFamiliar.findAll", query = "SELECT t FROM TipoCargaFamiliar t")
    , @NamedQuery(name = "TipoCargaFamiliar.findByTipoCargaFamiliarId", query = "SELECT t FROM TipoCargaFamiliar t WHERE t.tipoCargaFamiliarId = :tipoCargaFamiliarId")
    , @NamedQuery(name = "TipoCargaFamiliar.findByTipoCargaFamiliarNombre", query = "SELECT t FROM TipoCargaFamiliar t WHERE t.tipoCargaFamiliarNombre = :tipoCargaFamiliarNombre")})
public class TipoCargaFamiliar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipo_carga_familiar_id")
    private Integer tipoCargaFamiliarId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_carga_familiar_nombre")
    private String tipoCargaFamiliarNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cargaTrabajadorIdTipo")
    private Collection<CargaTrabajador> cargaTrabajadorCollection;

    public TipoCargaFamiliar() {
    }

    public TipoCargaFamiliar(Integer tipoCargaFamiliarId) {
        this.tipoCargaFamiliarId = tipoCargaFamiliarId;
    }

    public TipoCargaFamiliar(Integer tipoCargaFamiliarId, String tipoCargaFamiliarNombre) {
        this.tipoCargaFamiliarId = tipoCargaFamiliarId;
        this.tipoCargaFamiliarNombre = tipoCargaFamiliarNombre;
    }

    public Integer getTipoCargaFamiliarId() {
        return tipoCargaFamiliarId;
    }

    public void setTipoCargaFamiliarId(Integer tipoCargaFamiliarId) {
        this.tipoCargaFamiliarId = tipoCargaFamiliarId;
    }

    public String getTipoCargaFamiliarNombre() {
        return tipoCargaFamiliarNombre;
    }

    public void setTipoCargaFamiliarNombre(String tipoCargaFamiliarNombre) {
        this.tipoCargaFamiliarNombre = tipoCargaFamiliarNombre;
    }

    @XmlTransient
    public Collection<CargaTrabajador> getCargaTrabajadorCollection() {
        return cargaTrabajadorCollection;
    }

    public void setCargaTrabajadorCollection(Collection<CargaTrabajador> cargaTrabajadorCollection) {
        this.cargaTrabajadorCollection = cargaTrabajadorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoCargaFamiliarId != null ? tipoCargaFamiliarId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCargaFamiliar)) {
            return false;
        }
        TipoCargaFamiliar other = (TipoCargaFamiliar) object;
        if ((this.tipoCargaFamiliarId == null && other.tipoCargaFamiliarId != null) || (this.tipoCargaFamiliarId != null && !this.tipoCargaFamiliarId.equals(other.tipoCargaFamiliarId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.sigf.rest.entities.TipoCargaFamiliar[ tipoCargaFamiliarId=" + tipoCargaFamiliarId + " ]";
    }
    
}
