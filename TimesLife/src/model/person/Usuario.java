package model.person;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Usuario extends Pessoa {
	@Enumerated(EnumType.STRING)
	TipoUsuario tipo;
	
	public Usuario(String nome, String dataNasc, String endereco, String telefone, TipoUsuario tipo) {
		super(nome, dataNasc, endereco, telefone);
		this.tipo = tipo;
	}
	
}
