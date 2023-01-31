package Model;

public class Saioa {
	private int id_saioa;
	private Hora ordua;
	private Sarrera[] sarrera;
	
	//Constructor
	public Saioa(int id_saioa, Hora ordua, Sarrera[] sarrera){
		this.id_saioa = id_saioa;
		this.ordua = ordua;
		this.sarrera = sarrera;
	}
	
	//Getters
	public int getId_saioa() {
		return id_saioa;
	}
	public Hora getOrdua() {
		return ordua;
	}
	public Sarrera[] getSarrera() {
		return sarrera;
	}

	public void setId_saioa(int id_saioa) {
		this.id_saioa = id_saioa;
	}

	public void setOrdua(Hora ordua) {
		this.ordua = ordua;
	}

	public void setSarrera(Sarrera[] sarrera) {
		this.sarrera = sarrera;
	}
	
	
}
