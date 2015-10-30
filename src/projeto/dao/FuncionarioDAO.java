/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.dao;
import javax.persistence.EntityManager;
import projeto.interfaces.IFuncionarioDAO;
import projeto.modelo.Funcionario;

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
    
}