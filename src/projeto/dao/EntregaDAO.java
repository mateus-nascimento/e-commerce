/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.dao;
import javax.persistence.EntityManager;
import projeto.interfaces.IEntregaDAO;
import projeto.modelo.Entrega;

/**
 *
 * @author bboyrap
 */



/**
 *
 * @author bboyrap
 */
public class EntregaDAO extends DAOGeneric<Entrega> implements IEntregaDAO {
    private EntityManager em;
    
    public EntregaDAO(EntityManager em){
        super(em);
    }
    
}