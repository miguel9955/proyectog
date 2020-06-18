/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.edu.dae.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import uts.edu.dae.entidades.Aspirante;

/**
 *
 * @author Asus
 */
@Stateless
public class AspiranteFacade extends AbstractFacade<Aspirante> {
    @PersistenceContext(unitName = "ProyectoG-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AspiranteFacade() {
        super(Aspirante.class);
    }
    
}
