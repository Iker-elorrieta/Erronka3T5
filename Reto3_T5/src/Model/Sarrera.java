package Model;

import java.util.Objects;

public class Sarrera {
	private int id_sarrera;
	private Saioa saioa;
	
	//Constructor
	public Sarrera(int id_sarrera, Saioa saioa) {
		this.id_sarrera = id_sarrera;
		this.saioa = saioa;
	}
	
	public Sarrera() {
	}
	
	//Setters
	public void setId_sarrera(int id_sarrera) {
		this.id_sarrera = id_sarrera;
	}
	public void setSaioa(Saioa saioa) {
		this.saioa = saioa;
	}
		
	//Getters
	public int getId_sarrera() {
		return id_sarrera;
	}
	public Saioa getSaioa() {
		return saioa;
	}
	
	// ToString
	@Override
	public String toString() {
		return ""+saioa ;
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
