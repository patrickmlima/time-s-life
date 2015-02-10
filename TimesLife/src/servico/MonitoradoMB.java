package servico;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.dao.PessoaDAO;
import model.person.Monitorado;
import model.person.Pessoa;

@ManagedBean
@RequestScoped
public class MonitoradoMB {
	private Monitorado monitorado = new Monitorado();
	private List<Pessoa> monitoradosList;
	private List<Pessoa> monitoresList;
	private PessoaDAO dao = new PessoaDAO();

	public MonitoradoMB() {
	}

	public Monitorado getMonitorado() {
		return monitorado;
	}

	public void setMonitorado(Monitorado monitorado) {
		this.monitorado = monitorado;
	}

	public PessoaDAO getDao() {
		return dao;
	}

	public void setDao(PessoaDAO dao) {
		this.dao = dao;
	}

	public List<Pessoa> getMonitoradosList() {
		return monitoresList;
	}

	public void setMonitoradosList() {
		this.monitoresList = dao.listar();
	}

	public void salvar() {
		dao.adicionar(monitorado);
	}

	public Pessoa consultar() {
		return dao.buscar(monitorado);
	}

	public void alterar() {
		dao.editar(monitorado);
	}

	public void remover() {
		dao.remover(monitorado);
	}
	
	public void listar() {
		monitoradosList = dao.listar();
		System.out.println(""+monitoradosList.size());
	}
}
