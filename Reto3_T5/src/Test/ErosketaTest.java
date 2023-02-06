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

public class ErosketaTest {

	@Test
	public void testErosketaConsGet() {
		Bezero b1 = new Bezero("user123","User", "Diez", "gizon", 25, "12345678A", "12345"); 
		
		Filma f1 = new Filma(4, "Scary movie", "Komedia", 90, 2.2f);
		
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Aretoa a1 = new Aretoa(1,"areto 1");
		
		Saioa s1 = new Saioa(7, t, f1, a1);
		
		Sarrera sa1 = new Sarrera(3, s1);
		Sarrera[] sarrerak = new Sarrera[1];
		sarrerak[0] = sa1;
		
		Erosketa e1 = new Erosketa(14, b1, 30f, 24.5f, sarrerak);
				
		// Getters
		assertEquals(14, e1.getId_erosketa());
		assertEquals("user123", e1.getBezero().getId_bezero());
		assertEquals("User", e1.getBezero().getIzenBez());
		assertEquals("Diez", e1.getBezero().getAbizen());
		assertEquals("gizon", e1.getBezero().getSexua());
		assertEquals(25, e1.getBezero().getAdina());
		assertEquals("12345678A", e1.getBezero().getNan());
		assertEquals("12345", e1.getBezero().getPasahitza());
		assertEquals(30, e1.getDeskontua(), 0.01);
		assertEquals(24.5, e1.getTotala(), 0.01);
		assertEquals(3, sarrerak[0].getId_sarrera());
		assertEquals(7, sarrerak[0].getSaioa().getId_saioa());
		assertEquals(3, sarrerak[0].getSaioa().getOrdua().get(Calendar.HOUR));
		assertEquals(20, sarrerak[0].getSaioa().getOrdua().get(Calendar.MINUTE));
		assertEquals(4, sarrerak[0].getSaioa().getFilma().getId_filma());
		assertEquals("Scary movie", sarrerak[0].getSaioa().getFilma().getIzenburu());
		assertEquals("Komedia", sarrerak[0].getSaioa().getFilma().getGenero());
		assertEquals(90, sarrerak[0].getSaioa().getFilma().getIraupena());
		assertEquals(2.2, sarrerak[0].getSaioa().getFilma().getPrezioa(), 0.01);
		assertEquals(1, sarrerak[0].getSaioa().getAretoa().getId_areto());
		assertEquals("areto 1", sarrerak[0].getSaioa().getAretoa().getIzenAret());
	}
	
