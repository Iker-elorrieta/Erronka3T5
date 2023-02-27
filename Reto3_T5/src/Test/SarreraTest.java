package Test;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import Model.Filma;
import Model.Saioa;
import Model.Sarrera;

public class SarreraTest {

	@Test
	public void testSarreraConsGet() {
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Filma f1 = new Filma(3, "Scary movie", "Komedia", 90, 2.2f);
		
		Saioa s1 = new Saioa(7, t, f1);
		
		Sarrera sa1 = new Sarrera(3, s1);
		
		// Getters
		assertEquals(3, sa1.getId_sarrera());
		assertEquals(7, sa1.getSaioa().getId_saioa());
		assertEquals(3, sa1.getSaioa().getOrdua().get(Calendar.HOUR));
		assertEquals(20, sa1.getSaioa().getOrdua().get(Calendar.MINUTE));
		assertEquals(3, sa1.getSaioa().getFilma().getId_filma());
		assertEquals("Scary movie", sa1.getSaioa().getFilma().getIzenburu());
		assertEquals("Komedia", sa1.getSaioa().getFilma().getGenero());
		assertEquals(90, sa1.getSaioa().getFilma().getIraupena());
		assertEquals(2.2, sa1.getSaioa().getFilma().getPrezioa(), 0.01);
	}
	
	@Test
	public void testSarreraSetters() {
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Filma f1 = new Filma(3, "Scary movie", "Komedia", 90, 2.2f);
		
		Saioa s1 = new Saioa(7, t, f1);
		
		Sarrera sa1 = new Sarrera(3, s1);
		
		Calendar t2 = Calendar.getInstance();
		t2.set(Calendar.AM_PM, Calendar.PM);
		t2.set(Calendar.HOUR, 5);
		t2.set(Calendar.MINUTE, 50);
		
		Filma f2 = new Filma(8, "La novia de Frankenstain", "Beldurra", 145, 3.5f);
		
		Saioa s2 = new Saioa(9, t2, f2);
		
		// Setters
		sa1.setId_sarrera(4);
		sa1.setSaioa(s2);
		
		assertEquals(4, sa1.getId_sarrera());
		assertEquals(9, sa1.getSaioa().getId_saioa());
		assertEquals(5, sa1.getSaioa().getOrdua().get(Calendar.HOUR));
		assertEquals(50, sa1.getSaioa().getOrdua().get(Calendar.MINUTE));
		assertEquals(8, sa1.getSaioa().getFilma().getId_filma());
		assertEquals("La novia de Frankenstain", sa1.getSaioa().getFilma().getIzenburu());
		assertEquals("Beldurra", sa1.getSaioa().getFilma().getGenero());
		assertEquals(145, sa1.getSaioa().getFilma().getIraupena());
		assertEquals(3.5, sa1.getSaioa().getFilma().getPrezioa(), 0.01);
	}
	
	@Test
	public void testSarreraToString() {
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Filma f1 = new Filma(3, "Scary movie", "Komedia", 90, 2.2f);
		
		Saioa s1 = new Saioa(7, t, f1);
		
		Sarrera sa1 = new Sarrera(3, s1);
		
		//ToString
		assertEquals("Sarrera [id_sarrera=" + sa1.getId_sarrera() + ", saioa="+ sa1.getSaioa(),sa1.toString(),sa1.toString());
	}
	
	@Test
	public void testSarreraEquals() {
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Filma f1 = new Filma(3, "Scary movie", "Komedia", 90, 2.2f);
		
		Saioa s1 = new Saioa(7, t, f1);
		
		Sarrera sa1 = new Sarrera(3, s1);
		Sarrera sa2 = new Sarrera(3, s1);
		Sarrera sa3 = new Sarrera();
		
		// Equals
		assertTrue(sa1.equals(sa2));
		assertFalse(sa3.equals(null));
	}

}
