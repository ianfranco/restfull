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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ianfrancoconcha
 */
@Entity
@Table(name = "resumen_recaudacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResumenRecaudacion.findAll", query = "SELECT r FROM ResumenRecaudacion r")
    , @NamedQuery(name = "ResumenRecaudacion.findByResumenRecaudacionId", query = "SELECT r FROM ResumenRecaudacion r WHERE r.resumenRecaudacionId = :resumenRecaudacionId")
    , @NamedQuery(name = "ResumenRecaudacion.findByResumenRecaudacionFecha", query = "SELECT r FROM ResumenRecaudacion r WHERE r.resumenRecaudacionFecha = :resumenRecaudacionFecha")
    , @NamedQuery(name = "ResumenRecaudacion.findByResumenRecaudacionTotal", query = "SELECT r FROM ResumenRecaudacion r WHERE r.resumenRecaudacionTotal = :resumenRecaudacionTotal")
    , @NamedQuery(name = "ResumenRecaudacion.findByResumenRecaudacionTieneTransporte", query = "SELECT r FROM ResumenRecaudacion r WHERE r.resumenRecaudacionTieneTransporte = :resumenRecaudacionTieneTransporte")
    , @NamedQuery(name = "ResumenRecaudacion.findByResumenRecaudacionCerrado", query = "SELECT r FROM ResumenRecaudacion r WHERE r.resumenRecaudacionCerrado = :resumenRecaudacionCerrado")
    , @NamedQuery(name = "ResumenRecaudacion.findByResumenRecaudacionFechaIngreso", query = "SELECT r FROM ResumenRecaudacion r WHERE r.resumenRecaudacionFechaIngreso = :resumenRecaudacionFechaIngreso")
    , @NamedQuery(name = "ResumenRecaudacion.findByResumenRecaudacionFechaActualizacion", query = "SELECT r FROM ResumenRecaudacion r WHERE r.resumenRecaudacionFechaActualizacion = :resumenRecaudacionFechaActualizacion")})
