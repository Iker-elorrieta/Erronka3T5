package Model;

import java.util.Arrays;
import java.util.Objects;

public class Zinema {
	private int id_zinema;
	private String IzenZin;
	private String Kokalekua;
	private Aretoa[] areto;
	
	
	//Constructor
	public Zinema(int id_zinema, String izenZin, String kokalekua, Aretoa[] aretoa) {
		this.id_zinema = id_zinema;
		this.IzenZin = izenZin;
		this.Kokalekua = kokalekua;
		this.areto = aretoa;
	}
	
	public Zinema(){
		
	}
	
	//Setters
	public void setId_zinema(int id_zinema) {
		this.id_zinema = id_zinema;
	}
	public void setIzenZin(String izenZin) {
		IzenZin = izenZin;
	}
	public void setKokalekua(String kokalekua) {
		Kokalekua = kokalekua;
	}
	public void setAreto(Aretoa[] areto) {
		this.areto = areto;
	}
	
	//Getters
	public int getId_zinema() {
		return id_zinema;
	}
	public String getIzenZin() {
		return IzenZin;
	}
	public String getKokalekua() {
		return Kokalekua;
	}
	public Aretoa[] getAretoa() {
		return areto;
	}

	// ToString
	@Override
	public String toString() {
		return "Zinema [id_zinema=" + id_zinema + ", IzenZin=" + IzenZin + ", Kokalekua=" + Kokalekua + ", areto="
				+ Arrays.toString(areto) + "]";
	}

	// Equals
	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(areto);
		result = prime * result + Objects.hash(IzenZin, Kokalekua, id_zinema);
		return result;
	}*/

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		Zinema other = (Zinema) obj;
		return Objects.equals(id_zinema, other.id_zinema);
	}
}
