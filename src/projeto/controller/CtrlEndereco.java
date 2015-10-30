/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.controller;

import java.util.List;
import projeto.dao.DAOFactory;
import projeto.dao.EnderecoDAO;
import projeto.modelo.Endereco;

/**
 *
 * @author aluno
 */
public class CtrlEndereco {
    
    public void cadastrar(Endereco end) {
        DAOFactory.getEnderecoDAO().inserir(end);
    }
    public List<Endereco> buscarEndereco(int idUsuario){
        return DAOFactory.getEnderecoDAO().buscarEndereco(idUsuario);
    }
    public void alterar(Endereco end){
        DAOFactory.getEnderecoDAO().alterar(end);
    }
    public void remover(Endereco end){
        DAOFactory.getEnderecoDAO().remover(end);
    }
    
}
