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
	
	@Test
	public void testBezeroa() {
		Bezero b1 = new Bezero("user123","User", "Diez", "12345678A", "12345");
		Bezero b2 = new Bezero("admin123","admin", "Perez", "12345678B", "54321");
		
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
		
		// ToString
		assertEquals(b1.toString(), "Bezero [id_bezero=" + b1.getId_bezero() + ", izenBez=" + b1.getIzenBez() + ", abizen=" + b1.getAbizen() + ", nan=" + b1.getNan()
		+ ", pasahitza=" + b1.getPasahitza() + "]");
		
		// Equals
		assertTrue(b1.equals(b2));		
	}
	
	@Test
	public void testSarrera() {
		Sarrera sa1 = new Sarrera(3, 2.2f);
		Sarrera sa2 = new Sarrera(4, 5.5f);
		
		// Setters
		sa1.setId_sarrera(4);
		sa1.setPrezioa(5.5f);
		
		// Getters
		assertEquals(4, sa1.getId_sarrera());
		assertEquals(5.5, sa1.getPrezioa(),0.01);
		
		//ToString
		assertEquals(sa1.toString(),"Sarrera [id_sarrera=" + sa1.getId_sarrera() + ", prezioa=" + sa1.getPrezioa() + "]");
		
		// Equals
		assertTrue(sa1.equals(sa2));
	}
	
	@Test
	public void testFilm() {
		Filma f1 = new Filma(3, "Scary movie", "Komedia", 90);
		Filma f2 = new Filma(3, "Scary movie", "Komedia", 90);
		
		// Getters
		assertEquals(3, f1.getId_filma());
		assertEquals("Scary movie", f1.getIzenburu());
		assertEquals("Komedia", f1.getGenero());
		assertEquals(90, f1.getIraupena());
		
		// ToString
		assertEquals(f1.toString(), "Filma [id_filma=" + f1.getId_filma() + ", izenburu=" + f1.getIzenburu() + ", genero=" + f1.getGenero() + ", iraupena="
				+ f1.getIraupena() + "]");
		
		// Equals
		assertTrue(f1.equals(f2));
		
	}

	@Test
	public void testSaioa() {
		Hora h1 = new Hora();
		h1.setHoras(12);
		h1.setMinutos(39);
		
		Sarrera[] sarrerak = new Sarrera[1];
		Sarrera sarrera = new Sarrera(6, 2.2f);
		sarrerak[0] = sarrera; 
		
		Saioa s1 = new Saioa(3, h1, sarrerak);
		Saioa s2 = new Saioa(3, h1, sarrerak);
		
		// Getters
		assertEquals(3, s1.getId_saioa());
		assertEquals(h1, s1.getOrdua());
		assertEquals(12, h1.getHoras());
		assertEquals(39, h1.getMinutos());
		assertEquals(6, sarrerak[0].getId_sarrera());
		assertEquals(2.2, sarrerak[0].getPrezioa(),0.01);
		
		// ToString
		assertEquals(s1.toString(), "Saioa [id_saioa=" + s1.getId_saioa() + ", ordua=" + s1.getOrdua() + ", sarrera=" + Arrays.toString(sarrerak) + "]");
		
		// Equals
		assertTrue(s1.equals(s2));
	}
	
	@Test
	public void testAretoa() {
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
		
		// Getters
		assertEquals(1, a1.getId_areto());
		assertEquals("areto 1", a1.getIzenAret());
		Saioa[] s3 = a1.getSaioa();
		assertEquals(3, s3[0].getId_saioa());
		assertEquals(10, s3[0].getOrdua().getHoras());
		assertEquals(25, s3[0].getOrdua().getMinutos());
		assertEquals(6, s3[0].getSarrera()[0].getId_sarrera());
		assertEquals(2.2, saioak[0].getSarrera()[0].getPrezioa(), 0.01);
		
		//ToString
		assertEquals(a1.toString(), "Aretoa [id_areto=" + a1.getId_areto() + ", izenAret=" + a1.getIzenAret() + ", saioa=" + Arrays.toString(saioak) + "]");

		//Equals
		assertTrue(a1.equals(a2));
	}
	
	@Test
	public void testZinema() {
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
		Zinema z2 = new Zinema(7, "Golem zinema", "Arriqu�bar Plaza, 4, 48001 Bilbo, Bizkaia", aretoak);
		
		// Setters
		z1.setId_zinema(7);
		z1.setIzenZin("Golem zinema");
		z1.setKokalekua("Arriqu�bar Plaza, 4, 48001 Bilbo, Bizkaia");
		//z1.setAreto(aretoak[0].setId_areto(1));
		
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
		
		// ToString
		assertEquals(z1.toString(),"Zinema [id_zinema=" + z1.getId_zinema() + ", IzenZin=" + z1.getIzenZin() + ", Kokalekua=" + z1.getKokalekua() + ", areto="
				+ Arrays.toString(aretoak) + "]");
		
		// Equals
		assertTrue(z1.equals(z2));
	}
	
	@Test
	public void testErosketa() {
		Bezero[] bezeroak = new Bezero[1];
		Bezero b1 = new Bezero("user123","User", "Diez", "12345678A", "12345");
		bezeroak[0] = b1;
		
		Hora h1 = new Hora();
		h1.setHoras(10);
		h1.setMinutos(25);
		
		Sarrera[] sarrerak = new Sarrera[1];
		Sarrera sarrera = new Sarrera(6, 2.2f);
		sarrerak[0] = sarrera;
		
		Erosketa e1 = new Erosketa(14, bezeroak, sarrerak);
		
		// Setters
		e1.setId_erosketa(15);
		Bezero[] bezeroak2 = new Bezero[1];
		Bezero b2 = new Bezero("admin123","admin", "Perez", "12345678B", "54321");
		bezeroak2[0] = b2;
		e1.setId_bezero(bezeroak2);
		Sarrera[] sarrerak2 = new Sarrera[1];
		Sarrera sarrera2 = new Sarrera(9, 8.2f);
		sarrerak2[0] = sarrera2;
		e1.setSarrera(sarrerak2);
				
		// Getters
		assertEquals(15, e1.getId_erosketa());
		assertEquals("admin123", e1.getBezero()[0].getId_bezero());
		assertEquals("admin", e1.getBezero()[0].getIzenBez());
		assertEquals("Perez", e1.getBezero()[0].getAbizen());
		assertEquals("12345678B", e1.getBezero()[0].getNan());
		assertEquals("54321", e1.getBezero()[0].getPasahitza());
		assertEquals(9, e1.getSarrera()[0].getId_sarrera());
		assertEquals(8.2, e1.getSarrera()[0].getPrezioa(), 0.01);
		
		// ToString
		assertEquals(e1.toString(), "Erosketa [id_erosketa=" + e1.getId_erosketa() + ", bezeroa=" + Arrays.toString(bezeroak2) + ", sarrera="
				+ Arrays.toString(sarrerak2) + "]");
		
		// Equals
		Erosketa e2 = new Erosketa(15, bezeroak2, sarrerak2);
		assertTrue(e1.equals(e2));
		
	}

}
