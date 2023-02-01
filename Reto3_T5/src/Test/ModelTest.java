package Test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import Model.Aretoa;
import Model.Bezero;
import Model.Erosketa;
import Model.Filma;
import Model.Hora;
import Model.Saioa;
import Model.Sarrera;
import Model.Zinema;

public class ModelTest {
	
	// Bezeroa
	@Test
	public void testBezeroaConsGet() {
		// Constructor
		Bezero b1 = new Bezero("admin123","admin", "Perez", "12345678B", "54321");
		
		// Getters
		assertEquals("admin123", b1.getId_bezero());
		assertEquals("admin", b1.getIzenBez());
		assertEquals("Perez", b1.getAbizen());
		assertEquals("12345678B", b1.getNan());
		assertEquals("54321", b1.getPasahitza());		
	}
	
	@Test
	public void testBezeroaSetters() {
		// Constructor
		Bezero b1 = new Bezero("user123","User", "Diez", "12345678A", "12345");
		
		// Setters
		b1.setId_bezero("admin123");
		b1.setIzenBez("admin");
		b1.setAbizen("Perez");
		b1.setNan("12345678B");
		b1.setPasahitza("54321");
	}
	
	@Test
	public void testBezeroaToString() {
		// Constructor
		Bezero b1 = new Bezero("user123","User", "Diez", "12345678A", "12345");

		// ToString
		assertEquals(b1.toString(), "Bezero [id_bezero=" + b1.getId_bezero() + ", izenBez=" + b1.getIzenBez() + ", abizen=" + b1.getAbizen() + ", nan=" + b1.getNan()
		+ ", pasahitza=" + b1.getPasahitza() + "]");	
	}
	
	@Test
	public void testBezeroaEquals() {
		// Constructor
		Bezero b1 = new Bezero("user123","User", "Diez", "12345678A", "12345");
		Bezero b2 = new Bezero("user123","User", "Diez", "12345678A", "12345");
		Bezero b3 = new Bezero();
		
		// Equals
		assertTrue(b1.equals(b2));
		assertFalse(b3.equals(null));
	}
	
	// Sarrera
	@Test
	public void testSarreraConsGet() {
		Sarrera sa1 = new Sarrera(3, 2.2f);
		
		// Getters
		assertEquals(3, sa1.getId_sarrera());
		assertEquals(2.2, sa1.getPrezioa(),0.01);
	}
	
	@Test
	public void testSarreraSetters() {
		Sarrera sa1 = new Sarrera(3, 2.2f);
		
		// Setters
		sa1.setId_sarrera(4);
		sa1.setPrezioa(5.5f);
	}
	
	@Test
	public void testSarreraToString() {
		Sarrera sa1 = new Sarrera(3, 2.2f);
		
		//ToString
		assertEquals(sa1.toString(),"Sarrera [id_sarrera=" + sa1.getId_sarrera() + ", prezioa=" + sa1.getPrezioa() + "]");
	}
	
	@Test
	public void testSarreraEquals() {
		Sarrera sa1 = new Sarrera(3, 2.2f);
		Sarrera sa2 = new Sarrera(3, 2.2f);
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
		Hora h1 = new Hora();
		h1.setHoras(12);
		h1.setMinutos(39);
		
		Sarrera[] sarrerak = new Sarrera[1];
		Sarrera sarrera = new Sarrera(6, 2.2f);
		sarrerak[0] = sarrera; 
		
		Saioa s1 = new Saioa(3, h1, sarrerak);
		
		// Getters
		assertEquals(3, s1.getId_saioa());
		assertEquals(h1, s1.getOrdua());
		assertEquals(12, h1.getHoras());
		assertEquals(39, h1.getMinutos());
		assertEquals(6, sarrerak[0].getId_sarrera());
		assertEquals(2.2, sarrerak[0].getPrezioa(),0.01);
	}
	
