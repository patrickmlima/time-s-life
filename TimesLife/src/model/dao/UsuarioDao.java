package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.person.Monitorado;
import model.person.TipoUsuario;
import model.person.Usuario;
import model.teste.util.JPAUtil;

public class UsuarioDao extends AbstractDao<Usuario>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listarMonitores() {
		EntityManager em = new JPAUtil().getEntityManager();
		Query q = em.createQuery("Select u from Usuario u where u.tipo=:vTipo");
		q.setParameter("vTipo", TipoUsuario.MONITOR);
		return q.getResultList();
	}
	
	public List<Monitorado> listarMonitorados(Usuario monitor) {		
		return monitor.getMonitorados();
	}
}