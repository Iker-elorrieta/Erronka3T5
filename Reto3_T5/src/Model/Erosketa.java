package Model;

import java.util.Arrays;
import java.util.Objects;

public class Erosketa {
	private int id_erosketa;
	private Bezero bezero;
	private float deskontua;
	private float totala;
	private Sarrera[] sarrera;
	
	
	// Constructor
	public Erosketa(int id_erosketa, Bezero bezero, float deskontua, float totala, Sarrera[] sarrera){
		this.id_erosketa = id_erosketa;
		this.bezero = bezero;
		this.deskontua = deskontua;
		this.totala = totala;
		this.sarrera = sarrera;
	}
	
	public Erosketa(){
		
	}
	
	//Setters
	public void setId_erosketa(int id_erosketa) {
		this.id_erosketa = id_erosketa;
	}
	public void setBezero(Bezero id_bezero) {
		this.bezero = id_bezero;
	}
	public void setDeskontua(float deskontua) {
		this.deskontua = deskontua;
	}
	public void setTotala(float totala) {
		this.totala = totala;
	}
	public void setSarrera(Sarrera[] sarrera) {
		this.sarrera = sarrera;
	}	
		
	//Getters
	public int getId_erosketa() {
		return id_erosketa;
	}
	public Bezero getBezero() {
		return bezero;
	}
	public Float getDeskontua() {
		return deskontua;
	}
	public Float getTotala() {
		return totala;
	}
	public Sarrera[] getSarrera() {
		return sarrera;
	}

	// ToString
	@Override
	public String toString() {
		return "Erosketa [id_erosketa=" + id_erosketa + ", bezero=" + bezero + ", deskontua=" + deskontua + ", totala="
				+ totala + ", sarrera=" + Arrays.toString(sarrera) + "]";
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
