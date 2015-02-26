package model.person;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import model.dao.AbstractEntity;

@Entity
public class Dado extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Monitorado monitorado;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar time;
	
	private int bpm;
	private double latitude;
	private double longitude;
	
	public Dado() {
		
	}
	
	public Dado(Monitorado monitorado, int bpm, double latitude, double longitude) {
		this.monitorado = monitorado;
		this.bpm = bpm;
		this.latitude = latitude;
		this.longitude = longitude;
		this.time = Calendar.getInstance();
	}
	
	public Dado(Long id_monitorado, int bpm, double latitude, double longitude) {
		this(new Monitorado(), bpm, latitude, longitude);
		this.monitorado.setId(id_monitorado);
	}
	
	public int getBpm() {
		return bpm;
	}
	
	public void setBpm(int bpm) {
		this.bpm = bpm;
	}
	
	public Calendar getTime() {
		return time;
	}
	
	public String getTimeString() {
		return (new SimpleDateFormat("dd/MM/yyyy hh:mm:ss")).format(time.getTime());
	}
	
	public void setTime(Calendar time) {
		this.time = time;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	public Monitorado getMonitorado() {
		return this.monitorado;
	}
}
