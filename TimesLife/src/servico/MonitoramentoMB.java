package servico;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import model.dao.DadoDAO;
import model.person.Dado;
import model.person.Monitorado;

@ManagedBean
@SessionScoped
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
		if(monitorado == null) {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		dadosMonitorado = dao.listarDados(monitorado);
		return dadosMonitorado;
	}

	public void setDadosMonitorado(List<Dado> dadosMonitorado) {
		this.dadosMonitorado = dadosMonitorado;
	}
	
	public String carregarDados(Monitorado monitorado) {
		setMonitorado(monitorado);
		return "monitoramento.xhtml";
	}
	
	public void refresh(AjaxBehaviorEvent event) {
		System.out.println("----------FOCUS----------------");
	}
	
}
