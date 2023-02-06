package Test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import Model.Aretoa;
import Model.Zinema;

public class ZinemaTest {

	@Test
	public void testZinemaConsGet() {
		Aretoa a1 = new Aretoa(1,"areto 1");
		
		Aretoa[] aretoak = new Aretoa[1];
		aretoak[0] = a1;
		
		Zinema z1 = new Zinema(7, "Golem zinema", "Arriqu�bar Plaza, 4, 48001 Bilbo, Bizkaia", aretoak);
		
		// Getters
		assertEquals(7, z1.getId_zinema());
		assertEquals("Golem zinema", z1.getIzenZin());
		assertEquals("Arriqu�bar Plaza, 4, 48001 Bilbo, Bizkaia", z1.getKokalekua());
		assertEquals(1, z1.getAretoa()[0].getId_areto());
		assertEquals("areto 1", z1.getAretoa()[0].getIzenAret());
	}
	
	@Test
	public void testZinemaSetters() {
		Aretoa a1 = new Aretoa(1,"areto 1");
		
		Aretoa[] aretoak = new Aretoa[1];
		aretoak[0] = a1;
		
		Zinema z1 = new Zinema(2, "Zubi Cinesa Zinema", "Leizaola Lehendakariaren Kalea, 2, 48009 Bilbo, Bizkaia", aretoak);
		
		// Setters
		z1.setId_zinema(7);
		z1.setIzenZin("Golem zinema");
		z1.setKokalekua("Arriqu�bar Plaza, 4, 48001 Bilbo, Bizkaia");
		aretoak[0].setId_areto(2);
		aretoak[0].setIzenAret("areto 2");
		z1.setAreto(aretoak);
		
		assertEquals(7, z1.getId_zinema());
		assertEquals("Golem zinema", z1.getIzenZin());
		assertEquals("Arriqu�bar Plaza, 4, 48001 Bilbo, Bizkaia", z1.getKokalekua());
		assertEquals(2, z1.getAretoa()[0].getId_areto());
		assertEquals("areto 2", z1.getAretoa()[0].getIzenAret());
	}
	
	@Test
	public void testZinemaToString() {
		Aretoa[] aretoak = new Aretoa[1];
		Aretoa a1 = new Aretoa(1,"areto 1");
		aretoak[0] = a1;
		
		Zinema z1 = new Zinema(2, "Zubi Cinesa Zinema", "Leizaola Lehendakariaren Kalea, 2, 48009 Bilbo, Bizkaia", aretoak);
		
		assertEquals(z1.toString(),"Zinema [id_zinema=" + z1.getId_zinema() + ", IzenZin=" + z1.getIzenZin() + ", Kokalekua=" + z1.getKokalekua() + ", areto="
				+ Arrays.toString(aretoak) + "]");
	}
	
	@Test
	public void testZinemaEquals() {
		Aretoa[] aretoak = new Aretoa[1];
		Aretoa a1 = new Aretoa(1,"areto 1");
		aretoak[0] = a1;
		
		Zinema z1 = new Zinema(2, "Zubi Cinesa Zinema", "Leizaola Lehendakariaren Kalea, 2, 48009 Bilbo, Bizkaia", aretoak);
		Zinema z2 = new Zinema(2, "Zubi Cinesa Zinema", "Leizaola Lehendakariaren Kalea, 2, 48009 Bilbo, Bizkaia", aretoak);
		Zinema z3 = new Zinema();
		
		// Equals
		assertTrue(z1.equals(z2));
		assertFalse(z3.equals(null));
	}

}
