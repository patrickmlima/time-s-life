package servico;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.context.RequestContext;

import model.dao.MonitoradoDao;
import model.dao.UsuarioDao;
import model.person.Monitorado;
import model.person.Usuario;

@ManagedBean
@RequestScoped
public class MonitoradoMB {
	private Monitorado monitorado = new Monitorado();
	//data de nascimento do monitorado
	private Date dataNasc;
	private String dt;
	
	private List<Usuario> monitoresList;
	private List<Monitorado> monitoradosList;
	private Monitorado monitoradoSelecionado;
	
	private MonitoradoDao monitoradoDao = new MonitoradoDao();
	private UsuarioDao usuarioDao = new UsuarioDao();

	public MonitoradoMB() {
		monitoradosList = monitoradoDao.listar();
		monitoresList = usuarioDao.listarMonitores();
	}
	
	public Monitorado getMonitorado() {
		return monitorado;
	}

	public void setMonitorado(Monitorado monitorado) {
		this.monitorado = monitorado;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}		
	
	public String getDt() {
		return (new SimpleDateFormat("dd/MM/yyyy")).format(monitoradoSelecionado.getDataNasc().getTime());
	}

	public List<Usuario> getMonitoresList() {
		return monitoresList;
	}

	public void setMonitoresList() {
		this.monitoresList = usuarioDao.listarMonitores();
	}
	
	public List<Monitorado> getMonitoradosList() {
		return monitoradosList;
	}
	
	public void setMonitoradosList(List<Monitorado> monitoradosList) {
		this.monitoradosList = monitoradosList;
	}
	
	public Monitorado getMonitoradoSelecionado() {
		return monitoradoSelecionado;
	}
	
	public void setMonitoradoSelecionado(Monitorado monitoradoSelecionado) {
		this.monitoradoSelecionado = monitoradoSelecionado;
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
		try {
			if (valida()) {
				this.monitorado.setDataNasc(dataNasc);
				this.monitorado.calcularBatimentosIdeais();
				monitoradoDao.adicionar(monitorado);
				DialogMB.showMessage("Parabens", "Monitorado cadastrado com sucesso!");
				limpar();
			}
			else {
				DialogMB.showMessage("Monitorado não cadastrado", "A altura e/ou peso estão incorretos.");
			}
		} catch (Exception e) {
			DialogMB.showMessage("Falha", "Monitorado não pôde ser cadastrado.");
		}
		RequestContext.getCurrentInstance().execute("PF('dlgOk').show();");
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
	
	public void limpar() {
		monitorado = new Monitorado();
		dataNasc = null;
	}
	
	public boolean valida() {
		if ((monitorado.getAltura() > 0) && (monitorado.getPeso() > 0))
			return true;
		return false;
	}

}