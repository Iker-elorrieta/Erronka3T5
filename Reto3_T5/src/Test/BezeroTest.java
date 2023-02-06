package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Bezero;

public class BezeroTest {

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
}
