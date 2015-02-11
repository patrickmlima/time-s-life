package servico;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.dao.MonitoradoDao;
import model.dao.UsuarioDao;
import model.person.Monitorado;
import model.person.Usuario;

@ManagedBean
@RequestScoped
public class MonitoradoMB {
	private Monitorado monitorado = new Monitorado();
	private List<Monitorado> monitoradosList;
	private List<Usuario> monitoresList;
	private MonitoradoDao monitoradoDao = new MonitoradoDao();
	private UsuarioDao usuarioDao = new UsuarioDao();

	public MonitoradoMB() {
		monitoresList = usuarioDao.listarMonitores();
		monitoradosList = monitoradoDao.listarMonitorados();
	}
	
	public Monitorado getMonitorado() {
		return monitorado;
	}

	public void setMonitorado(Monitorado monitorado) {
		this.monitorado = monitorado;
	}

	public List<Monitorado> getMonitoradosList() {
		return monitoradosList;
	}

	public void setMonitoradosList(List<Monitorado> monitoradosList) {
		this.monitoradosList = monitoradoDao.listar();
	}

	public List<Usuario> getmonitoresList() {
		return monitoresList;
	}

	public void setmonitoresList() {
		this.monitoresList = usuarioDao.listarMonitores();
	}

	public MonitoradoDao getMonitoradoDao() {
		return monitoradoDao;
	}

	public void setMonitoradoDao(MonitoradoDao monitoradoDao) {
		this.monitoradoDao = monitoradoDao;
	}

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public void salvar() {
		this.monitorado.calcularBatimentosIdeais();
		monitoradoDao.adicionar(monitorado);
	}

	public Monitorado consultar() {
		return monitoradoDao.buscar(monitorado);
	}

	public void alterar() {
		monitoradoDao.editar(monitorado);
	}

	public void remover() {
		monitoradoDao.remover(monitorado);
	}
	
	public void listar() {
		monitoradosList = monitoradoDao.listar();
	}

}