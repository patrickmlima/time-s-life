package controller;

import model.person.Dado;

public class ServerController {
	
	private static ServerController scInstance;
	
	private ServerController() {
	}
	
	public static ServerController getInstance() {
		if(scInstance == null) {
			scInstance = new ServerController();
		}
		return scInstance;
	}
	
	public void direcionarDados(Dado dado){
	}
}
