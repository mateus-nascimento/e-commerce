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
        EntityTransaction tx = getEntityManager().getTransaction();
        try {
            tx.begin();
            Query query = getEntityManager().createNamedQuery("Carrinho.byUser");
            query.setParameter(1, idUsuario);
            List<Carrinho> retorno = query.getResultList();
            return retorno;
        }finally{
            tx.commit();
        }
    }
    
    public Carrinho getCarrinho(int idUsuario){
       EntityTransaction tx = getEntityManager().getTransaction();
       try{
           tx.begin();
           TypedQuery<Carrinho> query = getEntityManager().createNamedQuery("Carrinho.getCarrinho", Carrinho.class);
           query.setParameter(1, idUsuario);
           Carrinho carrinho = new Carrinho();
           carrinho = query.getSingleResult();
           return carrinho;
        }finally{
            tx.commit();
        }
    }
    
    public boolean carrinhoExiste(int idUsuario){
        EntityTransaction tx = getEntityManager().getTransaction();
        try{
            List carrinho = null;
            boolean retorno = false;
            tx.begin();
            Query query = getEntityManager().createNamedQuery("Carrinho.existe");
            query.setParameter(1, idUsuario);
            carrinho = query.getResultList();
            if(carrinho.size() > 0){
                retorno = true;
            }
            return retorno;
        }finally{
            tx.commit();
        }
    }
 
    public int quantidadeItemTotal(int idCarrinho){
        EntityTransaction tx = getEntityManager().getTransaction();
        try{
            int quantidade = 0;
            tx.begin();
            TypedQuery<Carrinho> query = getEntityManager().createNamedQuery("Carrinho.carrinho", Carrinho.class);
            query.setParameter(1, idCarrinho);
            Carrinho carrinho = query.getSingleResult();

            for(Produto p : carrinho.getProdutos()){
                quantidade++;
            }
            return quantidade;
        }finally{
            tx.commit();
        }
    }
    
    //valor total
    public double valorTotalCarrinho(int idCarrinho){
        EntityTransaction tx = getEntityManager().getTransaction();
        try{
            double valor = 0;
            tx.begin();
            TypedQuery<Carrinho> query = getEntityManager().createNamedQuery("Carrinho.carrinho", Carrinho.class);
            query.setParameter(1, idCarrinho);
            Carrinho carrinho = query.getSingleResult();

            for(Produto p : carrinho.getProdutos()){
               valor += p.getValor();
            }
            return valor;
        }finally{
            tx.commit();
        }
    }

    
}
