package servico;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import model.dao.DadoDAO;
import model.person.Dado;
import model.person.Monitorado;

@ManagedBean
public class MonitoramentoMB {
	private DadoDAO dao = new DadoDAO();
	
	private Monitorado monitorado;
	private List<Dado> dadosMonitorado;
	
	public MonitoramentoMB() {
	
	}

	public DadoDAO getDao() {
		return dao;
	}

	public void setDao(DadoDAO dao) {
		this.dao = dao;
	}

	public Monitorado getMonitorado() {
		return monitorado;
	}

	public void setMonitorado(Monitorado monitorado) {
		this.monitorado = monitorado;
	}

	public List<Dado> getDadosMonitorado() {
		dadosMonitorado = dao.listarDados(monitorado);
		return dadosMonitorado;
	}

	public void setDadosMonitorado(List<Dado> dadosMonitorado) {
		this.dadosMonitorado = dadosMonitorado;
	}
	
	public String carregarDados(Monitorado monitorado) {
		setMonitorado(monitorado);
		System.out.println("===========RETORNO------==========");
		return "monitoramento.xhtml";
	}
	
}
