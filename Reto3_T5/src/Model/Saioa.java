package Model;

public class Saioa {
	private int id_saioa;
	private Hora ordua;
	private int id_aretoa;
	private int id_filma;
	
	public Saioa(int id_saioa, Hora ordua, int id_aretoa, int id_filma){
		this.id_saioa = id_saioa;
		this.ordua = ordua;
		this.id_aretoa = id_aretoa;
		this.id_filma = id_filma;
	}
	
	//Getters
	public int getId_saioa() {
		return id_saioa;
	}
	public Hora getOrdua() {
		return ordua;
	}
	public int getId_aretoa() {
		return id_aretoa;
	}
	public int getId_filma() {
		return id_filma;
	}
}
