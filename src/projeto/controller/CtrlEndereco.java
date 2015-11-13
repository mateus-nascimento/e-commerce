/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.controller;

import java.util.List;
import projeto.dao.DAOFactory;
import projeto.modelo.Endereco;

/**
 *
 * @author aluno
 */
public class CtrlEndereco {
    
    public void cadastrar(Endereco end) throws Exception {
        if (end.getBairro().trim().equals("") || end.getBairro().length() < 4) {
            throw new Exception("Favor preencher o campo do bairro corretamente.");
        }else if (end.getCep().trim().equals("") || end.getCep().length() != 8) {
            throw new Exception("Favor preencher o campo do cep corretamente.");
        }else if (end.getCidade().trim().equals("") || end.getCidade().length() < 4) {
            throw new Exception("Favor preencher o campo da cidade corretamente.");
        }else if (end.getComplemento().trim().equals("") || end.getComplemento().length() < 4) {
            throw new Exception("Favor preencher o campo do complemento corretamente.");
        }else if (end.getEstado().equalsIgnoreCase("selecione um estado...")) {
            throw new Exception("Favor selecionar o campo do estado corretamente.");
        }else if (end.getLogradouro().trim().equals("") || end.getLogradouro().length() < 4) {
            throw new Exception("Favor preencher o campo do logradouro  corretamente.");
        }else if(end.getNumero() <2 || end.getNumero() == 00){
            throw new Exception("Favor preencher o campo do número corretamente.");
        }else if (end.getUsuario().getNome().length() < 3 || end.getUsuario().getNome().trim().equalsIgnoreCase("")){
            throw new Exception("Favor preencher o campo do nome do usuário corretamente.");
        }else if (end.getUsuario().getCpf().length() != 11 || end.getUsuario().getCpf().trim().equalsIgnoreCase("")){
            throw new Exception("Favor preencher o campo do cpf do usuário corretamente.");
        //}else if(!end.getUsuario().getEmail().contains("@") || !end.getUsuario().getEmail().contains("\\.")){
         //   throw new Exception("Favor preencher o campo do email do usuário corretamente.");
        }else if (end.getUsuario().getSenha().trim().length() < 6) {
            throw new Exception("Favor preencher o campo da senha do usuário corretamente, com no mínimo 6 digitos.");
        }else if(end.getUsuario().getTelefoneCelular().trim().length() < 11){
            throw  new Exception("Favor preencher o campo do telefone celular do cliente corretamente com 11 dígitos");
        }else if(end.getUsuario().getTelefoneFixo().trim().length() < 10){
            throw  new Exception("Favor preencher o campo do telefone fixo do cliente corretamente com 10 dígitos");
        }else{
            DAOFactory.getEnderecoDAO().inserir(end);
        }
        
        
    }
    public List<Endereco> buscarEndereco(int idUsuario){
        return DAOFactory.getEnderecoDAO().buscarEndereco(idUsuario);
    }
    public void alterar(Endereco end) throws Exception{
        if (end.getBairro().trim().equals("") || end.getBairro().length() < 4) {
            throw new Exception("Favor preencher o campo do bairro corretamente.");
        }else if (end.getCep().trim().equals("") || end.getCep().length() != 8) {
            throw new Exception("Favor preencher o campo do cep corretamente.");
        }else if (end.getCidade().trim().equals("") || end.getCidade().length() < 4) {
            throw new Exception("Favor preencher o campo da cidade corretamente.");
        }else if (end.getComplemento().trim().equals("") || end.getComplemento().length() < 4) {
            throw new Exception("Favor preencher o campo do complemento corretamente.");
        }else if (end.getEstado().trim().equals("") || end.getEstado().length() != 2) {
            throw new Exception("Favor selecionar o campo do estado corretamente.");
        }else if (end.getLogradouro().trim().equals("") || end.getLogradouro().length() < 4) {
            throw new Exception("Favor preencher o campo do logradouro  corretamente.");
        }else if(end.getNumero() <2 || end.getNumero() == 00){
            throw new Exception("Favor preencher o campo do número corretamente.");
        }else{
            DAOFactory.getEnderecoDAO().alterar(end);
        }
    }
    public void remover(Endereco end){
        DAOFactory.getEnderecoDAO().remover(end);
    }
    
}
