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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ianfrancoconcha
 */
@Entity
@Table(name = "descuento_extra_bus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DescuentoExtraBus.findAll", query = "SELECT d FROM DescuentoExtraBus d")
    , @NamedQuery(name = "DescuentoExtraBus.findByDescuentoExtraBusId", query = "SELECT d FROM DescuentoExtraBus d WHERE d.descuentoExtraBusId = :descuentoExtraBusId")
    , @NamedQuery(name = "DescuentoExtraBus.findByDescuentoExtraBusMonto", query = "SELECT d FROM DescuentoExtraBus d WHERE d.descuentoExtraBusMonto = :descuentoExtraBusMonto")
    , @NamedQuery(name = "DescuentoExtraBus.findByDescuentoExtraBusRecaudado", query = "SELECT d FROM DescuentoExtraBus d WHERE d.descuentoExtraBusRecaudado = :descuentoExtraBusRecaudado")})
public class DescuentoExtraBus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "descuento_extra_bus_id")
    private Integer descuentoExtraBusId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "descuento_extra_bus_monto")
    private int descuentoExtraBusMonto;
    @Column(name = "descuento_extra_bus_recaudado")
    private Boolean descuentoExtraBusRecaudado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recaudacionDescuentoExtraIdDcto")
    private Collection<RecaudacionDescuentoExtra> recaudacionDescuentoExtraCollection;
    @JoinColumn(name = "descuento_extra_bus_id_bus", referencedColumnName = "bus_id")
    @ManyToOne(optional = false)
    private Bus descuentoExtraBusIdBus;
    @JoinColumn(name = "descuento_extra_bus_id_descuento", referencedColumnName = "descuento_extra_id")
    @ManyToOne(optional = false)
    private DescuentoExtra descuentoExtraBusIdDescuento;

    public DescuentoExtraBus() {
    }

    public DescuentoExtraBus(Integer descuentoExtraBusId) {
        this.descuentoExtraBusId = descuentoExtraBusId;
    }

    public DescuentoExtraBus(Integer descuentoExtraBusId, int descuentoExtraBusMonto) {
        this.descuentoExtraBusId = descuentoExtraBusId;
        this.descuentoExtraBusMonto = descuentoExtraBusMonto;
    }

    public Integer getDescuentoExtraBusId() {
        return descuentoExtraBusId;
    }

    public void setDescuentoExtraBusId(Integer descuentoExtraBusId) {
        this.descuentoExtraBusId = descuentoExtraBusId;
    }

    public int getDescuentoExtraBusMonto() {
        return descuentoExtraBusMonto;
    }

    public void setDescuentoExtraBusMonto(int descuentoExtraBusMonto) {
        this.descuentoExtraBusMonto = descuentoExtraBusMonto;
    }

    public Boolean getDescuentoExtraBusRecaudado() {
        return descuentoExtraBusRecaudado;
    }

    public void setDescuentoExtraBusRecaudado(Boolean descuentoExtraBusRecaudado) {
        this.descuentoExtraBusRecaudado = descuentoExtraBusRecaudado;
    }

    @XmlTransient
    public Collection<RecaudacionDescuentoExtra> getRecaudacionDescuentoExtraCollection() {
        return recaudacionDescuentoExtraCollection;
    }

    public void setRecaudacionDescuentoExtraCollection(Collection<RecaudacionDescuentoExtra> recaudacionDescuentoExtraCollection) {
        this.recaudacionDescuentoExtraCollection = recaudacionDescuentoExtraCollection;
    }

    public Bus getDescuentoExtraBusIdBus() {
        return descuentoExtraBusIdBus;
    }

    public void setDescuentoExtraBusIdBus(Bus descuentoExtraBusIdBus) {
        this.descuentoExtraBusIdBus = descuentoExtraBusIdBus;
    }

    public DescuentoExtra getDescuentoExtraBusIdDescuento() {
        return descuentoExtraBusIdDescuento;
    }

    public void setDescuentoExtraBusIdDescuento(DescuentoExtra descuentoExtraBusIdDescuento) {
        this.descuentoExtraBusIdDescuento = descuentoExtraBusIdDescuento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (descuentoExtraBusId != null ? descuentoExtraBusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DescuentoExtraBus)) {
            return false;
        }
        DescuentoExtraBus other = (DescuentoExtraBus) object;
        if ((this.descuentoExtraBusId == null && other.descuentoExtraBusId != null) || (this.descuentoExtraBusId != null && !this.descuentoExtraBusId.equals(other.descuentoExtraBusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.sigf.rest.entities.DescuentoExtraBus[ descuentoExtraBusId=" + descuentoExtraBusId + " ]";
    }
    
}
