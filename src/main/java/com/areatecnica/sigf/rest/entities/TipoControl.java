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
@Table(name = "tipo_control")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoControl.findAll", query = "SELECT t FROM TipoControl t")
    , @NamedQuery(name = "TipoControl.findByTipoControlId", query = "SELECT t FROM TipoControl t WHERE t.tipoControlId = :tipoControlId")
    , @NamedQuery(name = "TipoControl.findByTipoControlNombre", query = "SELECT t FROM TipoControl t WHERE t.tipoControlNombre = :tipoControlNombre")
    , @NamedQuery(name = "TipoControl.findByTipoControlClasificacion", query = "SELECT t FROM TipoControl t WHERE t.tipoControlClasificacion = :tipoControlClasificacion")})
public class TipoControl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipo_control_id")
    private Integer tipoControlId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_control_nombre")
    private String tipoControlNombre;
    @Size(max = 45)
    @Column(name = "tipo_control_clasificacion")
    private String tipoControlClasificacion;
    @JoinColumn(name = "tipo_control_id_cuenta", referencedColumnName = "cuenta_id")
    @ManyToOne(optional = false)
    private Cuenta tipoControlIdCuenta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "controlIdTipo")
    private Collection<Control> controlCollection;

    public TipoControl() {
    }

    public TipoControl(Integer tipoControlId) {
        this.tipoControlId = tipoControlId;
    }

    public TipoControl(Integer tipoControlId, String tipoControlNombre) {
        this.tipoControlId = tipoControlId;
        this.tipoControlNombre = tipoControlNombre;
    }

    public Integer getTipoControlId() {
        return tipoControlId;
    }

    public void setTipoControlId(Integer tipoControlId) {
        this.tipoControlId = tipoControlId;
    }

    public String getTipoControlNombre() {
        return tipoControlNombre;
    }

    public void setTipoControlNombre(String tipoControlNombre) {
        this.tipoControlNombre = tipoControlNombre;
    }

    public String getTipoControlClasificacion() {
        return tipoControlClasificacion;
    }

    public void setTipoControlClasificacion(String tipoControlClasificacion) {
        this.tipoControlClasificacion = tipoControlClasificacion;
    }

    public Cuenta getTipoControlIdCuenta() {
        return tipoControlIdCuenta;
    }

    public void setTipoControlIdCuenta(Cuenta tipoControlIdCuenta) {
        this.tipoControlIdCuenta = tipoControlIdCuenta;
    }

    @XmlTransient
    public Collection<Control> getControlCollection() {
        return controlCollection;
    }

    public void setControlCollection(Collection<Control> controlCollection) {
        this.controlCollection = controlCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoControlId != null ? tipoControlId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoControl)) {
            return false;
        }
        TipoControl other = (TipoControl) object;
        if ((this.tipoControlId == null && other.tipoControlId != null) || (this.tipoControlId != null && !this.tipoControlId.equals(other.tipoControlId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.sigf.rest.entities.TipoControl[ tipoControlId=" + tipoControlId + " ]";
    }
    
}
