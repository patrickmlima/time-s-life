package model.dao;

import model.person.Pessoa;

public interface PessoaDAO {
	
	public void adicionar(Pessoa pessoa);
	public Pessoa consultar(Integer identificador);
	public void editar(Pessoa pessoa);
	public void excluir(Pessoa pessoa);
	public void listar();
}
