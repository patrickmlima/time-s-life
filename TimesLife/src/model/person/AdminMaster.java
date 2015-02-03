package model.person;

public class AdminMaster extends Pessoa {
	
	private String email;
	
	public AdminMaster() {
		super();
	}
	
	public AdminMaster(String nome, String dataNasc, String endereco, String telefone,
			String email) {
		super(nome, dataNasc, endereco, telefone, Categoria.ADMIN_MASTER);
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
