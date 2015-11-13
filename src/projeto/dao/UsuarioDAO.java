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
    
    public Boolean usuarioLogin(Usuario usuario){
        
        EntityTransaction tx = getEntityManager().getTransaction();
        try {
            List existe = null;
            boolean retorno = false;
            tx.begin();
            Query query = getEntityManager().createNamedQuery("Usuario.login");
            query.setParameter(1, usuario.getEmail());
            query.setParameter(2, usuario.getSenha());
            existe = query.getResultList();
            //tx.commit();
            if (existe.size() > 0) {
                retorno = true;
            }
            return retorno;
            
        }finally{
            tx.commit();
        }
    }
    
    
}
