/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.controller;

import java.util.List;
import projeto.dao.DAOFactory;
import projeto.modelo.Usuario;

/**
 *
 * @author aluno
 */
public class CtrlUsuario {
    
    
    public void cadastrar(Usuario usu){
        DAOFactory.getUsuarioDAO().inserir(usu);
    }
    public List<Usuario> buscarUsuario(){
        return DAOFactory.getUsuarioDAO().buscarTudo();
    }
    public void alterar(Usuario usu){
        DAOFactory.getUsuarioDAO().alterar(usu);
    }
    public void remover(Usuario usu){
        DAOFactory.getUsuarioDAO().remover(usu);
    }
    
    public boolean usuarioLogin(Usuario usu){
        return DAOFactory.getUsuarioDAO().usuarioLogin(usu);
    }
        
    
    
}
