/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.controller;

import java.util.List;
import projeto.dao.DAOFactory;
import projeto.modelo.Entrega;

/**
 *
 * @author bboyrap
 */
public class CtrlEntrega {
    public void cadastrar(Entrega ent){
        DAOFactory.getEntregaDAO().inserir(ent);
    }
    public List<Entrega> buscarEntrega(){
        return DAOFactory.getEntregaDAO().buscarTudo();
    }
    public void alterar(Entrega ent){
        DAOFactory.getEntregaDAO().alterar(ent);
    }
    public void remover(Entrega ent){
        DAOFactory.getEntregaDAO().remover(ent);
    }
}
