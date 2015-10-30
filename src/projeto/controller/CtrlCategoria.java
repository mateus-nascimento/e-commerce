/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.controller;

import java.util.ArrayList;
import java.util.List;
import projeto.dao.DAOFactory;
import projeto.modelo.Categoria;

/**
 *
 * @author aluno
 */
public class CtrlCategoria {
    public void cadastrar(Categoria cat){
        DAOFactory.getCategoriaDAO().inserir(cat);
    }
    public List<Categoria> buscarCategoria(){
        return DAOFactory.getCategoriaDAO().buscarTudo();
    }
    public void alterar(Categoria cat){
        DAOFactory.getCategoriaDAO().alterar(cat);
    }
    public void remover(Categoria c){
        DAOFactory.getCategoriaDAO().remover(c);
    }
    
}
