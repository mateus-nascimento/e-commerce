/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.controller;

import java.util.List;
import projeto.dao.DAOFactory;
import projeto.modelo.Os;

/**
 *
 * @author bboyrap
 */
public class CtrlOs {
    public void cadastrar(Os os){
        DAOFactory.getOsDAO().inserir(os);
    }
    public List<Os> buscarOs(){
        return DAOFactory.getOsDAO().buscarTudo();
    }
    public void alterar(Os os){
        DAOFactory.getOsDAO().alterar(os);
    }
    public void remover(Os os){
        DAOFactory.getOsDAO().remover(os);
    }
}
