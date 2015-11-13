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
import projeto.interfaces.IFuncionarioDAO;
import projeto.modelo.Funcionario;
import projeto.modelo.Usuario;

/**
 *
 * @author bboyrap
 */



/**
 *
 * @author bboyrap
 */
public class FuncionarioDAO extends DAOGeneric<Funcionario> implements IFuncionarioDAO {
    private EntityManager em;
    
    public FuncionarioDAO(EntityManager em){
        super(em);
    }

    public Funcionario carregarFuncionario(Usuario usuario) {
        EntityTransaction tx = getEntityManager().getTransaction();
        try {
            tx.begin();

            TypedQuery<Funcionario> query = getEntityManager().createNamedQuery("Funcionario.carregarDados", Funcionario.class);
            query.setParameter(1, usuario.getEmail());

            Funcionario funcionario = new Funcionario();
            funcionario = query.getSingleResult();

            //tx.commit();
            return funcionario;
        }finally{
            tx.commit();
        }
    }

    public List<Funcionario> funcionarioEntregador() {
        EntityTransaction tx = getEntityManager().getTransaction();
        try {
            List retorno = null;
            tx.begin();
            Query query = getEntityManager().createNamedQuery("Funcionario.entregador");
            retorno = query.getResultList();
            //tx.commit();
            return retorno;
        }finally{
            tx.commit();
        }
    }
    
}