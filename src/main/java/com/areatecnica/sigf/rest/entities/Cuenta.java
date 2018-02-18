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
@Table(name = "cuenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c")
    , @NamedQuery(name = "Cuenta.findByCuentaId", query = "SELECT c FROM Cuenta c WHERE c.cuentaId = :cuentaId")
    , @NamedQuery(name = "Cuenta.findByCuentaAdministrador", query = "SELECT c FROM Cuenta c WHERE c.cuentaAdministrador = :cuentaAdministrador")
    , @NamedQuery(name = "Cuenta.findByCuentaRut", query = "SELECT c FROM Cuenta c WHERE c.cuentaRut = :cuentaRut")
    , @NamedQuery(name = "Cuenta.findByCuentaActiva", query = "SELECT c FROM Cuenta c WHERE c.cuentaActiva = :cuentaActiva")})
public class Cuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cuenta_id")
    private Integer cuentaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "cuenta_administrador")
    private String cuentaAdministrador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "cuenta_rut")
    private String cuentaRut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuenta_activa")
    private boolean cuentaActiva;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "horarioJornadaIdCuenta")
    private Collection<HorarioJornada> horarioJornadaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "boletoIdCuenta")
    private Collection<Boleto> boletoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodoFrecuenciaIdCuenta")
    private Collection<PeriodoFrecuencia> periodoFrecuenciaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "valorMinutoIdCuenta")
    private Collection<ValorMinuto> valorMinutoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "representanteLegalIdCuenta")
    private Collection<RepresentanteLegal> representanteLegalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bancoIdCuenta")
    private Collection<Banco> bancoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoControlIdCuenta")
    private Collection<TipoControl> tipoControlCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "centroCostoIdCuenta")
    private Collection<CentroCosto> centroCostoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioIdCuenta")
    private Collection<Usuario> usuarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asignacionFamiliarIdCuenta")
    private Collection<AsignacionFamiliar> asignacionFamiliarCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "institucionSaludIdCuenta")
    private Collection<InstitucionSalud> institucionSaludCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "flotaIdCuenta")
    private Collection<Flota> flotaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "egresoIdCuenta")
    private Collection<Egreso> egresoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoObservacionIdCuenta")
    private Collection<TipoObservacion> tipoObservacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "administracionMensualIdCuenta")
    private Collection<AdministracionMensual> administracionMensualCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "intervalosAdministracionIdCuenta")
    private Collection<IntervalosAdministracion> intervalosAdministracionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoHaberTrabajadorIdCuenta")
    private Collection<TipoHaberTrabajador> tipoHaberTrabajadorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trabajadorIdCuenta")
    private Collection<Trabajador> trabajadorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "precioCombustibleIdCuenta")
    private Collection<PrecioCombustible> precioCombustibleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "institucionApvIdCuenta")
    private Collection<InstitucionApv> institucionApvCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoContratoIdCuenta")
    private Collection<TipoContrato> tipoContratoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "descuentoExtraIdCuenta")
    private Collection<DescuentoExtra> descuentoExtraCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sindicatoIdCuenta")
    private Collection<Sindicato> sindicatoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compraBoletoIdCuenta")
    private Collection<CompraBoleto> compraBoletoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoCargoIdCuenta")
    private Collection<TipoCargo> tipoCargoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoDescuentoTrabajadorIdCuenta")
    private Collection<TipoDescuentoTrabajador> tipoDescuentoTrabajadorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "institucionPrevisionIdCuenta")
    private Collection<InstitucionPrevision> institucionPrevisionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupoServicioIdCuenta")
    private Collection<GrupoServicio> grupoServicioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cajaRecaudacionIdCuenta")
    private Collection<CajaRecaudacion> cajaRecaudacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compraCombustibleIdCuenta")
    private Collection<CompraCombustible> compraCombustibleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mutualIdCuenta")
    private Collection<Mutual> mutualCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoAbonoIdCuenta")
    private Collection<TipoAbono> tipoAbonoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaIdCuenta")
    private Collection<Empresa> empresaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadNegocioIdCuenta")
    private Collection<UnidadNegocio> unidadNegocioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "procesoRecaudacionIdCuenta")
    private Collection<ProcesoRecaudacion> procesoRecaudacionCollection;
    @JoinColumn(name = "cuenta_id_tipo", referencedColumnName = "tipo_cuenta_id")
    @ManyToOne(optional = false)
    private TipoCuenta cuentaIdTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicioIdCuenta")
    private Collection<Servicio> servicioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoTrabajadorIdCuenta")
    private Collection<TipoTrabajador> tipoTrabajadorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cajaCompensacionIdCuenta")
    private Collection<CajaCompensacion> cajaCompensacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "controlIdCuenta")
    private Collection<Control> controlCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "terminalIdCuenta")
    private Collection<Terminal> terminalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departamentoIdCuenta")
    private Collection<Departamento> departamentoCollection;

    public Cuenta() {
    }

    public Cuenta(Integer cuentaId) {
        this.cuentaId = cuentaId;
    }

    public Cuenta(Integer cuentaId, String cuentaAdministrador, String cuentaRut, boolean cuentaActiva) {
        this.cuentaId = cuentaId;
        this.cuentaAdministrador = cuentaAdministrador;
        this.cuentaRut = cuentaRut;
        this.cuentaActiva = cuentaActiva;
    }

    public Integer getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(Integer cuentaId) {
        this.cuentaId = cuentaId;
    }

    public String getCuentaAdministrador() {
        return cuentaAdministrador;
    }

    public void setCuentaAdministrador(String cuentaAdministrador) {
        this.cuentaAdministrador = cuentaAdministrador;
    }

    public String getCuentaRut() {
        return cuentaRut;
    }

    public void setCuentaRut(String cuentaRut) {
        this.cuentaRut = cuentaRut;
    }

    public boolean getCuentaActiva() {
        return cuentaActiva;
    }

    public void setCuentaActiva(boolean cuentaActiva) {
        this.cuentaActiva = cuentaActiva;
    }

    @XmlTransient
    public Collection<HorarioJornada> getHorarioJornadaCollection() {
        return horarioJornadaCollection;
    }

    public void setHorarioJornadaCollection(Collection<HorarioJornada> horarioJornadaCollection) {
        this.horarioJornadaCollection = horarioJornadaCollection;
    }

    @XmlTransient
    public Collection<Boleto> getBoletoCollection() {
        return boletoCollection;
    }

    public void setBoletoCollection(Collection<Boleto> boletoCollection) {
        this.boletoCollection = boletoCollection;
    }

    @XmlTransient
    public Collection<PeriodoFrecuencia> getPeriodoFrecuenciaCollection() {
        return periodoFrecuenciaCollection;
    }

    public void setPeriodoFrecuenciaCollection(Collection<PeriodoFrecuencia> periodoFrecuenciaCollection) {
        this.periodoFrecuenciaCollection = periodoFrecuenciaCollection;
    }

    @XmlTransient
    public Collection<ValorMinuto> getValorMinutoCollection() {
        return valorMinutoCollection;
    }

    public void setValorMinutoCollection(Collection<ValorMinuto> valorMinutoCollection) {
        this.valorMinutoCollection = valorMinutoCollection;
    }

    @XmlTransient
    public Collection<RepresentanteLegal> getRepresentanteLegalCollection() {
        return representanteLegalCollection;
    }

    public void setRepresentanteLegalCollection(Collection<RepresentanteLegal> representanteLegalCollection) {
        this.representanteLegalCollection = representanteLegalCollection;
    }

    @XmlTransient
    public Collection<Banco> getBancoCollection() {
        return bancoCollection;
    }

    public void setBancoCollection(Collection<Banco> bancoCollection) {
        this.bancoCollection = bancoCollection;
    }

    @XmlTransient
    public Collection<TipoControl> getTipoControlCollection() {
        return tipoControlCollection;
    }

    public void setTipoControlCollection(Collection<TipoControl> tipoControlCollection) {
        this.tipoControlCollection = tipoControlCollection;
    }

    @XmlTransient
    public Collection<CentroCosto> getCentroCostoCollection() {
        return centroCostoCollection;
    }

    public void setCentroCostoCollection(Collection<CentroCosto> centroCostoCollection) {
        this.centroCostoCollection = centroCostoCollection;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @XmlTransient
    public Collection<AsignacionFamiliar> getAsignacionFamiliarCollection() {
        return asignacionFamiliarCollection;
    }

    public void setAsignacionFamiliarCollection(Collection<AsignacionFamiliar> asignacionFamiliarCollection) {
        this.asignacionFamiliarCollection = asignacionFamiliarCollection;
    }

    @XmlTransient
    public Collection<InstitucionSalud> getInstitucionSaludCollection() {
        return institucionSaludCollection;
    }

    public void setInstitucionSaludCollection(Collection<InstitucionSalud> institucionSaludCollection) {
        this.institucionSaludCollection = institucionSaludCollection;
    }

    @XmlTransient
    public Collection<Flota> getFlotaCollection() {
        return flotaCollection;
    }

    public void setFlotaCollection(Collection<Flota> flotaCollection) {
        this.flotaCollection = flotaCollection;
    }

    @XmlTransient
    public Collection<Egreso> getEgresoCollection() {
        return egresoCollection;
    }

    public void setEgresoCollection(Collection<Egreso> egresoCollection) {
        this.egresoCollection = egresoCollection;
    }

    @XmlTransient
    public Collection<TipoObservacion> getTipoObservacionCollection() {
        return tipoObservacionCollection;
    }

    public void setTipoObservacionCollection(Collection<TipoObservacion> tipoObservacionCollection) {
        this.tipoObservacionCollection = tipoObservacionCollection;
    }

    @XmlTransient
    public Collection<AdministracionMensual> getAdministracionMensualCollection() {
        return administracionMensualCollection;
    }

    public void setAdministracionMensualCollection(Collection<AdministracionMensual> administracionMensualCollection) {
        this.administracionMensualCollection = administracionMensualCollection;
    }

    @XmlTransient
    public Collection<IntervalosAdministracion> getIntervalosAdministracionCollection() {
        return intervalosAdministracionCollection;
    }

    public void setIntervalosAdministracionCollection(Collection<IntervalosAdministracion> intervalosAdministracionCollection) {
        this.intervalosAdministracionCollection = intervalosAdministracionCollection;
    }

    @XmlTransient
    public Collection<TipoHaberTrabajador> getTipoHaberTrabajadorCollection() {
        return tipoHaberTrabajadorCollection;
    }

    public void setTipoHaberTrabajadorCollection(Collection<TipoHaberTrabajador> tipoHaberTrabajadorCollection) {
        this.tipoHaberTrabajadorCollection = tipoHaberTrabajadorCollection;
    }

    @XmlTransient
    public Collection<Trabajador> getTrabajadorCollection() {
        return trabajadorCollection;
    }

    public void setTrabajadorCollection(Collection<Trabajador> trabajadorCollection) {
        this.trabajadorCollection = trabajadorCollection;
    }

    @XmlTransient
    public Collection<PrecioCombustible> getPrecioCombustibleCollection() {
        return precioCombustibleCollection;
    }

    public void setPrecioCombustibleCollection(Collection<PrecioCombustible> precioCombustibleCollection) {
        this.precioCombustibleCollection = precioCombustibleCollection;
    }

    @XmlTransient
    public Collection<InstitucionApv> getInstitucionApvCollection() {
        return institucionApvCollection;
    }

    public void setInstitucionApvCollection(Collection<InstitucionApv> institucionApvCollection) {
        this.institucionApvCollection = institucionApvCollection;
    }

    @XmlTransient
    public Collection<TipoContrato> getTipoContratoCollection() {
        return tipoContratoCollection;
    }

    public void setTipoContratoCollection(Collection<TipoContrato> tipoContratoCollection) {
        this.tipoContratoCollection = tipoContratoCollection;
    }

    @XmlTransient
    public Collection<DescuentoExtra> getDescuentoExtraCollection() {
        return descuentoExtraCollection;
    }

    public void setDescuentoExtraCollection(Collection<DescuentoExtra> descuentoExtraCollection) {
        this.descuentoExtraCollection = descuentoExtraCollection;
    }

    @XmlTransient
    public Collection<Sindicato> getSindicatoCollection() {
        return sindicatoCollection;
    }

    public void setSindicatoCollection(Collection<Sindicato> sindicatoCollection) {
        this.sindicatoCollection = sindicatoCollection;
    }

    @XmlTransient
    public Collection<CompraBoleto> getCompraBoletoCollection() {
        return compraBoletoCollection;
    }

    public void setCompraBoletoCollection(Collection<CompraBoleto> compraBoletoCollection) {
        this.compraBoletoCollection = compraBoletoCollection;
    }

    @XmlTransient
    public Collection<TipoCargo> getTipoCargoCollection() {
        return tipoCargoCollection;
    }

    public void setTipoCargoCollection(Collection<TipoCargo> tipoCargoCollection) {
        this.tipoCargoCollection = tipoCargoCollection;
    }

    @XmlTransient
    public Collection<TipoDescuentoTrabajador> getTipoDescuentoTrabajadorCollection() {
        return tipoDescuentoTrabajadorCollection;
    }

    public void setTipoDescuentoTrabajadorCollection(Collection<TipoDescuentoTrabajador> tipoDescuentoTrabajadorCollection) {
        this.tipoDescuentoTrabajadorCollection = tipoDescuentoTrabajadorCollection;
    }

    @XmlTransient
    public Collection<InstitucionPrevision> getInstitucionPrevisionCollection() {
        return institucionPrevisionCollection;
    }

    public void setInstitucionPrevisionCollection(Collection<InstitucionPrevision> institucionPrevisionCollection) {
        this.institucionPrevisionCollection = institucionPrevisionCollection;
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
    public Collection<CompraCombustible> getCompraCombustibleCollection() {
        return compraCombustibleCollection;
    }

    public void setCompraCombustibleCollection(Collection<CompraCombustible> compraCombustibleCollection) {
        this.compraCombustibleCollection = compraCombustibleCollection;
    }

    @XmlTransient
    public Collection<Mutual> getMutualCollection() {
        return mutualCollection;
    }

    public void setMutualCollection(Collection<Mutual> mutualCollection) {
        this.mutualCollection = mutualCollection;
    }

    @XmlTransient
    public Collection<TipoAbono> getTipoAbonoCollection() {
        return tipoAbonoCollection;
    }

    public void setTipoAbonoCollection(Collection<TipoAbono> tipoAbonoCollection) {
        this.tipoAbonoCollection = tipoAbonoCollection;
    }

    @XmlTransient
    public Collection<Empresa> getEmpresaCollection() {
        return empresaCollection;
    }

    public void setEmpresaCollection(Collection<Empresa> empresaCollection) {
        this.empresaCollection = empresaCollection;
    }

    @XmlTransient
    public Collection<UnidadNegocio> getUnidadNegocioCollection() {
        return unidadNegocioCollection;
    }

    public void setUnidadNegocioCollection(Collection<UnidadNegocio> unidadNegocioCollection) {
        this.unidadNegocioCollection = unidadNegocioCollection;
    }

    @XmlTransient
    public Collection<ProcesoRecaudacion> getProcesoRecaudacionCollection() {
        return procesoRecaudacionCollection;
    }

    public void setProcesoRecaudacionCollection(Collection<ProcesoRecaudacion> procesoRecaudacionCollection) {
        this.procesoRecaudacionCollection = procesoRecaudacionCollection;
    }

    public TipoCuenta getCuentaIdTipo() {
        return cuentaIdTipo;
    }

    public void setCuentaIdTipo(TipoCuenta cuentaIdTipo) {
        this.cuentaIdTipo = cuentaIdTipo;
    }

    @XmlTransient
    public Collection<Servicio> getServicioCollection() {
        return servicioCollection;
    }

    public void setServicioCollection(Collection<Servicio> servicioCollection) {
        this.servicioCollection = servicioCollection;
    }

    @XmlTransient
    public Collection<TipoTrabajador> getTipoTrabajadorCollection() {
        return tipoTrabajadorCollection;
    }

    public void setTipoTrabajadorCollection(Collection<TipoTrabajador> tipoTrabajadorCollection) {
        this.tipoTrabajadorCollection = tipoTrabajadorCollection;
    }

    @XmlTransient
    public Collection<CajaCompensacion> getCajaCompensacionCollection() {
        return cajaCompensacionCollection;
    }

    public void setCajaCompensacionCollection(Collection<CajaCompensacion> cajaCompensacionCollection) {
        this.cajaCompensacionCollection = cajaCompensacionCollection;
    }

    @XmlTransient
    public Collection<Control> getControlCollection() {
        return controlCollection;
    }

    public void setControlCollection(Collection<Control> controlCollection) {
        this.controlCollection = controlCollection;
    }

    @XmlTransient
    public Collection<Terminal> getTerminalCollection() {
        return terminalCollection;
    }

    public void setTerminalCollection(Collection<Terminal> terminalCollection) {
        this.terminalCollection = terminalCollection;
    }

    @XmlTransient
    public Collection<Departamento> getDepartamentoCollection() {
        return departamentoCollection;
    }

    public void setDepartamentoCollection(Collection<Departamento> departamentoCollection) {
        this.departamentoCollection = departamentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cuentaId != null ? cuentaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuenta)) {
            return false;
        }
        Cuenta other = (Cuenta) object;
        if ((this.cuentaId == null && other.cuentaId != null) || (this.cuentaId != null && !this.cuentaId.equals(other.cuentaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.sigf.rest.entities.Cuenta[ cuentaId=" + cuentaId + " ]";
    }
    
}
