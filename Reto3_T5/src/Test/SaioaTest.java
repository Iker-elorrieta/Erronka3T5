package Test;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import Model.Saioa;

public class SaioaTest {

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

}
