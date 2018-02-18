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
@Table(name = "abono_bus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AbonoBus.findAll", query = "SELECT a FROM AbonoBus a")
    , @NamedQuery(name = "AbonoBus.findByAbonoBusId", query = "SELECT a FROM AbonoBus a WHERE a.abonoBusId = :abonoBusId")
    , @NamedQuery(name = "AbonoBus.findByAbonoBusFechaInicio", query = "SELECT a FROM AbonoBus a WHERE a.abonoBusFechaInicio = :abonoBusFechaInicio")
    , @NamedQuery(name = "AbonoBus.findByAbonoBusFechaTermino", query = "SELECT a FROM AbonoBus a WHERE a.abonoBusFechaTermino = :abonoBusFechaTermino")
    , @NamedQuery(name = "AbonoBus.findByAbonoBusCuotaActual", query = "SELECT a FROM AbonoBus a WHERE a.abonoBusCuotaActual = :abonoBusCuotaActual")
    , @NamedQuery(name = "AbonoBus.findByAbonoBusTotalCuotas", query = "SELECT a FROM AbonoBus a WHERE a.abonoBusTotalCuotas = :abonoBusTotalCuotas")
    , @NamedQuery(name = "AbonoBus.findByAbonoBusMontoFijo", query = "SELECT a FROM AbonoBus a WHERE a.abonoBusMontoFijo = :abonoBusMontoFijo")
    , @NamedQuery(name = "AbonoBus.findByAbonoBusDescripcion", query = "SELECT a FROM AbonoBus a WHERE a.abonoBusDescripcion = :abonoBusDescripcion")
    , @NamedQuery(name = "AbonoBus.findByAbonoBusActivo", query = "SELECT a FROM AbonoBus a WHERE a.abonoBusActivo = :abonoBusActivo")
    , @NamedQuery(name = "AbonoBus.findByAbonoBusFechaIngreso", query = "SELECT a FROM AbonoBus a WHERE a.abonoBusFechaIngreso = :abonoBusFechaIngreso")})
