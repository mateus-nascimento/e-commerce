/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.modelo;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author bboyrap
 */

@Entity
@NamedQuery(name ="Categoria.findAll", query = "SELECT c FROM Categoria c")
public class Categoria {
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private boolean status;
    
    public Categoria(){
        
    }
    
    //anottations do relacionamento com produto (1:N)
    @OneToMany(cascade=CascadeType.PERSIST, mappedBy = "categoria")
    private Collection<Produto> produtos;

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
     * @return the produtos
     */
    public Collection<Produto> getProdutos() {
        return produtos;
    }

    /**
     * @param produtos the produtos to set
     */
    public void setProdutos(Collection<Produto> produtos) {
        this.produtos = produtos;
    }
    
    
    
    
}
