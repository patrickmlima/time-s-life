package servico;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.person.Monitorado;
import model.person.Usuario;

@ManagedBean
@SessionScoped
public class MostrarMonitoresMB implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Usuario> monitoresList;
	private Usuario monitorSelecionado;

	private String novoMonitorado;

	private ServicoDAO dao = new ServicoDAO();

	public MostrarMonitoresMB() {

	}

	public List<Usuario> getMonitoresList() {
		monitoresList = dao.listarMonitores();
		return monitoresList;
	}

	public void setMonitoresList(List<Usuario> monitoresList) {
		this.monitoresList = monitoresList;
	}

	public Usuario getMonitorSelecionado() {
		return monitorSelecionado;
	}

	public void setMonitorSelecionado(Usuario monitorSelecionado) {
		this.monitorSelecionado = monitorSelecionado;
	}

	public String getNovoMonitorado() {
		return novoMonitorado;
	}

	public void setNovoMonitorado(String novoMonitorado) {
		this.novoMonitorado = novoMonitorado;
	}

	public void excluirMonitorSelecionado() {
		if (monitoresList.contains(monitorSelecionado)) {
			monitoresList.remove(monitorSelecionado);
		}
		dao.excluirUsuario(monitorSelecionado);
	}

	public void adicionarMonitoradoALista() {
	}
}
