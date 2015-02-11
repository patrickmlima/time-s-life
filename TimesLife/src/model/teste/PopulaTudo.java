package model.teste;

import model.dao.MonitoradoDao;
import model.dao.UsuarioDao;
import model.person.Monitorado;
import model.person.TipoUsuario;
import model.person.Usuario;

public class PopulaTudo {
	public static void main(String[] args) {
		MonitoradoDao mDao = new MonitoradoDao();
		UsuarioDao uDao = new UsuarioDao();
		
		Monitorado mon1 = new Monitorado();
		mon1.setNome("monitorado teste1");
		mon1.setEndereco("rua 1");
		mon1.setDataNasc("21/12/194");
		mon1.setAltura(1.60f);
		mon1.setPeso(60.5f);
		mon1.setTelefone("991919191");
		mon1.setBATIMENTO_IDAL_MAXIMO(200);
		mon1.setBATIMENTO_IDEAL_MINIMO(70);
		
		Monitorado mon2 = new Monitorado();
		mon2.setNome("monitorado teste2");
		mon2.setEndereco("rua 2");
		mon2.setDataNasc("22/22/1996");
		mon2.setAltura(1.70f);
		mon2.setPeso(65.0f);
		mon2.setTelefone("992929292");
		mon2.setBATIMENTO_IDAL_MAXIMO(210);
		mon2.setBATIMENTO_IDEAL_MINIMO(90);
		
		Usuario user1 = new Usuario();
		user1.setNome("usuario teste1");
		user1.setEndereco("rua 01");
		user1.setDataNasc("11/11/1911");
		user1.setTelefone("992939192");
		user1.setTipo(TipoUsuario.MONITOR);
		user1.setMonitorados(mon1);
		user1.setMonitorados(mon2);
		
		mDao.adicionar(mon1);
		mDao.adicionar(mon2);
		uDao.adicionar(user1);
	}

}
