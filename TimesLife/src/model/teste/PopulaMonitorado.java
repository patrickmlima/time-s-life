package model.teste;

import javax.persistence.EntityManager;

import model.person.Dado;
import model.person.Monitorado;
import model.person.TipoUsuario;
import model.person.Usuario;
import model.teste.util.JPAUtil;

public class PopulaMonitorado {
	
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		
		Monitorado monitorado1 = new Monitorado("jao", "02/02/2002", "rua inexistente", "999999999", 60f, 1.70f);
		Monitorado monitorado2 = new Monitorado("pedo", "01/01/2001", "rua imaginaria", "988888888", 67f, 1.75f);

		Dado dado11 = new Dado(1, 12, 12, 23);
		Dado dado12 = new Dado(1, 100, 400, 50);
		
		Dado dado21 = new Dado (2, 100, 300, 300);
		Dado dado22 = new Dado(2, 40, 60, 70);
		
		Usuario us1 = new Usuario("user1", "04/04/2004", "rua sem rua", "00000000", TipoUsuario.MONITOR);
		Usuario us2 = new Usuario("user2", "05/05/2005", "rua COM rua", "11111111", TipoUsuario.MONITOR);
		Usuario us3 = new Usuario("ADMIN", "06/06/2006", "rua ua", "22222200", TipoUsuario.ADMIN);
		
		em.getTransaction().begin();
		em.persist(monitorado1);
		em.persist(monitorado2);
		em.persist(dado11);
		em.persist(dado21);
		em.persist(dado12);
		em.persist(dado22);
		em.persist(us1);
		em.persist(us2);
		em.persist(us3);
		
		em.getTransaction().commit();
		em.close();
	}
}
	
