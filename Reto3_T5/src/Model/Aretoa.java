package Model;

import java.util.Arrays;
import java.util.Objects;

public class Aretoa {
	private int id_areto;
	private String izenAret;
	private Saioa[] saioak;
	
	
	// Constructor
	public Aretoa(int id_aretoa, String izenAret, Saioa[] saioak){
		this.id_areto = id_aretoa;
		this.izenAret = izenAret;
		this.saioak=saioak;
	}
	
	public Aretoa(){
		
	}
	
	//Setters
	public void setId_areto(int id_areto) {
		this.id_areto = id_areto;
	}
	public void setIzenAret(String izenAret) {
		this.izenAret = izenAret;
	}
	public void setSaioak(Saioa[] saioak) {
		this.saioak = saioak;
	}
	
	// Getters
	public int getId_areto() {
		return id_areto;
	}
	public String getIzenAret() {
		return izenAret;
	}
	public Saioa[] getSaioak() {
		return saioak;
	}
	
	// ToString
	@Override
	public String toString() {
		return "Aretoa [id_areto=" + id_areto + ", izenAret=" + izenAret + ", saioak=" + Arrays.toString(saioak) + "]";
	}

	// Equals
	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(saioa);
		result = prime * result + Objects.hash(id_areto, izenAret);
		return result;
	}*/

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		Aretoa other = (Aretoa) obj;
		return Objects.equals(id_areto, other.id_areto);
	}	
}
