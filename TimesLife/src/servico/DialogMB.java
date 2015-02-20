package servico;

import javax.faces.bean.ManagedBean;

import org.primefaces.context.RequestContext;

@ManagedBean
public class DialogMB {
	private static String tituloDialog;
	private static String mensagemDialog;
	
	public String getTituloDialog() {
		return tituloDialog;
	}

	public String getMensagemDialog() {
		return mensagemDialog;
	}
	
	public static void showMessage(String title, String msg) {
		tituloDialog = title;
		mensagemDialog = msg;
		RequestContext.getCurrentInstance().execute("PF('dlgOk').show();");
	}

}
