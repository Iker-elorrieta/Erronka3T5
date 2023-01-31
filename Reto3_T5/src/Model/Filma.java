package Model;

import java.util.Objects;

public class Filma {
	private int id_filma;
	private String izenburu;
	private String genero;
	private int iraupena;
	
	//Constructor
	public Filma(int id_filma, String izenburu, String genero, int iraupena){
		this.id_filma = id_filma;
		this.izenburu = izenburu;
		this.genero = genero;
		this.iraupena = iraupena;
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
	
	// ToString
	@Override
	public String toString() {
		return "Filma [id_filma=" + id_filma + ", izenburu=" + izenburu + ", genero=" + genero + ", iraupena="
				+ iraupena + "]";
	}
	
	// Equals
	@Override
	public int hashCode() {
		return Objects.hash(genero, id_filma, iraupena, izenburu);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filma other = (Filma) obj;
		return Objects.equals(genero, other.genero) && id_filma == other.id_filma && iraupena == other.iraupena
				&& Objects.equals(izenburu, other.izenburu);
	}
}
