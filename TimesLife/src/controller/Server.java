package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.DadoDAO;
import model.dao.MonitoradoDao;
import model.person.Analisador;
import model.person.Dado;

import org.primefaces.context.RequestContext;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

/**
 * Servlet implementation class Server
 */
@WebServlet("/server")
public class Server extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Server() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("chegou");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(
				request.getInputStream()));
		String jsonDadoStr = "";
		if (br != null) {
			jsonDadoStr = br.readLine();
			JSONObject jsonDado = null;
			DadoDAO dao = null;
			Dado monitoradoDado = null;
			
			try {
				jsonDado = new JSONObject(jsonDadoStr);
				
				monitoradoDado = new Dado(jsonDado.getLong("idMonitorado"),
						jsonDado.getInt("bpm"), jsonDado.getDouble("latitude"),
						jsonDado.getDouble("longitude"));
				dao = new DadoDAO();
				dao.adicionar(monitoradoDado);
				System.out.println("+======== adicionou ========+");
				
				MonitoradoDao mDao = new MonitoradoDao();
				(new Analisador()).classificar(
						mDao.getByPrimaryKey(monitoradoDado.getMonitorado()
								.getId()), monitoradoDado);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
}
