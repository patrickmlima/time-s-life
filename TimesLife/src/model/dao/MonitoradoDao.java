package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.person.Monitorado;
import model.person.TipoUsuario;
import model.person.Usuario;
import model.teste.util.JPAUtil;

public class MonitoradoDao extends AbstractDao<Monitorado>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public List<Monitorado> listarMonitorados() {
		EntityManager em = new JPAUtil().getEntityManager();
		Query q = em.createQuery("Select m from Monitorado m");
		return q.getResultList();
	}
}
