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
    
    
    public void cadastrar(Usuario usu) throws Exception{
        if (usu.getNome().length() < 3 || usu.getNome().trim().equalsIgnoreCase("")){
            throw new Exception("Favor preencher o campo do nome do usuário corretamente.");
        }else if (usu.getCpf().length() != 11 || usu.getCpf().trim().equalsIgnoreCase("")){
            throw new Exception("Favor preencher o campo do cpf do usuário corretamente.");
        //}else if(!usu.getEmail().contains("@") && !usu.getEmail().contains("\\.")){
        //    throw new Exception("Favor preencher o campo do email do usuário corretamente.");
        }
        else if (usu.getSenha().trim().length() < 6) {
            throw new Exception("Favor preencher o campo da senha do usuário corretamente, com no mínimo 6 digitos.");
        }
        else if(usu.getTelefoneCelular().trim().length() < 11){
            throw  new Exception("Favor preencher o campo do telefone celular do cliente corretamente com 11 dígitos");
        }
        else if(usu.getTelefoneFixo().trim().length() < 10){
            throw  new Exception("Favor preencher o campo do telefone fixo do cliente corretamente com 10 dígitos");
        }else{
            DAOFactory.getUsuarioDAO().inserir(usu);
        }
    }
    public List<Usuario> buscarUsuario(){
        return DAOFactory.getUsuarioDAO().buscarTudo();
    }
    public void alterar(Usuario usu) throws Exception{
        if (usu.getNome().length() < 3 || usu.getNome().trim().equalsIgnoreCase("")){
            throw new Exception("Favor preencher o campo do nome do usuário corretamente.");
        }else if (usu.getCpf().length() != 11 || usu.getCpf().trim().equalsIgnoreCase("")){
            throw new Exception("Favor preencher o campo do cpf do usuário corretamente.");
        //}else if(!usu.getEmail().contains("@") && !usu.getEmail().contains("\\.")){
        //    throw new Exception("Favor preencher o campo do email do usuário corretamente.");
        }
        else if (usu.getSenha().trim().length() < 6) {
            throw new Exception("Favor preencher o campo da senha do usuário corretamente, com no mínimo 6 digitos.");
        }
        else if(usu.getTelefoneCelular().trim().length() < 11){
            throw  new Exception("Favor preencher o campo do telefone celular do cliente corretamente com 11 dígitos");
        }
        else if(usu.getTelefoneFixo().trim().length() < 10){
            throw  new Exception("Favor preencher o campo do telefone fixo do cliente corretamente com 10 dígitos");
        }else {
            DAOFactory.getUsuarioDAO().alterar(usu);
        }
    }
    public void remover(Usuario usu){
        DAOFactory.getUsuarioDAO().remover(usu);
    }
    
    public boolean usuarioLogin(Usuario usu){
        return DAOFactory.getUsuarioDAO().usuarioLogin(usu);
    }
        
    
    
}
