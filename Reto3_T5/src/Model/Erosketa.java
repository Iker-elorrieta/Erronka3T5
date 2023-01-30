package Model;

public class Erosketa {
	private int id_erosketa;
	private String id_bezero;
	private int id_sarrera;
	
	// Constructor
	public Erosketa(int id_erosketa, String id_bezero, int id_sarrera){
		this.id_erosketa = id_erosketa;
		this.id_bezero = id_bezero;
		this.id_sarrera = id_sarrera;
	}
	
	//Setters
	public void setId_erosketa(int id_erosketa) {
		this.id_erosketa = id_erosketa;
	}
	public void setId_bezero(String id_bezero) {
		this.id_bezero = id_bezero;
	}
	public void setId_sarrera(int id_sarrera) {
		this.id_sarrera = id_sarrera;
	}
		
		
	//Getters
	public int getId_erosketa() {
		return id_erosketa;
	}
	public String getId_bezero() {
		return id_bezero;
	}
	public int getId_sarrera() {
		return id_sarrera;
	}
}
