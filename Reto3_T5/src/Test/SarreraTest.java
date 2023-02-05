package Test;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import Model.Bezero;
import Model.Erosketa;
import Model.Filma;
import Model.Saioa;
import Model.Sarrera;

public class SarreraTest {

	@Test
	public void testSarreraConsGet() {
		Filma f1 = new Filma(4, "Scary movie", "Komedia", 90);
		Filma[] filmak = new Filma[1];
		filmak[0] = f1;
		
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Saioa s1 = new Saioa(7, t);
		Saioa[] saioak = new Saioa[1];
		saioak[0] = s1;
		
		Bezero b1 = new Bezero("user123","user", "Diez", "gizon", 25, "12345678A", "12345");
		Bezero[] bezeroak = new Bezero[1];
		bezeroak[0] = b1; 
		
		Erosketa e1 = new Erosketa(14, bezeroak, 30f, 24.5f);
		Erosketa[] erosketak = new Erosketa[1];
		erosketak[0] = e1;
		
		Sarrera sa1 = new Sarrera(3, filmak, 2.2f, saioak, erosketak);
		
		// Getters
		assertEquals(3, sa1.getId_sarrera());
		assertEquals(4, sa1.getFilma()[0].getId_filma());
		assertEquals("Scary movie", sa1.getFilma()[0].getIzenburu());
		assertEquals("Komedia", sa1.getFilma()[0].getGenero());
		assertEquals(90, sa1.getFilma()[0].getIraupena());
		assertEquals(2.2, sa1.getPrezioa(),0.01);
		assertEquals(7, sa1.getSaioa()[0].getId_saioa());
		assertEquals(3, sa1.getSaioa()[0].getOrdua().get(Calendar.HOUR));
		assertEquals(20, sa1.getSaioa()[0].getOrdua().get(Calendar.MINUTE));
		assertEquals(14, sa1.getErosketa()[0].getId_erosketa());
		assertEquals("user123", sa1.getErosketa()[0].getBezero()[0].getId_bezero());
		assertEquals("user", sa1.getErosketa()[0].getBezero()[0].getIzenBez());
		assertEquals("Diez", sa1.getErosketa()[0].getBezero()[0].getAbizen());
		assertEquals("gizon", sa1.getErosketa()[0].getBezero()[0].getSexua());
		assertEquals(25, sa1.getErosketa()[0].getBezero()[0].getAdina());
		assertEquals("12345678A", sa1.getErosketa()[0].getBezero()[0].getNan());
		assertEquals("12345", sa1.getErosketa()[0].getBezero()[0].getPasahitza());
		assertEquals(30, sa1.getErosketa()[0].getDeskontua(), 0.01);
		assertEquals(24.5, sa1.getErosketa()[0].getTotala(), 0.01);
	}
	
