package model.person;

import model.strategy.avisar.Alertavel;
import model.strategy.avisar.AvisarNaTela;

public class Analisador {
	private Alertavel alert;
	
	public void classificar(Monitorado monitorado, Dado dado) {
		if(dado.getBpm() > monitorado.getBATIMENTO_IDEAL_MAXIMO()) {
			//batimentos altos
		} else if(dado.getBpm() < monitorado.getBATIMENTO_IDEAL_MINIMO()) {
			//batimentos baixos
		}
	}
	
	public void avisar() {
		 alert = new AvisarNaTela();
		 //chamar avisar
	}
}
