package model.teste;

import java.util.List;
import java.util.Scanner;

import model.dao.DadoDAO;
import model.dao.PessoaDAO;
import model.person.Dado;
import model.person.Monitorado;
import model.person.Pessoa;
import model.person.TipoUsuario;
import model.person.Usuario;

public class PopulaMonitorado {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Monitorado monitorado1 = new Monitorado("jao", "02/02/2002", "rua inexistente", "999999999", 60f, 1.70f);
		Monitorado monitorado2 = new Monitorado("pedo", "01/01/2001", "rua imaginaria", "988888888", 67f, 1.75f);

		PessoaDAO pdao = new PessoaDAO();
		DadoDAO ddao = new DadoDAO();
		
		pdao.adicionar(monitorado1);
		pdao.adicionar(monitorado2);
		
		Dado dado11 = new Dado(1, 12, 12, 23);
		Dado dado12 = new Dado(1, 100, 400, 50);
		ddao.adicionar(dado11);
		ddao.adicionar(dado12);
		
		Dado dado21 = new Dado (2, 100, 300, 300);
		Dado dado22 = new Dado(2, 40, 60, 70);
		ddao.adicionar(dado21);
		ddao.adicionar(dado22);
		
		Usuario us1 = new Usuario("user1", "04/04/2004", "rua sem rua", "00000000", TipoUsuario.MONITOR);
		Usuario us2 = new Usuario("user2", "05/05/2005", "rua COM rua", "11111111", TipoUsuario.MONITOR);
		Usuario us3 = new Usuario("ADMIN", "06/06/2006", "rua ua", "22222200", TipoUsuario.ADMIN);
		pdao.adicionar(us3);
		pdao.adicionar(us2);
		pdao.adicionar(us1);
		
		System.out.println("inseriu");
		sc.nextLine();
		
		Pessoa pc = pdao.buscar(us2);
		System.out.println(pc.getNome() + " - " + pc.getEndereco() + " - " + pc.getTelefone());
		System.out.println("consultou");
		sc.nextLine();
		
		monitorado2.setNome("ze");
		monitorado2.setAltura(1.60f);
		pdao.editar(monitorado2);
		System.out.println("editou");
		Pessoa pnew = pdao.buscar(monitorado2);
		System.out.println(pnew.getNome() + " - " + ((Monitorado)pnew).getAltura());
		sc.nextLine();
		
		pdao.remover(us2);
		System.out.println("excluiu");
		sc.nextLine();
		
		List<Pessoa> plist = pdao.listar();
		for(Pessoa p : plist) {
			System.out.println(p.getNome() + " - " + p.getId());
		}
		System.out.println("-------------------------------------------");
		List<Dado> dlist = ddao.listar();
		for(Dado d : dlist) {
			System.out.println(d.getMonitorado().getId() + " - " + d.getBpm());
		}
		System.out.println("\n listou");
		sc.nextLine();
		
		sc.close();
	}
}
	
