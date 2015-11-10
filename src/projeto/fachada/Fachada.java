/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.fachada;

import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import projeto.controller.*;
import projeto.modelo.*;

/**
 *
 * @author aluno
 */
public class Fachada {
    
    //Instancia dos controladores
    CtrlEndereco ctrlEndereco = new CtrlEndereco();
    CtrlProduto ctrlProduto = new CtrlProduto();
    CtrlCategoria ctrlCategoria = new CtrlCategoria();
    CtrlCarrinho ctrlCarrinho = new CtrlCarrinho();
    CtrlEntrega ctrlEntrega = new CtrlEntrega();
    CtrlFuncionario ctrlFuncionario = new CtrlFuncionario();
    CtrlOs ctrlOs = new CtrlOs();
    CtrlUsuario ctrlUsuario = new CtrlUsuario();
    
    
    
    
    
    //endereco
    public void enderecoCadastrar(Endereco end){
        
        ctrlEndereco.cadastrar(end);
    }
    public List<Endereco> enderecoBuscar(int idUsuario){
        List<Endereco> lista = ctrlEndereco.buscarEndereco(idUsuario);
        return lista;
    }
    
    public void enderecoAlterar(Endereco end){
        ctrlEndereco.alterar(end);
    }
    
    public void enderecoRemover(Endereco end){
        ctrlEndereco.remover(end);
    }
    
    //produto
    public void produtoCadastrar(Produto pro){
        
        ctrlProduto.cadastrar(pro);
    }
    public List<Produto> produtoBuscar(){
        List<Produto> lista = ctrlProduto.buscarProduto();
        return lista;
    }
    
    public void produtoAlterar(Produto prod){
        ctrlProduto.alterar(prod);
    }

    public void produtoRemover(Produto prod){
        ctrlProduto.remover(prod);
    }
    
    //categoria
    public void categoriaCadastrar(Categoria cat){
        ctrlCategoria.cadastrar(cat);
    }
    
//anderson... tentar retornar o OBJETO categoria pelas camadas at� chegar no form atrav�s da namedquerie na classe categoria.
    public List<Categoria> categoriaBuscar(){
        List<Categoria> lista = ctrlCategoria.buscarCategoria();
        return lista;
        
    }
    public void categoriaAlterar(Categoria cat){
        ctrlCategoria.alterar(cat);
    }
    
    public void categoriaRemover(Categoria c){
        ctrlCategoria.remover(c);
    }
    
    //carrinho
    public void carrinhoCadastrar(Carrinho car){
        ctrlCarrinho.cadastrar(car);
    }
    public List<Carrinho> carrinhoListar(int idUsuario){
        List<Carrinho> lista = ctrlCarrinho.carrinhoListar(idUsuario);
        return lista;
    }
    public int quantidadeItem(int id) {
        int quantidade = ctrlCarrinho.quantidadeItem(id);
        return quantidade;
    }

    public double valorTotalCarrinho(int id) {
        double valor = ctrlCarrinho.valorTotalCarrinho(id);
        return valor;
    }
    
    public boolean carrinhoExiste(int idUsuario){
        return ctrlCarrinho.carrinhoExiste(idUsuario);
    }
    
    public Carrinho getCarrinho(int idUsuario){
        return ctrlCarrinho.getCarrinho(idUsuario);
    }
    
    
    //entrega
    public void entregaCadastrar(Entrega ent){
        
        ctrlEntrega.cadastrar(ent);
    }
    public List<Entrega> entregaBuscar(){
        List<Entrega> lista = ctrlEntrega.buscarEntrega();
        return lista;
    }
    public void entregaAlterar(Entrega ent){
        ctrlEntrega.alterar(ent);
    }
    public void entregaRemover(Entrega ent){
        ctrlEntrega.remover(ent);
    }
    
    //funcionario
    public void funcionarioCadastrar(Funcionario fun){
        
        ctrlFuncionario.cadastrar(fun);
    }
    public List<Funcionario> funcionarioBuscar(){
        List<Funcionario> lista = ctrlFuncionario.buscarFuncionario();
        return lista;
    }
    public void funcionarioAlterar(Funcionario fun){
        ctrlFuncionario.alterar(fun);
    }
    public void funcionarioRemover(Funcionario fun){
        ctrlFuncionario.remover(fun);
    }
    
    public Funcionario carregarFuncionario(Usuario usuario) {
        return ctrlFuncionario.carregarFuncionario(usuario);
    }
    
    //os
    public void osCadastrar(Os os){
        
        ctrlOs.cadastrar(os);
    }
    public List<Os> osBuscar(){
        List<Os> lista = ctrlOs.buscarOs();
        return lista;
    }
    public void osAlterar(Os os){
        ctrlOs.alterar(os);
    }
    public void osRemover(Os os){
        ctrlOs.remover(os);
    }
    
    //usuario
    public void usuarioCadastrar(Usuario usu){
        
        ctrlUsuario.cadastrar(usu);
    }
    public List<Usuario> usuarioBuscar(){
        List<Usuario> lista = ctrlUsuario.buscarUsuario();
        return lista;
    }
    public void usuarioAlterar(Usuario usu){
        ctrlUsuario.alterar(usu);
    }
     public void usuarioRemover(Usuario usu){
         ctrlUsuario.remover(usu);
    }
     
     public Boolean usuarioLogin(Usuario usu){
         return ctrlUsuario.usuarioLogin(usu);
     }

    
}
