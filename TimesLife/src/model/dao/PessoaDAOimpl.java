package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.person.Pessoa;
import model.teste.util.JPAUtil;

public class PessoaDAOimpl implements PessoaDAO{
	
	private static PessoaDAO instance;
	
	private PessoaDAOimpl() {
	}
	
	public static PessoaDAO getInstance() {
		if(instance == null) {
			instance = new PessoaDAOimpl();
		}
		return instance;
	}

	@Override
	public void adicionar(Pessoa pessoa) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		try {
			em.persist(pessoa);
			em.getTransaction().commit();
		} catch(Exception e) {
			
		}
		finally {
			em.close();
		}
	}

	@Override
	public Pessoa consultar(Integer identificador) {
		EntityManager em = new JPAUtil().getEntityManager();
		Query qFind = em.createQuery("Select p from Pessoa p where p.identificador =:vId");
		qFind.setParameter("vId", identificador);
		@SuppressWarnings("unchecked")
		List<Pessoa> pessoa = qFind.getResultList();
		return pessoa.get(0);
	}

	@Override
	public void editar(Pessoa pessoa) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		try {
			em.merge(pessoa);
			em.getTransaction().commit();
		} catch(Exception e) {
			
		} finally {
			em.close();
		}
	}

	@Override
	public void excluir(Pessoa pessoa) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		try {
			em.remove(pessoa);
			em.getTransaction().commit();
		} catch (Exception e) {
			
		} finally {
			em.close();
		}
	}

	@Override
	public void listar() {
		// TODO Auto-generated method stub
		
	}

}
