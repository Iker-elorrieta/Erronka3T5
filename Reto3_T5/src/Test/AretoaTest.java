package Test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Calendar;

import org.junit.Test;

import Model.Aretoa;
import Model.Filma;
import Model.Saioa;

public class AretoaTest {

	@Test
	public void testAretoaConsGet() {
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Filma f1 = new Filma(3, "Scary movie", "Komedia", 90, 2.2f);
		
		Saioa s1 = new Saioa(3, t, f1);
		Saioa[] saioak = new Saioa[1];
		saioak[0] = s1;
		
		Aretoa a1 = new Aretoa(1,"areto 1", saioak);
		
		// Getters
		assertEquals(1, a1.getId_areto());
		assertEquals("areto 1", a1.getIzenAret());
		assertEquals(3, a1.getSaioak()[0].getId_saioa());
		assertEquals(3, a1.getSaioak()[0].getOrdua().get(Calendar.HOUR));
		assertEquals(20, a1.getSaioak()[0].getOrdua().get(Calendar.MINUTE));
		assertEquals(3, a1.getSaioak()[0].getFilma().getId_filma());
		assertEquals("Scary movie", a1.getSaioak()[0].getFilma().getIzenburu());
		assertEquals("Komedia", a1.getSaioak()[0].getFilma().getGenero());
		assertEquals(90, a1.getSaioak()[0].getFilma().getIraupena());
		assertEquals(2.2, a1.getSaioak()[0].getFilma().getPrezioa(), 0.01);
	}
	
	@Test
	public void testAretoaSetters() {
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Filma f1 = new Filma(3, "Scary movie", "Komedia", 90, 2.2f);
		
		Saioa s1 = new Saioa(3, t, f1);
		Saioa[] saioak = new Saioa[1];
		saioak[0] = s1;
		
		Calendar t2 = Calendar.getInstance();
		t2.set(Calendar.AM_PM, Calendar.PM);
		t2.set(Calendar.HOUR, 5);
		t2.set(Calendar.MINUTE, 50);
		
		Filma f2 = new Filma(1, "Handia", "Drama", 116, 4.5f);
		
		Saioa s2 = new Saioa(5, t2, f2);
		Saioa[] saioak2 = new Saioa[1];
		saioak2[0] = s2;
		
		Aretoa a1 = new Aretoa(1,"areto 1", saioak);
		
		// Setters
		a1.setId_areto(2);
		a1.setIzenAret("areto 2");
		a1.setSaioak(saioak2);
		
		
		assertEquals(2, a1.getId_areto());
		assertEquals("areto 2", a1.getIzenAret());
		assertEquals(5, a1.getSaioak()[0].getId_saioa());
		assertEquals(5, a1.getSaioak()[0].getOrdua().get(Calendar.HOUR));
		assertEquals(50, a1.getSaioak()[0].getOrdua().get(Calendar.MINUTE));
		assertEquals(1, a1.getSaioak()[0].getFilma().getId_filma());
		assertEquals("Handia", a1.getSaioak()[0].getFilma().getIzenburu());
		assertEquals("Drama", a1.getSaioak()[0].getFilma().getGenero());
		assertEquals(116, a1.getSaioak()[0].getFilma().getIraupena());
		assertEquals(4.5, a1.getSaioak()[0].getFilma().getPrezioa(), 0.01);
	}
	
	@Test
	public void testAretoaToString() {
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Filma f1 = new Filma(3, "Scary movie", "Komedia", 90, 2.2f);
		
		Saioa s1 = new Saioa(3, t, f1);
		Saioa[] saioak = new Saioa[1];
		saioak[0] = s1;
		
		Aretoa a1 = new Aretoa(1,"areto 1", saioak);
		
		//ToString
		assertEquals(a1.toString(), "Aretoa [id_areto=" + a1.getId_areto() + ", izenAret=" + a1.getIzenAret() + ", saioak=" + Arrays.toString(saioak) + "]");
	}

	@Test
	public void testAretoaEquals() {
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Filma f1 = new Filma(3, "Scary movie", "Komedia", 90, 2.2f);
		
		Saioa s1 = new Saioa(3, t, f1);
		Saioa[] saioak = new Saioa[1];
		saioak[0] = s1;
		
		Aretoa a1 = new Aretoa(1,"areto 1", saioak);
		Aretoa a2 = new Aretoa(1,"areto 1", saioak);
		Aretoa a3 = new Aretoa();
		
		//Equals
		assertTrue(a1.equals(a2));
		assertFalse(a3.equals(null));
	}

}
