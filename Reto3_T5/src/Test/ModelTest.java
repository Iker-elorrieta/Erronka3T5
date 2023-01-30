package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Aretoa;
import Model.Bezero;
import Model.Erosketa;
import Model.Filma;
import Model.Hora;
import Model.Saioa;

public class ModelTest {

	@Test
	public void testAretoa() {
		Aretoa a1 = new Aretoa(1,"areto 1", 2);
		
		// Getters
		assertEquals(1, a1.getId_areto());
		assertEquals("areto 1", a1.getIzenAret());
		assertEquals(2, a1.getId_zinema());
	}
	
	@Test
	public void testBezeroa() {
		Bezero b1 = new Bezero("user123","User", "Diez", "12345678A", "12345");
		
		// Setters
		b1.setId_bezero("admin123");
		b1.setIzenBez("admin");
		b1.setAbizen("Perez");
		b1.setNan("12345678B");
		b1.setPasahitza("54321");
		
		// Getters
		assertEquals("admin123", b1.getId_bezero());
		assertEquals("admin", b1.getIzenBez());
		assertEquals("Perez", b1.getAbizen());
		assertEquals("12345678B", b1.getNan());
		assertEquals("54321", b1.getPasahitza());
		
	}
	
	@Test
	public void testErosketa() {
		Erosketa e1 = new Erosketa(14,"user123", 5);
		
		// Setters
		e1.setId_erosketa(15);
		e1.setId_bezero("admin123");
		e1.setId_sarrera(6);
				
		// Getters
		assertEquals(15, e1.getId_erosketa());
		assertEquals("admin123", e1.getId_bezero());
		assertEquals(6, e1.getId_sarrera());
	}
	
	@Test
	public void testFilm() {
		Hora h1 = new Hora();
		h1.setHoras(12);
		h1.setMinutos(39);
		Saioa sa1 = new Saioa(3, h1, 1, 5);
		
		// Getters
		assertEquals(3, sa1.getId_saioa());
		assertEquals(h1, sa1.getOrdua());
		assertEquals(1, sa1.getId_aretoa());
		assertEquals(5, sa1.getId_filma());
	}

}
