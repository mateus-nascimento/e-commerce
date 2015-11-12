/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author bboyrap
 */
@Entity
@NamedQuery(name ="Os.findAll", query = "SELECT o FROM Os o")
public class Os {
    @Id
    @GeneratedValue
    private int id;
    
    public Os(){
        
    }
    
    //carrinho
    @OneToOne
    @JoinColumn(name = "idCarrinho")//id do carrinho da os
    private Carrinho carrinho;
    
    //entrega
    @OneToOne(mappedBy = "os")
    @Cascade(CascadeType.PERSIST)
    private Entrega entrega;
    
    
    

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
     * @return the carrinho
     */
    public Carrinho getCarrinho() {
        return carrinho;
    }

    /**
     * @param carrinho the carrinho to set
     */
    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    /**
     * @return the entrega
     */
    public Entrega getEntrega() {
        return entrega;
    }

    /**
     * @param entrega the entrega to set
     */
    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }
    
    
    
    
}
