package model.teste;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

import model.person.Dado;

public class SimulaEnvio {
	
	private String urlString = "http://localhost:8080/TimesLife/server";
	
	public SimulaEnvio() {
		
	}
	
	public void sendData() {
		HttpURLConnection connection = null;
		try {
			URL urlServer = new URL(urlString);

			connection = (HttpURLConnection) urlServer
					.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setDoInput(true);
			connection.setDoOutput(true);

			Dado dado;
			JSONObject JSONDado;
			dado = new Dado(4l, 80, 0, 0);
			JSONDado = new JSONObject();
			JSONDado.put("idMonitorado", dado.getMonitorado().getId());
			JSONDado.put("bpm", dado.getBpm());
			JSONDado.put("latitude", dado.getLatitude());
			JSONDado.put("longitude", dado.getLongitude());

			connection.setRequestProperty("Content-Length", ""
					+ JSONDado.toString().getBytes().length);
			
			OutputStreamWriter writer = new OutputStreamWriter(
					connection.getOutputStream());
			writer.write(JSONDado.toString());
			writer.flush();
			writer.close();
			
			connection.getInputStream();
			
			System.out.println("enviou");
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(connection != null) {
				connection.disconnect();
			}
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println("tentando enviar");
		SimulaEnvio envio = new SimulaEnvio();
		envio.sendData();
	}

}
