/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.controller;

import java.util.List;
import projeto.dao.DAOFactory;
import projeto.modelo.Produto;

/**
 *
 * @author aluno
 */
public class CtrlProduto {
    public void cadastrar(Produto prod) throws Exception{
        
        if (prod.getNome().length() < 4 || prod.getNome().trim().equalsIgnoreCase("")){
            throw new Exception("Favor preencher o campo do nome do produto corretamente.");
        }else if (prod.getValor() == 0)  {
            throw new Exception("Favor preencher o campo do valor do produto corretamente.");
        }else if (prod.getDescricao().length() < 3 || prod.getDescricao().trim().equalsIgnoreCase("")){
            throw new Exception("Favor preencher o campo da descrição do produto corretamente");
        }else if(prod.getCategoria() == null || prod.getCategoria().getId() == 0){
            throw new Exception("Favor selecionar a categoria do produto corretamente");
        }
        else{
            DAOFactory.getProdutoDAO().inserir(prod);//erro aqui
        }
    }
    public List<Produto> buscarProduto(){
        return DAOFactory.getProdutoDAO().buscarTudo();
    }
    public void alterar(Produto prod) throws Exception{
        if (prod.getNome().length() < 4 || prod.getNome().trim().equalsIgnoreCase("")){
            throw new Exception("Favor preencher o campo do nome do produto corretamente.");
        }else if (prod.getValor() == 0)  {
            throw new Exception("Favor preencher o campo do valor do produto corretamente.");
        }else if (prod.getDescricao().length() < 3 || prod.getDescricao().trim().equalsIgnoreCase("")){
            throw new Exception("Favor preencher o campo da descrição do produto corretamente");
        }else if(prod.getCategoria() == null || prod.getCategoria().getId() == 0){
            throw new Exception("Favor selecionar a categoria do produto corretamente");
        }
        else{
            DAOFactory.getProdutoDAO().alterar(prod);
        }
    }
    public void remover(Produto prod){
        DAOFactory.getProdutoDAO().remover(prod);
    }
}
