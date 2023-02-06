package Model;

import java.util.Objects;

public class Filma {
	private int id_filma;
	private String izenburu;
	private String genero;
	private int iraupena;
	private float prezioa;
	
	//Constructor
	public Filma(int id_filma, String izenburu, String genero, int iraupena, float prezioa){
		this.id_filma = id_filma;
		this.izenburu = izenburu;
		this.genero = genero;
		this.iraupena = iraupena;
		this.prezioa = prezioa;
	}
	
	public Filma(){
	}
	
	//Getters
	public int getId_filma() {
		return id_filma;
	}
	public String getIzenburu() {
		return izenburu;
	}
	public String getGenero() {
		return genero;
	}
	public int getIraupena() {
		return iraupena;
	}
	public float getPrezioa() {
		return prezioa;
	}
	
	// ToString
	@Override
	public String toString() {
		return "Filma [id_filma=" + id_filma + ", izenburu=" + izenburu + ", genero=" + genero + ", iraupena="
				+ iraupena + ", prezioa=" + prezioa + "]";
	}
	
	// Equals
	/*@Override
	public int hashCode() {
		return Objects.hash(genero, id_filma, iraupena, izenburu);
	}*/

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		Filma other = (Filma) obj;
		return Objects.equals(id_filma, other.id_filma);
	}
}
