package servico;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import org.primefaces.context.RequestContext;

@ManagedBean
public class DialogMB implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static String tituloDialog;
	private static String mensagemDialog;
	
	public String getTituloDialog() {
		return tituloDialog;
	}

	public String getMensagemDialog() {
		return mensagemDialog;
	}
	
	public static void showMessage(String title, String msg, String dlgName) {
		tituloDialog = title;
		mensagemDialog = msg;
		RequestContext.getCurrentInstance().execute("PF('" + dlgName + "').show();");
	}

}
