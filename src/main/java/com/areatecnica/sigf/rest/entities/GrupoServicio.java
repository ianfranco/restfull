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
@Table(name = "grupo_servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrupoServicio.findAll", query = "SELECT g FROM GrupoServicio g")
    , @NamedQuery(name = "GrupoServicio.findByGrupoServicioId", query = "SELECT g FROM GrupoServicio g WHERE g.grupoServicioId = :grupoServicioId")
    , @NamedQuery(name = "GrupoServicio.findByGrupoServicioIdentificador", query = "SELECT g FROM GrupoServicio g WHERE g.grupoServicioIdentificador = :grupoServicioIdentificador")
    , @NamedQuery(name = "GrupoServicio.findByGrupoServicioAccesoInspector", query = "SELECT g FROM GrupoServicio g WHERE g.grupoServicioAccesoInspector = :grupoServicioAccesoInspector")})
public class GrupoServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "grupo_servicio_id")
    private Integer grupoServicioId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "grupo_servicio_identificador")
    private String grupoServicioIdentificador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "grupo_servicio_acceso_inspector")
    private boolean grupoServicioAccesoInspector;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "busIdGrupoServicio")
    private Collection<Bus> busCollection;
    @JoinColumn(name = "grupo_servicio_id_cuenta", referencedColumnName = "cuenta_id")
    @ManyToOne(optional = false)
    private Cuenta grupoServicioIdCuenta;
    @JoinColumn(name = "grupo_servicio_id_terminal", referencedColumnName = "terminal_id")
    @ManyToOne(optional = false)
    private Terminal grupoServicioIdTerminal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicioIdGrupoServicio")
    private Collection<Servicio> servicioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tarifaGrupoServicioIdGrupo")
    private Collection<TarifaGrupoServicio> tarifaGrupoServicioCollection;

    public GrupoServicio() {
    }

    public GrupoServicio(Integer grupoServicioId) {
        this.grupoServicioId = grupoServicioId;
    }

    public GrupoServicio(Integer grupoServicioId, String grupoServicioIdentificador, boolean grupoServicioAccesoInspector) {
        this.grupoServicioId = grupoServicioId;
        this.grupoServicioIdentificador = grupoServicioIdentificador;
        this.grupoServicioAccesoInspector = grupoServicioAccesoInspector;
    }

    public Integer getGrupoServicioId() {
        return grupoServicioId;
    }

    public void setGrupoServicioId(Integer grupoServicioId) {
        this.grupoServicioId = grupoServicioId;
    }

    public String getGrupoServicioIdentificador() {
        return grupoServicioIdentificador;
    }

    public void setGrupoServicioIdentificador(String grupoServicioIdentificador) {
        this.grupoServicioIdentificador = grupoServicioIdentificador;
    }

    public boolean getGrupoServicioAccesoInspector() {
        return grupoServicioAccesoInspector;
    }

    public void setGrupoServicioAccesoInspector(boolean grupoServicioAccesoInspector) {
        this.grupoServicioAccesoInspector = grupoServicioAccesoInspector;
    }

    @XmlTransient
    public Collection<Bus> getBusCollection() {
        return busCollection;
    }

    public void setBusCollection(Collection<Bus> busCollection) {
        this.busCollection = busCollection;
    }

    public Cuenta getGrupoServicioIdCuenta() {
        return grupoServicioIdCuenta;
    }

    public void setGrupoServicioIdCuenta(Cuenta grupoServicioIdCuenta) {
        this.grupoServicioIdCuenta = grupoServicioIdCuenta;
    }

    public Terminal getGrupoServicioIdTerminal() {
        return grupoServicioIdTerminal;
    }

    public void setGrupoServicioIdTerminal(Terminal grupoServicioIdTerminal) {
        this.grupoServicioIdTerminal = grupoServicioIdTerminal;
    }

    @XmlTransient
    public Collection<Servicio> getServicioCollection() {
        return servicioCollection;
    }

    public void setServicioCollection(Collection<Servicio> servicioCollection) {
        this.servicioCollection = servicioCollection;
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
        hash += (grupoServicioId != null ? grupoServicioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoServicio)) {
            return false;
        }
        GrupoServicio other = (GrupoServicio) object;
        if ((this.grupoServicioId == null && other.grupoServicioId != null) || (this.grupoServicioId != null && !this.grupoServicioId.equals(other.grupoServicioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.sigf.rest.entities.GrupoServicio[ grupoServicioId=" + grupoServicioId + " ]";
    }
    
}
