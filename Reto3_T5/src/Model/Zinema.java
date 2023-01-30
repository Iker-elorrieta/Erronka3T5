package Model;

public class Zinema {
	private int id_zinema;
	private String IzenZin;
	private String Kokalekua;
	
	
	//Constructor
	public Zinema(int id_zinema, String izenZin, String kokalekua) {
		this.id_zinema = id_zinema;
		IzenZin = izenZin;
		Kokalekua = kokalekua;
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
}
