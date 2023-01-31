package Model;

public class Aretoa {
	private int id_areto;
	private String izenAret;
	private Saioa[] saioa;
	
	// Constructor
	public Aretoa(int id_aretoa, String izenAret, int id_zinema){
		this.id_areto = id_aretoa;
		this.izenAret = izenAret;
	}
	
	
	// Getters
	public int getId_areto() {
		return id_areto;
	}
	public String getIzenAret() {
		return izenAret;
	}
	
}
