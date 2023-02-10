package Test;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import Model.Aretoa;
import Model.Filma;
import Model.Saioa;

public class SaioaTest {

	@Test
	public void testSaioaConsGet() {
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Filma f1 = new Filma(3, "Scary movie", "Komedia", 90, 2.2f);
		
		Aretoa a1 = new Aretoa(1,"areto 1");
		
		Saioa s1 = new Saioa(3, t, f1, a1);
		
		// Getters
		assertEquals(3, s1.getId_saioa());
		assertEquals(3, s1.getOrdua().get(Calendar.HOUR));
		assertEquals(20, s1.getOrdua().get(Calendar.MINUTE));
		assertEquals(3, s1.getFilma().getId_filma());
		assertEquals("Scary movie", s1.getFilma().getIzenburu());
		assertEquals("Komedia", s1.getFilma().getGenero());
		assertEquals(90, s1.getFilma().getIraupena());
		assertEquals(2.2, s1.getFilma().getPrezioa(), 0.01);
		assertEquals(1, s1.getAretoa().getId_areto());
		assertEquals("areto 1", s1.getAretoa().getIzenAret());
	}
	
	@Test
	public void testSaioaSetters() {
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Filma f1 = new Filma(3, "Scary movie", "Komedia", 90, 2.2f);
		Filma f2 = new Filma(8, "La novia de Frankenstain", "Beldurra", 145, 3.5f);
		
		Aretoa a1 = new Aretoa(1,"areto 1");
		
		Saioa s1 = new Saioa(3, t, f1, a1);
		
		// Setters
		s1.setId_saioa(7);
		t.set(Calendar.HOUR, 5);
		t.set(Calendar.MINUTE, 30);
		s1.setOrdua(t);
		s1.setFilma(f2);
		a1.setId_areto(2);
		a1.setIzenAret("areto 2");
		s1.setAretoa(a1);
		
		assertEquals(7, s1.getId_saioa());
		assertEquals(5, s1.getOrdua().get(Calendar.HOUR));
		assertEquals(30, s1.getOrdua().get(Calendar.MINUTE));
		assertEquals(8, s1.getFilma().getId_filma());
		assertEquals("La novia de Frankenstain", s1.getFilma().getIzenburu());
		assertEquals("Beldurra", s1.getFilma().getGenero());
		assertEquals(145, s1.getFilma().getIraupena());
		assertEquals(3.5, s1.getFilma().getPrezioa(), 0.01);
		assertEquals(2, s1.getAretoa().getId_areto());
		assertEquals("areto 2", s1.getAretoa().getIzenAret());
	}
	
	@Test
	public void testSaioaToString() {
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Filma f1 = new Filma(3, "Scary movie", "Komedia", 90, 2.2f);
		
		Aretoa a1 = new Aretoa(1,"areto 1");
		
		Saioa s1 = new Saioa(3, t, f1, a1);
		
		// ToString
		assertEquals(s1.toString(), "Saioa [id_saioa=" + s1.getId_saioa() + ", ordua=" + s1.getOrdua().get(Calendar.HOUR)+":"+s1.getOrdua().get(Calendar.MINUTE)+", data="+s1.getOrdua().get(Calendar.DAY_OF_MONTH)+"-"+s1.getOrdua().get(Calendar.MONTH)+"-"+s1.getOrdua().get(Calendar.YEAR)+ ", filma=" + s1.getFilma() + ", aretoa=" + s1.getAretoa() + "]");
	}
	
	@Test
	public void testSaioaEquals() {
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Filma f1 = new Filma(3, "Scary movie", "Komedia", 90, 2.2f);
		
		Aretoa a1 = new Aretoa(1,"areto 1");
		
		Saioa s1 = new Saioa(3, t, f1, a1);
		Saioa s2 = new Saioa(3, t, f1, a1);
		Saioa s3 = new Saioa();
		
		// Equals
		assertTrue(s1.equals(s2));
		assertFalse(s3.equals(null));
	}

}
