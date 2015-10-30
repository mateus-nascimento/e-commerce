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
import projeto.interfaces.ICarrinhoDAO;
import projeto.modelo.Carrinho;


/**
 *
 * @author bboyrap
 */
public class CarrinhoDAO extends DAOGeneric<Carrinho> implements ICarrinhoDAO {
    private EntityManager em;
    
    public CarrinhoDAO(EntityManager em){
        super(em);
    }
    public List<Carrinho> carrinhoListar(int idUsuario){

        List retorno = null;
        EntityTransaction tx = getEntityManager().getTransaction();
        tx.begin();
        Query query = getEntityManager().createNamedQuery("Carrinho.byUser");
        query.setParameter(1, idUsuario);
        retorno = query.getResultList();
        tx.commit();
        return retorno;
                
    }
    
    public int quantidadeItem(int idCarrinho){
        int quantidade = 0;
        EntityTransaction tx = getEntityManager().getTransaction();
        tx.begin();
        Query query = getEntityManager().createNamedQuery("Carrinho.Quantidade");
        query.setParameter(1, idCarrinho);
        quantidade = query.getMaxResults();
        tx.commit();
        return quantidade;
    }
    
    public int valorTotalCarrinho(int idCarrinho){
        int quantidade = 0;
        EntityTransaction tx = getEntityManager().getTransaction();
        tx.begin();
        Query query = getEntityManager().createNamedQuery("Carrinho.valorTotal");
        query.setParameter(1, idCarrinho);
        quantidade = query.getMaxResults();
        tx.commit();
        return quantidade;
        
    }
}
