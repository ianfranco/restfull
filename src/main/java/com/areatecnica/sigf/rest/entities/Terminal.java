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
@Table(name = "terminal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Terminal.findAll", query = "SELECT t FROM Terminal t")
    , @NamedQuery(name = "Terminal.findByTerminalId", query = "SELECT t FROM Terminal t WHERE t.terminalId = :terminalId")
    , @NamedQuery(name = "Terminal.findByTerminalNombre", query = "SELECT t FROM Terminal t WHERE t.terminalNombre = :terminalNombre")
    , @NamedQuery(name = "Terminal.findByTerminalDireccion", query = "SELECT t FROM Terminal t WHERE t.terminalDireccion = :terminalDireccion")
    , @NamedQuery(name = "Terminal.findByTerminalSuperficie", query = "SELECT t FROM Terminal t WHERE t.terminalSuperficie = :terminalSuperficie")
    , @NamedQuery(name = "Terminal.findByTerminalTelefono", query = "SELECT t FROM Terminal t WHERE t.terminalTelefono = :terminalTelefono")
    , @NamedQuery(name = "Terminal.findByTerminalEmail", query = "SELECT t FROM Terminal t WHERE t.terminalEmail = :terminalEmail")
    , @NamedQuery(name = "Terminal.findByTerminalUbicacionLongitud", query = "SELECT t FROM Terminal t WHERE t.terminalUbicacionLongitud = :terminalUbicacionLongitud")
    , @NamedQuery(name = "Terminal.findByTerminalUbicacionLatitud", query = "SELECT t FROM Terminal t WHERE t.terminalUbicacionLatitud = :terminalUbicacionLatitud")})
