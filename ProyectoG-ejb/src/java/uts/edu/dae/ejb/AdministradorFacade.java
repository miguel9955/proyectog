/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.edu.dae.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import uts.edu.dae.entidades.Administrador;

/**
 *
 * @author Asus
 */
@Stateless
public class AdministradorFacade extends AbstractFacade<Administrador> {
    @PersistenceContext(unitName = "ProyectoG-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdministradorFacade() {
        super(Administrador.class);
    }
    
}
