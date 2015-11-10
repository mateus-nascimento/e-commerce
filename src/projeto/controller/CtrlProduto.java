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
        
        if (prod.getNome() == null){
            throw new Exception("Favor preencher o campo do nome do usuário.");
        }else if (prod.getCategoria() == null || prod.getCategoria().equals(prod))  {
            
        }
{
            
        }
        DAOFactory.getProdutoDAO().inserir(prod);
    }
    public List<Produto> buscarProduto(){
        return DAOFactory.getProdutoDAO().buscarTudo();
    }
    public void alterar(Produto prod){
        DAOFactory.getProdutoDAO().alterar(prod);
    }
    public void remover(Produto prod){
        DAOFactory.getProdutoDAO().remover(prod);
    }
}
