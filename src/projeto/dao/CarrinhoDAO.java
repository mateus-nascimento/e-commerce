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
import javax.persistence.TypedQuery;
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
    
    public Carrinho getCarrinho(int idUsuario){
       EntityTransaction tx = getEntityManager().getTransaction();
       tx.begin();
       
       TypedQuery<Carrinho> query = getEntityManager().createNamedQuery("Carrinho.getCarrinho", Carrinho.class);
       query.setParameter(1, idUsuario);

       Carrinho carrinho = new Carrinho();
       carrinho = query.getSingleResult();
       
       tx.commit();
       return carrinho;
    }
    
    public boolean carrinhoExiste(int idUsuario){
        List carrinho = null;
        boolean retorno = false;
        
        EntityTransaction tx = getEntityManager().getTransaction();
        tx.begin();
        Query query = getEntityManager().createNamedQuery("Carrinho.existe");
        query.setParameter(1, idUsuario);
        carrinho = query.getResultList();
        tx.commit();
        
        if(carrinho.size() > 0){
            retorno = true;
        }
        return retorno;
    }
    
    public int quantidadeItem(int idCarrinho){
        int quantidade = 0;
        EntityTransaction tx = getEntityManager().getTransaction();
        tx.begin();
        TypedQuery<Integer> query = getEntityManager().createNamedQuery("Carrinho.quantidade", Integer.class);
        query.setParameter(1, idCarrinho);
        quantidade = query.getSingleResult();//testar diferenca entre first e max result
        tx.commit();
        return quantidade;
    }
    
    public double valorTotalCarrinho(int idCarrinho){
        double valor = 0;
        EntityTransaction tx = getEntityManager().getTransaction();
        tx.begin();
        TypedQuery<Double> query = getEntityManager().createNamedQuery("Carrinho.valorTotal", Double.class);
        query.setParameter(1, idCarrinho);
        valor = query.getMaxResults();
        tx.commit();
        return valor;
    }
}