public class Terminal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "terminal_id")
    private Integer terminalId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "terminal_nombre")
    private String terminalNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "terminal_direccion")
    private String terminalDireccion;
    @Column(name = "terminal_superficie")
    private Integer terminalSuperficie;
    @Size(max = 45)
    @Column(name = "terminal_telefono")
    private String terminalTelefono;
    @Size(max = 45)
    @Column(name = "terminal_email")
    private String terminalEmail;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "terminal_ubicacion_longitud")
    private Double terminalUbicacionLongitud;
    @Column(name = "terminal_ubicacion_latitud")
    private Double terminalUbicacionLatitud;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "surtidorIdTerminal")
    private Collection<Surtidor> surtidorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioIdTerminal")
    private Collection<Usuario> usuarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "liquidacionSueldoIdTerminal")
    private Collection<LiquidacionSueldo> liquidacionSueldoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trabajadorIdTerminal")
    private Collection<Trabajador> trabajadorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "busIdTerminal")
    private Collection<Bus> busCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "relacionLaboralIdTerminal")
    private Collection<RelacionLaboral> relacionLaboralCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupoServicioIdTerminal")
    private Collection<GrupoServicio> grupoServicioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cajaRecaudacionIdTerminal")
    private Collection<CajaRecaudacion> cajaRecaudacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicioIdTerminal")
    private Collection<Servicio> servicioCollection;
    @JoinColumn(name = "terminal_id_comuna", referencedColumnName = "comuna_id")
    @ManyToOne(optional = false)
    private Comuna terminalIdComuna;
    @JoinColumn(name = "terminal_id_cuenta", referencedColumnName = "cuenta_id")
    @ManyToOne(optional = false)
    private Cuenta terminalIdCuenta;

    public Terminal() {
    }

    public Terminal(Integer terminalId) {
        this.terminalId = terminalId;
    }

    public Terminal(Integer terminalId, String terminalNombre, String terminalDireccion) {
        this.terminalId = terminalId;
        this.terminalNombre = terminalNombre;
        this.terminalDireccion = terminalDireccion;
    }

    public Integer getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(Integer terminalId) {
        this.terminalId = terminalId;
    }

    public String getTerminalNombre() {
        return terminalNombre;
    }

    public void setTerminalNombre(String terminalNombre) {
        this.terminalNombre = terminalNombre;
    }

    public String getTerminalDireccion() {
        return terminalDireccion;
    }

    public void setTerminalDireccion(String terminalDireccion) {
        this.terminalDireccion = terminalDireccion;
    }

    public Integer getTerminalSuperficie() {
        return terminalSuperficie;
    }

    public void setTerminalSuperficie(Integer terminalSuperficie) {
        this.terminalSuperficie = terminalSuperficie;
    }

    public String getTerminalTelefono() {
        return terminalTelefono;
    }

    public void setTerminalTelefono(String terminalTelefono) {
        this.terminalTelefono = terminalTelefono;
    }

    public String getTerminalEmail() {
        return terminalEmail;
    }

    public void setTerminalEmail(String terminalEmail) {
        this.terminalEmail = terminalEmail;
    }

    public Double getTerminalUbicacionLongitud() {
        return terminalUbicacionLongitud;
    }

    public void setTerminalUbicacionLongitud(Double terminalUbicacionLongitud) {
        this.terminalUbicacionLongitud = terminalUbicacionLongitud;
    }

    public Double getTerminalUbicacionLatitud() {
        return terminalUbicacionLatitud;
    }

    public void setTerminalUbicacionLatitud(Double terminalUbicacionLatitud) {
        this.terminalUbicacionLatitud = terminalUbicacionLatitud;
    }

    @XmlTransient
    public Collection<Surtidor> getSurtidorCollection() {
        return surtidorCollection;
    }

    public void setSurtidorCollection(Collection<Surtidor> surtidorCollection) {
        this.surtidorCollection = surtidorCollection;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @XmlTransient
    public Collection<LiquidacionSueldo> getLiquidacionSueldoCollection() {
        return liquidacionSueldoCollection;
    }

    public void setLiquidacionSueldoCollection(Collection<LiquidacionSueldo> liquidacionSueldoCollection) {
        this.liquidacionSueldoCollection = liquidacionSueldoCollection;
    }

    @XmlTransient
    public Collection<Trabajador> getTrabajadorCollection() {
        return trabajadorCollection;
    }

    public void setTrabajadorCollection(Collection<Trabajador> trabajadorCollection) {
        this.trabajadorCollection = trabajadorCollection;
    }

    @XmlTransient
    public Collection<Bus> getBusCollection() {
        return busCollection;
    }

    public void setBusCollection(Collection<Bus> busCollection) {
        this.busCollection = busCollection;
    }

    @XmlTransient
    public Collection<RelacionLaboral> getRelacionLaboralCollection() {
        return relacionLaboralCollection;
    }

    public void setRelacionLaboralCollection(Collection<RelacionLaboral> relacionLaboralCollection) {
        this.relacionLaboralCollection = relacionLaboralCollection;
    }

    @XmlTransient
    public Collection<GrupoServicio> getGrupoServicioCollection() {
        return grupoServicioCollection;
    }

    public void setGrupoServicioCollection(Collection<GrupoServicio> grupoServicioCollection) {
        this.grupoServicioCollection = grupoServicioCollection;
    }

    @XmlTransient
    public Collection<CajaRecaudacion> getCajaRecaudacionCollection() {
        return cajaRecaudacionCollection;
    }

    public void setCajaRecaudacionCollection(Collection<CajaRecaudacion> cajaRecaudacionCollection) {
        this.cajaRecaudacionCollection = cajaRecaudacionCollection;
    }

    @XmlTransient
    public Collection<Servicio> getServicioCollection() {
        return servicioCollection;
    }

    public void setServicioCollection(Collection<Servicio> servicioCollection) {
        this.servicioCollection = servicioCollection;
    }

    public Comuna getTerminalIdComuna() {
        return terminalIdComuna;
    }

    public void setTerminalIdComuna(Comuna terminalIdComuna) {
        this.terminalIdComuna = terminalIdComuna;
    }

    public Cuenta getTerminalIdCuenta() {
        return terminalIdCuenta;
    }

    public void setTerminalIdCuenta(Cuenta terminalIdCuenta) {
        this.terminalIdCuenta = terminalIdCuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (terminalId != null ? terminalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Terminal)) {
            return false;
        }
        Terminal other = (Terminal) object;
        if ((this.terminalId == null && other.terminalId != null) || (this.terminalId != null && !this.terminalId.equals(other.terminalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.sigf.rest.entities.Terminal[ terminalId=" + terminalId + " ]";
    }
    
}
