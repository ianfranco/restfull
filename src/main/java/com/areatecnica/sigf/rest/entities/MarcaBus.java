/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.sigf.rest.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ianfrancoconcha
 */
@Entity
@Table(name = "marca_bus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MarcaBus.findAll", query = "SELECT m FROM MarcaBus m")
    , @NamedQuery(name = "MarcaBus.findByMarcaBusId", query = "SELECT m FROM MarcaBus m WHERE m.marcaBusId = :marcaBusId")
    , @NamedQuery(name = "MarcaBus.findByMarcaBusNombre", query = "SELECT m FROM MarcaBus m WHERE m.marcaBusNombre = :marcaBusNombre")
    , @NamedQuery(name = "MarcaBus.findByMarcaBusFechaIngreso", query = "SELECT m FROM MarcaBus m WHERE m.marcaBusFechaIngreso = :marcaBusFechaIngreso")})
public class MarcaBus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "marca_bus_id")
    private Integer marcaBusId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "marca_bus_nombre")
    private String marcaBusNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "marca_bus_fecha_ingreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date marcaBusFechaIngreso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modeloMarcaBusIdMarca")
    private Collection<ModeloMarcaBus> modeloMarcaBusCollection;

    public MarcaBus() {
    }

    public MarcaBus(Integer marcaBusId) {
        this.marcaBusId = marcaBusId;
    }

    public MarcaBus(Integer marcaBusId, String marcaBusNombre, Date marcaBusFechaIngreso) {
        this.marcaBusId = marcaBusId;
        this.marcaBusNombre = marcaBusNombre;
        this.marcaBusFechaIngreso = marcaBusFechaIngreso;
    }

    public Integer getMarcaBusId() {
        return marcaBusId;
    }

    public void setMarcaBusId(Integer marcaBusId) {
        this.marcaBusId = marcaBusId;
    }

    public String getMarcaBusNombre() {
        return marcaBusNombre;
    }

    public void setMarcaBusNombre(String marcaBusNombre) {
        this.marcaBusNombre = marcaBusNombre;
    }

    public Date getMarcaBusFechaIngreso() {
        return marcaBusFechaIngreso;
    }

    public void setMarcaBusFechaIngreso(Date marcaBusFechaIngreso) {
        this.marcaBusFechaIngreso = marcaBusFechaIngreso;
    }

    @XmlTransient
    public Collection<ModeloMarcaBus> getModeloMarcaBusCollection() {
        return modeloMarcaBusCollection;
    }

    public void setModeloMarcaBusCollection(Collection<ModeloMarcaBus> modeloMarcaBusCollection) {
        this.modeloMarcaBusCollection = modeloMarcaBusCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (marcaBusId != null ? marcaBusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MarcaBus)) {
            return false;
        }
        MarcaBus other = (MarcaBus) object;
        if ((this.marcaBusId == null && other.marcaBusId != null) || (this.marcaBusId != null && !this.marcaBusId.equals(other.marcaBusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.sigf.rest.entities.MarcaBus[ marcaBusId=" + marcaBusId + " ]";
    }
    
}