public class ResumenRecaudacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "resumen_recaudacion_id")
    private Integer resumenRecaudacionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "resumen_recaudacion_fecha")
    @Temporal(TemporalType.DATE)
    private Date resumenRecaudacionFecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "resumen_recaudacion_total")
    private int resumenRecaudacionTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "resumen_recaudacion_tiene_transporte")
    private int resumenRecaudacionTieneTransporte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "resumen_recaudacion_cerrado")
    private boolean resumenRecaudacionCerrado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "resumen_recaudacion_fecha_ingreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date resumenRecaudacionFechaIngreso;
    @Column(name = "resumen_recaudacion_fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date resumenRecaudacionFechaActualizacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detalleResumenRecaudacionIdResumen")
    private Collection<DetalleResumenRecaudacion> detalleResumenRecaudacionCollection;
    @JoinColumn(name = "resumen_recaudacion_id_caja", referencedColumnName = "caja_recaudacion_id")
    @ManyToOne(optional = false)
    private CajaRecaudacion resumenRecaudacionIdCaja;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detalleResumenChequeIdResumen")
    private Collection<DetalleResumenCheque> detalleResumenChequeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ctvResumenIdResumenRecaudacion")
    private Collection<CtvResumen> ctvResumenCollection;

    public ResumenRecaudacion() {
    }

    public ResumenRecaudacion(Integer resumenRecaudacionId) {
        this.resumenRecaudacionId = resumenRecaudacionId;
    }

    public ResumenRecaudacion(Integer resumenRecaudacionId, Date resumenRecaudacionFecha, int resumenRecaudacionTotal, int resumenRecaudacionTieneTransporte, boolean resumenRecaudacionCerrado, Date resumenRecaudacionFechaIngreso) {
        this.resumenRecaudacionId = resumenRecaudacionId;
        this.resumenRecaudacionFecha = resumenRecaudacionFecha;
        this.resumenRecaudacionTotal = resumenRecaudacionTotal;
        this.resumenRecaudacionTieneTransporte = resumenRecaudacionTieneTransporte;
        this.resumenRecaudacionCerrado = resumenRecaudacionCerrado;
        this.resumenRecaudacionFechaIngreso = resumenRecaudacionFechaIngreso;
    }

    public Integer getResumenRecaudacionId() {
        return resumenRecaudacionId;
    }

    public void setResumenRecaudacionId(Integer resumenRecaudacionId) {
        this.resumenRecaudacionId = resumenRecaudacionId;
    }

    public Date getResumenRecaudacionFecha() {
        return resumenRecaudacionFecha;
    }

    public void setResumenRecaudacionFecha(Date resumenRecaudacionFecha) {
        this.resumenRecaudacionFecha = resumenRecaudacionFecha;
    }

    public int getResumenRecaudacionTotal() {
        return resumenRecaudacionTotal;
    }

    public void setResumenRecaudacionTotal(int resumenRecaudacionTotal) {
        this.resumenRecaudacionTotal = resumenRecaudacionTotal;
    }

    public int getResumenRecaudacionTieneTransporte() {
        return resumenRecaudacionTieneTransporte;
    }

    public void setResumenRecaudacionTieneTransporte(int resumenRecaudacionTieneTransporte) {
        this.resumenRecaudacionTieneTransporte = resumenRecaudacionTieneTransporte;
    }

    public boolean getResumenRecaudacionCerrado() {
        return resumenRecaudacionCerrado;
    }

    public void setResumenRecaudacionCerrado(boolean resumenRecaudacionCerrado) {
        this.resumenRecaudacionCerrado = resumenRecaudacionCerrado;
    }

    public Date getResumenRecaudacionFechaIngreso() {
        return resumenRecaudacionFechaIngreso;
    }

    public void setResumenRecaudacionFechaIngreso(Date resumenRecaudacionFechaIngreso) {
        this.resumenRecaudacionFechaIngreso = resumenRecaudacionFechaIngreso;
    }

    public Date getResumenRecaudacionFechaActualizacion() {
        return resumenRecaudacionFechaActualizacion;
    }

    public void setResumenRecaudacionFechaActualizacion(Date resumenRecaudacionFechaActualizacion) {
        this.resumenRecaudacionFechaActualizacion = resumenRecaudacionFechaActualizacion;
    }

    @XmlTransient
    public Collection<DetalleResumenRecaudacion> getDetalleResumenRecaudacionCollection() {
        return detalleResumenRecaudacionCollection;
    }

    public void setDetalleResumenRecaudacionCollection(Collection<DetalleResumenRecaudacion> detalleResumenRecaudacionCollection) {
        this.detalleResumenRecaudacionCollection = detalleResumenRecaudacionCollection;
    }

    public CajaRecaudacion getResumenRecaudacionIdCaja() {
        return resumenRecaudacionIdCaja;
    }

    public void setResumenRecaudacionIdCaja(CajaRecaudacion resumenRecaudacionIdCaja) {
        this.resumenRecaudacionIdCaja = resumenRecaudacionIdCaja;
    }

    @XmlTransient
    public Collection<DetalleResumenCheque> getDetalleResumenChequeCollection() {
        return detalleResumenChequeCollection;
    }

    public void setDetalleResumenChequeCollection(Collection<DetalleResumenCheque> detalleResumenChequeCollection) {
        this.detalleResumenChequeCollection = detalleResumenChequeCollection;
    }

    @XmlTransient
    public Collection<CtvResumen> getCtvResumenCollection() {
        return ctvResumenCollection;
    }

    public void setCtvResumenCollection(Collection<CtvResumen> ctvResumenCollection) {
        this.ctvResumenCollection = ctvResumenCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resumenRecaudacionId != null ? resumenRecaudacionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResumenRecaudacion)) {
            return false;
        }
        ResumenRecaudacion other = (ResumenRecaudacion) object;
        if ((this.resumenRecaudacionId == null && other.resumenRecaudacionId != null) || (this.resumenRecaudacionId != null && !this.resumenRecaudacionId.equals(other.resumenRecaudacionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.sigf.rest.entities.ResumenRecaudacion[ resumenRecaudacionId=" + resumenRecaudacionId + " ]";
    }
    
}
