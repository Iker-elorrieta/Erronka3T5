package Model;

public class Aretoa {
	private int id_areto;
	private String izenAret;
	private int id_zinema;
	
	// Constructor
	public Aretoa(int id_aretoa, String izenAret, int id_zinema){
		this.id_areto = id_aretoa;
		this.izenAret = izenAret;
		this.id_zinema = id_zinema;
	}
	
	
	// Getters
	public int getId_areto() {
		return id_areto;
	}
	public String getIzenAret() {
		return izenAret;
	}
	public int getId_zinema() {
		return id_zinema;
	}
	
}
