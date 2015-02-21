package servico;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.person.Usuario;

@ManagedBean
@ViewScoped
public class MostrarMonitoresMB {
	
	private List<Usuario> monitoresList;
	private Usuario monitorSelecionado;
	
	private ServicoDAO dao = new ServicoDAO();
	
	public MostrarMonitoresMB() {
		monitoresList = dao.listarMonitores();
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

	
	public void excluirMonitorSelecionado() {
		if(monitoresList.contains(monitorSelecionado)) {
			monitoresList.remove(monitorSelecionado);
		}
		dao.excluirUsuario(monitorSelecionado);
	}
}