	@Test
	public void testSaioaSetters() {
		Hora h1 = new Hora();
		h1.setHoras(12);
		h1.setMinutos(39);
		
		Sarrera[] sarrerak = new Sarrera[1];
		Sarrera sarrera = new Sarrera(6, 2.2f);
		sarrerak[0] = sarrera; 
		
		Saioa s1 = new Saioa(3, h1, sarrerak);
		
		// Setters
		s1.setId_saioa(7);
		h1.setHoras(16);
		h1.setMinutos(50);
		s1.setOrdua(h1);
		sarrerak[0].setId_sarrera(8);
		sarrerak[0].setPrezioa(5.5f);
		s1.setSarrera(sarrerak);
	}
	
	@Test
	public void testSaioaToString() {
		Hora h1 = new Hora();
		h1.setHoras(12);
		h1.setMinutos(39);
		
		Sarrera[] sarrerak = new Sarrera[1];
		Sarrera sarrera = new Sarrera(6, 2.2f);
		sarrerak[0] = sarrera; 
		
		Saioa s1 = new Saioa(3, h1, sarrerak);
		
		// ToString
		assertEquals(s1.toString(), "Saioa [id_saioa=" + s1.getId_saioa() + ", ordua=" + s1.getOrdua() + ", sarrera=" + Arrays.toString(sarrerak) + "]");
	}
	
	@Test
	public void testSaioaEquals() {
		Hora h1 = new Hora();
		h1.setHoras(12);
		h1.setMinutos(39);
		
		Sarrera[] sarrerak = new Sarrera[1];
		Sarrera sarrera = new Sarrera(6, 2.2f);
		sarrerak[0] = sarrera; 
		
		Saioa s1 = new Saioa(3, h1, sarrerak);
		Saioa s2 = new Saioa(3, h1, sarrerak);
		Saioa s3 = new Saioa();
		
		// Equals
		assertTrue(s1.equals(s2));
		assertFalse(s3.equals(null));
	}
	
	// Aretoa
	@Test
	public void testAretoaConsGet() {
		Hora h1 = new Hora();
		h1.setHoras(10);
		h1.setMinutos(25);
		
		Sarrera[] sarrerak = new Sarrera[1];
		Sarrera sarrera = new Sarrera(6, 2.2f);
		sarrerak[0] = sarrera;
		
		Saioa[] saioak = new Saioa[1];
		Saioa s1 = new Saioa(3, h1, sarrerak);
		saioak[0] = s1;
		
		Aretoa a1 = new Aretoa(1,"areto 1", saioak);
		
		// Getters
		assertEquals(1, a1.getId_areto());
		assertEquals("areto 1", a1.getIzenAret());
		Saioa[] s3 = a1.getSaioa();
		assertEquals(3, s3[0].getId_saioa());
		assertEquals(10, s3[0].getOrdua().getHoras());
		assertEquals(25, s3[0].getOrdua().getMinutos());
		assertEquals(6, s3[0].getSarrera()[0].getId_sarrera());
		assertEquals(2.2, saioak[0].getSarrera()[0].getPrezioa(), 0.01);
	}
	
	@Test
	public void testAretoaSetters() {
		Hora h1 = new Hora();
		h1.setHoras(10);
		h1.setMinutos(25);
		
		Sarrera[] sarrerak = new Sarrera[1];
		Sarrera sarrera = new Sarrera(6, 2.2f);
		sarrerak[0] = sarrera;
		
		Saioa[] saioak = new Saioa[1];
		Saioa s1 = new Saioa(3, h1, sarrerak);
		saioak[0] = s1;
		
		Aretoa a1 = new Aretoa(1,"areto 1", saioak);
		
		// Setters
		a1.setId_areto(2);
		a1.setIzenAret("areto 2");
		sarrerak[0].setId_sarrera(8);
		sarrerak[0].setPrezioa(5.5f);
		saioak[0].setId_saioa(5);
		h1.setHoras(15);
		h1.setMinutos(40);
		saioak[0].setOrdua(h1);
		saioak[0].setSarrera(sarrerak);
		a1.setSaioa(saioak);
	}
	
	@Test
	public void testAretoaToString() {
		Hora h1 = new Hora();
		h1.setHoras(10);
		h1.setMinutos(25);
		
		Sarrera[] sarrerak = new Sarrera[1];
		Sarrera sarrera = new Sarrera(6, 2.2f);
		sarrerak[0] = sarrera;
		
		Saioa[] saioak = new Saioa[1];
		Saioa s1 = new Saioa(3, h1, sarrerak);
		saioak[0] = s1;
		
		Aretoa a1 = new Aretoa(1,"areto 1", saioak);
		
		//ToString
		assertEquals(a1.toString(), "Aretoa [id_areto=" + a1.getId_areto() + ", izenAret=" + a1.getIzenAret() + ", saioa=" + Arrays.toString(saioak) + "]");
	}

