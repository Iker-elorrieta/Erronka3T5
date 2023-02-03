package Test;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Calendar;

import org.junit.Test;

import Model.Aretoa;
import Model.Bezero;
import Model.Erosketa;
import Model.Filma;
import Model.Saioa;
import Model.Sarrera;
import Model.Zinema;

public class ModelTest {
	
	// Bezeroa
	@Test
	public void testBezeroaConsGet() {
		// Constructor
		Bezero b1 = new Bezero("admin123","admin", "Perez","gizon", 25, "12345678B", "54321");
		
		// Getters
		assertEquals("admin123", b1.getId_bezero());
		assertEquals("admin", b1.getIzenBez());
		assertEquals("Perez", b1.getAbizen());
		assertEquals("gizon",b1.getSexua());
		assertEquals(25,b1.getAdina());
		assertEquals("12345678B", b1.getNan());
		assertEquals("54321", b1.getPasahitza());		
	}
	
	@Test
	public void testBezeroaSetters() {
		// Constructor
		Bezero b1 = new Bezero("user123","User", "Diez", "gizon", 25, "12345678A", "12345");
		
		// Setters
		b1.setId_bezero("admin123");
		b1.setIzenBez("admin");
		b1.setAbizen("Perez");
		b1.setSexua("emakume");
		b1.setAdina(30);
		b1.setNan("12345678B");
		b1.setPasahitza("54321");
		
		
		assertEquals("admin123", b1.getId_bezero());
		assertEquals("admin", b1.getIzenBez());
		assertEquals("Perez", b1.getAbizen());
		assertEquals("emakume",b1.getSexua());
		assertEquals(30, b1.getAdina());
		assertEquals("12345678B", b1.getNan());
		assertEquals("54321", b1.getPasahitza());
	}
	
	@Test
	public void testBezeroaToString() {
		// Constructor
		Bezero b1 = new Bezero("user123","User", "Diez", "gizon", 25, "12345678A", "12345");

		// ToString
		assertEquals(b1.toString(), "Bezero [id_bezero=" + b1.getId_bezero() + ", izenBez=" + b1.getIzenBez() + ", abizen=" + b1.getAbizen() + ", sexua=" + b1.getSexua() + ", adina=" + b1.getAdina() + ", nan=" + b1.getNan() + ", pasahitza=" + b1.getPasahitza() + "]");	
	}
	
	@Test
	public void testBezeroaEquals() {
		// Constructor
		Bezero b1 = new Bezero("user123","User", "Diez", "gizon", 25, "12345678A", "12345");
		Bezero b2 = new Bezero("user123","User", "Diez", "gizon", 25, "12345678A", "12345");
		Bezero b3 = new Bezero();
		
		// Equals
		assertTrue(b1.equals(b2));
		assertFalse(b3.equals(null));
	}
	
	// Sarrera
	@Test
	public void testSarreraConsGet() {
		Sarrera sa1 = new Sarrera(3, 2, 2.2f, 6, 8);
		
		// Getters
		assertEquals(3, sa1.getId_sarrera());
		assertEquals(2, sa1.getId_filma());
		assertEquals(2.2, sa1.getPrezioa(),0.01);
		assertEquals(6, sa1.getId_saioa());
		assertEquals(8, sa1.getId_erosketa());
	}
	
	@Test
	public void testSarreraSetters() {
		Sarrera sa1 = new Sarrera(3, 2, 2.2f, 6, 8);
		
		// Setters
		sa1.setId_sarrera(4);
		sa1.setId_filma(5);
		sa1.setPrezioa(5.5f);
		sa1.setId_saioa(7);;
		sa1.setId_erosketa(9);;
		
		assertEquals(4, sa1.getId_sarrera());
		assertEquals(5, sa1.getId_filma());
		assertEquals(5.5, sa1.getPrezioa(),0.01);
		assertEquals(7, sa1.getId_saioa());
		assertEquals(9, sa1.getId_erosketa());
	}
	
