/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.dao;
import javax.persistence.EntityManager;
import projeto.interfaces.IProdutoDAO;
import projeto.modelo.Produto;

/**
 *
 * @author bboyrap
 */



/**
 *
 * @author bboyrap
 */
public class ProdutoDAO extends DAOGeneric<Produto> implements IProdutoDAO {
    private EntityManager em;
    
    public ProdutoDAO(EntityManager em){
        super(em);
    }
    
    
}
