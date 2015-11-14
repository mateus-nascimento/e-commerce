/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//teste
package projeto.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author bboyrap
 */
public abstract class DAOFactory {

    private static EntityManager manager;
    private static final EntityManagerFactory factory;

    static {
        factory = Persistence.createEntityManagerFactory("testeprojeto");
//        factory = Persistence.createEntityManagerFactory("projetoecommerce");
        if (manager == null || !manager.isOpen()) {
            manager = factory.createEntityManager();
        }
    }

    public static ProdutoDAO getProdutoDAO(){
        ProdutoDAO dao = new ProdutoDAO(manager);
        return dao;
    }
    
    public static CategoriaDAO getCategoriaDAO(){
        CategoriaDAO dao = new CategoriaDAO(manager);
        return dao;
    }
    
    public static CarrinhoDAO getCarrinhoDAO(){
        CarrinhoDAO dao = new CarrinhoDAO(manager);
        return dao;
    }
    public static EnderecoDAO getEnderecoDAO(){
        EnderecoDAO dao = new EnderecoDAO(manager);
        return dao;
    }
    public static EntregaDAO getEntregaDAO(){
        EntregaDAO dao = new EntregaDAO(manager);
        return dao;
    }
    public static FuncionarioDAO getFuncionarioDAO(){
        FuncionarioDAO dao = new FuncionarioDAO(manager);
        return dao;
    }
    public static OsDAO getOsDAO(){
        OsDAO dao = new OsDAO(manager);
        return dao;
    }
    
    public static UsuarioDAO getUsuarioDAO(){
        UsuarioDAO dao = new UsuarioDAO(manager);
        return dao;
    }
}