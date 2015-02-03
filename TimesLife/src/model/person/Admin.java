package model.person;

public class Admin extends Pessoa {
	
	private String email;
	
	public Admin() {
		super();
	}
	
	public Admin(String nome, String dataNasc, String endereco, String telefone,
			String email) {
		super(nome, dataNasc, endereco, telefone, Categoria.ADMIN);
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void seEmail(String email) {
		this.email = email;
	}

}
