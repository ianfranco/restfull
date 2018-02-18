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
@Table(name = "boleto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Boleto.findAll", query = "SELECT b FROM Boleto b")
    , @NamedQuery(name = "Boleto.findByBoletoId", query = "SELECT b FROM Boleto b WHERE b.boletoId = :boletoId")
    , @NamedQuery(name = "Boleto.findByBoletoNombre", query = "SELECT b FROM Boleto b WHERE b.boletoNombre = :boletoNombre")
    , @NamedQuery(name = "Boleto.findByBoletoActivo", query = "SELECT b FROM Boleto b WHERE b.boletoActivo = :boletoActivo")
    , @NamedQuery(name = "Boleto.findByBoletoFechaIngreso", query = "SELECT b FROM Boleto b WHERE b.boletoFechaIngreso = :boletoFechaIngreso")})
public class Boleto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "boleto_id")
    private Integer boletoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "boleto_nombre")
    private String boletoNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "boleto_activo")
    private boolean boletoActivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "boleto_fecha_ingreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date boletoFechaIngreso;
    @JoinColumn(name = "boleto_id_cuenta", referencedColumnName = "cuenta_id")
    @ManyToOne(optional = false)
    private Cuenta boletoIdCuenta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventarioInternoIdBoleto")
    private Collection<InventarioInterno> inventarioInternoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detalleCompraBoletoIdBoleto")
    private Collection<DetalleCompraBoleto> detalleCompraBoletoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "registroBoletoIdBoleto")
    private Collection<RegistroBoleto> registroBoletoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tarifaGrupoServicioIdBoleto")
    private Collection<TarifaGrupoServicio> tarifaGrupoServicioCollection;

    public Boleto() {
    }

    public Boleto(Integer boletoId) {
        this.boletoId = boletoId;
    }

    public Boleto(Integer boletoId, String boletoNombre, boolean boletoActivo, Date boletoFechaIngreso) {
        this.boletoId = boletoId;
        this.boletoNombre = boletoNombre;
        this.boletoActivo = boletoActivo;
        this.boletoFechaIngreso = boletoFechaIngreso;
    }

    public Integer getBoletoId() {
        return boletoId;
    }

    public void setBoletoId(Integer boletoId) {
        this.boletoId = boletoId;
    }

    public String getBoletoNombre() {
        return boletoNombre;
    }

    public void setBoletoNombre(String boletoNombre) {
        this.boletoNombre = boletoNombre;
    }

    public boolean getBoletoActivo() {
        return boletoActivo;
    }

    public void setBoletoActivo(boolean boletoActivo) {
        this.boletoActivo = boletoActivo;
    }

    public Date getBoletoFechaIngreso() {
        return boletoFechaIngreso;
    }

    public void setBoletoFechaIngreso(Date boletoFechaIngreso) {
        this.boletoFechaIngreso = boletoFechaIngreso;
    }

    public Cuenta getBoletoIdCuenta() {
        return boletoIdCuenta;
    }

    public void setBoletoIdCuenta(Cuenta boletoIdCuenta) {
        this.boletoIdCuenta = boletoIdCuenta;
    }

    @XmlTransient
    public Collection<InventarioInterno> getInventarioInternoCollection() {
        return inventarioInternoCollection;
    }

    public void setInventarioInternoCollection(Collection<InventarioInterno> inventarioInternoCollection) {
        this.inventarioInternoCollection = inventarioInternoCollection;
    }

    @XmlTransient
    public Collection<DetalleCompraBoleto> getDetalleCompraBoletoCollection() {
        return detalleCompraBoletoCollection;
    }

    public void setDetalleCompraBoletoCollection(Collection<DetalleCompraBoleto> detalleCompraBoletoCollection) {
        this.detalleCompraBoletoCollection = detalleCompraBoletoCollection;
    }

    @XmlTransient
    public Collection<RegistroBoleto> getRegistroBoletoCollection() {
        return registroBoletoCollection;
    }

    public void setRegistroBoletoCollection(Collection<RegistroBoleto> registroBoletoCollection) {
        this.registroBoletoCollection = registroBoletoCollection;
    }

    @XmlTransient
    public Collection<TarifaGrupoServicio> getTarifaGrupoServicioCollection() {
        return tarifaGrupoServicioCollection;
    }

    public void setTarifaGrupoServicioCollection(Collection<TarifaGrupoServicio> tarifaGrupoServicioCollection) {
        this.tarifaGrupoServicioCollection = tarifaGrupoServicioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (boletoId != null ? boletoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Boleto)) {
            return false;
        }
        Boleto other = (Boleto) object;
        if ((this.boletoId == null && other.boletoId != null) || (this.boletoId != null && !this.boletoId.equals(other.boletoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.sigf.rest.entities.Boleto[ boletoId=" + boletoId + " ]";
    }
    
}
