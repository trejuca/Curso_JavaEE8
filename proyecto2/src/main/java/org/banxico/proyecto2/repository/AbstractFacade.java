package org.banxico.proyecto2.repository;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
/**
 * Clase abstracta que implementa los metodos de negocio
 * @author jc
 *
 * @param <T>
 */
public abstract class AbstractFacade<T> {

	/**
	 * Atributo que contiene una referencia a la entidad
	 */
	private Class<T> entityClass;
	
	/**
	 * Constructor de clase
	 * 
	 * @param entityClass
	 */
	public AbstractFacade(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	
	public abstract EntityManager getEntityManager();
	
	public void save(T entity) {
		getEntityManager().persist(entity);
	}
	
	public void update(T entity) {
		getEntityManager().merge(entity);
	}
	
	public void delete(Integer id) {
		getEntityManager().remove(
			getEntityManager().find(entityClass, id));	
	}
	
	public T findById(Integer id) {
		return getEntityManager().find(entityClass, id);
	}
	
	public List<T> findAll() {
		CriteriaQuery criteria = getEntityManager().getCriteriaBuilder().createQuery();
		criteria.select(criteria.from(entityClass));
		// SELECT * FROM entityClass
		
		return getEntityManager().createQuery(criteria).getResultList();
	}
	
	public List<T> findRange(int[] range) {
		/*CriteriaQuery criteria = getEntityManager().getCriteriaBuilder().createQuery();
		criteria.select(criteria.from(entityClass));
		
		
		Query query = getEntityManager().createQuery(criteria);
		query.setMaxResults(range[0]);
		query.setFirstResult(range[1]);*/
		
		Query query =getEntityManager().createNativeQuery(
				"SELECT * FROM customer LIMIT ?1 OFFSET ?2", entityClass);
		
		query.setParameter(1, range[0]);
		query.setParameter(2, range[1]);
		
		return query.getResultList();
	}
	
	public int count() {
		
		CriteriaQuery criteria = getEntityManager().getCriteriaBuilder().createQuery();
		Root<T> root = criteria.from(entityClass);
		criteria.select(getEntityManager().getCriteriaBuilder().count(root));
		
		Query query = getEntityManager().createQuery(criteria);
		
		return (int)query.getSingleResult();
	}
	
	public Integer findMax(String namedQuery) {
		return getEntityManager().createNamedQuery(namedQuery, Integer.class)
				.getSingleResult();
	}
}
