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
@Table(name = "caja_recaudacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CajaRecaudacion.findAll", query = "SELECT c FROM CajaRecaudacion c")
    , @NamedQuery(name = "CajaRecaudacion.findByCajaRecaudacionId", query = "SELECT c FROM CajaRecaudacion c WHERE c.cajaRecaudacionId = :cajaRecaudacionId")
    , @NamedQuery(name = "CajaRecaudacion.findByCajaRecaudacionNombre", query = "SELECT c FROM CajaRecaudacion c WHERE c.cajaRecaudacionNombre = :cajaRecaudacionNombre")
    , @NamedQuery(name = "CajaRecaudacion.findByCajaRecaudacionTieneEgresos", query = "SELECT c FROM CajaRecaudacion c WHERE c.cajaRecaudacionTieneEgresos = :cajaRecaudacionTieneEgresos")
    , @NamedQuery(name = "CajaRecaudacion.findByCajaRecaudacionActiva", query = "SELECT c FROM CajaRecaudacion c WHERE c.cajaRecaudacionActiva = :cajaRecaudacionActiva")
    , @NamedQuery(name = "CajaRecaudacion.findByCajaRecaudacionFechaIngreso", query = "SELECT c FROM CajaRecaudacion c WHERE c.cajaRecaudacionFechaIngreso = :cajaRecaudacionFechaIngreso")})
