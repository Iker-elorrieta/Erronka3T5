package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Filma;

public class FilmaTest {

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

}
