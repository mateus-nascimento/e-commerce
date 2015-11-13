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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Cascade;




/**
 *
 * @author bboyrap
 */
@Entity//OBJETIVO(SQL)>> SELECT COUNT(idProduto) FROM Produto_Carrinho WHERE idCarrinho = ?1
//Select A From Amigo A join A.usuarios U where U.idUsuario=:idUsuario // SELECT DISTINCT p FROM Professor p WHERE p.disciplinas.id = :disciplinaParam 
//SELECT COUNT(P.id) FROM Produto P JOIN P.carrinhos.produtos C WHERE C.produtos.id = ?1//SELECT COUNT(P.id) FROM Produto P JOIN C.produtos C WHERE C.id = ?1
//SELECT COUNT(P.id) FROM Produto P JOIN P.carrinhos C WHERE C.id = ?1//SELECT COUNT(P.id) FROM Produto P WHERE P.carrinhos.id = ?1
@NamedQueries({@NamedQuery(name = "Carrinho.byUser", query = "SELECT C FROM Carrinho C WHERE c.usuario.id = ?1 "),
               @NamedQuery(name = "Carrinho.existe", query = "SELECT C.id FROM Carrinho C WHERE c.usuario.id = ?1 AND C.status = TRUE"),
               @NamedQuery(name = "Carrinho.getCarrinho", query = "SELECT C FROM Carrinho C where C.usuario.id = ?1 AND C.status = 1"),
               @NamedQuery(name = "Carrinho.carrinho", query = "SELECT C FROM Carrinho C WHERE C.id = ?1")})
               
public class Carrinho {
    @Id
    @GeneratedValue
    private int id;
    private boolean status;
    
    //anottations do relacionamento com produto (N:N)
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name = "Produto_Carrinho",//nome da tabela que vai ser gerada no banco
               joinColumns = {@JoinColumn(name = "idCarrinho")},//nome da chave primaria da tabela carrinho
               inverseJoinColumns = {@JoinColumn(name = "idProduto")})//nome da chave estrangeira na tabela produto em Produto_Carrinho
    private Collection<Produto> produtos;
    
    //anottations do relacionamento com Usuario (N:1)
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
    
    
    //anottations do relacionamento com os (1:1)
    
    @OneToOne(mappedBy = "carrinho")
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    private Os os;
    
    
    
    
    
    public Carrinho(){
        
    }

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

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the os
     */
    public Os getOs() {
        return os;
    }

    /**
     * @param os the os to set
     */
    public void setOs(Os os) {
        this.os = os;
    }
    
}
