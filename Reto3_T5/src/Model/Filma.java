package Model;

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
}
