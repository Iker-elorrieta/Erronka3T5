package Test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Calendar;

import org.junit.Test;

import Model.Aretoa;
import Model.Filma;
import Model.Saioa;
import Model.Zinema;

public class ZinemaTest {

	@Test
	public void testZinemaConsGet() {
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Filma f1 = new Filma(3, "Scary movie", "Komedia", 90, 2.2f);
		
		Saioa s1 = new Saioa(3, t, f1);
		Saioa[] saioak = new Saioa[1];
		saioak[0] = s1;
		
		Aretoa a1 = new Aretoa(1,"areto 1", saioak);
		
		Aretoa[] aretoak = new Aretoa[1];
		aretoak[0] = a1;
		
		Zinema z1 = new Zinema(7, "Golem zinema", "Arriqu�bar Plaza, 4, 48001 Bilbo, Bizkaia", aretoak, "428,69,212,168", "src/resources/golem.png");
		
		// Getters
		assertEquals(7, z1.getId_zinema());
		assertEquals("Golem zinema", z1.getIzenZin());
		assertEquals("Arriqu�bar Plaza, 4, 48001 Bilbo, Bizkaia", z1.getKokalekua());
		assertEquals(1, z1.getAretoa()[0].getId_areto());
		assertEquals("areto 1", z1.getAretoa()[0].getIzenAret());
		assertEquals(3, z1.getAretoa()[0].getSaioak()[0].getId_saioa());
		assertEquals(3, z1.getAretoa()[0].getSaioak()[0].getOrdua().get(Calendar.HOUR));
		assertEquals(20, z1.getAretoa()[0].getSaioak()[0].getOrdua().get(Calendar.MINUTE));
		assertEquals(3, z1.getAretoa()[0].getSaioak()[0].getFilma().getId_filma());
		assertEquals("Scary movie", z1.getAretoa()[0].getSaioak()[0].getFilma().getIzenburu());
		assertEquals("Komedia", z1.getAretoa()[0].getSaioak()[0].getFilma().getGenero());
		assertEquals(90, z1.getAretoa()[0].getSaioak()[0].getFilma().getIraupena());
		assertEquals(2.2, z1.getAretoa()[0].getSaioak()[0].getFilma().getPrezioa(), 0.01);
		assertEquals("428,69,212,168", z1.getBounds());
		assertEquals("src/resources/golem.png", z1.getRoute());
	}
	
	@Test
	public void testZinemaSetters() {
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Filma f1 = new Filma(3, "Scary movie", "Komedia", 90, 2.2f);
		
		Saioa s1 = new Saioa(3, t, f1);
		Saioa[] saioak = new Saioa[1];
		saioak[0] = s1;
		
		Aretoa a1 = new Aretoa(1,"areto 1", saioak);
		
		Aretoa[] aretoak = new Aretoa[1];
		aretoak[0] = a1;
		
		Zinema z1 = new Zinema(7, "Golem zinema", "Arriqu�bar Plaza, 4, 48001 Bilbo, Bizkaia", aretoak, "428,69,212,168", "src/resources/golem.png");
		
		
		Calendar t2 = Calendar.getInstance();
		t2.set(Calendar.AM_PM, Calendar.PM);
		t2.set(Calendar.HOUR, 5);
		t2.set(Calendar.MINUTE, 50);
		
		Filma f2 = new Filma(1, "Handia", "Drama", 116, 4.5f);
		
		Saioa s2 = new Saioa(4, t2, f2);
		Saioa[] saioak2 = new Saioa[1];
		saioak2[0] = s2;
		
		Aretoa a2 = new Aretoa(2,"areto 2", saioak2);
		
		Aretoa[] aretoak2 = new Aretoa[1];
		aretoak2[0] = a2;
		
		// Setters
		z1.setId_zinema(6);
		z1.setIzenZin("Cinesa Zubiarte");
		z1.setKokalekua("Leizaola Lehendakariaren Kalea, 2, 48009 Bilbo, Bizkaia");
		z1.setAreto(aretoak2);
		z1.setBounds("10,69,199,168");
		z1.setRoute("src/resources/zubi.png");
		
		assertEquals(6, z1.getId_zinema());
		assertEquals("Cinesa Zubiarte", z1.getIzenZin());
		assertEquals("Leizaola Lehendakariaren Kalea, 2, 48009 Bilbo, Bizkaia", z1.getKokalekua());
		assertEquals(2, z1.getAretoa()[0].getId_areto());
		assertEquals("areto 2", z1.getAretoa()[0].getIzenAret());
		assertEquals(4, z1.getAretoa()[0].getSaioak()[0].getId_saioa());
		assertEquals(5, z1.getAretoa()[0].getSaioak()[0].getOrdua().get(Calendar.HOUR));
		assertEquals(50, z1.getAretoa()[0].getSaioak()[0].getOrdua().get(Calendar.MINUTE));
		assertEquals(1, z1.getAretoa()[0].getSaioak()[0].getFilma().getId_filma());
		assertEquals("Handia", z1.getAretoa()[0].getSaioak()[0].getFilma().getIzenburu());
		assertEquals("Drama", z1.getAretoa()[0].getSaioak()[0].getFilma().getGenero());
		assertEquals(116, z1.getAretoa()[0].getSaioak()[0].getFilma().getIraupena());
		assertEquals(4.5, z1.getAretoa()[0].getSaioak()[0].getFilma().getPrezioa(), 0.01);
		assertEquals("10,69,199,168", z1.getBounds());
		assertEquals("src/resources/zubi.png", z1.getRoute());
	}
	
	@Test
	public void testZinemaToString() {
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Filma f1 = new Filma(3, "Scary movie", "Komedia", 90, 2.2f);
		
		Saioa s1 = new Saioa(3, t, f1);
		Saioa[] saioak = new Saioa[1];
		saioak[0] = s1;
		
		Aretoa a1 = new Aretoa(1,"areto 1", saioak);
		
		Aretoa[] aretoak = new Aretoa[1];
		aretoak[0] = a1;
		
		Zinema z1 = new Zinema(7, "Golem zinema", "Arriqu�bar Plaza, 4, 48001 Bilbo, Bizkaia", aretoak, "428,69,212,168", "src/resources/golem.png");
		
		assertEquals(z1.toString(),"Zinema [id_zinema=" + z1.getId_zinema() + ", IzenZin=" + z1.getIzenZin() + ", Kokalekua=" + z1.getKokalekua() + ", areto="+ Arrays.toString(aretoak) + ",Bounds="+z1.getBounds()+",Route="+z1.getRoute()+"]");
	}
	
	@Test
	public void testZinemaEquals() {
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Filma f1 = new Filma(3, "Scary movie", "Komedia", 90, 2.2f);
		
		Saioa s1 = new Saioa(3, t, f1);
		Saioa[] saioak = new Saioa[1];
		saioak[0] = s1;
		
		Aretoa a1 = new Aretoa(1,"areto 1", saioak);
		
		Aretoa[] aretoak = new Aretoa[1];
		aretoak[0] = a1;
		
		Zinema z1 = new Zinema(7, "Golem zinema", "Arriqu�bar Plaza, 4, 48001 Bilbo, Bizkaia", aretoak, "428,69,212,168", "src/resources/golem.png");
		Zinema z2 = new Zinema(7, "Golem zinema", "Arriqu�bar Plaza, 4, 48001 Bilbo, Bizkaia", aretoak, "10,69,199,168", "src/resources/golem.png");
		Zinema z3 = new Zinema();
		
		// Equals
		assertTrue(z1.equals(z2));
		assertFalse(z3.equals(null));
	}

}