	@Test
	public void testSarreraSetters() {
		Filma f1 = new Filma(4, "Scary movie", "Komedia", 90);
		Filma[] filmak = new Filma[1];
		filmak[0] = f1;
		
		Filma f2 = new Filma(8, "La novia de Frankenstain", "Beldurra", 145);
		
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Saioa s1 = new Saioa(7, t);
		Saioa[] saioak = new Saioa[1];
		saioak[0] = s1;
		
		Bezero b1 = new Bezero("user123","User", "Diez", "gizon", 25, "12345678A", "12345");
		Bezero[] bezeroak = new Bezero[1];
		bezeroak[0] = b1; 
		
		Erosketa e1 = new Erosketa(14, bezeroak, 30f, 24.5f);
		Erosketa[] erosketak = new Erosketa[1];
		erosketak[0] = e1;
		
		Sarrera sa1 = new Sarrera(3, filmak, 2.2f, saioak, erosketak);
		
		// Setters
		sa1.setId_sarrera(4);
		filmak[0] = f2;
		sa1.setFilma(filmak);
		sa1.setPrezioa(5.5f);
		saioak[0].setId_saioa(9);
		t.set(Calendar.HOUR, 5);
		t.set(Calendar.MINUTE, 30);
		saioak[0].setOrdua(t);
		sa1.setSaioa(saioak);
		erosketak[0].setId_erosketa(15);
		bezeroak[0].setId_bezero("admin123");
		bezeroak[0].setIzenBez("admin");
		bezeroak[0].setAbizen("Perez");
		bezeroak[0].setSexua("emakume");
		bezeroak[0].setAdina(30);
		bezeroak[0].setNan("12345678B");
		bezeroak[0].setPasahitza("54321");
		erosketak[0].setBezero(bezeroak);;
		erosketak[0].setDeskontua(20);
		erosketak[0].setTotala(15f);
		sa1.setErosketa(erosketak);
		
		assertEquals(4, sa1.getId_sarrera());
		assertEquals(8, sa1.getFilma()[0].getId_filma());
		assertEquals("La novia de Frankenstain", sa1.getFilma()[0].getIzenburu());
		assertEquals("Beldurra", sa1.getFilma()[0].getGenero());
		assertEquals(145, sa1.getFilma()[0].getIraupena());
		assertEquals(5.5, sa1.getPrezioa(),0.01);
		assertEquals(9, sa1.getSaioa()[0].getId_saioa());
		assertEquals(5, sa1.getSaioa()[0].getOrdua().get(Calendar.HOUR));
		assertEquals(30, sa1.getSaioa()[0].getOrdua().get(Calendar.MINUTE));
		assertEquals(15, sa1.getErosketa()[0].getId_erosketa());
		assertEquals("admin123", sa1.getErosketa()[0].getBezero()[0].getId_bezero());
		assertEquals("admin", sa1.getErosketa()[0].getBezero()[0].getIzenBez());
		assertEquals("Perez", sa1.getErosketa()[0].getBezero()[0].getAbizen());
		assertEquals("emakume", sa1.getErosketa()[0].getBezero()[0].getSexua());
		assertEquals(30, sa1.getErosketa()[0].getBezero()[0].getAdina());
		assertEquals("12345678B", sa1.getErosketa()[0].getBezero()[0].getNan());
		assertEquals("54321", sa1.getErosketa()[0].getBezero()[0].getPasahitza());
		assertEquals(20, sa1.getErosketa()[0].getDeskontua(), 0.01);
		assertEquals(15, sa1.getErosketa()[0].getTotala(), 0.01);
	}
	
	@Test
	public void testSarreraToString() {
		Filma f1 = new Filma(4, "Scary movie", "Komedia", 90);
		Filma[] filmak = new Filma[1];
		filmak[0] = f1;
		
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Saioa s1 = new Saioa(7, t);
		Saioa[] saioak = new Saioa[1];
		saioak[0] = s1;
		
		Bezero b1 = new Bezero("user123","User", "Diez", "gizon", 25, "12345678A", "12345");
		Bezero[] bezeroak = new Bezero[1];
		bezeroak[0] = b1; 
		
		Erosketa e1 = new Erosketa(14, bezeroak, 30f, 24.5f);
		Erosketa[] erosketak = new Erosketa[1];
		erosketak[0] = e1;
		
		Sarrera sa1 = new Sarrera(3, filmak, 2.2f, saioak, erosketak);
		
		//ToString
		assertEquals(sa1.toString(),"Sarrera [id_sarrera=" + sa1.getId_sarrera() + ", filma=" + sa1.getFilma() + ", prezioa=" + sa1.getPrezioa() + ", saioa="
				+ sa1.getSaioa() + ", erosketa=" + sa1.getErosketa() + "]");
	}
	
	@Test
	public void testSarreraEquals() {
		Filma f1 = new Filma(4, "Scary movie", "Komedia", 90);
		Filma[] filmak = new Filma[1];
		filmak[0] = f1;
		
		Calendar t = Calendar.getInstance();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		t.set(Calendar.MINUTE, 20);
		
		Saioa s1 = new Saioa(7, t);
		Saioa[] saioak = new Saioa[1];
		saioak[0] = s1;
		
		Bezero b1 = new Bezero("user123","User", "Diez", "gizon", 25, "12345678A", "12345");
		Bezero[] bezeroak = new Bezero[1];
		bezeroak[0] = b1; 
		
		Erosketa e1 = new Erosketa(14, bezeroak, 30f, 24.5f);
		Erosketa[] erosketak = new Erosketa[1];
		erosketak[0] = e1;
		
		Sarrera sa1 = new Sarrera(3, filmak, 2.2f, saioak, erosketak);
		Sarrera sa2 = new Sarrera(3, filmak, 2.2f, saioak, erosketak);
		Sarrera sa3 = new Sarrera();
		
		// Equals
		assertTrue(sa1.equals(sa2));
		assertFalse(sa3.equals(null));
	}

}
