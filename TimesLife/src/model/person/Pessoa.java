package model.person;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import model.dao.AbstractEntity;

@MappedSuperclass
public class Pessoa extends AbstractEntity<Long>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@Temporal(TemporalType.DATE)
	private Calendar dataNasc;
	private String endereco;
	private String telefone;
	
	public Pessoa() {
		
	}
	
	public Pessoa(String nome, Calendar dataNasc, String endereco, String telefone) {
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	} 

	public Calendar getDataNasc() {
		return dataNasc;
	}
	
	public String getDataNascString() {
		return (new SimpleDateFormat("dd/MM/yyyy")).format(dataNasc.getTime());
	}

	public void setDataNasc(Date date) {
		dataNasc = Calendar.getInstance();
		dataNasc.setTime(date);
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
