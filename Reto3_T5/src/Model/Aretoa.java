package Model;

public class Aretoa {
	private int id_areto;
	private String izenAret;
	private Saioa[] saioa;
	
	// Constructor
	public Aretoa(int id_aretoa, String izenAret, int id_zinema, Saioa[] saioa){
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

	
}
