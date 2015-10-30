/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Outras;


import projeto.modelo.*;
import projeto.dao.*;

/**
 *
 * @author bboyrap
 */
public class Persistence {
    public static void main(String[] args){
        //funcionario
        /*
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Joao");
        funcionario.setEmail("joao@email.com");
        funcionario.setSenha("123456");
        funcionario.setCpf("12345678911");
        funcionario.setTelefoneCelular("819988775566");
        funcionario.setTelefoneFixo("8133445522");
        funcionario.setStatus(true);
        funcionario.setMatricula(1);
        funcionario.setSetor("Diretor");
        */
        
        //usuario
        /*
        Usuario usuario = new Usuario();
        usuario.setNome("mateus");
        usuario.setEmail("mateus@email.com");
        usuario.setSenha("123456");
        usuario.setCpf("12345678912");
        usuario.setTelefoneCelular("819988774411");
        usuario.setTelefoneFixo("8133447766");
        usuario.setStatus(true);
        */
        
        
        //endereco
        /*
        Endereco endereco = new Endereco();
        endereco.setLogradouro("Rua A");
        endereco.setBairro("venenolandia");
        endereco.setCep("51010130");
        endereco.setCidade("Chernobyl");
        endereco.setComplemento("uma lugarzinho de naturais");
        endereco.setNumero(100);
        endereco.setEstado("Orbital de plutão");
        endereco.setStatus(true);
        endereco.setUsuario(usuario);
        */
        
        Usuario u = new Usuario();
        u.setId(2);
        
        Endereco endereco2 = new Endereco();
        endereco2.setLogradouro("Rua Raimundos 2");
        endereco2.setBairro("Rocklandia 2");
        endereco2.setCep("51010132");
        endereco2.setCidade("Cidade do Rock 2");
        endereco2.setComplemento("uma lugarzinho de rockeiros 2");
        endereco2.setNumero(99);
        endereco2.setEstado("Rock and roll 2");
        endereco2.setStatus(true);
        endereco2.setUsuario(u);
        
        DAOFactory.getEnderecoDAO().inserir(endereco2);
        //CRUD endereço e cascata usuario, funcionario
        
        //insert
        /*
        DAOFactory.getEnderecoDAO().inserir(endereco);
        DAOFactory.getEnderecoDAO().inserir(endereco2);
        */
        
        //listar
        /*
        Endereco resultado = DAOFactory.getEnderecoDAO().buscarPorChave(1);
        System.out.println("Endereco 1:");
        System.out.println(resultado);
        resultado = DAOFactory.getEnderecoDAO().buscarPorChave(2);
        System.out.println("Endereco 2:");
        System.out.println(resultado.getLogradouro());
        */
        
        //delete 
        
        /*Endereco testDelete = new Endereco();
        testDelete.setId(3);
        DAOFactory.getEnderecoDAO().remover(testDelete);
        */
        
        //alter
        /*
        Endereco testAlter = DAOFactory.getEnderecoDAO().buscarPorChave(1);
        testAlter.setLogradouro("teste de alteracao por dao generico");
        DAOFactory.getEnderecoDAO().alterar(testAlter);
        */
        
        //categoria
        /*
        Categoria categoria = new Categoria();
        categoria.setNome("Bebida");
        categoria.setStatus(true);
        
        //produto e cascata categoria
        
        Produto produto = new Produto();
        produto.setNome("Coca");
        produto.setDescricao("veneno natural");
        produto.setValor((float) 3.50);
        produto.setStatus(true);
        produto.setCategoria(categoria);
        */
        //insert
        //DAOFactory.getProdutoDAO().inserir(produto);
        
        //listar
        //Produto listaProduto = DAOFactory.getProdutoDAO().buscarPorChave(1);
        //System.out.println(listaProduto);
        
        
        //delete
        //Produto produto = new Produto();
        //produto.setId(1);
        //DAOFactory.getProdutoDAO().remover(produto);
        
        
        
        
        
        
        
        
        
        
        
        //carrinho
        
        
        
        
        
        
        //os
        
        
        
        
        
        //entrega
        
        
        
        
        
        //FactoryDAO.getEntregaDAO().inserir(entrega);
        
        
    }
    
}
