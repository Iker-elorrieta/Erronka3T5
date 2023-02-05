package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Bezero;
import Model.Erosketa;
import Model.Saioa;

public class ErosketaTest {

	@Test
	public void testErosketaConsGet() {
		Bezero b1 = new Bezero("user123","User", "Diez", "gizon", 25, "12345678A", "12345");
		Bezero[] bezeroak = new Bezero[1];
		bezeroak[0] = b1; 
		
		Erosketa e1 = new Erosketa(14, bezeroak, 30f, 24.5f);
				
		// Getters
		assertEquals(14, e1.getId_erosketa());
		assertEquals("user123", e1.getBezero()[0].getId_bezero());
		assertEquals("User", e1.getBezero()[0].getIzenBez());
		assertEquals("Diez", e1.getBezero()[0].getAbizen());
		assertEquals("gizon", e1.getBezero()[0].getSexua());
		assertEquals(25, e1.getBezero()[0].getAdina());
		assertEquals("12345678A", e1.getBezero()[0].getNan());
		assertEquals("12345", e1.getBezero()[0].getPasahitza());
		assertEquals(30, e1.getDeskontua(), 0.01);
		assertEquals(24.5, e1.getTotala(), 0.01);
	}
	
	@Test
	public void testErosketaSetters() {
		Bezero b1 = new Bezero("user123","User", "Diez", "gizon", 25, "12345678A", "12345");
		Bezero[] bezeroak = new Bezero[1];
		bezeroak[0] = b1; 
		
		Erosketa e1 = new Erosketa(14, bezeroak, 30f, 24.5f);
		
		// Setters
		e1.setId_erosketa(15);
		bezeroak[0].setId_bezero("admin123");
		bezeroak[0].setIzenBez("admin");
		bezeroak[0].setAbizen("Perez");
		bezeroak[0].setSexua("emakume");
		bezeroak[0].setAdina(30);
		bezeroak[0].setNan("12345678B");
		bezeroak[0].setPasahitza("54321");
		e1.setBezero(bezeroak);;
		e1.setDeskontua(20);
		e1.setTotala(15f);
		
		assertEquals(15, e1.getId_erosketa());
		assertEquals("admin123", e1.getBezero()[0].getId_bezero());
		assertEquals("admin", e1.getBezero()[0].getIzenBez());
		assertEquals("Perez", e1.getBezero()[0].getAbizen());
		assertEquals("emakume", e1.getBezero()[0].getSexua());
		assertEquals(30, e1.getBezero()[0].getAdina());
		assertEquals("12345678B", e1.getBezero()[0].getNan());
		assertEquals("54321", e1.getBezero()[0].getPasahitza());
		assertEquals(20, e1.getDeskontua(), 0.01);
		assertEquals(15, e1.getTotala(), 0.01);
	}
	
	@Test
	public void testErosketaToString() {
		Bezero b1 = new Bezero("user123","User", "Diez", "gizon", 25, "12345678A", "12345");
		Bezero[] bezeroak = new Bezero[1];
		bezeroak[0] = b1; 
		
		Erosketa e1 = new Erosketa(14, bezeroak, 30f, 24.5f);
		
		// ToString
		assertEquals(e1.toString(), "Erosketa [id_erosketa=" + e1.getId_erosketa() + ", bezero=" + e1.getBezero() + ", totala=" + e1.getTotala()
				+ ", deskontua=" + e1.getDeskontua() + "]");
	}
	
	@Test
	public void testErosketaEquals() {
		Bezero b1 = new Bezero("user123","User", "Diez", "gizon", 25, "12345678A", "12345");
		Bezero[] bezeroak = new Bezero[1];
		bezeroak[0] = b1; 
		
		Erosketa e1 = new Erosketa(14, bezeroak, 30f, 24.5f);
		Erosketa e2 = new Erosketa(14, bezeroak, 30f, 24.5f);
		Erosketa e3 = new Erosketa();
				
		// Equals
		assertTrue(e1.equals(e2));
		assertFalse(e3.equals(null));
		
	}

}
