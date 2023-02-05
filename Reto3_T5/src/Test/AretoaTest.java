package Test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Calendar;

import org.junit.Test;

import Model.Aretoa;
import Model.Saioa;

public class AretoaTest {

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

}
