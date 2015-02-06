package servico;

import javax.faces.bean.ManagedBean;

import model.dao.PessoaDAO;
import model.person.Pessoa;
import model.person.Usuario;

@ManagedBean
public class UsuarioMB {
	Usuario usuario = new Usuario();
	PessoaDAO dao = new PessoaDAO();
	
	public void salvar() {
		dao.adicionar(usuario);
	}
	
	public Pessoa buscar() {
		return dao.buscar(usuario);
	}
	
	public void editar() {
		dao.editar(usuario);
	}
	
	public void excluir() {
		dao.remover(usuario);
	}	
}
