package Model;

public class Erosketa {
	private int id_erosketa;
	private Bezero[] bezeroa;
	private Sarrera[] sarrera;
	
	// Constructor
	public Erosketa(int id_erosketa, Bezero[] bezero, Sarrera[] sarrera){
		this.id_erosketa = id_erosketa;
		this.bezeroa = bezero;
		this.sarrera = sarrera;
	}
	
	//Setters
	public void setId_erosketa(int id_erosketa) {
		this.id_erosketa = id_erosketa;
	}
	public void setId_bezero(Bezero[] bezero) {
		this.bezeroa = bezero;
	}
	public void setSarrera(Sarrera[] sarrera) {
		this.sarrera = sarrera;
	}
		
		
	//Getters
	public int getId_erosketa() {
		return id_erosketa;
	}
	public Bezero[] getBezero() {
		return bezeroa;
	}
	public Sarrera[] getSarrera() {
		return sarrera;
	}
}
