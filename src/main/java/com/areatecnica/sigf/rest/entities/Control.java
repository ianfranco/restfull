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
@Table(name = "control")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Control.findAll", query = "SELECT c FROM Control c")
    , @NamedQuery(name = "Control.findByControlId", query = "SELECT c FROM Control c WHERE c.controlId = :controlId")
    , @NamedQuery(name = "Control.findByControlNombre", query = "SELECT c FROM Control c WHERE c.controlNombre = :controlNombre")
    , @NamedQuery(name = "Control.findByControlLatitud", query = "SELECT c FROM Control c WHERE c.controlLatitud = :controlLatitud")
    , @NamedQuery(name = "Control.findByControlLongitud", query = "SELECT c FROM Control c WHERE c.controlLongitud = :controlLongitud")
    , @NamedQuery(name = "Control.findByControlRadio", query = "SELECT c FROM Control c WHERE c.controlRadio = :controlRadio")})
public class Control implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "control_id")
    private Integer controlId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "control_nombre")
    private String controlNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "control_latitud")
    private double controlLatitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "control_longitud")
    private double controlLongitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "control_radio")
    private int controlRadio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "controlServicioIdControl")
    private Collection<ControlServicio> controlServicioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "controlHorarioServicioIdControl")
    private Collection<ControlHorarioServicio> controlHorarioServicioCollection;
    @JoinColumn(name = "control_id_cuenta", referencedColumnName = "cuenta_id")
    @ManyToOne(optional = false)
    private Cuenta controlIdCuenta;
    @JoinColumn(name = "control_id_tipo", referencedColumnName = "tipo_control_id")
    @ManyToOne(optional = false)
    private TipoControl controlIdTipo;

    public Control() {
    }

    public Control(Integer controlId) {
        this.controlId = controlId;
    }

    public Control(Integer controlId, String controlNombre, double controlLatitud, double controlLongitud, int controlRadio) {
        this.controlId = controlId;
        this.controlNombre = controlNombre;
        this.controlLatitud = controlLatitud;
        this.controlLongitud = controlLongitud;
        this.controlRadio = controlRadio;
    }

    public Integer getControlId() {
        return controlId;
    }

    public void setControlId(Integer controlId) {
        this.controlId = controlId;
    }

    public String getControlNombre() {
        return controlNombre;
    }

    public void setControlNombre(String controlNombre) {
        this.controlNombre = controlNombre;
    }

    public double getControlLatitud() {
        return controlLatitud;
    }

    public void setControlLatitud(double controlLatitud) {
        this.controlLatitud = controlLatitud;
    }

    public double getControlLongitud() {
        return controlLongitud;
    }

    public void setControlLongitud(double controlLongitud) {
        this.controlLongitud = controlLongitud;
    }

    public int getControlRadio() {
        return controlRadio;
    }

    public void setControlRadio(int controlRadio) {
        this.controlRadio = controlRadio;
    }

    @XmlTransient
    public Collection<ControlServicio> getControlServicioCollection() {
        return controlServicioCollection;
    }

    public void setControlServicioCollection(Collection<ControlServicio> controlServicioCollection) {
        this.controlServicioCollection = controlServicioCollection;
    }

    @XmlTransient
    public Collection<ControlHorarioServicio> getControlHorarioServicioCollection() {
        return controlHorarioServicioCollection;
    }

    public void setControlHorarioServicioCollection(Collection<ControlHorarioServicio> controlHorarioServicioCollection) {
        this.controlHorarioServicioCollection = controlHorarioServicioCollection;
    }

    public Cuenta getControlIdCuenta() {
        return controlIdCuenta;
    }

    public void setControlIdCuenta(Cuenta controlIdCuenta) {
        this.controlIdCuenta = controlIdCuenta;
    }

    public TipoControl getControlIdTipo() {
        return controlIdTipo;
    }

    public void setControlIdTipo(TipoControl controlIdTipo) {
        this.controlIdTipo = controlIdTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (controlId != null ? controlId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Control)) {
            return false;
        }
        Control other = (Control) object;
        if ((this.controlId == null && other.controlId != null) || (this.controlId != null && !this.controlId.equals(other.controlId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.sigf.rest.entities.Control[ controlId=" + controlId + " ]";
    }
    
}
