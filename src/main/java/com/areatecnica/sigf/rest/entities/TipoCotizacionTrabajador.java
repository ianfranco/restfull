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
@Table(name = "tipo_cotizacion_trabajador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCotizacionTrabajador.findAll", query = "SELECT t FROM TipoCotizacionTrabajador t")
    , @NamedQuery(name = "TipoCotizacionTrabajador.findByTipoCotizacionTrabajadorId", query = "SELECT t FROM TipoCotizacionTrabajador t WHERE t.tipoCotizacionTrabajadorId = :tipoCotizacionTrabajadorId")
    , @NamedQuery(name = "TipoCotizacionTrabajador.findByTipoCotizacionTrabajadorNombre", query = "SELECT t FROM TipoCotizacionTrabajador t WHERE t.tipoCotizacionTrabajadorNombre = :tipoCotizacionTrabajadorNombre")})
public class TipoCotizacionTrabajador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipo_cotizacion_trabajador_id")
    private Integer tipoCotizacionTrabajadorId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tipo_cotizacion_trabajador_nombre")
    private String tipoCotizacionTrabajadorNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trabajadorIdTipoCotizacionTrabajador")
    private Collection<Trabajador> trabajadorCollection;

    public TipoCotizacionTrabajador() {
    }

    public TipoCotizacionTrabajador(Integer tipoCotizacionTrabajadorId) {
        this.tipoCotizacionTrabajadorId = tipoCotizacionTrabajadorId;
    }

    public TipoCotizacionTrabajador(Integer tipoCotizacionTrabajadorId, String tipoCotizacionTrabajadorNombre) {
        this.tipoCotizacionTrabajadorId = tipoCotizacionTrabajadorId;
        this.tipoCotizacionTrabajadorNombre = tipoCotizacionTrabajadorNombre;
    }

    public Integer getTipoCotizacionTrabajadorId() {
        return tipoCotizacionTrabajadorId;
    }

    public void setTipoCotizacionTrabajadorId(Integer tipoCotizacionTrabajadorId) {
        this.tipoCotizacionTrabajadorId = tipoCotizacionTrabajadorId;
    }

    public String getTipoCotizacionTrabajadorNombre() {
        return tipoCotizacionTrabajadorNombre;
    }

    public void setTipoCotizacionTrabajadorNombre(String tipoCotizacionTrabajadorNombre) {
        this.tipoCotizacionTrabajadorNombre = tipoCotizacionTrabajadorNombre;
    }

    @XmlTransient
    public Collection<Trabajador> getTrabajadorCollection() {
        return trabajadorCollection;
    }

    public void setTrabajadorCollection(Collection<Trabajador> trabajadorCollection) {
        this.trabajadorCollection = trabajadorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoCotizacionTrabajadorId != null ? tipoCotizacionTrabajadorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCotizacionTrabajador)) {
            return false;
        }
        TipoCotizacionTrabajador other = (TipoCotizacionTrabajador) object;
        if ((this.tipoCotizacionTrabajadorId == null && other.tipoCotizacionTrabajadorId != null) || (this.tipoCotizacionTrabajadorId != null && !this.tipoCotizacionTrabajadorId.equals(other.tipoCotizacionTrabajadorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.sigf.rest.entities.TipoCotizacionTrabajador[ tipoCotizacionTrabajadorId=" + tipoCotizacionTrabajadorId + " ]";
    }
    
}
