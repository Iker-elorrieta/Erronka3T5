package Model;

import java.util.Calendar;
import java.util.Objects;

public class Saioa {
	private int id_saioa;
	private Calendar ordua;
	private Filma filma;
	
	//Constructor
	public Saioa(int id_saioa, Calendar ordua, Filma filma){
		this.id_saioa = id_saioa;
		this.ordua = ordua;
		this.filma = filma;
	}
	
	public Saioa(){
		
	}
	
	//Getters
	public int getId_saioa() {
		return id_saioa;
	}
	public Calendar getOrdua() {
		return ordua;
	}
	public Filma getFilma() {
		return filma;
	}
	
	// Setters
	public void setId_saioa(int id_saioa) {
		this.id_saioa = id_saioa;
	}
	public void setOrdua(Calendar ordua) {
		this.ordua = ordua;
	}
	public void setFilma(Filma filma) {
		this.filma = filma;
	}
	
	// ToString
	@Override
	public String toString() {
		return "Saioa [id_saioa=" + id_saioa + ", ordua=" + ordua.get(Calendar.HOUR)+":"+ordua.get(Calendar.MINUTE)+", data="+ordua.get(Calendar.DAY_OF_MONTH)+"-"+ordua.get(Calendar.MONTH)+"-"+ordua.get(Calendar.YEAR)+ ", filma=" + filma + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		Saioa other = (Saioa) obj;
		return Objects.equals(id_saioa, other.id_saioa);
	}	
	
}
