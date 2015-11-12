/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author bboyrap
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQueries({@NamedQuery(name ="Usuario.findAll", query = "SELECT U FROM Usuario U"),
               @NamedQuery(name ="Usuario.login", query = "SELECT U.id, U.email, F.matricula FROM Usuario U, Funcionario F WHERE U.email = ?1 AND U.senha = ?2")})
public class Usuario implements Serializable{
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String telefoneFixo;
    private String telefoneCelular;
    private String cpf;
    private boolean status;
     
    ////relacionamento com endereço
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "usuario")
    private Collection<Endereco> enderecos;
    
    
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "usuario")
    private Collection<Carrinho> carrinhos;
    
    public Usuario(){
        
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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the telefoneFixo
     */
    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    /**
     * @param telefoneFixo the telefoneFixo to set
     */
    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    /**
     * @return the telefoneCelular
     */
    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    /**
     * @param telefoneCelular the telefoneCelular to set
     */
    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
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
     * @return the enderecos
     */
    public Collection<Endereco> getEnderecos() {
        return enderecos;
    }

    /**
     * @param enderecos the enderecos to set
     */
    public void setEnderecos(Collection<Endereco> enderecos) {
        this.enderecos = enderecos;
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
    