	@Test
	public void testAretoaEquals() {
		Hora h1 = new Hora();
		h1.setHoras(10);
		h1.setMinutos(25);
		
		Sarrera[] sarrerak = new Sarrera[1];
		Sarrera sarrera = new Sarrera(6, 2.2f);
		sarrerak[0] = sarrera;
		
		Saioa[] saioak = new Saioa[1];
		Saioa s1 = new Saioa(3, h1, sarrerak);
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
		Hora h1 = new Hora();
		h1.setHoras(10);
		h1.setMinutos(25);
		
		Sarrera[] sarrerak = new Sarrera[1];
		Sarrera sarrera = new Sarrera(6, 2.2f);
		sarrerak[0] = sarrera;
		
		Saioa[] saioak = new Saioa[1];
		Saioa s1 = new Saioa(3, h1, sarrerak);
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
		assertEquals(10, z1.getAretoa()[0].getSaioa()[0].getOrdua().getHoras());
		assertEquals(25, z1.getAretoa()[0].getSaioa()[0].getOrdua().getMinutos());
		assertEquals(6, z1.getAretoa()[0].getSaioa()[0].getSarrera()[0].getId_sarrera());
		assertEquals(2.2, z1.getAretoa()[0].getSaioa()[0].getSarrera()[0].getPrezioa(), 0.01);
	}
	
	@Test
	public void testZinemaSetters() {
		Hora h1 = new Hora();
		h1.setHoras(10);
		h1.setMinutos(25);
		
		Sarrera[] sarrerak = new Sarrera[1];
		Sarrera sarrera = new Sarrera(6, 2.2f);
		sarrerak[0] = sarrera;
		
		Saioa[] saioak = new Saioa[1];
		Saioa s1 = new Saioa(3, h1, sarrerak);
		saioak[0] = s1;
		
		Aretoa[] aretoak = new Aretoa[1];
		Aretoa a1 = new Aretoa(1,"areto 1", saioak);
		aretoak[0] = a1;
		
		Zinema z1 = new Zinema(2, "Zubi Cinesa Zinema", "Leizaola Lehendakariaren Kalea, 2, 48009 Bilbo, Bizkaia", aretoak);
		
		// Setters
		z1.setId_zinema(7);
		z1.setIzenZin("Golem zinema");
		z1.setKokalekua("Arriqu�bar Plaza, 4, 48001 Bilbo, Bizkaia");
		sarrerak[0].setId_sarrera(8);
		sarrerak[0].setPrezioa(5.5f);
		saioak[0].setId_saioa(5);
		h1.setHoras(15);
		h1.setMinutos(40);
		saioak[0].setOrdua(h1);
		saioak[0].setSarrera(sarrerak);
		aretoak[0].setId_areto(2);
		aretoak[0].setIzenAret("areto 2");
		aretoak[0].setSaioa(saioak);
		z1.setAreto(aretoak);
	}
	
	@Test
	public void testZinemaToString() {
		Hora h1 = new Hora();
		h1.setHoras(10);
		h1.setMinutos(25);
		
		Sarrera[] sarrerak = new Sarrera[1];
		Sarrera sarrera = new Sarrera(6, 2.2f);
		sarrerak[0] = sarrera;
		
		Saioa[] saioak = new Saioa[1];
		Saioa s1 = new Saioa(3, h1, sarrerak);
		saioak[0] = s1;
		
		Aretoa[] aretoak = new Aretoa[1];
		Aretoa a1 = new Aretoa(1,"areto 1", saioak);
		aretoak[0] = a1;
		
		Zinema z1 = new Zinema(2, "Zubi Cinesa Zinema", "Leizaola Lehendakariaren Kalea, 2, 48009 Bilbo, Bizkaia", aretoak);// ToString
		
		assertEquals(z1.toString(),"Zinema [id_zinema=" + z1.getId_zinema() + ", IzenZin=" + z1.getIzenZin() + ", Kokalekua=" + z1.getKokalekua() + ", areto="
				+ Arrays.toString(aretoak) + "]");
	}
	
