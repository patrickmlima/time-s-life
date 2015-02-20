package servico;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.dao.UsuarioDao;
import model.person.Pessoa;
import model.person.TipoUsuario;
import model.person.Usuario;

@ManagedBean
@RequestScoped
public class UsuarioMB {
	private Usuario usuario = new Usuario();
	private Date dataNasc;
	private TipoUsuario tipo;
	
	private UsuarioDao dao = new UsuarioDao();
	private List<Usuario> monitoresList;
	private Usuario monitorSelecionado;
	
	public UsuarioMB() {
		monitoresList = dao.listarMonitores();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Date getDataNasc() {
		return dataNasc;
	}
	
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
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
	
	public List<Usuario> getMonitoresList() {
		return monitoresList;
	}
	
	public void setMonitoresList(List<Usuario> monitoresList) {
		this.monitoresList = monitoresList;
	}
	
	public Usuario getMonitorSelecionado() {
		return monitorSelecionado;
	}
	
	public void setmonitorSelecionado(Usuario monitorSelecionado) {
		this.monitorSelecionado = monitorSelecionado;
	}
	

	public void salvar() {
		try {
		usuario.setDataNasc(dataNasc);
		dao.adicionar(usuario);
		DialogMB.showMessage("Parabéns", "Usuário adicionado com sucesso!");
		limpar();
		} catch(Exception e) {
			DialogMB.showMessage("Falha", "Usuário não pôde ser adicionado.");
		}
		
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
	
	public void limpar() {
		usuario = new Usuario();
		dataNasc = null;
	}
}
