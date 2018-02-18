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
@Table(name = "surtidor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Surtidor.findAll", query = "SELECT s FROM Surtidor s")
    , @NamedQuery(name = "Surtidor.findBySurtidorId", query = "SELECT s FROM Surtidor s WHERE s.surtidorId = :surtidorId")
    , @NamedQuery(name = "Surtidor.findBySurtidorIdentificador", query = "SELECT s FROM Surtidor s WHERE s.surtidorIdentificador = :surtidorIdentificador")
    , @NamedQuery(name = "Surtidor.findBySurtidorObservaciones", query = "SELECT s FROM Surtidor s WHERE s.surtidorObservaciones = :surtidorObservaciones")})
public class Surtidor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "surtidor_id")
    private Integer surtidorId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "surtidor_identificador")
    private String surtidorIdentificador;
    @Size(max = 200)
    @Column(name = "surtidor_observaciones")
    private String surtidorObservaciones;
    @JoinColumn(name = "surtidor_id_terminal", referencedColumnName = "terminal_id")
    @ManyToOne(optional = false)
    private Terminal surtidorIdTerminal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ventaCombustibleIdSurtidor")
    private Collection<VentaCombustible> ventaCombustibleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numeralSurtidorIdSurtidor")
    private Collection<NumeralSurtidor> numeralSurtidorCollection;

    public Surtidor() {
    }

    public Surtidor(Integer surtidorId) {
        this.surtidorId = surtidorId;
    }

    public Surtidor(Integer surtidorId, String surtidorIdentificador) {
        this.surtidorId = surtidorId;
        this.surtidorIdentificador = surtidorIdentificador;
    }

    public Integer getSurtidorId() {
        return surtidorId;
    }

    public void setSurtidorId(Integer surtidorId) {
        this.surtidorId = surtidorId;
    }

    public String getSurtidorIdentificador() {
        return surtidorIdentificador;
    }

    public void setSurtidorIdentificador(String surtidorIdentificador) {
        this.surtidorIdentificador = surtidorIdentificador;
    }

    public String getSurtidorObservaciones() {
        return surtidorObservaciones;
    }

    public void setSurtidorObservaciones(String surtidorObservaciones) {
        this.surtidorObservaciones = surtidorObservaciones;
    }

    public Terminal getSurtidorIdTerminal() {
        return surtidorIdTerminal;
    }

    public void setSurtidorIdTerminal(Terminal surtidorIdTerminal) {
        this.surtidorIdTerminal = surtidorIdTerminal;
    }

    @XmlTransient
    public Collection<VentaCombustible> getVentaCombustibleCollection() {
        return ventaCombustibleCollection;
    }

    public void setVentaCombustibleCollection(Collection<VentaCombustible> ventaCombustibleCollection) {
        this.ventaCombustibleCollection = ventaCombustibleCollection;
    }

    @XmlTransient
    public Collection<NumeralSurtidor> getNumeralSurtidorCollection() {
        return numeralSurtidorCollection;
    }

    public void setNumeralSurtidorCollection(Collection<NumeralSurtidor> numeralSurtidorCollection) {
        this.numeralSurtidorCollection = numeralSurtidorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (surtidorId != null ? surtidorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Surtidor)) {
            return false;
        }
        Surtidor other = (Surtidor) object;
        if ((this.surtidorId == null && other.surtidorId != null) || (this.surtidorId != null && !this.surtidorId.equals(other.surtidorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.sigf.rest.entities.Surtidor[ surtidorId=" + surtidorId + " ]";
    }
    
}
