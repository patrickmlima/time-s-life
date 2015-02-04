package model.person;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Dado {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID;
	
	@ManyToOne
	private Monitorado monitorado;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar time;
	
	private int bpm;
	private double latitude;
	private double longitude;
	
	public Dado(Monitorado monitorado, int bpm, double latitude, double longitude) {
		this.monitorado = monitorado;
		this.bpm = bpm;
		this.latitude = latitude;
		this.longitude = longitude;
		this.time = Calendar.getInstance();
	}
	
	public Dado(int id_monitorado, int bpm, double latitude, double longitude) {
		this(new Monitorado(), bpm, latitude, longitude);
		this.monitorado.setIdentificador(id_monitorado);
	}
	
	public int getBpm() {
		return bpm;
	}
	
	public void setBpm(int bpm) {
		this.bpm = bpm;
	}
	
	public Calendar getDate() {
		return time;
	}
	
	public void setDate(Calendar time) {
		this.time = time;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	
}
