package model.person;

import javax.persistence.Entity;

@Entity
public class Monitorado extends Pessoa implements Monitoravel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private float peso;
	private float altura;
	private int BATIMENTO_IDEAL_MINIMO;
	private int BATIMENTO_IDEAL_MAXIMO;
	
	public Monitorado() {
		super();
	}
	
	public Monitorado(String nome, String dataNasc, String endereco, String telefone,
			float peso, float altura) {
		super(nome, dataNasc, endereco, telefone);
		this.peso = peso;
		this.altura = altura;
		calcularBatimentosIdeais();
	}
	
	@Override
	public void calcularBatimentosIdeais() {
		BATIMENTO_IDEAL_MAXIMO = 180;
		BATIMENTO_IDEAL_MINIMO = 80;
		
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


	public int getBATIMENTO_IDEAL_MINIMO() {
		return BATIMENTO_IDEAL_MINIMO; 
	}

	public void setBATIMENTO_IDEAL_MINIMO(int bATIMENTO_IDEAL_MINIMO) {
		BATIMENTO_IDEAL_MINIMO = bATIMENTO_IDEAL_MINIMO;
	}

	public int getBATIMENTO_IDEAL_MAXIMO() {
		return BATIMENTO_IDEAL_MAXIMO;
	}

	public void setBATIMENTO_IDAL_MAXIMO(int bATIMENTO_IDEAL_MAXIMO) {
		BATIMENTO_IDEAL_MAXIMO = bATIMENTO_IDEAL_MAXIMO;
	}
		
}
