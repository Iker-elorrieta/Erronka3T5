package Model;

import java.util.Calendar;
import java.util.Objects;

public class Saioa {
	private int id_saioa;
	private Calendar ordua;
	private Filma filma;
	private Aretoa aretoa;
	
	//Constructor
	public Saioa(int id_saioa, Calendar ordua, Filma filma, Aretoa aretoa){
		this.id_saioa = id_saioa;
		this.ordua = ordua;
		this.filma = filma;
		this.aretoa = aretoa;
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
	public Filma getFilma() {
		return filma;
	}
	public Aretoa getAretoa() {
		return aretoa;
	}
	
	// Setters
	public void setId_saioa(int id_saioa) {
		this.id_saioa = id_saioa;
	}
	public void setOrdua(Calendar ordua) {
		this.ordua = ordua;
	}
	public void setFilma(Filma filma) {
		this.filma = filma;
	}
	public void setAretoa(Aretoa aretoa) {
		this.aretoa = aretoa;
	}
	
	// ToString
	@Override
	public String toString() {
		return "Saioa [id_saioa=" + id_saioa + ", ordua=" + ordua + ", filma=" + filma + ", aretoa=" + aretoa + "]";
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
