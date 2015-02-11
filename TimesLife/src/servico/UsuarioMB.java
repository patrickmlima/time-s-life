package servico;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.dao.UsuarioDao;
import model.person.Pessoa;
import model.person.TipoUsuario;
import model.person.Usuario;

@ManagedBean
@RequestScoped
public class UsuarioMB {
	Usuario usuario = new Usuario();
	TipoUsuario tipo;
	UsuarioDao dao = new UsuarioDao();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@SuppressWarnings("static-access")
	public TipoUsuario[] getTipo() {
		return tipo.values();
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

	public UsuarioDao getDao() {
		return dao;
	}

	public void setDao(UsuarioDao dao) {
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
