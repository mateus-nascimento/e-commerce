/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 *
 * @author bboyrap
 */
@Entity
@NamedQuery(name ="Entrega.findAll", query = "SELECT e FROM Entrega e")
public class Entrega {
    @Id
    @GeneratedValue
    private int id;
    private boolean status;//0 se não for pra entregar e 1 para entregar no endereco da entrega
    
    //os
    @OneToOne
    @JoinColumn(name = "idOs")//id da os de entrega
    private Os os;
    
    
    //endereco
    @ManyToOne
    @JoinColumn(name = "idEndereco")
    private Endereco endereco;
    
    
    
    //funcionario (N)
    @OneToOne
    @JoinColumn(name = "idFuncionario")
    private Funcionario funcionario;
    
    
    
    
    
    public Entrega(){
        
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

    /**
     * @return the endereco
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the funcionario
     */
    public Funcionario getFuncionario() {
        return funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
}
