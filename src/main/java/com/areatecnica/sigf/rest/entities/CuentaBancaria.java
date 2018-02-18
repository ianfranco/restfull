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
@Table(name = "cuenta_bancaria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CuentaBancaria.findAll", query = "SELECT c FROM CuentaBancaria c")
    , @NamedQuery(name = "CuentaBancaria.findByCuentaBancariaId", query = "SELECT c FROM CuentaBancaria c WHERE c.cuentaBancariaId = :cuentaBancariaId")
    , @NamedQuery(name = "CuentaBancaria.findByCuentaBancariaNumero", query = "SELECT c FROM CuentaBancaria c WHERE c.cuentaBancariaNumero = :cuentaBancariaNumero")
    , @NamedQuery(name = "CuentaBancaria.findByCuentaBancariaNombreTitular", query = "SELECT c FROM CuentaBancaria c WHERE c.cuentaBancariaNombreTitular = :cuentaBancariaNombreTitular")
    , @NamedQuery(name = "CuentaBancaria.findByCuentaBancariaRutTitular", query = "SELECT c FROM CuentaBancaria c WHERE c.cuentaBancariaRutTitular = :cuentaBancariaRutTitular")
    , @NamedQuery(name = "CuentaBancaria.findByCuentaBancariaActiva", query = "SELECT c FROM CuentaBancaria c WHERE c.cuentaBancariaActiva = :cuentaBancariaActiva")})
public class CuentaBancaria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cuenta_bancaria_id")
    private Integer cuentaBancariaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuenta_bancaria_numero")
    private int cuentaBancariaNumero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "cuenta_bancaria_nombre_titular")
    private String cuentaBancariaNombreTitular;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "cuenta_bancaria_rut_titular")
    private String cuentaBancariaRutTitular;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuenta_bancaria_activa")
    private boolean cuentaBancariaActiva;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuentaBancoProcesoIdBanco")
    private Collection<CuentaBancoProceso> cuentaBancoProcesoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuentaBancoEmpresaIdCuenta")
    private Collection<CuentaBancoEmpresa> cuentaBancoEmpresaCollection;
    @JoinColumn(name = "cuenta_bancaria_id_banco", referencedColumnName = "banco_id")
    @ManyToOne(optional = false)
    private Banco cuentaBancariaIdBanco;
    @JoinColumn(name = "cuenta_bancaria_id_tipo_cuenta", referencedColumnName = "tipo_cuenta_banco_id")
    @ManyToOne(optional = false)
    private TipoCuentaBanco cuentaBancariaIdTipoCuenta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuentaBancoTrabajadorCuenta")
    private Collection<CuentaBancoTrabajador> cuentaBancoTrabajadorCollection;

    public CuentaBancaria() {
    }

    public CuentaBancaria(Integer cuentaBancariaId) {
        this.cuentaBancariaId = cuentaBancariaId;
    }

    public CuentaBancaria(Integer cuentaBancariaId, int cuentaBancariaNumero, String cuentaBancariaNombreTitular, String cuentaBancariaRutTitular, boolean cuentaBancariaActiva) {
        this.cuentaBancariaId = cuentaBancariaId;
        this.cuentaBancariaNumero = cuentaBancariaNumero;
        this.cuentaBancariaNombreTitular = cuentaBancariaNombreTitular;
        this.cuentaBancariaRutTitular = cuentaBancariaRutTitular;
        this.cuentaBancariaActiva = cuentaBancariaActiva;
    }

    public Integer getCuentaBancariaId() {
        return cuentaBancariaId;
    }

    public void setCuentaBancariaId(Integer cuentaBancariaId) {
        this.cuentaBancariaId = cuentaBancariaId;
    }

    public int getCuentaBancariaNumero() {
        return cuentaBancariaNumero;
    }

    public void setCuentaBancariaNumero(int cuentaBancariaNumero) {
        this.cuentaBancariaNumero = cuentaBancariaNumero;
    }

    public String getCuentaBancariaNombreTitular() {
        return cuentaBancariaNombreTitular;
    }

    public void setCuentaBancariaNombreTitular(String cuentaBancariaNombreTitular) {
        this.cuentaBancariaNombreTitular = cuentaBancariaNombreTitular;
    }

    public String getCuentaBancariaRutTitular() {
        return cuentaBancariaRutTitular;
    }

    public void setCuentaBancariaRutTitular(String cuentaBancariaRutTitular) {
        this.cuentaBancariaRutTitular = cuentaBancariaRutTitular;
    }

    public boolean getCuentaBancariaActiva() {
        return cuentaBancariaActiva;
    }

    public void setCuentaBancariaActiva(boolean cuentaBancariaActiva) {
        this.cuentaBancariaActiva = cuentaBancariaActiva;
    }

    @XmlTransient
    public Collection<CuentaBancoProceso> getCuentaBancoProcesoCollection() {
        return cuentaBancoProcesoCollection;
    }

    public void setCuentaBancoProcesoCollection(Collection<CuentaBancoProceso> cuentaBancoProcesoCollection) {
        this.cuentaBancoProcesoCollection = cuentaBancoProcesoCollection;
    }

    @XmlTransient
    public Collection<CuentaBancoEmpresa> getCuentaBancoEmpresaCollection() {
        return cuentaBancoEmpresaCollection;
    }

    public void setCuentaBancoEmpresaCollection(Collection<CuentaBancoEmpresa> cuentaBancoEmpresaCollection) {
        this.cuentaBancoEmpresaCollection = cuentaBancoEmpresaCollection;
    }

    public Banco getCuentaBancariaIdBanco() {
        return cuentaBancariaIdBanco;
    }

    public void setCuentaBancariaIdBanco(Banco cuentaBancariaIdBanco) {
        this.cuentaBancariaIdBanco = cuentaBancariaIdBanco;
    }

    public TipoCuentaBanco getCuentaBancariaIdTipoCuenta() {
        return cuentaBancariaIdTipoCuenta;
    }

    public void setCuentaBancariaIdTipoCuenta(TipoCuentaBanco cuentaBancariaIdTipoCuenta) {
        this.cuentaBancariaIdTipoCuenta = cuentaBancariaIdTipoCuenta;
    }

    @XmlTransient
    public Collection<CuentaBancoTrabajador> getCuentaBancoTrabajadorCollection() {
        return cuentaBancoTrabajadorCollection;
    }

    public void setCuentaBancoTrabajadorCollection(Collection<CuentaBancoTrabajador> cuentaBancoTrabajadorCollection) {
        this.cuentaBancoTrabajadorCollection = cuentaBancoTrabajadorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cuentaBancariaId != null ? cuentaBancariaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentaBancaria)) {
            return false;
        }
        CuentaBancaria other = (CuentaBancaria) object;
        if ((this.cuentaBancariaId == null && other.cuentaBancariaId != null) || (this.cuentaBancariaId != null && !this.cuentaBancariaId.equals(other.cuentaBancariaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.sigf.rest.entities.CuentaBancaria[ cuentaBancariaId=" + cuentaBancariaId + " ]";
    }
    
}
