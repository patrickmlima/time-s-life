package model.teste;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.teste.util.JPAUtil;

public class TesteConsulta {
	EntityManager em = new JPAUtil().getEntityManager();
	
	Query q1 = em.createQuery("Select p from Pessoa p where p.identificador =:vId and p.tipo =:vtipo oderd by p.identificador");
	
	
}
