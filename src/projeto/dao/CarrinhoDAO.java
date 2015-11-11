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
import projeto.modelo.Produto;


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
 
    public int quantidadeItemTotal(int idCarrinho){
        int quantidade = 0;
        EntityTransaction tx = getEntityManager().getTransaction();
        tx.begin();
        TypedQuery<Carrinho> query = getEntityManager().createNamedQuery("Carrinho.carrinho", Carrinho.class);
        query.setParameter(1, idCarrinho);
        Carrinho carrinho = query.getSingleResult();
        
        for(Produto p : carrinho.getProdutos()){
            quantidade++;
        }
        tx.commit();
        return quantidade;
    }
    
    //valor total
    public double valorTotalCarrinho(int idCarrinho){
        double valor = 0;
        EntityTransaction tx = getEntityManager().getTransaction();
        tx.begin();
        TypedQuery<Carrinho> query = getEntityManager().createNamedQuery("Carrinho.carrinho", Carrinho.class);
        query.setParameter(1, idCarrinho);
        Carrinho carrinho = query.getSingleResult();
        
        for(Produto p : carrinho.getProdutos()){
           valor += p.getValor() * quantidadeItemCarrinho(idCarrinho, p.getId());
        }
        tx.commit();
        return valor;
    }
    
    public int quantidadeItemCarrinho(int idCarrinho, int idProduto){
         int quantidadeItem = 0;
        EntityTransaction tx = getEntityManager().getTransaction();
        tx.begin();
        TypedQuery<Carrinho> query = getEntityManager().createNamedQuery("Carrinho.carrinho", Carrinho.class);
        query.setParameter(1, idCarrinho);
        Carrinho carrinho = query.getSingleResult();
        
        
        for(Produto p : carrinho.getProdutos()){
            if (p.getId() == idProduto) {
                quantidadeItem++;
            }
        }
        tx.commit();
        return quantidadeItem;
    }
}