	@Test
	public void testSarreraToString() {
		Sarrera sa1 = new Sarrera(3, 2, 2.2f, 6, 8);
		
		//ToString
		assertEquals(sa1.toString(),"Sarrera [id_sarrera=" + sa1.getId_sarrera() + ", id_filma=" + sa1.getId_filma() + ", prezioa=" + sa1.getPrezioa() + ", id_saioa="
				+ sa1.getId_saioa() + ", id_erosketa=" + sa1.getId_erosketa() + "]");
	}
	
	@Test
	public void testSarreraEquals() {
		Sarrera sa1 = new Sarrera(3, 2, 2.2f, 6, 8);
		Sarrera sa2 = new Sarrera(3, 2, 2.2f, 6, 8);
		Sarrera sa3 = new Sarrera();
		
		// Equals
		assertTrue(sa1.equals(sa2));
		assertFalse(sa3.equals(null));
	}
	
	// Filma
	@Test
	public void testFilmConsGet() {
		Filma f1 = new Filma(3, "Scary movie", "Komedia", 90);
		
		// Getters
		assertEquals(3, f1.getId_filma());
		assertEquals("Scary movie", f1.getIzenburu());
		assertEquals("Komedia", f1.getGenero());
		assertEquals(90, f1.getIraupena());
		
	}
	
	@Test
	public void testFilmToString() {
		Filma f1 = new Filma(3, "Scary movie", "Komedia", 90);
		
		// ToString
		assertEquals(f1.toString(), "Filma [id_filma=" + f1.getId_filma() + ", izenburu=" + f1.getIzenburu() + ", genero=" + f1.getGenero() + ", iraupena="
				+ f1.getIraupena() + "]");
	}
	
	@Test
	public void testFilmEquals() {
		Filma f1 = new Filma(3, "Scary movie", "Komedia", 90);
		Filma f2 = new Filma(3, "Scary movie", "Komedia", 90);
		Filma f3 = new Filma();
		
		// Equals
		assertTrue(f1.equals(f2));
		assertFalse(f3.equals(null));
	}
	
	// Saioa
	@Test
	public void testSaioaConsGet() {
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Saioa s1 = new Saioa(3, t);
		
		// Getters
		assertEquals(3, s1.getId_saioa());
		assertEquals(3, s1.getOrdua().get(Calendar.HOUR));
		assertEquals(20, s1.getOrdua().get(Calendar.MINUTE));
	}
	
	@Test
	public void testSaioaSetters() {
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Saioa s1 = new Saioa(3, t);
		
		// Setters
		s1.setId_saioa(7);
		t.set(Calendar.HOUR, 5);
		t.set(Calendar.MINUTE, 30);
		s1.setOrdua(t);
		
		assertEquals(7, s1.getId_saioa());
		assertEquals(5, s1.getOrdua().get(Calendar.HOUR));
		assertEquals(30, s1.getOrdua().get(Calendar.MINUTE));
	}
	
	@Test
	public void testSaioaToString() {
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Saioa s1 = new Saioa(3, t);
		
		// ToString
		assertEquals(s1.toString(), "Saioa [id_saioa=" + s1.getId_saioa() + ", ordua=" + s1.getOrdua() + "]");
	}
	
	@Test
	public void testSaioaEquals() {
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Saioa s1 = new Saioa(3, t);
		Saioa s2 = new Saioa(3, t);
		Saioa s3 = new Saioa();
		
		// Equals
		assertTrue(s1.equals(s2));
		assertFalse(s3.equals(null));
	}
	
	// Aretoa
	@Test
	public void testAretoaConsGet() {
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Saioa[] saioak = new Saioa[1];
		Saioa s1 = new Saioa(3, t);
		saioak[0] = s1;
		
		Aretoa a1 = new Aretoa(1,"areto 1", saioak);
		
		// Getters
		assertEquals(1, a1.getId_areto());
		assertEquals("areto 1", a1.getIzenAret());
		assertEquals(3, saioak[0].getId_saioa());
		assertEquals(3, s1.getOrdua().get(Calendar.HOUR));
		assertEquals(20, s1.getOrdua().get(Calendar.MINUTE));
	}
	
