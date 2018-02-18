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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ianfrancoconcha
 */
@Entity
@Table(name = "proceso_recaudacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcesoRecaudacion.findAll", query = "SELECT p FROM ProcesoRecaudacion p")
    , @NamedQuery(name = "ProcesoRecaudacion.findByProcesoRecaudacionId", query = "SELECT p FROM ProcesoRecaudacion p WHERE p.procesoRecaudacionId = :procesoRecaudacionId")
    , @NamedQuery(name = "ProcesoRecaudacion.findByProcesoRecaudacionNombre", query = "SELECT p FROM ProcesoRecaudacion p WHERE p.procesoRecaudacionNombre = :procesoRecaudacionNombre")
    , @NamedQuery(name = "ProcesoRecaudacion.findByProcesoRecaudacionTieneCuenta", query = "SELECT p FROM ProcesoRecaudacion p WHERE p.procesoRecaudacionTieneCuenta = :procesoRecaudacionTieneCuenta")
    , @NamedQuery(name = "ProcesoRecaudacion.findByProcesoRecaudacionTieneEgresos", query = "SELECT p FROM ProcesoRecaudacion p WHERE p.procesoRecaudacionTieneEgresos = :procesoRecaudacionTieneEgresos")
    , @NamedQuery(name = "ProcesoRecaudacion.findByProcesoRecaudacionActivo", query = "SELECT p FROM ProcesoRecaudacion p WHERE p.procesoRecaudacionActivo = :procesoRecaudacionActivo")
    , @NamedQuery(name = "ProcesoRecaudacion.findByProcesoRecaudacionFechaIngreso", query = "SELECT p FROM ProcesoRecaudacion p WHERE p.procesoRecaudacionFechaIngreso = :procesoRecaudacionFechaIngreso")})
