package Model;

public class Sarrera {
	private int id_sarrera;
	private float prezioa;
	
	//Constructor
	public Sarrera(int id_sarrera, float prezioa) {
		this.id_sarrera = id_sarrera;
		this.prezioa = prezioa;
	}
	
	//Setters
	public void setId_sarrera(int id_sarrera) {
		this.id_sarrera = id_sarrera;
	}	
	public void setPrezioa(float prezioa) {
		this.prezioa = prezioa;
	}
		
	//Getters
	public int getId_sarrera() {
		return id_sarrera;
	}
	public float getPrezioa() {
		return prezioa;
	}
}
