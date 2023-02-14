package Test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Calendar;

import org.junit.Test;

import Model.Bezero;
import Model.Erosketa;
import Model.Filma;
import Model.Saioa;
import Model.Sarrera;

public class ErosketaTest {

	@Test
	public void testErosketaConsGet() {
		Bezero b1 = new Bezero("user123","User", "Diez", "gizon", 25, "12345678A", "12345"); 
		
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Filma f1 = new Filma(3, "Scary movie", "Komedia", 90, 2.2f);
		
		Saioa s1 = new Saioa(7, t, f1);
		
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
		assertEquals(3, e1.getSarrera()[0].getId_sarrera());
		assertEquals(7, e1.getSarrera()[0].getSaioa().getId_saioa());
		assertEquals(3, e1.getSarrera()[0].getSaioa().getOrdua().get(Calendar.HOUR));
		assertEquals(20, e1.getSarrera()[0].getSaioa().getOrdua().get(Calendar.MINUTE));
		assertEquals(3, e1.getSarrera()[0].getSaioa().getFilma().getId_filma());
		assertEquals("Scary movie", e1.getSarrera()[0].getSaioa().getFilma().getIzenburu());
		assertEquals("Komedia", e1.getSarrera()[0].getSaioa().getFilma().getGenero());
		assertEquals(90, e1.getSarrera()[0].getSaioa().getFilma().getIraupena());
		assertEquals(2.2, e1.getSarrera()[0].getSaioa().getFilma().getPrezioa(), 0.01);
	}
	
	@Test
	public void testErosketaSetters() {
		Bezero b1 = new Bezero("user123","User", "Diez", "gizon", 25, "12345678A", "12345"); 
		
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Filma f1 = new Filma(3, "Scary movie", "Komedia", 90, 2.2f);
		
		Saioa s1 = new Saioa(7, t, f1);
		
		Sarrera sa1 = new Sarrera(3, s1);
		Sarrera[] sarrerak = new Sarrera[1];
		sarrerak[0] = sa1;
		
		Erosketa e1 = new Erosketa(14, b1, 30f, 24.5f, sarrerak);
		
		Bezero b2 = new Bezero("admin123","admin", "Perez","emakume", 30, "12345678B", "54321");
		
		Calendar t2 = Calendar.getInstance();
		t2.set(Calendar.AM_PM, Calendar.PM);
		t2.set(Calendar.HOUR, 5);
		t2.set(Calendar.MINUTE, 50);
		
		Filma f2 = new Filma(8, "La novia de Frankenstain", "Beldurra", 145, 3.5f);
		
		Saioa s2 = new Saioa(9, t2, f2);
		
		Sarrera sa2 = new Sarrera(4, s2);
		Sarrera[] sarrerak2 = new Sarrera[1];
		sarrerak2[0] = sa2;
		
		// Setters
		e1.setId_erosketa(15);
		e1.setBezero(b2);
		e1.setDeskontua(20);
		e1.setTotala(15f);
		e1.setSarrera(sarrerak2);
		
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
		assertEquals(4, e1.getSarrera()[0].getId_sarrera());
		assertEquals(9, e1.getSarrera()[0].getSaioa().getId_saioa());
		assertEquals(5, e1.getSarrera()[0].getSaioa().getOrdua().get(Calendar.HOUR));
		assertEquals(50, e1.getSarrera()[0].getSaioa().getOrdua().get(Calendar.MINUTE));
		assertEquals(8, e1.getSarrera()[0].getSaioa().getFilma().getId_filma());
		assertEquals("La novia de Frankenstain", e1.getSarrera()[0].getSaioa().getFilma().getIzenburu());
		assertEquals("Beldurra", e1.getSarrera()[0].getSaioa().getFilma().getGenero());
		assertEquals(145, e1.getSarrera()[0].getSaioa().getFilma().getIraupena());
		assertEquals(3.5, e1.getSarrera()[0].getSaioa().getFilma().getPrezioa(), 0.01);
	}
	
	@Test
	public void testErosketaToString() {
		Bezero b1 = new Bezero("user123","User", "Diez", "gizon", 25, "12345678A", "12345"); 
		
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Filma f1 = new Filma(3, "Scary movie", "Komedia", 90, 2.2f);
		
		Saioa s1 = new Saioa(7, t, f1);
		
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
		
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Filma f1 = new Filma(3, "Scary movie", "Komedia", 90, 2.2f);
		
		Saioa s1 = new Saioa(7, t, f1);
		
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
