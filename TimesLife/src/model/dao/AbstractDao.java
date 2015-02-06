package model.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.teste.util.JPAUtil;

public abstract class AbstractDao<T extends AbstractEntity> implements
		Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em = new JPAUtil().getEntityManager();
	
	private Class <T> persistentClass;
	
	public AbstractDao() {
		init();
	}
	public void init() {
		ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
		persistentClass = (Class<T>) type.getActualTypeArguments()[0];
	}

	public void adicionar(T entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public T buscar(T entity) {
		entity = (T) em.find(entity.getClass(), entity.getId());
		return entity;
	}

	public void editar(T entity) {
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
	}
	
	public void remover(T entity) {
		em.getTransaction().begin();
		em.remove(em.getReference(entity.getClass(), entity.getId()));
		em.getTransaction().commit();
	}
	
	public List<T> listar() {
		Query query = em.createQuery("Select t from " + persistentClass.getName() + " t" );
		List<T> list = query.getResultList();

		return list;
	}
	
	public T getByPrimaryKey(T entity) {
		return em.find(persistentClass, entity.getId());
	}
	
	public T getByPrimaryKey(int key) {
		return em.find(persistentClass, key);
	}
	
}
