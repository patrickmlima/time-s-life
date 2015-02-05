package model.teste;

import java.util.Scanner;

import model.dao.PessoaDAO;
import model.dao.PessoaDAOimpl;
import model.person.Dado;
import model.person.Monitorado;
import model.person.Pessoa;
import model.person.TipoUsuario;
import model.person.Usuario;

public class PopulaMonitorado {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PessoaDAO pdao = PessoaDAOimpl.getInstance();
		
		Monitorado monitorado1 = new Monitorado("jao", "02/02/2002", "rua inexistente", "999999999", 60f, 1.70f);
		Monitorado monitorado2 = new Monitorado("pedo", "01/01/2001", "rua imaginaria", "988888888", 67f, 1.75f);

//		Dado dado11 = new Dado(1, 12, 12, 23);
//		Dado dado12 = new Dado(1, 100, 400, 50);
//		
//		Dado dado21 = new Dado (2, 100, 300, 300);
//		Dado dado22 = new Dado(2, 40, 60, 70);
		
		Usuario us1 = new Usuario("user1", "04/04/2004", "rua sem rua", "00000000", TipoUsuario.MONITOR);
		Usuario us2 = new Usuario("user2", "05/05/2005", "rua COM rua", "11111111", TipoUsuario.MONITOR);
		Usuario us3 = new Usuario("ADMIN", "06/06/2006", "rua ua", "22222200", TipoUsuario.ADMIN);
		
		pdao.adicionar(monitorado1);
		pdao.adicionar(monitorado2);
		pdao.adicionar(us1);
		pdao.adicionar(us2);
		pdao.adicionar(us3);
//		
//		System.out.println("inseriu");
//		sc.nextLine();
//		
//		Pessoa pc = pdao.consultar(us2.getIdentificador());
//		System.out.println(pc.getNome() + " - " + pc.getEndereco() + " - " + pc.getTelefone());
//		System.out.println("consultou");
//		sc.nextLine();
//		
//		monitorado2.setNome("ze");
//		monitorado2.setAltura(1.60f);
//		pdao.editar(monitorado2);
//		System.out.println("editou");
//		Pessoa pnew = pdao.consultar(monitorado2.getIdentificador());
//		System.out.println(pnew.getNome() + " - " + ((Monitorado)pnew).getAltura());
//		sc.nextLine();
//		
//		pdao.excluir(us2);
//		System.out.println("excluiu");
//		sc.nextLine();
//		
//		sc.close();
	}
}
	
