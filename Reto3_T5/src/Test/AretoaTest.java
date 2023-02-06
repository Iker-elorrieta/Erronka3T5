package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Aretoa;

public class AretoaTest {

	@Test
	public void testAretoaConsGet() {
		Aretoa a1 = new Aretoa(1,"areto 1");
		
		// Getters
		assertEquals(1, a1.getId_areto());
		assertEquals("areto 1", a1.getIzenAret());
	}
	
	@Test
	public void testAretoaSetters() {
		Aretoa a1 = new Aretoa(1,"areto 1");
		
		// Setters
		a1.setId_areto(2);
		a1.setIzenAret("areto 2");
		
		assertEquals(2, a1.getId_areto());
		assertEquals("areto 2", a1.getIzenAret());
	}
	
	@Test
	public void testAretoaToString() {
		Aretoa a1 = new Aretoa(1,"areto 1");
		
		//ToString
		assertEquals(a1.toString(), "Aretoa [id_areto=" + a1.getId_areto() + ", izenAret=" + a1.getIzenAret() + "]");
	}

	@Test
	public void testAretoaEquals() {
		Aretoa a1 = new Aretoa(1,"areto 1");
		Aretoa a2 = new Aretoa(1,"areto 1");
		Aretoa a3 = new Aretoa();
		
		//Equals
		assertTrue(a1.equals(a2));
		assertFalse(a3.equals(null));
	}

}