public class CajaRecaudacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "caja_recaudacion_id")
    private Integer cajaRecaudacionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "caja_recaudacion_nombre")
    private String cajaRecaudacionNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "caja_recaudacion_tiene_egresos")
    private boolean cajaRecaudacionTieneEgresos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "caja_recaudacion_activa")
    private boolean cajaRecaudacionActiva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "caja_recaudacion_fecha_ingreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cajaRecaudacionFechaIngreso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "egresoCajaRecaudacionIdCaja")
    private Collection<EgresoCajaRecaudacion> egresoCajaRecaudacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recaudacionIdCaja")
    private Collection<Recaudacion> recaudacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cajaProcesoIdCaja")
    private Collection<CajaProceso> cajaProcesoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resumenRecaudacionIdCaja")
    private Collection<ResumenRecaudacion> resumenRecaudacionCollection;
    @JoinColumn(name = "caja_recaudacion_id_cuenta", referencedColumnName = "cuenta_id")
    @ManyToOne(optional = false)
    private Cuenta cajaRecaudacionIdCuenta;
    @JoinColumn(name = "caja_recaudacion_id_terminal", referencedColumnName = "terminal_id")
    @ManyToOne(optional = false)
    private Terminal cajaRecaudacionIdTerminal;
    @JoinColumn(name = "caja_recaudacion_id_usuario", referencedColumnName = "usuario_id")
    @ManyToOne(optional = false)
    private Usuario cajaRecaudacionIdUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventarioCajaIdCaja")
    private Collection<InventarioCaja> inventarioCajaCollection;

    public CajaRecaudacion() {
    }

    public CajaRecaudacion(Integer cajaRecaudacionId) {
        this.cajaRecaudacionId = cajaRecaudacionId;
    }

    public CajaRecaudacion(Integer cajaRecaudacionId, String cajaRecaudacionNombre, boolean cajaRecaudacionTieneEgresos, boolean cajaRecaudacionActiva, Date cajaRecaudacionFechaIngreso) {
        this.cajaRecaudacionId = cajaRecaudacionId;
        this.cajaRecaudacionNombre = cajaRecaudacionNombre;
        this.cajaRecaudacionTieneEgresos = cajaRecaudacionTieneEgresos;
        this.cajaRecaudacionActiva = cajaRecaudacionActiva;
        this.cajaRecaudacionFechaIngreso = cajaRecaudacionFechaIngreso;
    }

    public Integer getCajaRecaudacionId() {
        return cajaRecaudacionId;
    }

    public void setCajaRecaudacionId(Integer cajaRecaudacionId) {
        this.cajaRecaudacionId = cajaRecaudacionId;
    }

    public String getCajaRecaudacionNombre() {
        return cajaRecaudacionNombre;
    }

    public void setCajaRecaudacionNombre(String cajaRecaudacionNombre) {
        this.cajaRecaudacionNombre = cajaRecaudacionNombre;
    }

    public boolean getCajaRecaudacionTieneEgresos() {
        return cajaRecaudacionTieneEgresos;
    }

    public void setCajaRecaudacionTieneEgresos(boolean cajaRecaudacionTieneEgresos) {
        this.cajaRecaudacionTieneEgresos = cajaRecaudacionTieneEgresos;
    }

    public boolean getCajaRecaudacionActiva() {
        return cajaRecaudacionActiva;
    }

    public void setCajaRecaudacionActiva(boolean cajaRecaudacionActiva) {
        this.cajaRecaudacionActiva = cajaRecaudacionActiva;
    }

    public Date getCajaRecaudacionFechaIngreso() {
        return cajaRecaudacionFechaIngreso;
    }

    public void setCajaRecaudacionFechaIngreso(Date cajaRecaudacionFechaIngreso) {
        this.cajaRecaudacionFechaIngreso = cajaRecaudacionFechaIngreso;
    }

    @XmlTransient
    public Collection<EgresoCajaRecaudacion> getEgresoCajaRecaudacionCollection() {
        return egresoCajaRecaudacionCollection;
    }

    public void setEgresoCajaRecaudacionCollection(Collection<EgresoCajaRecaudacion> egresoCajaRecaudacionCollection) {
        this.egresoCajaRecaudacionCollection = egresoCajaRecaudacionCollection;
    }

    @XmlTransient
    public Collection<Recaudacion> getRecaudacionCollection() {
        return recaudacionCollection;
    }

    public void setRecaudacionCollection(Collection<Recaudacion> recaudacionCollection) {
        this.recaudacionCollection = recaudacionCollection;
    }

    @XmlTransient
    public Collection<CajaProceso> getCajaProcesoCollection() {
        return cajaProcesoCollection;
    }

    public void setCajaProcesoCollection(Collection<CajaProceso> cajaProcesoCollection) {
        this.cajaProcesoCollection = cajaProcesoCollection;
    }

    @XmlTransient
    public Collection<ResumenRecaudacion> getResumenRecaudacionCollection() {
        return resumenRecaudacionCollection;
    }

    public void setResumenRecaudacionCollection(Collection<ResumenRecaudacion> resumenRecaudacionCollection) {
        this.resumenRecaudacionCollection = resumenRecaudacionCollection;
    }

    public Cuenta getCajaRecaudacionIdCuenta() {
        return cajaRecaudacionIdCuenta;
    }

    public void setCajaRecaudacionIdCuenta(Cuenta cajaRecaudacionIdCuenta) {
        this.cajaRecaudacionIdCuenta = cajaRecaudacionIdCuenta;
    }

    public Terminal getCajaRecaudacionIdTerminal() {
        return cajaRecaudacionIdTerminal;
    }

    public void setCajaRecaudacionIdTerminal(Terminal cajaRecaudacionIdTerminal) {
        this.cajaRecaudacionIdTerminal = cajaRecaudacionIdTerminal;
    }

    public Usuario getCajaRecaudacionIdUsuario() {
        return cajaRecaudacionIdUsuario;
    }

    public void setCajaRecaudacionIdUsuario(Usuario cajaRecaudacionIdUsuario) {
        this.cajaRecaudacionIdUsuario = cajaRecaudacionIdUsuario;
    }

    @XmlTransient
    public Collection<InventarioCaja> getInventarioCajaCollection() {
        return inventarioCajaCollection;
    }

    public void setInventarioCajaCollection(Collection<InventarioCaja> inventarioCajaCollection) {
        this.inventarioCajaCollection = inventarioCajaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cajaRecaudacionId != null ? cajaRecaudacionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CajaRecaudacion)) {
            return false;
        }
        CajaRecaudacion other = (CajaRecaudacion) object;
        if ((this.cajaRecaudacionId == null && other.cajaRecaudacionId != null) || (this.cajaRecaudacionId != null && !this.cajaRecaudacionId.equals(other.cajaRecaudacionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.sigf.rest.entities.CajaRecaudacion[ cajaRecaudacionId=" + cajaRecaudacionId + " ]";
    }
    
}
