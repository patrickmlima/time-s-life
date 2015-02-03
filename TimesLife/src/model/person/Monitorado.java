package model.person;

public class Monitorado extends Pessoa implements Monitoravel {
	
	private boolean ativo;
	private float peso;
	private float altura;
	private int bpm;
	private int BATIMENTO_IDEAL_MINIMO;
	private int BATIMENTO_IDAL_MAXIMO;
	
	public Monitorado() {
		super();
	}
	
	public Monitorado(String nome, String dataNasc, String endereco, String telefone,
			float peso, float altura) {
		super(nome, dataNasc, endereco, telefone, Categoria.MONITORADO);
		this.peso = peso;
		this.altura = altura;
		this.ativo = false;
		calcularBatimentosIdeais();
	}
	
	@Override
	public void calcularBatimentosIdeais() {
		// TODO Auto-generated method stub
		
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public int getBpm() {
		return bpm;
	}

	public void setBpm(int bpm) {
		this.bpm = bpm;
	}

	public int getBATIMENTO_IDEAL_MINIMO() {
		return BATIMENTO_IDEAL_MINIMO;
	}

	public void setBATIMENTO_IDEAL_MINIMO(int bATIMENTO_IDEAL_MINIMO) {
		BATIMENTO_IDEAL_MINIMO = bATIMENTO_IDEAL_MINIMO;
	}

	public int getBATIMENTO_IDAL_MAXIMO() {
		return BATIMENTO_IDAL_MAXIMO;
	}

	public void setBATIMENTO_IDAL_MAXIMO(int bATIMENTO_IDAL_MAXIMO) {
		BATIMENTO_IDAL_MAXIMO = bATIMENTO_IDAL_MAXIMO;
	}
		
}
