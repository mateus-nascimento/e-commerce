/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.modelo;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 *
 * @author bboyrap
 */
@Entity
@NamedQuery(name ="Produto.findAll", query = "SELECT p FROM Produto p")
public class Produto {
    @Id 
    @GeneratedValue
    private int id;
    private String nome;
    private float valor;
    private String descricao;
    private boolean status;
    
        
    public Produto(){
        
    }
    
    //anottations do relacionamento com categoria (N:1)
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idCategoria")//coluna estrangeira que vai ser criada aqui (idCategoria em produto)
    private Categoria categoria;
    
    
    //anottations do relacionamento com carrinho (N:N)
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "Produto_Carrinho",//nome da tabela que ira ser gerada no banco de dados
               joinColumns = @JoinColumn(name = "idProduto"),//nome da chave primaria da tabela de produto
               inverseJoinColumns = @JoinColumn(name = "idCarrinho"))//nome da chave estrangeira na tabela carrinho em Produto_Carrinho
    private Collection<Carrinho> carrinhos;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the valor
     */
    public float getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(float valor) {
        this.valor = valor;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * @return the categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the carrinhos
     */
    public Collection<Carrinho> getCarrinhos() {
        return carrinhos;
    }

    /**
     * @param carrinhos the carrinhos to set
     */
    public void setCarrinhos(Collection<Carrinho> carrinhos) {
        this.carrinhos = carrinhos;
    }
    
    

            
    
}
