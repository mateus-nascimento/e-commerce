/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.dao;
import javax.persistence.EntityManager;
import projeto.interfaces.IOsDAO;
import projeto.modelo.Os;

/**
 *
 * @author bboyrap
 */



/**
 *
 * @author bboyrap
 */
public class OsDAO extends DAOGeneric<Os> implements IOsDAO {
    private EntityManager em;
    
    public OsDAO(EntityManager em){
        super(em);
    }
    
}
