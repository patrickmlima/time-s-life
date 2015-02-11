package model.person;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;

@Entity
public class Usuario extends Pessoa {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Enumerated(EnumType.STRING)
	private TipoUsuario tipo;
	
	@ManyToMany
	private List<Monitorado> monitorados;
	
	
	public Usuario() {
		monitorados = new LinkedList<Monitorado>();
	}
	
	public Usuario(String nome, String dataNasc, String endereco, String telefone, TipoUsuario tipo) {
		super(nome, dataNasc, endereco, telefone);
		this.tipo = tipo;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

	public List<Monitorado> getMonitorados() {
		return monitorados;
	}

	public void setMonitorados(Monitorado monitorado) {
		this.monitorados.add(monitorado);
	}	
}
