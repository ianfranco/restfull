/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.sigf.rest.entities.service;

import com.areatecnica.sigf.rest.dao.IGuiaDao;
import com.areatecnica.sigf.rest.dao.impl.IGuiaDaoImpl;
import com.areatecnica.sigf.rest.entities.Guia;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ianfrancoconcha
 */
@Stateless
@Path("guia")
public class GuiaFacadeREST extends AbstractFacade<Guia> {

    private IGuiaDao dao; 
    
    @PersistenceContext(unitName = "com.areatecnica.sigf_SIGFRest_war_1.0PU")
    private EntityManager em;

    public GuiaFacadeREST() {
        super(Guia.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Guia entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Guia entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Guia find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Guia> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Guia> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    
    /*NUEVO METODO*/
    @GET
    @Path("/consultaq/{fecha2}")
    
    @Produces(MediaType.TEXT_PLAIN)
    public String test(@PathParam("fecha2") Integer fecha){
        this.dao = new IGuiaDaoImpl();
        return "AWESOME"+fecha;
    }

    @GET
    @Path("/consulta/{fecha}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Guia> findGuiasByDate(@PathParam("fecha") Date fecha){
        this.dao = new IGuiaDaoImpl();
        return this.dao.findByDate(fecha);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
