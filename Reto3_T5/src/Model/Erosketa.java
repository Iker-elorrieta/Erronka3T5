package Model;

import java.util.Arrays;
import java.util.Objects;

public class Erosketa {
	private int id_erosketa;
	private Bezero[] bezeroa;
	private Sarrera[] sarrera;
	
	// Constructor
	public Erosketa(int id_erosketa, Bezero[] bezero, Sarrera[] sarrera){
		this.id_erosketa = id_erosketa;
		this.bezeroa = bezero;
		this.sarrera = sarrera;
	}
	
	public Erosketa(){
		
	}
	
	//Setters
	public void setId_erosketa(int id_erosketa) {
		this.id_erosketa = id_erosketa;
	}
	public void setId_bezero(Bezero[] bezero) {
		this.bezeroa = bezero;
	}
	public void setSarrera(Sarrera[] sarrera) {
		this.sarrera = sarrera;
	}
		
		
	//Getters
	public int getId_erosketa() {
		return id_erosketa;
	}
	public Bezero[] getBezero() {
		return bezeroa;
	}
	public Sarrera[] getSarrera() {
		return sarrera;
	}

	// ToString
	@Override
	public String toString() {
		return "Erosketa [id_erosketa=" + id_erosketa + ", bezeroa=" + Arrays.toString(bezeroa) + ", sarrera="
				+ Arrays.toString(sarrera) + "]";
	}

	// Equals
	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(bezeroa);
		result = prime * result + Arrays.hashCode(sarrera);
		result = prime * result + Objects.hash(id_erosketa);
		return result;
	}*/

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		Erosketa other = (Erosketa) obj;
		return Objects.equals(id_erosketa, other.id_erosketa);
	}
}
