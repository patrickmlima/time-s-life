package model.dao;

import java.util.List;

import model.person.Dado;

public interface DadosDAO {
	
	public void adicionar(Dado dado);
	public List<Dado> consultar(Integer monitoradoId);
}
