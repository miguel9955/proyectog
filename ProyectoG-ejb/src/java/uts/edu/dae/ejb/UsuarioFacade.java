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
import uts.edu.dae.entidades.Usuario;

/**
 *
 * @author Asus
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {
    @PersistenceContext(unitName = "ProyectoG-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public Usuario encontrarUsuarioNombre(String correoUsuario){
        Query query = em.createNamedQuery("Usuario.findByCorreoUsuario",Usuario.class)
                .setParameter("correoUsuario", correoUsuario);
        List <Usuario> listado = query.getResultList();
        if (!listado.isEmpty()) {
            return listado.get(0);
        } 
    return null;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
}
