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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "descuento_extra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DescuentoExtra.findAll", query = "SELECT d FROM DescuentoExtra d")
    , @NamedQuery(name = "DescuentoExtra.findByDescuentoExtraId", query = "SELECT d FROM DescuentoExtra d WHERE d.descuentoExtraId = :descuentoExtraId")
    , @NamedQuery(name = "DescuentoExtra.findByDescuentoExtraFecha", query = "SELECT d FROM DescuentoExtra d WHERE d.descuentoExtraFecha = :descuentoExtraFecha")
    , @NamedQuery(name = "DescuentoExtra.findByDescuentoExtraMonto", query = "SELECT d FROM DescuentoExtra d WHERE d.descuentoExtraMonto = :descuentoExtraMonto")})
public class DescuentoExtra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "descuento_extra_id")
    private Integer descuentoExtraId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "descuento_extra_descripcion")
    private String descuentoExtraDescripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "descuento_extra_fecha")
    @Temporal(TemporalType.DATE)
    private Date descuentoExtraFecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "descuento_extra_monto")
    private int descuentoExtraMonto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "descuentoExtraBusIdDescuento")
    private Collection<DescuentoExtraBus> descuentoExtraBusCollection;
    @JoinColumn(name = "descuento_extra_id_cuenta", referencedColumnName = "cuenta_id")
    @ManyToOne(optional = false)
    private Cuenta descuentoExtraIdCuenta;

    public DescuentoExtra() {
    }

    public DescuentoExtra(Integer descuentoExtraId) {
        this.descuentoExtraId = descuentoExtraId;
    }

    public DescuentoExtra(Integer descuentoExtraId, String descuentoExtraDescripcion, Date descuentoExtraFecha, int descuentoExtraMonto) {
        this.descuentoExtraId = descuentoExtraId;
        this.descuentoExtraDescripcion = descuentoExtraDescripcion;
        this.descuentoExtraFecha = descuentoExtraFecha;
        this.descuentoExtraMonto = descuentoExtraMonto;
    }

    public Integer getDescuentoExtraId() {
        return descuentoExtraId;
    }

    public void setDescuentoExtraId(Integer descuentoExtraId) {
        this.descuentoExtraId = descuentoExtraId;
    }

    public String getDescuentoExtraDescripcion() {
        return descuentoExtraDescripcion;
    }

    public void setDescuentoExtraDescripcion(String descuentoExtraDescripcion) {
        this.descuentoExtraDescripcion = descuentoExtraDescripcion;
    }

    public Date getDescuentoExtraFecha() {
        return descuentoExtraFecha;
    }

    public void setDescuentoExtraFecha(Date descuentoExtraFecha) {
        this.descuentoExtraFecha = descuentoExtraFecha;
    }

    public int getDescuentoExtraMonto() {
        return descuentoExtraMonto;
    }

    public void setDescuentoExtraMonto(int descuentoExtraMonto) {
        this.descuentoExtraMonto = descuentoExtraMonto;
    }

    @XmlTransient
    public Collection<DescuentoExtraBus> getDescuentoExtraBusCollection() {
        return descuentoExtraBusCollection;
    }

    public void setDescuentoExtraBusCollection(Collection<DescuentoExtraBus> descuentoExtraBusCollection) {
        this.descuentoExtraBusCollection = descuentoExtraBusCollection;
    }

    public Cuenta getDescuentoExtraIdCuenta() {
        return descuentoExtraIdCuenta;
    }

    public void setDescuentoExtraIdCuenta(Cuenta descuentoExtraIdCuenta) {
        this.descuentoExtraIdCuenta = descuentoExtraIdCuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (descuentoExtraId != null ? descuentoExtraId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DescuentoExtra)) {
            return false;
        }
        DescuentoExtra other = (DescuentoExtra) object;
        if ((this.descuentoExtraId == null && other.descuentoExtraId != null) || (this.descuentoExtraId != null && !this.descuentoExtraId.equals(other.descuentoExtraId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.sigf.rest.entities.DescuentoExtra[ descuentoExtraId=" + descuentoExtraId + " ]";
    }
    
}
