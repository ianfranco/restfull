/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.sigf.rest.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ianfrancoconcha
 */
@Entity
@Table(name = "cuenta_banco_proceso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CuentaBancoProceso.findAll", query = "SELECT c FROM CuentaBancoProceso c")
    , @NamedQuery(name = "CuentaBancoProceso.findByCuentaBancoProcesoId", query = "SELECT c FROM CuentaBancoProceso c WHERE c.cuentaBancoProcesoId = :cuentaBancoProcesoId")})
public class CuentaBancoProceso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cuenta_banco_proceso_id")
    private Integer cuentaBancoProcesoId;
    @JoinColumn(name = "cuenta_banco_proceso_id_banco", referencedColumnName = "cuenta_bancaria_id")
    @ManyToOne(optional = false)
    private CuentaBancaria cuentaBancoProcesoIdBanco;
    @JoinColumn(name = "cuenta_banco_proceso_id_proceso", referencedColumnName = "proceso_recaudacion_id")
    @ManyToOne(optional = false)
    private ProcesoRecaudacion cuentaBancoProcesoIdProceso;

    public CuentaBancoProceso() {
    }

    public CuentaBancoProceso(Integer cuentaBancoProcesoId) {
        this.cuentaBancoProcesoId = cuentaBancoProcesoId;
    }

    public Integer getCuentaBancoProcesoId() {
        return cuentaBancoProcesoId;
    }

    public void setCuentaBancoProcesoId(Integer cuentaBancoProcesoId) {
        this.cuentaBancoProcesoId = cuentaBancoProcesoId;
    }

    public CuentaBancaria getCuentaBancoProcesoIdBanco() {
        return cuentaBancoProcesoIdBanco;
    }

    public void setCuentaBancoProcesoIdBanco(CuentaBancaria cuentaBancoProcesoIdBanco) {
        this.cuentaBancoProcesoIdBanco = cuentaBancoProcesoIdBanco;
    }

    public ProcesoRecaudacion getCuentaBancoProcesoIdProceso() {
        return cuentaBancoProcesoIdProceso;
    }

    public void setCuentaBancoProcesoIdProceso(ProcesoRecaudacion cuentaBancoProcesoIdProceso) {
        this.cuentaBancoProcesoIdProceso = cuentaBancoProcesoIdProceso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cuentaBancoProcesoId != null ? cuentaBancoProcesoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentaBancoProceso)) {
            return false;
        }
        CuentaBancoProceso other = (CuentaBancoProceso) object;
        if ((this.cuentaBancoProcesoId == null && other.cuentaBancoProcesoId != null) || (this.cuentaBancoProcesoId != null && !this.cuentaBancoProcesoId.equals(other.cuentaBancoProcesoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.sigf.rest.entities.CuentaBancoProceso[ cuentaBancoProcesoId=" + cuentaBancoProcesoId + " ]";
    }
    
}
