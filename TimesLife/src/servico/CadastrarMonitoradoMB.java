package servico;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.person.Monitorado;
import model.person.Usuario;

@ManagedBean
@ViewScoped
public class CadastrarMonitoradoMB implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Monitorado monitorado = new Monitorado();
	//data de nascimento do monitorado
	private Date dataNasc;
	private Usuario monitor;
	
	private ServicoDAO dao = new ServicoDAO();

	public CadastrarMonitoradoMB() {
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
	
	public Usuario getMonitor() {
		return monitor;
	}

	public void setMonitor(Usuario monitor) {
		this.monitor = monitor;
	}

	public ServicoDAO getDao() {
		return dao;
	}

	public void setDao(ServicoDAO dao) {
		this.dao = dao;
	}

	
	public void salvar() {
		try {
			if (valida()) {
				this.monitorado.setDataNasc(dataNasc);
				this.monitorado.calcularBatimentosIdeais();
				this.monitorado.setMonitores(monitor);
				dao.salvarMonitorado(monitorado);
				DialogMB.showMessage("Parabens", "Monitorado cadastrado com sucesso!", "dlgOk");
				limpar();
			}
			else {
				DialogMB.showMessage("Monitorado não cadastrado", "A altura e/ou peso estão incorretos.", "dlgOk");
			}
		} catch (Exception e) {
			DialogMB.showMessage("Falha", "Monitorado não pôde ser cadastrado.", "dlgOk");
		}
	}
	
	public void removerMonitoradoSelecionado() {
		
	}
	
	private void limpar() {
		monitorado = new Monitorado();
		dataNasc = null;
	}
	
	private boolean valida() {
		if ((monitorado.getAltura() > 0) && (monitorado.getPeso() > 0))
			return true;
		return false;
	}

}