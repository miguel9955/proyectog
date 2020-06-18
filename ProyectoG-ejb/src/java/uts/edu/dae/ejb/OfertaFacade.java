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
import uts.edu.dae.entidades.Oferta;

/**
 *
 * @author Asus
 */
@Stateless
public class OfertaFacade extends AbstractFacade<Oferta> {
    @PersistenceContext(unitName = "ProyectoG-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public List ListaEmpresa(String CORREO_EMPRESA){
        System.out.println(""+CORREO_EMPRESA);
    Query query =em.createQuery("SELECT O FROM Oferta O WHERE O.nitEmpresa =(SELECT E.nitEmpresa FROM Empresa E WHERE E.correoEmpresa='cococorp@gmail.com')");
        if (query.getResultList().size()>0) {
            List orden = query.getResultList();
            return orden;
        }
        return null;
        }
    public List ListaOferTaa(String CORREO_EMPRESA){
        Query query =em.createQuery("SELECT O FROM Oferta O, Empresa E WHERE O.nitEmpresa = E.nitEmpresa ");
        if (query.getResultList().size()>0) {
            List orden = query.getResultList();
            return orden;
        }
        return null;
    }
public List ListaOfer(){
        Query query =em.createQuery("SELECT O FROM Oferta O WHERE O.estadoOferta= 'ACTIVO' ");
        if (query.getResultList().size()>0) {
            List orden = query.getResultList();
            return orden;
        }
        return null;
    }

    public OfertaFacade() {
        super(Oferta.class);
    }
    
}
