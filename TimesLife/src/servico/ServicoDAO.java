package servico;

import java.io.Serializable;
import java.util.List;

import model.dao.MonitoradoDao;
import model.dao.UsuarioDao;
import model.person.Monitorado;
import model.person.Usuario;

public class ServicoDAO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MonitoradoDao monitoradoDao = new MonitoradoDao();
	private UsuarioDao usuarioDao = new UsuarioDao();	
	
	public boolean salvarMonitorado(Monitorado monitorado) {
		try {
			monitoradoDao.adicionar(monitorado);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	public boolean excluirMonitorado(Monitorado monitorado) {
		try {
			monitoradoDao.remover(monitorado);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	public boolean editarMonitorado(Monitorado monitorado) {
		try {
			monitoradoDao.editar(monitorado);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	public List<Monitorado> listarMonitorados() {
		try {
			return monitoradoDao.listar();
		} catch(Exception e) {
			return null;
		}
	}
	
	//---------------------------------------------------
	public boolean salvarUsuario(Usuario usuario) {
		try {
			usuarioDao.adicionar(usuario);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	public boolean excluirUsuario(Usuario usuario) {
		try {
			usuarioDao.remover(usuario);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	public boolean editarUsuario(Usuario usuario) {
		try {
			usuarioDao.editar(usuario);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	public List<Usuario> listarMonitores() {
		try {
			return usuarioDao.listarMonitores();
		} catch(Exception e) {
			return null;
		}
	}
	

}
