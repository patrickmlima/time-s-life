package servico;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.person.Monitorado;
import model.person.Usuario;

@ManagedBean
@ViewScoped
public class MostrarMonitoradoMB {
	private List<Usuario> monitoresList;
	private List<Monitorado> monitoradosList;
	private Monitorado monitoradoSelecionado;
	
	private ServicoDAO dao = new ServicoDAO();

	public MostrarMonitoradoMB() {
		monitoradosList = dao.listarMonitorados();
	}
	
	public List<Usuario> getMonitoresList() {
		return monitoresList;
	}

	public void setMonitoresList(List<Usuario> monitoresList) {
		this.monitoresList = monitoresList;
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
	
	public void excluirMonitoradoSelecionado() {
		if(monitoradosList.contains(monitoradoSelecionado)) {
			monitoradosList.remove(monitoradoSelecionado);
			dao.excluirMonitorado(monitoradoSelecionado);
		}
	}
	
	public void editarMonitorado() {
		dao.editarMonitorado(monitoradoSelecionado);
		DialogMB.showMessage(" ", "Dados do monitorado editados", "dlgOk");
	}

}
