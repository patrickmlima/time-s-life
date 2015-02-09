package servico;

import javax.faces.bean.ManagedBean;

import model.dao.PessoaDAO;
import model.person.Pessoa;
import model.person.TipoUsuario;
import model.person.Usuario;

@ManagedBean
public class UsuarioMB {
	Usuario usuario = new Usuario();
	TipoUsuario tipo;
	PessoaDAO dao = new PessoaDAO();
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

	public PessoaDAO getDao() {
		return dao;
	}

	public void setDao(PessoaDAO dao) {
		this.dao = dao;
	}

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