	@Test
	public void testAretoaSetters() {
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Saioa[] saioak = new Saioa[1];
		Saioa s1 = new Saioa(3, t);
		saioak[0] = s1;
		
		Aretoa a1 = new Aretoa(1,"areto 1", saioak);
		
		// Setters
		a1.setId_areto(2);
		a1.setIzenAret("areto 2");
		saioak[0].setId_saioa(5);
		t.set(Calendar.HOUR, 6);
		t.set(Calendar.MINUTE, 45);
		saioak[0].setOrdua(t);
		a1.setSaioa(saioak);
		
		assertEquals(2, a1.getId_areto());
		assertEquals("areto 2", a1.getIzenAret());
		assertEquals(5, saioak[0].getId_saioa());
		assertEquals(6, s1.getOrdua().get(Calendar.HOUR));
		assertEquals(45, s1.getOrdua().get(Calendar.MINUTE));
	}
	
	@Test
	public void testAretoaToString() {
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Saioa[] saioak = new Saioa[1];
		Saioa s1 = new Saioa(3, t);
		saioak[0] = s1;
		
		Aretoa a1 = new Aretoa(1,"areto 1", saioak);
		
		//ToString
		assertEquals(a1.toString(), "Aretoa [id_areto=" + a1.getId_areto() + ", izenAret=" + a1.getIzenAret() + ", saioa=" + Arrays.toString(saioak) + "]");
	}

	@Test
	public void testAretoaEquals() {
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Saioa[] saioak = new Saioa[1];
		Saioa s1 = new Saioa(3, t);
		saioak[0] = s1;
		
		Aretoa a1 = new Aretoa(1,"areto 1", saioak);
		Aretoa a2 = new Aretoa(1,"areto 1", saioak);
		Aretoa a3 = new Aretoa();
		
		//Equals
		assertTrue(a1.equals(a2));
		assertFalse(a3.equals(null));
	}
	
	// Zinema
	@Test
	public void testZinemaConsGet() {
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Saioa[] saioak = new Saioa[1];
		Saioa s1 = new Saioa(3, t);
		saioak[0] = s1;
		
		Aretoa[] aretoak = new Aretoa[1];
		Aretoa a1 = new Aretoa(1,"areto 1", saioak);
		aretoak[0] = a1;
		
		Zinema z1 = new Zinema(7, "Golem zinema", "Arriqu�bar Plaza, 4, 48001 Bilbo, Bizkaia", aretoak);
		
		// Getters
		assertEquals(7, z1.getId_zinema());
		assertEquals("Golem zinema", z1.getIzenZin());
		assertEquals("Arriqu�bar Plaza, 4, 48001 Bilbo, Bizkaia", z1.getKokalekua());
		assertEquals(1, z1.getAretoa()[0].getId_areto());
		assertEquals("areto 1", z1.getAretoa()[0].getIzenAret());
		assertEquals(3, z1.getAretoa()[0].getSaioa()[0].getId_saioa());
		assertEquals(3, s1.getOrdua().get(Calendar.HOUR));
		assertEquals(20, s1.getOrdua().get(Calendar.MINUTE));
	}
	
	@Test
	public void testZinemaSetters() {
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Saioa[] saioak = new Saioa[1];
		Saioa s1 = new Saioa(3, t);
		saioak[0] = s1;
		
		Aretoa[] aretoak = new Aretoa[1];
		Aretoa a1 = new Aretoa(1,"areto 1", saioak);
		aretoak[0] = a1;
		
		Zinema z1 = new Zinema(2, "Zubi Cinesa Zinema", "Leizaola Lehendakariaren Kalea, 2, 48009 Bilbo, Bizkaia", aretoak);
		
		// Setters
		z1.setId_zinema(7);
		z1.setIzenZin("Golem zinema");
		z1.setKokalekua("Arriqu�bar Plaza, 4, 48001 Bilbo, Bizkaia");
		aretoak[0].setId_areto(2);
		aretoak[0].setIzenAret("areto 2");
		t.set(Calendar.HOUR, 7);
		t.set(Calendar.MINUTE, 55);
		saioak[0].setOrdua(t);
		saioak[0].setId_saioa(4);
		aretoak[0].setSaioa(saioak);
		z1.setAreto(aretoak);
		
		assertEquals(7, z1.getId_zinema());
		assertEquals("Golem zinema", z1.getIzenZin());
		assertEquals("Arriqu�bar Plaza, 4, 48001 Bilbo, Bizkaia", z1.getKokalekua());
		assertEquals(2, z1.getAretoa()[0].getId_areto());
		assertEquals("areto 2", z1.getAretoa()[0].getIzenAret());
		assertEquals(4, z1.getAretoa()[0].getSaioa()[0].getId_saioa());
		assertEquals(7, s1.getOrdua().get(Calendar.HOUR));
		assertEquals(55, s1.getOrdua().get(Calendar.MINUTE));
	}
	
