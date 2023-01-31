package Model;

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
}
