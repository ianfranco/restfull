/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.sigf.rest.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "egreso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Egreso.findAll", query = "SELECT e FROM Egreso e")
    , @NamedQuery(name = "Egreso.findByEgresoId", query = "SELECT e FROM Egreso e WHERE e.egresoId = :egresoId")
    , @NamedQuery(name = "Egreso.findByEgresoNombre", query = "SELECT e FROM Egreso e WHERE e.egresoNombre = :egresoNombre")
    , @NamedQuery(name = "Egreso.findByEgresoValorDefecto", query = "SELECT e FROM Egreso e WHERE e.egresoValorDefecto = :egresoValorDefecto")
    , @NamedQuery(name = "Egreso.findByEgresoPorcentaje", query = "SELECT e FROM Egreso e WHERE e.egresoPorcentaje = :egresoPorcentaje")
    , @NamedQuery(name = "Egreso.findByEgresoNumeroOrden", query = "SELECT e FROM Egreso e WHERE e.egresoNumeroOrden = :egresoNumeroOrden")
    , @NamedQuery(name = "Egreso.findByEgresoObligatorio", query = "SELECT e FROM Egreso e WHERE e.egresoObligatorio = :egresoObligatorio")
    , @NamedQuery(name = "Egreso.findByEgresoActivo", query = "SELECT e FROM Egreso e WHERE e.egresoActivo = :egresoActivo")})
public class Egreso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "egreso_id")
    private Integer egresoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "egreso_nombre")
    private String egresoNombre;
    @Column(name = "egreso_valor_defecto")
    private Integer egresoValorDefecto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "egreso_porcentaje")
    private BigDecimal egresoPorcentaje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "egreso_numero_orden")
    private int egresoNumeroOrden;
    @Column(name = "egreso_obligatorio")
    private Boolean egresoObligatorio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "egreso_activo")
    private boolean egresoActivo;
    @JoinColumn(name = "egreso_id_cuenta", referencedColumnName = "cuenta_id")
    @ManyToOne(optional = false)
    private Cuenta egresoIdCuenta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "egresoCajaRecaudacionIdEgreso")
    private Collection<EgresoCajaRecaudacion> egresoCajaRecaudacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "egresoProcesoRecaudacionIdEgreso")
    private Collection<EgresoProcesoRecaudacion> egresoProcesoRecaudacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recaudacionGuiaIdEgreso")
    private Collection<RecaudacionGuia> recaudacionGuiaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "egresoBusIdEgreso")
    private Collection<EgresoBus> egresoBusCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "egresoFlotaIdEgreso")
    private Collection<EgresoFlota> egresoFlotaCollection;

    public Egreso() {
    }

    public Egreso(Integer egresoId) {
        this.egresoId = egresoId;
    }

    public Egreso(Integer egresoId, String egresoNombre, int egresoNumeroOrden, boolean egresoActivo) {
        this.egresoId = egresoId;
        this.egresoNombre = egresoNombre;
        this.egresoNumeroOrden = egresoNumeroOrden;
        this.egresoActivo = egresoActivo;
    }

    public Integer getEgresoId() {
        return egresoId;
    }

    public void setEgresoId(Integer egresoId) {
        this.egresoId = egresoId;
    }

    public String getEgresoNombre() {
        return egresoNombre;
    }

    public void setEgresoNombre(String egresoNombre) {
        this.egresoNombre = egresoNombre;
    }

    public Integer getEgresoValorDefecto() {
        return egresoValorDefecto;
    }

    public void setEgresoValorDefecto(Integer egresoValorDefecto) {
        this.egresoValorDefecto = egresoValorDefecto;
    }

    public BigDecimal getEgresoPorcentaje() {
        return egresoPorcentaje;
    }

    public void setEgresoPorcentaje(BigDecimal egresoPorcentaje) {
        this.egresoPorcentaje = egresoPorcentaje;
    }

    public int getEgresoNumeroOrden() {
        return egresoNumeroOrden;
    }

    public void setEgresoNumeroOrden(int egresoNumeroOrden) {
        this.egresoNumeroOrden = egresoNumeroOrden;
    }

    public Boolean getEgresoObligatorio() {
        return egresoObligatorio;
    }

    public void setEgresoObligatorio(Boolean egresoObligatorio) {
        this.egresoObligatorio = egresoObligatorio;
    }

    public boolean getEgresoActivo() {
        return egresoActivo;
    }

    public void setEgresoActivo(boolean egresoActivo) {
        this.egresoActivo = egresoActivo;
    }

    public Cuenta getEgresoIdCuenta() {
        return egresoIdCuenta;
    }

    public void setEgresoIdCuenta(Cuenta egresoIdCuenta) {
        this.egresoIdCuenta = egresoIdCuenta;
    }

    @XmlTransient
    public Collection<EgresoCajaRecaudacion> getEgresoCajaRecaudacionCollection() {
        return egresoCajaRecaudacionCollection;
    }

    public void setEgresoCajaRecaudacionCollection(Collection<EgresoCajaRecaudacion> egresoCajaRecaudacionCollection) {
        this.egresoCajaRecaudacionCollection = egresoCajaRecaudacionCollection;
    }

    @XmlTransient
    public Collection<EgresoProcesoRecaudacion> getEgresoProcesoRecaudacionCollection() {
        return egresoProcesoRecaudacionCollection;
    }

    public void setEgresoProcesoRecaudacionCollection(Collection<EgresoProcesoRecaudacion> egresoProcesoRecaudacionCollection) {
        this.egresoProcesoRecaudacionCollection = egresoProcesoRecaudacionCollection;
    }

    @XmlTransient
    public Collection<RecaudacionGuia> getRecaudacionGuiaCollection() {
        return recaudacionGuiaCollection;
    }

    public void setRecaudacionGuiaCollection(Collection<RecaudacionGuia> recaudacionGuiaCollection) {
        this.recaudacionGuiaCollection = recaudacionGuiaCollection;
    }

    @XmlTransient
    public Collection<EgresoBus> getEgresoBusCollection() {
        return egresoBusCollection;
    }

    public void setEgresoBusCollection(Collection<EgresoBus> egresoBusCollection) {
        this.egresoBusCollection = egresoBusCollection;
    }

    @XmlTransient
    public Collection<EgresoFlota> getEgresoFlotaCollection() {
        return egresoFlotaCollection;
    }

    public void setEgresoFlotaCollection(Collection<EgresoFlota> egresoFlotaCollection) {
        this.egresoFlotaCollection = egresoFlotaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (egresoId != null ? egresoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Egreso)) {
            return false;
        }
        Egreso other = (Egreso) object;
        if ((this.egresoId == null && other.egresoId != null) || (this.egresoId != null && !this.egresoId.equals(other.egresoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.sigf.rest.entities.Egreso[ egresoId=" + egresoId + " ]";
    }
    
}
