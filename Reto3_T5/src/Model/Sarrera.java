package Model;

public class Sarrera {
	private int id_sarrera;
	private float prezioa;
	private String id_bezero;
	private int id_saioa;
	
	//Constructor
	public Sarrera(int id_sarrera, float prezioa, String id_bezero, int id_saioa) {
		this.id_sarrera = id_sarrera;
		this.prezioa = prezioa;
		this.id_bezero = id_bezero;
		this.id_saioa = id_saioa;
	}
	
	//Setters
	public void setId_sarrera(int id_sarrera) {
		this.id_sarrera = id_sarrera;
	}	
	public void setPrezioa(float prezioa) {
		this.prezioa = prezioa;
	}
	public void setId_bezero(String id_bezero) {
		this.id_bezero = id_bezero;
	}
	public void setId_saioa(int id_saioa) {
		this.id_saioa = id_saioa;
	}
		
	//Getters
	public int getId_sarrera() {
		return id_sarrera;
	}
	public float getPrezioa() {
		return prezioa;
	}
	public String getId_bezero() {
		return id_bezero;
	}
	public int getId_saioa() {
		return id_saioa;
	}
}
