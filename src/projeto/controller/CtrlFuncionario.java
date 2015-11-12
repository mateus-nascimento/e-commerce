/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.controller;

import java.util.List;
import projeto.dao.DAOFactory;
import projeto.modelo.Funcionario;
import projeto.modelo.Usuario;

/**
 *
 * @author aluno
 */
public class CtrlFuncionario {
    public void cadastrar(Funcionario fun){
        DAOFactory.getFuncionarioDAO().inserir(fun);
    }
    public List<Funcionario> buscarFuncionario(){
        return DAOFactory.getFuncionarioDAO().buscarTudo();
    }
    public List<Funcionario> funcionarioEntregador(){
        return DAOFactory.getFuncionarioDAO().funcionarioEntregador();
    }
    public void alterar(Funcionario fun){
        DAOFactory.getFuncionarioDAO().alterar(fun);
    }
    public void remover(Funcionario fun){
        DAOFactory.getFuncionarioDAO().remover(fun);
    }
    public Funcionario carregarFuncionario(Usuario usuario) {
        return DAOFactory.getFuncionarioDAO().carregarFuncionario(usuario);
    }
}