	@Test
	public void testZinemaToString() {
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Saioa[] saioak = new Saioa[1];
		Saioa s1 = new Saioa(3, t);
		saioak[0] = s1;
		
		Aretoa[] aretoak = new Aretoa[1];
		Aretoa a1 = new Aretoa(1,"areto 1", saioak);
		aretoak[0] = a1;
		
		Zinema z1 = new Zinema(2, "Zubi Cinesa Zinema", "Leizaola Lehendakariaren Kalea, 2, 48009 Bilbo, Bizkaia", aretoak);
		
		assertEquals(z1.toString(),"Zinema [id_zinema=" + z1.getId_zinema() + ", IzenZin=" + z1.getIzenZin() + ", Kokalekua=" + z1.getKokalekua() + ", areto="
				+ Arrays.toString(aretoak) + "]");
	}
	
	@Test
	public void testZinemaEquals() {
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Saioa[] saioak = new Saioa[1];
		Saioa s1 = new Saioa(3, t);
		saioak[0] = s1;
		
		Aretoa[] aretoak = new Aretoa[1];
		Aretoa a1 = new Aretoa(1,"areto 1", saioak);
		aretoak[0] = a1;
		
		Zinema z1 = new Zinema(2, "Zubi Cinesa Zinema", "Leizaola Lehendakariaren Kalea, 2, 48009 Bilbo, Bizkaia", aretoak);
		Zinema z2 = new Zinema(2, "Zubi Cinesa Zinema", "Leizaola Lehendakariaren Kalea, 2, 48009 Bilbo, Bizkaia", aretoak);
		Zinema z3 = new Zinema();
		
		// Equals
		assertTrue(z1.equals(z2));
		assertFalse(z3.equals(null));
	}
	
	// Erosketa
	@Test
	public void testErosketaConsGet() {
		Erosketa e1 = new Erosketa(14, "User123", 30, 24.5f);
				
		// Getters
		assertEquals(14, e1.getId_erosketa());
		assertEquals("User123", e1.getId_bezero());
		assertEquals(30, e1.getDeskontua(), 0.01);
		assertEquals(24.5, e1.getTotala(), 0.01);
	}
	
	@Test
	public void testErosketaSetters() {
		Erosketa e1 = new Erosketa(14, "User123", 30, 24.5f);
		
		// Setters
		e1.setId_erosketa(15);
		e1.setId_bezero("Admin123");
		e1.setDeskontua(20);
		e1.setTotala(15f);
		
		assertEquals(15, e1.getId_erosketa());
		assertEquals("Admin123", e1.getId_bezero());
		assertEquals(20, e1.getDeskontua(), 0.01);
		assertEquals(15, e1.getTotala(), 0.01);
	}
	
	@Test
	public void testErosketaToString() {
		Erosketa e1 = new Erosketa(14, "User123", 30, 24.5f);
		
		// ToString
		assertEquals(e1.toString(), "Erosketa [id_erosketa=" + e1.getId_erosketa() + ", id_bezero=" + e1.getId_bezero() + ", totala=" + e1.getTotala()
				+ ", deskontua=" + e1.getDeskontua() + "]");
	}
	
	@Test
	public void testErosketaEquals() {
		Erosketa e1 = new Erosketa(14, "User123", 30, 24.5f);
		Erosketa e2 = new Erosketa(14, "User123", 30, 24.5f);
		Erosketa e3 = new Erosketa();
				
		// Equals
		assertTrue(e1.equals(e2));
		assertFalse(e3.equals(null));
		
	}
}
