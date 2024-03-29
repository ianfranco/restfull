/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.sigf.rest.dao;

import com.areatecnica.sigf.rest.entities.Bus;
import com.areatecnica.sigf.rest.entities.Cuenta;
import com.areatecnica.sigf.rest.entities.GrupoServicio;
import com.areatecnica.sigf.rest.entities.Guia;
import com.areatecnica.sigf.rest.entities.ProcesoRecaudacion;
import com.areatecnica.sigf.rest.entities.Terminal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ianfr
 */
public interface IGuiaDao<T> extends IGenericDAO<T> {
    
    public List<Guia> findByDate(Date date);
    
    public Guia findByCuentaFolio(Cuenta cuenta, int folio);
    
    public Guia findLastGuiaByBusFecha(Bus bus, Date fecha);
    
    public Guia findLastGuiaByBusEqualsFecha(Bus bus, Date fecha);
    
    public int findLastFolio(Terminal terminal);
        
    public List<Guia> findByProcesoFechaRecaudacion(ProcesoRecaudacion procesoRecaudacion, Date fechaRecaudacion);
    
    public List<Guia> findByProcesoFechaGuia(ProcesoRecaudacion procesoRecaudacion, Date fechaGuia);
    
    public List<Guia> findByBusFecha(Bus bus, Date fecha);
    
    public List<Guia> findByBusBetweenFechaRecaudacion(Bus bus, Date inicio, Date termino);
    
    public List<Guia> findByBusPendientes(Bus bus);
    
    public List<Guia> findByCuentaFecha(Cuenta cuenta, Date fecha);
    
    public List<Guia> findByFechaGrupoServicio(GrupoServicio grupoServicio, Date fecha);
    
    public void delete(Guia guia);
    
}