public class ProcesoRecaudacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "proceso_recaudacion_id")
    private Integer procesoRecaudacionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "proceso_recaudacion_nombre")
    private String procesoRecaudacionNombre;
    @Column(name = "proceso_recaudacion_tiene_cuenta")
    private Short procesoRecaudacionTieneCuenta;
    @Column(name = "proceso_recaudacion_tiene_egresos")
    private Boolean procesoRecaudacionTieneEgresos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "proceso_recaudacion_activo")
    private boolean procesoRecaudacionActivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "proceso_recaudacion_fecha_ingreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date procesoRecaudacionFechaIngreso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuentaBancoProcesoIdProceso")
    private Collection<CuentaBancoProceso> cuentaBancoProcesoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "busIdProcesoRecaudacion")
    private Collection<Bus> busCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "egresoProcesoRecaudacionIdProceso")
    private Collection<EgresoProcesoRecaudacion> egresoProcesoRecaudacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cajaProcesoIdProceso")
    private Collection<CajaProceso> cajaProcesoCollection;
    @JoinColumn(name = "proceso_recaudacion_id_cuenta", referencedColumnName = "cuenta_id")
    @ManyToOne(optional = false)
    private Cuenta procesoRecaudacionIdCuenta;

    public ProcesoRecaudacion() {
    }

    public ProcesoRecaudacion(Integer procesoRecaudacionId) {
        this.procesoRecaudacionId = procesoRecaudacionId;
    }

    public ProcesoRecaudacion(Integer procesoRecaudacionId, String procesoRecaudacionNombre, boolean procesoRecaudacionActivo, Date procesoRecaudacionFechaIngreso) {
        this.procesoRecaudacionId = procesoRecaudacionId;
        this.procesoRecaudacionNombre = procesoRecaudacionNombre;
        this.procesoRecaudacionActivo = procesoRecaudacionActivo;
        this.procesoRecaudacionFechaIngreso = procesoRecaudacionFechaIngreso;
    }

    public Integer getProcesoRecaudacionId() {
        return procesoRecaudacionId;
    }

    public void setProcesoRecaudacionId(Integer procesoRecaudacionId) {
        this.procesoRecaudacionId = procesoRecaudacionId;
    }

    public String getProcesoRecaudacionNombre() {
        return procesoRecaudacionNombre;
    }

    public void setProcesoRecaudacionNombre(String procesoRecaudacionNombre) {
        this.procesoRecaudacionNombre = procesoRecaudacionNombre;
    }

    public Short getProcesoRecaudacionTieneCuenta() {
        return procesoRecaudacionTieneCuenta;
    }

    public void setProcesoRecaudacionTieneCuenta(Short procesoRecaudacionTieneCuenta) {
        this.procesoRecaudacionTieneCuenta = procesoRecaudacionTieneCuenta;
    }

    public Boolean getProcesoRecaudacionTieneEgresos() {
        return procesoRecaudacionTieneEgresos;
    }

    public void setProcesoRecaudacionTieneEgresos(Boolean procesoRecaudacionTieneEgresos) {
        this.procesoRecaudacionTieneEgresos = procesoRecaudacionTieneEgresos;
    }

    public boolean getProcesoRecaudacionActivo() {
        return procesoRecaudacionActivo;
    }

    public void setProcesoRecaudacionActivo(boolean procesoRecaudacionActivo) {
        this.procesoRecaudacionActivo = procesoRecaudacionActivo;
    }

    public Date getProcesoRecaudacionFechaIngreso() {
        return procesoRecaudacionFechaIngreso;
    }

    public void setProcesoRecaudacionFechaIngreso(Date procesoRecaudacionFechaIngreso) {
        this.procesoRecaudacionFechaIngreso = procesoRecaudacionFechaIngreso;
    }

    @XmlTransient
    public Collection<CuentaBancoProceso> getCuentaBancoProcesoCollection() {
        return cuentaBancoProcesoCollection;
    }

    public void setCuentaBancoProcesoCollection(Collection<CuentaBancoProceso> cuentaBancoProcesoCollection) {
        this.cuentaBancoProcesoCollection = cuentaBancoProcesoCollection;
    }

    @XmlTransient
    public Collection<Bus> getBusCollection() {
        return busCollection;
    }

    public void setBusCollection(Collection<Bus> busCollection) {
        this.busCollection = busCollection;
    }

    @XmlTransient
    public Collection<EgresoProcesoRecaudacion> getEgresoProcesoRecaudacionCollection() {
        return egresoProcesoRecaudacionCollection;
    }

    public void setEgresoProcesoRecaudacionCollection(Collection<EgresoProcesoRecaudacion> egresoProcesoRecaudacionCollection) {
        this.egresoProcesoRecaudacionCollection = egresoProcesoRecaudacionCollection;
    }

    @XmlTransient
    public Collection<CajaProceso> getCajaProcesoCollection() {
        return cajaProcesoCollection;
    }

    public void setCajaProcesoCollection(Collection<CajaProceso> cajaProcesoCollection) {
        this.cajaProcesoCollection = cajaProcesoCollection;
    }

    public Cuenta getProcesoRecaudacionIdCuenta() {
        return procesoRecaudacionIdCuenta;
    }

    public void setProcesoRecaudacionIdCuenta(Cuenta procesoRecaudacionIdCuenta) {
        this.procesoRecaudacionIdCuenta = procesoRecaudacionIdCuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (procesoRecaudacionId != null ? procesoRecaudacionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcesoRecaudacion)) {
            return false;
        }
        ProcesoRecaudacion other = (ProcesoRecaudacion) object;
        if ((this.procesoRecaudacionId == null && other.procesoRecaudacionId != null) || (this.procesoRecaudacionId != null && !this.procesoRecaudacionId.equals(other.procesoRecaudacionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.sigf.rest.entities.ProcesoRecaudacion[ procesoRecaudacionId=" + procesoRecaudacionId + " ]";
    }
    
}
