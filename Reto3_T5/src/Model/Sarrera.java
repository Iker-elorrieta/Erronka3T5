package Model;

import java.util.Objects;

public class Sarrera {
	private int id_sarrera;
	private Filma[] filma;
	private float prezioa;
	private Saioa[] saioa;
	private Erosketa[] erosketa;
	
	//Constructor
	public Sarrera(int id_sarrera, Filma[] filma, float prezioa, Saioa[] saioa, Erosketa[] erosketa) {
		this.id_sarrera = id_sarrera;
		this.filma = filma;
		this.prezioa = prezioa;
		this.saioa = saioa;
		this.erosketa = erosketa;
	}
	
	public Sarrera() {
	}
	
	//Setters
	public void setId_sarrera(int id_sarrera) {
		this.id_sarrera = id_sarrera;
	}	
	public void setFilma(Filma[] filma) {
		this.filma = filma;
	}
	public void setPrezioa(float prezioa) {
		this.prezioa = prezioa;
	}
	public void setSaioa(Saioa[] saioa) {
		this.saioa = saioa;
	}
	public void setErosketa(Erosketa[] erosketa) {
		this.erosketa = erosketa;
	}
		
	//Getters
	public int getId_sarrera() {
		return id_sarrera;
	}
	public Filma[] getFilma() {
		return filma;
	}
	public float getPrezioa() {
		return prezioa;
	}
	public Saioa[] getSaioa() {
		return saioa;
	}
	public Erosketa[] getErosketa() {
		return erosketa;
	}
	
	// ToString
	@Override
	public String toString() {
		return "Sarrera [id_sarrera=" + id_sarrera + ", filma=" + filma + ", prezioa=" + prezioa + ", saioa="
				+ saioa + ", erosketa=" + erosketa + "]";
	}
	
	// Equals
	/*@Override
	public int hashCode() {
		return Objects.hash(id_sarrera, prezioa);
	}*/

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		Sarrera other = (Sarrera) obj;
		return Objects.equals(id_sarrera, other.id_sarrera);
	}
}
