package model.person;

import model.strategy.avisar.Alertavel;
import model.strategy.avisar.AvisarNaTela;

public class Analisador {
	private Alertavel alert;
	
	public void classificar(Monitorado monitorado, Dado dado) {
		if(dado.getBpm() > monitorado.getBATIMENTO_IDEAL_MAXIMO()) {
			System.out.print("Batimento acelerados");
		} else if(dado.getBpm() < monitorado.getBATIMENTO_IDEAL_MINIMO()) {
			System.out.print("Batimento desacelerados");
		}
	}
	
	public void avisar() {
		 alert = new AvisarNaTela();
		 //chamar avisar
	}
}
