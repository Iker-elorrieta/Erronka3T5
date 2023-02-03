package Model;

import java.util.Objects;

public class Sarrera {
	private int id_sarrera;
	private int id_filma;
	private float prezioa;
	private int id_saioa;
	private int id_erosketa;
	
	//Constructor
	public Sarrera(int id_sarrera, int id_filma, float prezioa, int id_saioa, int id_erosketa) {
		this.id_sarrera = id_sarrera;
		this.id_filma = id_filma;
		this.prezioa = prezioa;
		this.id_saioa = id_saioa;
		this.id_erosketa = id_erosketa;
	}
	
	public Sarrera() {
	}
	
	//Setters
	public void setId_sarrera(int id_sarrera) {
		this.id_sarrera = id_sarrera;
	}	
	public void setId_filma(int id_filma) {
		this.id_filma = id_filma;
	}
	public void setPrezioa(float prezioa) {
		this.prezioa = prezioa;
	}
	public void setId_saioa(int id_saioa) {
		this.id_saioa = id_saioa;
	}
	public void setId_erosketa(int id_erosketa) {
		this.id_erosketa = id_erosketa;
	}
		
	//Getters
	public int getId_sarrera() {
		return id_sarrera;
	}
	public int getId_filma() {
		return id_filma;
	}
	public float getPrezioa() {
		return prezioa;
	}
	public int getId_saioa() {
		return id_saioa;
	}
	public int getId_erosketa() {
		return id_erosketa;
	}
	
	// ToString
	@Override
	public String toString() {
		return "Sarrera [id_sarrera=" + id_sarrera + ", id_filma=" + id_filma + ", prezioa=" + prezioa + ", id_saioa="
				+ id_saioa + ", id_erosketa=" + id_erosketa + "]";
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
