package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.person.Dado;
import model.person.Monitorado;
import model.teste.util.JPAUtil;

public class DadoDAO extends AbstractDao<Dado>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public List<Dado> listarDados(Monitorado monitorado) {
		EntityManager em = new JPAUtil().getEntityManager();
		
		Query q = em.createQuery("Select d from Dado d where monitorado_id=:id");
		q.setParameter("id", monitorado.getId());
		return q.getResultList();
	}
}
