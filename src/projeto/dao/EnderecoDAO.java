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
import projeto.interfaces.IEnderecoDAO;
import projeto.modelo.Endereco;

/**
 *
 * @author bboyrap
 */



/**
 *
 * @author bboyrap
 */
public class EnderecoDAO extends DAOGeneric<Endereco> implements IEnderecoDAO {

    private EntityManager em;
    
    public EnderecoDAO(EntityManager em){
        super(em);
    }
    
    public List buscarEndereco(int idUsuario){
        EntityTransaction tx = getEntityManager().getTransaction();
        try {
            List retorno = null;
            tx.begin();
            Query query = getEntityManager().createNamedQuery("Endereco.byUser");
            query.setParameter(1, idUsuario);
            retorno = query.getResultList();
            //tx.commit();
            return retorno;
            
        }finally{
            tx.commit();
        }
    }
    
    
    
}
