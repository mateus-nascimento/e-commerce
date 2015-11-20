/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.fachada;

import java.util.ArrayList;
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
    public void enderecoCadastrar(Endereco end)throws Exception{
        
        ctrlEndereco.cadastrar(end);
    }
    public List<Endereco> enderecoBuscar(int idUsuario)throws Exception{
        List<Endereco> lista = ctrlEndereco.buscarEndereco(idUsuario);
        return lista;
    }
    
    public void enderecoAlterar(Endereco end)throws Exception{
        ctrlEndereco.alterar(end);
    }
    
    public void enderecoRemover(Endereco end)throws Exception{
        ctrlEndereco.remover(end);
    }
    
    //produto
    public void produtoCadastrar(Produto pro)throws Exception{
        ctrlProduto.cadastrar(pro);
    }
    public List<Produto> produtoBuscar()throws Exception{
        List<Produto> lista = ctrlProduto.buscarProduto();
        return lista;
    }
    
    public void produtoAlterar(Produto prod)throws Exception{
        ctrlProduto.alterar(prod);
    }

    public void produtoRemover(Produto prod)throws Exception{
        ctrlProduto.remover(prod);
    }
    
    public List<Produto> produtosCarrinho(int idCarrinho) throws Exception {
        List<Produto> lista = ctrlProduto.produtosCarrinho(idCarrinho);
        return lista;
    }
    
    //categoria
    public void categoriaCadastrar(Categoria cat)throws Exception{
        ctrlCategoria.cadastrar(cat);
    }
    
//anderson... tentar retornar o OBJETO categoria pelas camadas at� chegar no form atrav�s da namedquerie na classe categoria.
    public List<Categoria> categoriaBuscar()throws Exception{
        List<Categoria> lista = ctrlCategoria.buscarCategoria();
        return lista;
        
    }
    public void categoriaAlterar(Categoria cat)throws Exception{
        ctrlCategoria.alterar(cat);
    }
    
    public void categoriaRemover(Categoria c)throws Exception{
        ctrlCategoria.remover(c);
    }
    
    //carrinho
    public void carrinhoCadastrar(Carrinho car)throws Exception{
        ctrlCarrinho.cadastrar(car);
    }
    public List<Carrinho> carrinhoListar(int idUsuario)throws Exception{
        List<Carrinho> lista = ctrlCarrinho.carrinhoListar(idUsuario);
        return lista;
    }
    public int quantidadeItemTotal(int id) throws Exception{
        int quantidade = ctrlCarrinho.quantidadeItemTotal(id);
        return quantidade;
    }

    public double valorTotalCarrinho(int id) throws Exception{
        double valor = ctrlCarrinho.valorTotalCarrinho(id);
        return valor;
    }
    
    public boolean carrinhoExiste(int idUsuario)throws Exception{
        return ctrlCarrinho.carrinhoExiste(idUsuario);
    }
    
    public Carrinho getCarrinho(int idUsuario)throws Exception{
        return ctrlCarrinho.getCarrinho(idUsuario);
    }
    
    public void carrinhoAlterar(Carrinho c) throws Exception{
        ctrlCarrinho.alterar(c);
    }
    
    //entrega
    public void entregaCadastrar(Entrega ent)throws Exception{
        
        ctrlEntrega.cadastrar(ent);
    }
    public List<Entrega> entregaBuscar()throws Exception{
        List<Entrega> lista = ctrlEntrega.buscarEntrega();
        return lista;
    }
    public void entregaAlterar(Entrega ent)throws Exception{
        ctrlEntrega.alterar(ent);
    }
    public void entregaRemover(Entrega ent)throws Exception{
        ctrlEntrega.remover(ent);
    }
    
    //funcionario
    public void funcionarioCadastrar(Funcionario fun)throws Exception{
        
        ctrlFuncionario.cadastrar(fun);
    }
    public List<Funcionario> funcionarioBuscar()throws Exception{
        List<Funcionario> lista = ctrlFuncionario.buscarFuncionario();
        return lista;
    }
    public List<Funcionario> funcionarioEntregador() throws Exception{
        List<Funcionario> lista = ctrlFuncionario.funcionarioEntregador();
        return lista;
    }
    
    public void funcionarioAlterar(Funcionario fun)throws Exception{
        ctrlFuncionario.alterar(fun);
    }
    public void funcionarioRemover(Funcionario fun)throws Exception{
        ctrlFuncionario.remover(fun);
    }
    
    public Funcionario carregarFuncionario(Usuario usuario)throws Exception {
        return ctrlFuncionario.carregarFuncionario(usuario);
    }
    
    //os
    public void osCadastrar(Os os)throws Exception{
        
        ctrlOs.cadastrar(os);
    }
    public List<Os> osBuscar()throws Exception{
        List<Os> lista = ctrlOs.buscarOs();
        return lista;
    }
    public void osAlterar(Os os)throws Exception{
        ctrlOs.alterar(os);
    }
    public void osRemover(Os os)throws Exception{
        ctrlOs.remover(os);
    }
    
    //usuario
    public void usuarioCadastrar(Usuario usu)throws Exception{
        
        ctrlUsuario.cadastrar(usu);
    }
    public List<Usuario> usuarioBuscar()throws Exception{
        List<Usuario> lista = ctrlUsuario.buscarUsuario();
        return lista;
    }
    public void usuarioAlterar(Usuario usu)throws Exception{
        ctrlUsuario.alterar(usu);
    }
     public void usuarioRemover(Usuario usu)throws Exception{
         ctrlUsuario.remover(usu);
    }
     
     public Boolean usuarioLogin(Usuario usu)throws Exception{
         return ctrlUsuario.usuarioLogin(usu);
     }

    
}
