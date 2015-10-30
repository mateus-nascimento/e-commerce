/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.dao;
import javax.persistence.EntityManager;
import projeto.interfaces.ICategoriaDAO;

import projeto.modelo.Categoria;


/**
 *
 * @author bboyrap
 */

/**
 *
 * @author bboyrap
 */
public class CategoriaDAO extends DAOGeneric<Categoria> implements ICategoriaDAO {
    private EntityManager em;
    
    public CategoriaDAO(EntityManager em){
        super(em);
    }
    
}
