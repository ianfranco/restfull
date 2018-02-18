/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.sigf.rest.entities.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author ianfrancoconcha
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.areatecnica.sigf.rest.entities.service.AbonoBusFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.AbonoLiquidacionFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.AdministracionMensualFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.AsignacionFamiliarFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.AuditEntryFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.AuditFieldFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.BancoFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.BoletoFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.BusFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.CajaCompensacionFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.CajaProcesoFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.CajaRecaudacionFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.CalleFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.CalleServicioFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.CargaRetroactivaFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.CargaTrabajadorFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.CargoBusFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.CargoLiquidacionFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.CausalFiniquitoFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.CentroCostoFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.CiudadFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.ClasificacionCuentaFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.CompraBoletoFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.CompraCombustibleFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.ComunaFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.ContratoUnidadFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.ControlAsistenciaFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.ControlFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.ControlHorarioServicioFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.ControlServicioFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.CtvResumenFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.CuentaBancariaFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.CuentaBancoEmpresaFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.CuentaBancoProcesoFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.CuentaBancoTrabajadorFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.CuentaFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.DepartamentoFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.DescuentoExtraBusFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.DescuentoExtraFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.DescuentoLiquidacionFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.DescuentoTrabajadorFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.DespachoFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.DetalleCompraBoletoFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.DetalleIntervalosMensualFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.DetalleResumenChequeFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.DetalleResumenRecaudacionFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.DiaFestivoFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.EgresoBusFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.EgresoCajaRecaudacionFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.EgresoFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.EgresoFlotaFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.EgresoProcesoRecaudacionFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.EmpresaFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.EstadoBusFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.EstadoCivilFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.FechaFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.FeriadoLegalFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.FiniquitoRelacionLaboralFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.FlotaFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.FormaPagoFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.FrecuenciaServicioFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.GastoAdministracionMensualFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.GrupoServicioFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.GuiaFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.HaberLiquidacionFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.HaberTrabajadorFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.HoraExtraTrabajadorFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.HorarioJornadaFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.HorarioServicioFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.ImpuestoSegundaCategoriaFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.InstitucionApvFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.InstitucionPrevisionFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.InstitucionSaludFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.IntervalosAdministracionFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.InventarioCajaFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.InventarioInternoFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.JornadaLaboralFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.JornadaTrabajadorFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.LicenciaMedicaFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.LiquidacionEmpresaFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.LiquidacionSueldoFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.LogFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.MarcaBusFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.MenuFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.MetodoPagoFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.ModeloMarcaBusFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.MonedaPactadaInstitucionSaludFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.MutualFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.NumeralSurtidorFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.ObservacionTipoCuentaFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.ObservacionTrabajadorFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.OperadorTransporteFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.ParametroCesantiaFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.ParametroInterpolacionFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.ParentescoCargaFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.PeriodoFrecuenciaFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.PlanCuentaFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.PrecioCombustibleFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.PrivilegioFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.ProcesoRecaudacionFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.RecaudacionBoletoFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.RecaudacionCombustibleFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.RecaudacionDescuentoExtraFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.RecaudacionExtraFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.RecaudacionFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.RecaudacionGuiaFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.RecaudacionMinutoFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.ReconocimientoDeudaFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.RegionFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.RegistroBoletoFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.RegistroMinutoFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.RelacionLaboralFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.RepresentanteEmpresaFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.RepresentanteLegalFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.ResumenRecaudacionFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.RolFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.RolMenuFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.ServicioFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.SindicatoFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.SueldoBaseFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.SurtidorFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.TarifaGrupoServicioFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.TerminalFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.TipoAbonoFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.TipoCargaFamiliarFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.TipoCargoFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.TipoCombustibleFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.TipoContratoFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.TipoControlFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.TipoCotizacionTrabajadorFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.TipoCuentaBancoFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.TipoCuentaFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.TipoDemandaFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.TipoDescuentoTrabajadorFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.TipoDiaFrecuenciaFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.TipoEstacionalidadFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.TipoHaberTrabajadorFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.TipoInstitucionApvFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.TipoLineaFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.TipoMovimientoPersonalFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.TipoNominaFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.TipoObservacionFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.TipoTrabajadorFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.TopeFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.TrabajadorAdicionalSaludFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.TrabajadorFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.UnidadNegocioFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.UsuarioFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.UsuarioSessionFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.ValorFijoFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.ValorMinutoFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.ValorRolloUnidadFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.ValorUfFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.ValorUtmFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.VentaBoletoFacadeREST.class);
        resources.add(com.areatecnica.sigf.rest.entities.service.VentaCombustibleFacadeREST.class);
    }
    
}