public class AbonoBus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "abono_bus_id")
    private Integer abonoBusId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "abono_bus_fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date abonoBusFechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "abono_bus_fecha_termino")
    @Temporal(TemporalType.DATE)
    private Date abonoBusFechaTermino;
    @Basic(optional = false)
    @NotNull
    @Column(name = "abono_bus_cuota_actual")
    private int abonoBusCuotaActual;
    @Basic(optional = false)
    @NotNull
    @Column(name = "abono_bus_total_cuotas")
    private int abonoBusTotalCuotas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "abono_bus_monto_fijo")
    private int abonoBusMontoFijo;
    @Size(max = 100)
    @Column(name = "abono_bus_descripcion")
    private String abonoBusDescripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "abono_bus_activo")
    private boolean abonoBusActivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "abono_bus_fecha_ingreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date abonoBusFechaIngreso;
    @JoinColumn(name = "abono_bus_id_bus", referencedColumnName = "bus_id")
    @ManyToOne(optional = false)
    private Bus abonoBusIdBus;
    @JoinColumn(name = "abono_bus_id_tipo_abono", referencedColumnName = "tipo_abono_id")
    @ManyToOne(optional = false)
    private TipoAbono abonoBusIdTipoAbono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "abonoLiquidacionIdAbono")
    private Collection<AbonoLiquidacion> abonoLiquidacionCollection;

    public AbonoBus() {
    }

    public AbonoBus(Integer abonoBusId) {
        this.abonoBusId = abonoBusId;
    }

    public AbonoBus(Integer abonoBusId, Date abonoBusFechaInicio, Date abonoBusFechaTermino, int abonoBusCuotaActual, int abonoBusTotalCuotas, int abonoBusMontoFijo, boolean abonoBusActivo, Date abonoBusFechaIngreso) {
        this.abonoBusId = abonoBusId;
        this.abonoBusFechaInicio = abonoBusFechaInicio;
        this.abonoBusFechaTermino = abonoBusFechaTermino;
        this.abonoBusCuotaActual = abonoBusCuotaActual;
        this.abonoBusTotalCuotas = abonoBusTotalCuotas;
        this.abonoBusMontoFijo = abonoBusMontoFijo;
        this.abonoBusActivo = abonoBusActivo;
        this.abonoBusFechaIngreso = abonoBusFechaIngreso;
    }

    public Integer getAbonoBusId() {
        return abonoBusId;
    }

    public void setAbonoBusId(Integer abonoBusId) {
        this.abonoBusId = abonoBusId;
    }

    public Date getAbonoBusFechaInicio() {
        return abonoBusFechaInicio;
    }

    public void setAbonoBusFechaInicio(Date abonoBusFechaInicio) {
        this.abonoBusFechaInicio = abonoBusFechaInicio;
    }

    public Date getAbonoBusFechaTermino() {
        return abonoBusFechaTermino;
    }

    public void setAbonoBusFechaTermino(Date abonoBusFechaTermino) {
        this.abonoBusFechaTermino = abonoBusFechaTermino;
    }

    public int getAbonoBusCuotaActual() {
        return abonoBusCuotaActual;
    }

    public void setAbonoBusCuotaActual(int abonoBusCuotaActual) {
        this.abonoBusCuotaActual = abonoBusCuotaActual;
    }

    public int getAbonoBusTotalCuotas() {
        return abonoBusTotalCuotas;
    }

    public void setAbonoBusTotalCuotas(int abonoBusTotalCuotas) {
        this.abonoBusTotalCuotas = abonoBusTotalCuotas;
    }

    public int getAbonoBusMontoFijo() {
        return abonoBusMontoFijo;
    }

    public void setAbonoBusMontoFijo(int abonoBusMontoFijo) {
        this.abonoBusMontoFijo = abonoBusMontoFijo;
    }

    public String getAbonoBusDescripcion() {
        return abonoBusDescripcion;
    }

    public void setAbonoBusDescripcion(String abonoBusDescripcion) {
        this.abonoBusDescripcion = abonoBusDescripcion;
    }

    public boolean getAbonoBusActivo() {
        return abonoBusActivo;
    }

    public void setAbonoBusActivo(boolean abonoBusActivo) {
        this.abonoBusActivo = abonoBusActivo;
    }

    public Date getAbonoBusFechaIngreso() {
        return abonoBusFechaIngreso;
    }

    public void setAbonoBusFechaIngreso(Date abonoBusFechaIngreso) {
        this.abonoBusFechaIngreso = abonoBusFechaIngreso;
    }

    public Bus getAbonoBusIdBus() {
        return abonoBusIdBus;
    }

    public void setAbonoBusIdBus(Bus abonoBusIdBus) {
        this.abonoBusIdBus = abonoBusIdBus;
    }

    public TipoAbono getAbonoBusIdTipoAbono() {
        return abonoBusIdTipoAbono;
    }

    public void setAbonoBusIdTipoAbono(TipoAbono abonoBusIdTipoAbono) {
        this.abonoBusIdTipoAbono = abonoBusIdTipoAbono;
    }

    @XmlTransient
    public Collection<AbonoLiquidacion> getAbonoLiquidacionCollection() {
        return abonoLiquidacionCollection;
    }

    public void setAbonoLiquidacionCollection(Collection<AbonoLiquidacion> abonoLiquidacionCollection) {
        this.abonoLiquidacionCollection = abonoLiquidacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (abonoBusId != null ? abonoBusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AbonoBus)) {
            return false;
        }
        AbonoBus other = (AbonoBus) object;
        if ((this.abonoBusId == null && other.abonoBusId != null) || (this.abonoBusId != null && !this.abonoBusId.equals(other.abonoBusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.sigf.rest.entities.AbonoBus[ abonoBusId=" + abonoBusId + " ]";
    }
    
}
