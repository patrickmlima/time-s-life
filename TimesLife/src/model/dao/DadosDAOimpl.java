package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.person.Dado;
import model.teste.util.JPAUtil;

public class DadosDAOimpl implements DadosDAO {
	private static DadosDAO instance;
	
	private DadosDAOimpl() {
		
	}
	
	public static DadosDAO getInstance() {
		if(instance == null) {
			instance = new DadosDAOimpl();
		}
		return instance;
	}

	@Override
	public void adicionar(Dado dado) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		em.persist(dado);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Dado> consultar(Integer monitoradoId) {
		EntityManager em = new JPAUtil().getEntityManager();
		Query query = em.createQuery("Select d from Dado d where d.monitorado=:id");
		query.setParameter("id", monitoradoId);
		
		List<Dado> list = query.getResultList();
		return list;
	}
	
	

}
