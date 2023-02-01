package Model;

import java.util.Objects;

public class Bezero {
	private String id_bezero;
	private String izenBez;
	private String abizen;
	private String nan;
	private String pasahitza;
	
	// Constructor
	public Bezero(String id_bezero, String izenBez, String abizen, String nan, String pasahitza){
		this.id_bezero = id_bezero;
		this.izenBez = izenBez;
		this.abizen = abizen;
		this.nan = nan;
		this.pasahitza = pasahitza;
	}
	
	public Bezero(){
	}
	
	// Setters
	public void setId_bezero(String id_bezero) {
		this.id_bezero = id_bezero;
	}
	public void setIzenBez(String izenBez) {
		this.izenBez = izenBez;
	}
	public void setAbizen(String abizen) {
		this.abizen = abizen;
	}
	public void setNan(String nan) {
		this.nan = nan;
	}
	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}
	
	// Getters
	public String getId_bezero() {
		return id_bezero;
	}
	public String getIzenBez() {
		return izenBez;
	}
	public String getAbizen() {
		return abizen;
	}
	public String getNan() {
		return nan;
	}
	public String getPasahitza() {
		return pasahitza;
	}
	
	// ToString
	@Override
	public String toString() {
		return "Bezero [id_bezero=" + id_bezero + ", izenBez=" + izenBez + ", abizen=" + abizen + ", nan=" + nan
				+ ", pasahitza=" + pasahitza + "]";
	}
	
	// Equals
	/*@Override
	public int hashCode() {
		return Objects.hash(abizen, id_bezero, izenBez, nan, pasahitza);
	}*/

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		Bezero other = (Bezero) obj;
		return Objects.equals(id_bezero, other.id_bezero);
	}
	
}
