package model.person;

public class TestePessoa {
	public static void main(String[] args) {
		Pessoa p = new Pessoa("joao", "01/01/1991", "rua jaguariuna", "+5592999999999",
				Categoria.ADMIN);
		
		if(p.getCategoria().equals(Categoria.ADMIN_MASTER)) {
			System.out.println("falhou");
		}
	}

}
