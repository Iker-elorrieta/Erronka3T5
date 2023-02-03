package Model;

import java.util.Objects;

public class Erosketa {
	private int id_erosketa;
	private String id_bezero;
	private float totala;
	private float deskontua;
	
	// Constructor
	public Erosketa(int id_erosketa, String id_bezero, float deskontua, float totala){
		this.id_erosketa = id_erosketa;
		this.id_bezero = id_bezero;
		this.deskontua = deskontua;
		this.totala = totala;
	}
	
	public Erosketa(){
		
	}
	
	//Setters
	public void setId_erosketa(int id_erosketa) {
		this.id_erosketa = id_erosketa;
	}
	public void setId_bezero(String id_bezero) {
		this.id_bezero = id_bezero;
	}
	public void setDeskontua(float deskontua) {
		this.deskontua = deskontua;
	}
	public void setTotala(float totala) {
		this.totala = totala;
	}
		
		
	//Getters
	public int getId_erosketa() {
		return id_erosketa;
	}
	public String getId_bezero() {
		return id_bezero;
	}
	public Float getDeskontua() {
		return deskontua;
	}
	public Float getTotala() {
		return totala;
	}

	// ToString
	@Override
	public String toString() {
		return "Erosketa [id_erosketa=" + id_erosketa + ", id_bezero=" + id_bezero + ", totala=" + totala
				+ ", deskontua=" + deskontua + "]";
	}

	// Equals
	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(bezeroa);
		result = prime * result + Arrays.hashCode(sarrera);
		result = prime * result + Objects.hash(id_erosketa);
		return result;
	}*/

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		Erosketa other = (Erosketa) obj;
		return Objects.equals(id_erosketa, other.id_erosketa);
	}
}