	@Test
	public void testZinemaEquals() {
		Hora h1 = new Hora();
		h1.setHoras(10);
		h1.setMinutos(25);
		
		Sarrera[] sarrerak = new Sarrera[1];
		Sarrera sarrera = new Sarrera(6, 2.2f);
		sarrerak[0] = sarrera;
		
		Saioa[] saioak = new Saioa[1];
		Saioa s1 = new Saioa(3, h1, sarrerak);
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
		Bezero[] bezeroak = new Bezero[1];
		Bezero b1 = new Bezero("user123","User", "Diez", "12345678A", "12345");
		bezeroak[0] = b1;
		
		Sarrera[] sarrerak = new Sarrera[1];
		Sarrera sarrera = new Sarrera(6, 2.2f);
		sarrerak[0] = sarrera;
		
		Erosketa e1 = new Erosketa(14, bezeroak, sarrerak);
				
		// Getters
		assertEquals(14, e1.getId_erosketa());
		assertEquals("user123", e1.getBezero()[0].getId_bezero());
		assertEquals("User", e1.getBezero()[0].getIzenBez());
		assertEquals("Diez", e1.getBezero()[0].getAbizen());
		assertEquals("12345678A", e1.getBezero()[0].getNan());
		assertEquals("12345", e1.getBezero()[0].getPasahitza());
		assertEquals(6, e1.getSarrera()[0].getId_sarrera());
		assertEquals(2.2, e1.getSarrera()[0].getPrezioa(), 0.01);	
	}
	
	@Test
	public void testErosketaSetters() {
		Bezero[] bezeroak = new Bezero[1];
		Bezero b1 = new Bezero("user123","User", "Diez", "12345678A", "12345");
		bezeroak[0] = b1;
		
		Sarrera[] sarrerak = new Sarrera[1];
		Sarrera sarrera = new Sarrera(6, 2.2f);
		sarrerak[0] = sarrera;
		
		Erosketa e1 = new Erosketa(14, bezeroak, sarrerak);
		
		// Setters
		e1.setId_erosketa(15);
		bezeroak[0].setId_bezero("admin123");
		bezeroak[0].setIzenBez("admin");
		bezeroak[0].setAbizen("Perez");
		bezeroak[0].setNan("12345678B");
		bezeroak[0].setPasahitza("54321");
		e1.setId_bezero(bezeroak);
		sarrerak[0].setId_sarrera(9);
		sarrerak[0].setPrezioa(8.2f);;
		e1.setSarrera(sarrerak);
	}
	
	@Test
	public void testErosketaToString() {
		Bezero[] bezeroak = new Bezero[1];
		Bezero b1 = new Bezero("user123","User", "Diez", "12345678A", "12345");
		bezeroak[0] = b1;
		
		Sarrera[] sarrerak = new Sarrera[1];
		Sarrera sarrera = new Sarrera(6, 2.2f);
		sarrerak[0] = sarrera;
		
		Erosketa e1 = new Erosketa(14, bezeroak, sarrerak);
		
		// ToString
		assertEquals(e1.toString(), "Erosketa [id_erosketa=" + e1.getId_erosketa() + ", bezeroa=" + Arrays.toString(bezeroak) + ", sarrera="
				+ Arrays.toString(sarrerak) + "]");
	}
	
	@Test
	public void testErosketaEquals() {
		Bezero[] bezeroak = new Bezero[1];
		Bezero b1 = new Bezero("user123","User", "Diez", "12345678A", "12345");
		bezeroak[0] = b1;
		
		Sarrera[] sarrerak = new Sarrera[1];
		Sarrera sarrera = new Sarrera(6, 2.2f);
		sarrerak[0] = sarrera;
		
		Erosketa e1 = new Erosketa(14, bezeroak, sarrerak);
		Erosketa e2 = new Erosketa(14, bezeroak, sarrerak);
		Erosketa e3 = new Erosketa();
				
		// Equals
		assertTrue(e1.equals(e2));
		assertFalse(e3.equals(null));
		
	}

}
