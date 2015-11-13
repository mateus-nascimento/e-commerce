/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author bboyrap
 */
public class DAOGeneric<Entidade> {
    private EntityManager entityManager;
    private Class<Entidade> classePersistente;
    
    @SuppressWarnings("unchecked")
    public DAOGeneric(EntityManager em){
        this.setEntityManager(em);
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();  
        classePersistente = (Class<Entidade>) parameterizedType.getActualTypeArguments()[0];  
    }
    
    /**
    * Executa o merge do objeto que se encontra em memória.
    * 
    * @param objeto
    *            a ser realizado o merge
    * @return objeto que foi executado o merge
    */
    public Entidade alterar(Entidade objeto) {
        
        EntityTransaction tx = getEntityManager().getTransaction();
        try {
            tx.begin();

            objeto = getEntityManager().merge(objeto);

            //tx.commit();

            return objeto;
            
        }finally{
            tx.commit();
        }
            
            
        
        
    }

   /**
    * Salva o objeto atual na base de dados.
    * 
    * @param objeto a ser salvo
    */
    public void inserir(Entidade objeto) {
        EntityTransaction tx = getEntityManager().getTransaction();		
        try {
            tx.begin();
            getEntityManager().persist(objeto);
            //tx.commit();
            System.out.println(classePersistente.getSimpleName() + " salvo com sucesso");
        } catch (PersistenceException e) {
            tx.rollback();
        }finally{
            tx.commit();
        }
    }

   /**
    * Salva o objeto atual na base de dados.
    * 
    * @param objeto
    *            a ser salvo
    */
    public final void inserirColecao(Collection<Entidade> colecao) {
            EntityTransaction tx = getEntityManager().getTransaction();
        try {
            tx.begin();

            for (Entidade entidade : colecao) {
                    getEntityManager().persist(entidade);	
            }

            //tx.commit();

            System.out.println(classePersistente.getSimpleName() + " salvos com sucesso: " + colecao.size());
        } catch (PersistenceException e) {
            e.printStackTrace();
        }finally{
            tx.commit();
        }
        
    }

   /**
    * Remove o objeto da base de dados.
    * 
    * @param objeto
    *            a ser removido
    */
    public final void remover(Entidade objeto) {
        EntityTransaction tx = getEntityManager().getTransaction();
        try {
            tx.begin();

            // Este merge foi incluido para permitir a exclusao de objetos no estado Detached
            objeto = getEntityManager().merge(objeto);

            getEntityManager().remove(objeto);

            //tx.commit();

            System.out.println(classePersistente.getSimpleName() + " removido com sucesso");		
        }finally{
            tx.commit();
        }
        
    }



   /**
    * Busca o objeto uma vez passado sua chave como parâmetro.
    * 
    * @param chave
    *            identificador
    * @return Objeto do tipo T
    */
    public final Entidade buscarPorChave(Serializable chave) {
        Entidade instance = null;
        try {
                instance = (Entidade) getEntityManager().find(getClassePersistente(), chave);
        } catch (RuntimeException re) {
                re.printStackTrace();
        }
        return instance;
    }
   
    /** Metodo para atualizar as listas de categorias, produtos de cada form etc...
     * 
     * @param objeto
     * @return 
     */
    public final List buscarTudo(){
        //List<Entidade> retorno = new ArrayList<Entidade>();
        EntityTransaction tx = getEntityManager().getTransaction();	
        List retorno = null;
        try {
            tx.begin();
            Query query = getEntityManager().createNamedQuery(classePersistente.getSimpleName() + ".findAll");
            retorno = query.getResultList();
            tx.commit();
            

        } catch (Exception e) {
            e.getMessage();
        }
        
        return retorno;
        
        
        
    }
    
    /*public final Entidade buscarTudo(Entidade objeto){
        
       	//tentando concatenar o nome da querie Categoria.findAll!!
        Query query = getEntityManager().createNamedQuery(classePersistente.getSimpleName() + "findAll");
        List resultado = query.getResultList();
        
        
        
        
    }*/
    
    
    

   /**
    * Atualiza o objeto que se encontra em memória.
    * 
    * @param object
    *            objeto a ser atualizado
    */
    public final void refresh(Entidade object) {
        getEntityManager().refresh(object);
    }
    
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
    
    protected final Class<Entidade> getClassePersistente() {
        return classePersistente;
    }
}
