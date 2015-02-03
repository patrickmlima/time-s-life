package model.person;

public class Monitor extends Pessoa {
	
	public Monitor() {
		super();
	}
	
	public Monitor(String nome, String dataNasc, String endereco, String telefone) {
		super(nome, dataNasc, endereco, telefone, Categoria.MONITOR);
	}

}
