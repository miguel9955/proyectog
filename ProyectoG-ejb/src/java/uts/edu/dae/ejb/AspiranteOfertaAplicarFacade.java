/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.edu.dae.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import uts.edu.dae.entidades.AspiranteOfertaAplicar;

/**
 *
 * @author Asus
 */
@Stateless
public class AspiranteOfertaAplicarFacade extends AbstractFacade<AspiranteOfertaAplicar> {
    @PersistenceContext(unitName = "ProyectoG-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
     public List ListaVer(int ID){
        System.out.println(""+ID);
    Query query =em.createQuery("SELECT A.apellidosAspirante AS apelldio, A.hojadevidaAspirante AS hoja FROM AspiranteOfertaAplicar AP,Aspirante A WHERE AP.idAspiranteOferta=:ID AND AP.documentoAspirante=A.documentoAspirante").setParameter("ID", ID);
        if (query.getResultList().size()>0) {
            List orden = query.getResultList();
            return orden;
        }
        return null;
        }

    public AspiranteOfertaAplicarFacade() {
        super(AspiranteOfertaAplicar.class);
    }

    
    
}
