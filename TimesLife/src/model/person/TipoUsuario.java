package model.person;

public enum TipoUsuario {
	ADMIN("Administrador"), 
	MONITOR("Monitor");
	
	private String label;
	
	private TipoUsuario(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return this.label;
	}
	 
}
