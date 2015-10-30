/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.dao;
import javax.persistence.EntityManager;
import projeto.interfaces.IUsuarioDAO;
import projeto.modelo.Usuario;

/**
 *
 * @author bboyrap
 */



/**
 *
 * @author bboyrap
 */
public class UsuarioDAO extends DAOGeneric<Usuario> implements IUsuarioDAO {
    private EntityManager em;
    
    public UsuarioDAO(EntityManager em){
        super(em);
    }
    
}
