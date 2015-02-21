package servico;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.person.TipoUsuario;
import model.person.Usuario;

@ManagedBean
@ViewScoped
public class CadastrarUsuarioMB {
	private Usuario usuario = new Usuario();
	private Date dataNasc;
	private TipoUsuario tipo;
	
	private ServicoDAO dao = new ServicoDAO();

	
	public CadastrarUsuarioMB() {
		
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Date getDataNasc() {
		return dataNasc;
	}
	
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	@SuppressWarnings("static-access")
	public TipoUsuario[] getTipo() {
		return tipo.values();
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}
	

	public void salvar() {
		try {
		usuario.setDataNasc(dataNasc);
		dao.salvarUsuario(usuario);
		DialogMB.showMessage("Parabéns", "Usuário adicionado com sucesso!", "dlgOk");
		limpar();
		} catch(Exception e) {
			DialogMB.showMessage("Falha", "Usuário não pôde ser adicionado.", "dlgOk");
		}
	}
	
	private void limpar() {
		usuario = new Usuario();
		dataNasc = null;
	}
}
