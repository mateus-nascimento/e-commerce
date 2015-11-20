/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
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
    
    public List<Produto> produtosCarrinho(int idCarrinho) {
        EntityTransaction tx = getEntityManager().getTransaction();
        try{
            tx.begin();
            Query query = getEntityManager().createNamedQuery("Carrinho.produtos");
            query.setParameter(1, idCarrinho);
            List<Produto> retorno = query.getResultList();
            return retorno;
        }finally{
            tx.commit();
        }
    }
    
}
