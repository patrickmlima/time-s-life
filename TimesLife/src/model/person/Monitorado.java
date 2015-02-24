package model.person;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

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
	
	@ManyToMany(mappedBy="monitorados")
	private List<Usuario> monitores;
	
	public Monitorado() {
		monitores = new LinkedList<Usuario>();
	}
	
	public Monitorado(String nome, Calendar dataNasc, String endereco, String telefone,
			float peso, float altura) {
		super(nome, dataNasc, endereco, telefone);
		this.peso = peso;
		this.altura = altura;
		calcularBatimentosIdeais();
	}
	
	//deixar mais preciso
	public int calculaIdade() {
		Calendar atual = Calendar.getInstance();
		Calendar dtNasc = getDataNasc();
		int idade = atual.get(Calendar.YEAR) - dtNasc.get(Calendar.YEAR);
		return idade;
	}
	
	//para maior precisão, incluir sexo
	@Override
	public void calcularBatimentosIdeais() {
		int idade = calculaIdade();
		if(idade == 0) {
			setBATIMENTO_IDAL_MAXIMO(160);
			setBATIMENTO_IDEAL_MINIMO(130);
		} else if(idade > 0 && idade < 1) {
			setBATIMENTO_IDAL_MAXIMO(130);
			setBATIMENTO_IDEAL_MINIMO(110);
		} else if(idade >= 1 && idade < 7) {
			setBATIMENTO_IDAL_MAXIMO(120);
			setBATIMENTO_IDEAL_MINIMO(80);
		} else if(idade >= 7 && idade < 18) {
			setBATIMENTO_IDAL_MAXIMO(90);
			setBATIMENTO_IDEAL_MINIMO(80);
		} else {
			setBATIMENTO_IDAL_MAXIMO(80);
			setBATIMENTO_IDEAL_MINIMO(60);
		}
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
	
	public List<Usuario> getMonitores() {
		return monitores;
	}
	
	public void setMonitores(Usuario monitor) {
		if(!monitores.contains(monitor)) {
			monitores.add(monitor);
			monitor.setMonitorados(this);
		}
	}
}
