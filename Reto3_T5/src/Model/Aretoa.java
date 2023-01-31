package Model;

import java.util.Arrays;
import java.util.Objects;

public class Aretoa {
	private int id_areto;
	private String izenAret;
	private Saioa[] saioa;
	
	// Constructor
	public Aretoa(int id_aretoa, String izenAret, Saioa[] saioa){
		this.id_areto = id_aretoa;
		this.izenAret = izenAret;
		this.saioa = saioa;
	}
	
	//Setters
	public void setId_areto(int id_areto) {
		this.id_areto = id_areto;
	}
	public void setIzenAret(String izenAret) {
		this.izenAret = izenAret;
	}
	public void setSaioa(Saioa[] saioa) {
		this.saioa = saioa;
	}
	
	// Getters
	public int getId_areto() {
		return id_areto;
	}
	public String getIzenAret() {
		return izenAret;
	}
	public Saioa[] getSaioa() {
		return saioa;
	}
	
	// ToString
	@Override
	public String toString() {
		return "Aretoa [id_areto=" + id_areto + ", izenAret=" + izenAret + ", saioa=" + Arrays.toString(saioa) + "]";
	}

	// Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(saioa);
		result = prime * result + Objects.hash(id_areto, izenAret);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aretoa other = (Aretoa) obj;
		return id_areto == other.id_areto && Objects.equals(izenAret, other.izenAret)
				&& Arrays.equals(saioa, other.saioa);
	}
	
}
