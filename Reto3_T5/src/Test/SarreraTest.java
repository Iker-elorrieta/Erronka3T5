package Test;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import Model.Aretoa;
import Model.Filma;
import Model.Saioa;
import Model.Sarrera;

public class SarreraTest {

	@Test
	public void testSarreraConsGet() {
		Filma f1 = new Filma(4, "Scary movie", "Komedia", 90, 2.2f);
		
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Aretoa a1 = new Aretoa(1,"areto 1");
		
		Saioa s1 = new Saioa(7, t, f1, a1);
		
		Sarrera sa1 = new Sarrera(3, s1);
		
		// Getters
		assertEquals(3, sa1.getId_sarrera());
		assertEquals(7, sa1.getSaioa().getId_saioa());
		assertEquals(3, sa1.getSaioa().getOrdua().get(Calendar.HOUR));
		assertEquals(20, sa1.getSaioa().getOrdua().get(Calendar.MINUTE));
		assertEquals(4, sa1.getSaioa().getFilma().getId_filma());
		assertEquals("Scary movie", sa1.getSaioa().getFilma().getIzenburu());
		assertEquals("Komedia", sa1.getSaioa().getFilma().getGenero());
		assertEquals(90, sa1.getSaioa().getFilma().getIraupena());
		assertEquals(2.2, sa1.getSaioa().getFilma().getPrezioa(), 0.01);
		assertEquals(1, sa1.getSaioa().getAretoa().getId_areto());
		assertEquals("areto 1", sa1.getSaioa().getAretoa().getIzenAret());
	}
	
	@Test
	public void testSarreraSetters() {
		Filma f1 = new Filma(4, "Scary movie", "Komedia", 90, 2.2f);
		Filma f2 = new Filma(8, "La novia de Frankenstain", "Beldurra", 145, 3.5f);
		
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Aretoa a1 = new Aretoa(1,"areto 1");
		
		Saioa s1 = new Saioa(7, t, f1, a1);
		
		Sarrera sa1 = new Sarrera(3, s1);
		
		// Setters
		sa1.setId_sarrera(4);
		s1.setId_saioa(9);
		t.set(Calendar.HOUR, 5);
		t.set(Calendar.MINUTE, 30);
		s1.setOrdua(t);
		s1.setFilma(f2);
		a1.setId_areto(2);
		a1.setIzenAret("areto 2");
		s1.setAretoa(a1);
		sa1.setSaioa(s1);
		
		assertEquals(4, sa1.getId_sarrera());
		assertEquals(9, sa1.getSaioa().getId_saioa());
		assertEquals(5, sa1.getSaioa().getOrdua().get(Calendar.HOUR));
		assertEquals(30, sa1.getSaioa().getOrdua().get(Calendar.MINUTE));
		assertEquals(8, sa1.getSaioa().getFilma().getId_filma());
		assertEquals("La novia de Frankenstain", sa1.getSaioa().getFilma().getIzenburu());
		assertEquals("Beldurra", sa1.getSaioa().getFilma().getGenero());
		assertEquals(145, sa1.getSaioa().getFilma().getIraupena());
		assertEquals(3.5, sa1.getSaioa().getFilma().getPrezioa(), 0.01);
		assertEquals(2, sa1.getSaioa().getAretoa().getId_areto());
		assertEquals("areto 2", sa1.getSaioa().getAretoa().getIzenAret());
	}
	
	@Test
	public void testSarreraToString() {
		Filma f1 = new Filma(4, "Scary movie", "Komedia", 90, 2.2f);
		
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Aretoa a1 = new Aretoa(1,"areto 1");
		
		Saioa s1 = new Saioa(7, t, f1, a1);
		
		Sarrera sa1 = new Sarrera(3, s1);
		
		//ToString
		assertEquals(sa1.toString(),"Sarrera [id_sarrera=" + sa1.getId_sarrera() + ", saioa="
				+ sa1.getSaioa() + "]");
	}
	
	@Test
	public void testSarreraEquals() {
		Filma f1 = new Filma(4, "Scary movie", "Komedia", 90, 2.2f);
		
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Aretoa a1 = new Aretoa(1,"areto 1");
		
		Saioa s1 = new Saioa(7, t, f1, a1);
		
		Sarrera sa1 = new Sarrera(3, s1);
		Sarrera sa2 = new Sarrera(3, s1);
		Sarrera sa3 = new Sarrera();
		
		// Equals
		assertTrue(sa1.equals(sa2));
		assertFalse(sa3.equals(null));
	}

}
