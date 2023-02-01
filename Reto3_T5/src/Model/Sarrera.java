package Model;

import java.util.Objects;

public class Sarrera {
	private int id_sarrera;
	private float prezioa;
	
	//Constructor
	public Sarrera(int id_sarrera, float prezioa) {
		this.id_sarrera = id_sarrera;
		this.prezioa = prezioa;
	}
	
	public Sarrera() {
	}
	
	//Setters
	public void setId_sarrera(int id_sarrera) {
		this.id_sarrera = id_sarrera;
	}	
	public void setPrezioa(float prezioa) {
		this.prezioa = prezioa;
	}
		
	//Getters
	public int getId_sarrera() {
		return id_sarrera;
	}
	public float getPrezioa() {
		return prezioa;
	}
	
	// ToString
	@Override
	public String toString() {
		return "Sarrera [id_sarrera=" + id_sarrera + ", prezioa=" + prezioa + "]";
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