	@Test
	public void testErosketaSetters() {
		Bezero b1 = new Bezero("user123","User", "Diez", "gizon", 25, "12345678A", "12345"); 
		
		Filma f1 = new Filma(4, "Scary movie", "Komedia", 90, 2.2f);
		Filma f2 = new Filma(8, "La novia de Frankenstain", "Beldurra", 145, 3.5f);
		
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Aretoa a1 = new Aretoa(1,"areto 1");
		
		Saioa s1 = new Saioa(7, t, f1, a1);
		
		Sarrera sa1 = new Sarrera(3, s1);
		Sarrera[] sarrerak = new Sarrera[1];
		sarrerak[0] = sa1;
		
		Erosketa e1 = new Erosketa(14, b1, 30f, 24.5f, sarrerak);
		
		// Setters
		e1.setId_erosketa(15);
		b1.setId_bezero("admin123");
		b1.setIzenBez("admin");
		b1.setAbizen("Perez");
		b1.setSexua("emakume");
		b1.setAdina(30);
		b1.setNan("12345678B");
		b1.setPasahitza("54321");
		e1.setBezero(b1);
		e1.setDeskontua(20);
		e1.setTotala(15f);
		sarrerak[0].setId_sarrera(4);
		s1.setId_saioa(9);
		t.set(Calendar.HOUR, 5);
		t.set(Calendar.MINUTE, 30);
		s1.setOrdua(t);
		s1.setFilma(f2);
		a1.setId_areto(2);
		a1.setIzenAret("areto 2");
		s1.setAretoa(a1);
		sarrerak[0].setSaioa(s1);
		e1.setSarrera(sarrerak);
		
		assertEquals(15, e1.getId_erosketa());
		assertEquals("admin123", e1.getBezero().getId_bezero());
		assertEquals("admin", e1.getBezero().getIzenBez());
		assertEquals("Perez", e1.getBezero().getAbizen());
		assertEquals("emakume", e1.getBezero().getSexua());
		assertEquals(30, e1.getBezero().getAdina());
		assertEquals("12345678B", e1.getBezero().getNan());
		assertEquals("54321", e1.getBezero().getPasahitza());
		assertEquals(20, e1.getDeskontua(), 0.01);
		assertEquals(15, e1.getTotala(), 0.01);
		assertEquals(4, sarrerak[0].getId_sarrera());
		assertEquals(9, sarrerak[0].getSaioa().getId_saioa());
		assertEquals(5, sarrerak[0].getSaioa().getOrdua().get(Calendar.HOUR));
		assertEquals(30, sarrerak[0].getSaioa().getOrdua().get(Calendar.MINUTE));
		assertEquals(8, sarrerak[0].getSaioa().getFilma().getId_filma());
		assertEquals("La novia de Frankenstain", sarrerak[0].getSaioa().getFilma().getIzenburu());
		assertEquals("Beldurra", sarrerak[0].getSaioa().getFilma().getGenero());
		assertEquals(145, sarrerak[0].getSaioa().getFilma().getIraupena());
		assertEquals(3.5, sarrerak[0].getSaioa().getFilma().getPrezioa(), 0.01);
		assertEquals(2, sarrerak[0].getSaioa().getAretoa().getId_areto());
		assertEquals("areto 2", sarrerak[0].getSaioa().getAretoa().getIzenAret());
	}
	
	@Test
	public void testErosketaToString() {
		Bezero b1 = new Bezero("user123","User", "Diez", "gizon", 25, "12345678A", "12345"); 
		
		Filma f1 = new Filma(4, "Scary movie", "Komedia", 90, 2.2f);
		
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Aretoa a1 = new Aretoa(1,"areto 1");
		
		Saioa s1 = new Saioa(7, t, f1, a1);
		
		Sarrera sa1 = new Sarrera(3, s1);
		Sarrera[] sarrerak = new Sarrera[1];
		sarrerak[0] = sa1;
		
		Erosketa e1 = new Erosketa(14, b1, 30f, 24.5f, sarrerak);
		
		// ToString
		assertEquals(e1.toString(), "Erosketa [id_erosketa=" + e1.getId_erosketa() + ", bezero=" + e1.getBezero() + ", deskontua=" + e1.getDeskontua() + ", totala="
				+ e1.getTotala() + ", sarrera=" + Arrays.toString(e1.getSarrera()) + "]");
	}
	
	@Test
	public void testErosketaEquals() {
		Bezero b1 = new Bezero("user123","User", "Diez", "gizon", 25, "12345678A", "12345"); 
		
		Filma f1 = new Filma(4, "Scary movie", "Komedia", 90, 2.2f);
		
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Aretoa a1 = new Aretoa(1,"areto 1");
		
		Saioa s1 = new Saioa(7, t, f1, a1);
		
		Sarrera sa1 = new Sarrera(3, s1);
		Sarrera[] sarrerak = new Sarrera[1];
		sarrerak[0] = sa1;
		
		Erosketa e1 = new Erosketa(14, b1, 30f, 24.5f, sarrerak);
		Erosketa e2 = new Erosketa(14, b1, 30f, 24.5f, sarrerak);
		Erosketa e3 = new Erosketa();
				
		// Equals
		assertTrue(e1.equals(e2));
		assertFalse(e3.equals(null));
		
	}

}
