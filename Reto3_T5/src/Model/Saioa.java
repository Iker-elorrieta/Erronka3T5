package Model;

import java.util.Calendar;
import java.util.Objects;

public class Saioa {
	private int id_saioa;
	private Calendar ordua;
	
	//Constructor
	public Saioa(int id_saioa, Calendar ordua){
		this.id_saioa = id_saioa;
		this.ordua = ordua;
	}
	
	public Saioa(){
		
	}
	
	//Getters
	public int getId_saioa() {
		return id_saioa;
	}
	public Calendar getOrdua() {
		return ordua;
	}
	
	// Setters
	public void setId_saioa(int id_saioa) {
		this.id_saioa = id_saioa;
	}

	public void setOrdua(Calendar ordua) {
		this.ordua = ordua;
	}
	
	// ToString
	@Override
	public String toString() {
		return "Saioa [id_saioa=" + id_saioa + ", ordua=" + ordua + "]";
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
