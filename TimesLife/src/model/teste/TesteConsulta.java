package model.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.person.Monitorado;
import model.person.Pessoa;
import model.teste.util.JPAUtil;

public class TesteConsulta {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		
//		Query q2 = em.createQuery("Select d from Dado d where d.")
		
//		Query q1 = em.createQuery("Select p from Pessoa p where p.identificador =:vId ");
//		q1.setParameter("vId", 1);
	
//		
//		
//		List<Pessoa> pessoas = q1.getResultList();
//		
//		for(Pessoa p : pessoas) {
//			System.out.println(p.getNome() + " - " + p.getDataNasc() + " ~~ " + ((Monitorado)p).getBATIMENTO_IDEAL_MINIMO()
//					+ " / " + ((Monitorado)p).getBATIMENTO_IDEAL_MAXIMO());
//		}
	}
	
}
