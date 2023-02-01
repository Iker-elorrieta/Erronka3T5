package Model;

import java.util.Arrays;
import java.util.Objects;

public class Saioa {
	private int id_saioa;
	private Hora ordua;
	private Sarrera[] sarrera;
	
	//Constructor
	public Saioa(int id_saioa, Hora ordua, Sarrera[] sarrera){
		this.id_saioa = id_saioa;
		this.ordua = ordua;
		this.sarrera = sarrera;
	}
	
	public Saioa(){
		
	}
	
	//Getters
	public int getId_saioa() {
		return id_saioa;
	}
	public Hora getOrdua() {
		return ordua;
	}
	public Sarrera[] getSarrera() {
		return sarrera;
	}
	
	// Setters
	public void setId_saioa(int id_saioa) {
		this.id_saioa = id_saioa;
	}

	public void setOrdua(Hora ordua) {
		this.ordua = ordua;
	}

	public void setSarrera(Sarrera[] sarrera) {
		this.sarrera = sarrera;
	}
	
	// ToString
	@Override
	public String toString() {
		return "Saioa [id_saioa=" + id_saioa + ", ordua=" + ordua + ", sarrera=" + Arrays.toString(sarrera) + "]";
	}
	
	// Equals
	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(sarrera);
		result = prime * result + Objects.hash(id_saioa, ordua);
		return result;
	}*/

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		Saioa other = (Saioa) obj;
		return Objects.equals(id_saioa, other.id_saioa);
	}
	
	
}
