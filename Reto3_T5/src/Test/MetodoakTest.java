package Test;

import static org.junit.Assert.*;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Controlador.Metodoak;
import Model.Bezero;
import Model.Zinema;

public class MetodoakTest {

	@Test
	public void ZinemakKargatuTest() {
		Metodoak metodoak = new Metodoak();
		Zinema[] zinemak_array = metodoak.ZinemakKargatu();
		
		assertEquals(1, zinemak_array[0].getId_zinema());
		assertEquals("Cinesa Zubiarte", zinemak_array[0].getIzenZin());
		assertEquals("Leizaola Lehendakariaren Kalea, 2, 48009 Bilbo, Bizkaia", zinemak_array[0].getKokalekua());
		assertEquals(1, zinemak_array[0].getAretoa()[0].getId_areto());
		assertEquals("Areto 1", zinemak_array[0].getAretoa()[0].getIzenAret());
		assertEquals(2,zinemak_array[0].getAretoa()[1].getId_areto());
		assertEquals("Areto 2", zinemak_array[0].getAretoa()[1].getIzenAret());
		assertEquals(3,zinemak_array[0].getAretoa()[2].getId_areto());
		assertEquals("Areto 3", zinemak_array[0].getAretoa()[2].getIzenAret());
	}
	
	@Test
	public void BezeroakKargatuTest() {
		Metodoak metodoak = new Metodoak();
		Bezero[] bezeroak_array = metodoak.BezeroakKargatu();
		
		assertEquals("aingeru1", bezeroak_array[0].getId_bezero());
		assertEquals("Aingeru", bezeroak_array[0].getIzenBez());
		assertEquals("Siranaula", bezeroak_array[0].getAbizen());
		assertEquals("emakume", bezeroak_array[0].getSexua());
		assertEquals(54, bezeroak_array[0].getAdina());
		assertEquals("12345678R", bezeroak_array[0].getNan());
		assertEquals("1234", bezeroak_array[0].getPasahitza());
	}
	
	// No hay datos
	@Test
	public void SarrerakKargatuTest() {
//		Metodoak metodoak = new Metodoak();
//		Sarrera[] sarrerak_array = metodoak.SarrerakKargatu();
//		
//		assertEquals(1, sarrerak_array[0].getId_sarrera());
//		assertEquals(1, sarrerak_array[0].getSaioa().getId_saioa());
//		assertEquals(1, sarrerak_array[0].getSaioa().getOrdua().get(Calendar.HOUR));
//		assertEquals(1, sarrerak_array[0].getSaioa().getOrdua().get(Calendar.MINUTE));
//		assertEquals(1, sarrerak_array[0].getSaioa().getFilma().getId_filma());
//		assertEquals(1, sarrerak_array[0].getSaioa().getFilma().getIzenburu());
//		assertEquals(1, sarrerak_array[0].getSaioa().getFilma().getGenero());
//		assertEquals(1, sarrerak_array[0].getSaioa().getFilma().getIraupena());
//		assertEquals(1, sarrerak_array[0].getSaioa().getFilma().getPrezioa(), 0.01);
//		assertEquals(1, sarrerak_array[0].getSaioa().getAretoa().getId_areto());
//		assertEquals(1, sarrerak_array[0].getSaioa().getAretoa().getIzenAret());
	}
	
	// No hay datos
	@Test
	public void ErosketakKargatuTest() {
//		Metodoak metodoak = new Metodoak();
//		Erosketa[] erosketak_array = metodoak.ErosketakKargatu();
//		
//		assertEquals(1, erosketak_array[0].getId_erosketa());
//		assertEquals(1, erosketak_array[0].getBezero().getId_bezero());
//		assertEquals(1, erosketak_array[0].getBezero().getIzenBez());
//		assertEquals(1, erosketak_array[0].getBezero().getAbizen());
//		assertEquals(1, erosketak_array[0].getBezero().getAdina());
//		assertEquals(1, erosketak_array[0].getBezero().getSexua());
//		assertEquals(1, erosketak_array[0].getBezero().getPasahitza());
//		assertEquals(1, erosketak_array[0].getDeskontua(), 0.01);
//		assertEquals(1, erosketak_array[0].getTotala(), 0.01);
//		assertEquals(1, erosketak_array[0].getSarrera()[0].getId_sarrera());
//		assertEquals(1, erosketak_array[0].getSarrera()[0].getSaioa().getId_saioa());
//		assertEquals(1, erosketak_array[0].getSarrera()[0].getSaioa().getOrdua().get(Calendar.HOUR));
//		assertEquals(1, erosketak_array[0].getSarrera()[0].getSaioa().getOrdua().get(Calendar.MINUTE));
//		assertEquals(1, erosketak_array[0].getSarrera()[0].getSaioa().getFilma().getId_filma());
//		assertEquals(1, erosketak_array[0].getSarrera()[0].getSaioa().getFilma().getIzenburu());
//		assertEquals(1, erosketak_array[0].getSarrera()[0].getSaioa().getFilma().getGenero());
//		assertEquals(1, erosketak_array[0].getSarrera()[0].getSaioa().getFilma().getIraupena());
//		assertEquals(1, erosketak_array[0].getSarrera()[0].getSaioa().getFilma().getPrezioa(), 0.01);
//		assertEquals(1, erosketak_array[0].getSarrera()[0].getSaioa().getAretoa().getId_areto());
//		assertEquals(1, erosketak_array[0].getSarrera()[0].getSaioa().getAretoa().getIzenAret());
	}
	
	@Test
	public void BotoiakKargatuTest(){
		Metodoak metodoak = new Metodoak();
		Zinema[] zinemak_array = metodoak.ZinemakKargatu();
		String[][] botoi_zinemak;
		botoi_zinemak = metodoak.BotoiakKargatu(zinemak_array);
		
		assertEquals("10,69,199,168",botoi_zinemak[0][0]);
		assertEquals("src/resources/zubi.png",botoi_zinemak[0][1]);
	}
	
	@Test
	public void ZinemarenFilmakTest(){
		Metodoak metodoak = new Metodoak();
		Zinema[] zinemak_array = metodoak.ZinemakKargatu();
		String[][] film_array = new String[0][0];
		film_array= metodoak.ZinemarenFilmak(zinemak_array, 1);
		
		assertEquals("Handia", film_array[0][0]);
		assertEquals("Drama", film_array[0][1]);
		assertEquals("116", film_array[0][2]);
		assertEquals("4.5", film_array[0][3]);
	}
	
	@Test
	public void IdFilmaTest(){
		Metodoak metodoak = new Metodoak();
		Zinema[] zinemak_array = metodoak.ZinemakKargatu();
		
		assertEquals(1, metodoak.IdFilma("Handia", zinemak_array, 1));
	}
	
	@Test
	public void FilmarenDataBalidatuTest(){
		Metodoak metodoak = new Metodoak();
		Zinema[] zinemak_array = metodoak.ZinemakKargatu();
		assertTrue(metodoak.FilmarenDataBalidatu(zinemak_array, "22-3-2023", 1));
	}
	
	@Test
	public void SaioOrduakIdTest(){
		Metodoak metodoak = new Metodoak();
		Zinema[] zinemak_array = metodoak.ZinemakKargatu();
		int id_filma = metodoak.IdFilma("Handia", zinemak_array, 1);
		String[][] saio_orduak_id = new String[0][2];
		saio_orduak_id = metodoak.SaioOrduakId(id_filma,"6-2-2023",zinemak_array,1);
		
		assertEquals("14:0", saio_orduak_id[0][0]);
		assertEquals("445", saio_orduak_id[0][1]);
	}
	
	@Test
	public void SaioOrduakTest(){
		Metodoak metodoak = new Metodoak();
		Zinema[] zinemak_array = metodoak.ZinemakKargatu();
		int id_filma = metodoak.IdFilma("Handia", zinemak_array, 1);
		String[][] saio_orduak_id = new String[0][2];
		saio_orduak_id = metodoak.SaioOrduakId(id_filma,"6-2-2023",zinemak_array,1);
		String[] orduak = metodoak.SaioOrduak(saio_orduak_id);
		assertEquals("1. 14:0", orduak[0]);
	}
	
	@Test
	public void SaioAretoakTest(){
		Metodoak metodoak = new Metodoak();
		Zinema[] zinemak_array = metodoak.ZinemakKargatu();
		int id_filma = metodoak.IdFilma("Handia", zinemak_array, 1);
		String[][] saio_orduak_id = new String[0][2];
		saio_orduak_id = metodoak.SaioOrduakId(id_filma,"6-2-2023",zinemak_array,1);
		assertEquals("Areto 3", metodoak.SaioAretoak(saio_orduak_id, 0, zinemak_array, 1));
	}
	
	@Test
	public void FilmPrezioaTest(){
		Metodoak metodoak = new Metodoak();
		Zinema[] zinemak_array = metodoak.ZinemakKargatu();
		assertEquals(4.5f, metodoak.FilmPrezioa("Handia", zinemak_array, 1), 0.01);
	}
	
	@Test
	public void SaioaGordeTest(){
		Metodoak metodoak = new Metodoak();
		String[][] laburpena = new String [0][7];
		Zinema[] zinemak_array = metodoak.ZinemakKargatu();
		laburpena = metodoak.SaioaGorde(laburpena,zinemak_array, 1, "Handia","Areto 3", "6-2-2023", "1. 14:0", "4.5",445);
		assertEquals("Cinesa Zubiarte", laburpena[0][0]);
		assertEquals("Handia", laburpena[0][1]);
		assertEquals("6-2-2023", laburpena[0][2]);
		assertEquals("14:0", laburpena[0][3]);
		assertEquals("Areto 3", laburpena[0][4]);
		assertEquals("4.5", laburpena[0][5]);
		assertEquals("445", laburpena[0][6]);
	}
	
	@Test
	public void PrezioTotalaKalkulatuTest(){
		Metodoak metodoak = new Metodoak();
		String[][] laburpena = new String [0][7];
		Zinema[] zinemak_array = metodoak.ZinemakKargatu();
		laburpena = metodoak.SaioaGorde(laburpena,zinemak_array, 1, "Handia","Areto 3", "6-2-2023", "1. 14:0", "4.5", 445);
		assertEquals("4,50", metodoak.PrezioTotalaKalkulatu(laburpena));
	}
	
	@Test
	public void DeskotuKalkulatu0Test(){
		Metodoak metodoak = new Metodoak();
		String[][] laburpena = new String [0][7];
		Zinema[] zinemak_array = metodoak.ZinemakKargatu();
		laburpena = metodoak.SaioaGorde(laburpena,zinemak_array, 1, "Handia","Areto 3", "6-2-2023", "1. 14:0", "4.5", 445);
		assertEquals(0, metodoak.DeskotuKalkulatu(laburpena));
	}
	
	@Test
	public void DeskotuKalkulatu20Test(){
		Metodoak metodoak = new Metodoak();
		String[][] laburpena = new String [0][7];
		Zinema[] zinemak_array = metodoak.ZinemakKargatu();
		laburpena = metodoak.SaioaGorde(laburpena,zinemak_array, 1, "Handia","Areto 3", "6-2-2023", "1. 14:0", "4.5", 445);
		laburpena = metodoak.SaioaGorde(laburpena,zinemak_array, 1, "La novia de Frankenstein","Areto 1", "6-2-2023", "3. 20:0", "5.75", 21);
		assertEquals(20, metodoak.DeskotuKalkulatu(laburpena));
	}
	
	@Test
	public void DeskotuKalkulatu30Test(){
		Metodoak metodoak = new Metodoak();
		String[][] laburpena = new String [0][5];
		Zinema[] zinemak_array = metodoak.ZinemakKargatu();
		laburpena = metodoak.SaioaGorde(laburpena,zinemak_array, 1, "Handia","Areto 3", "6-2-2023", "1. 14:0", "4.5", 445);
		laburpena = metodoak.SaioaGorde(laburpena,zinemak_array, 1, "La novia de Frankenstein","Areto 1", "6-2-2023", "3. 20:0", "5.75", 21);
		laburpena = metodoak.SaioaGorde(laburpena,zinemak_array, 1, "El gran Lebowsky","Areto 2", "28-3-2023", "4. 23:0", "6.25", 207);
		assertEquals(30, metodoak.DeskotuKalkulatu(laburpena));
	}
	
	@Test
	public void PrezioTotalaKalkulatuDeskontuarekinTest(){
		Metodoak metodoak = new Metodoak();
		String[][] laburpena = new String [0][5];
		Zinema[] zinemak_array = metodoak.ZinemakKargatu();
		laburpena = metodoak.SaioaGorde(laburpena,zinemak_array, 1, "Handia","Areto 3", "6-2-2023", "1. 14:0", "4.5", 445);
		laburpena = metodoak.SaioaGorde(laburpena,zinemak_array, 1, "La novia de Frankenstein","Areto 1", "6-2-2023", "3. 20:0", "5.75", 21);
		laburpena = metodoak.SaioaGorde(laburpena,zinemak_array, 1, "El gran Lebowsky","Areto 2", "28-3-2023", "4. 23:0", "6.25", 207);
		assertEquals("11,55", metodoak.PrezioTotalaKalkulatuDeskontuarekin(laburpena));
	}
	
	@Test
	public void LoginBalidatuTest(){
		Metodoak metodoak = new Metodoak();
		Bezero[] bezeroak_array = metodoak.BezeroakKargatu();
		assertTrue(metodoak.LoginBalidatu("ibai0","1234", bezeroak_array));
	}
	
	@Test
	public void RegistroaEginTest(){
		Metodoak metodoak = new Metodoak();
		Bezero[] bezeroak_array = new Bezero[0];
		bezeroak_array = metodoak.BezeroakKargatu();
		metodoak.RegistroaEgin(bezeroak_array,"juan3","Juan","Martinez",32,"gizon","12345678J","1234");
		String id_bez = bezeroak_array[2].getId_bezero();
		String id_bezeroa = "";
		String izenbez = "";
		String abizbez = "";
		String sexua = "";
		int adina = 0;
		String nan = "";
		String pasahitza = "";
		
		
		Connection conn;					
		try {
			String url = "jdbc:mysql://localhost:3306/db_zinema";
			conn = (Connection) DriverManager.getConnection (url, "root","");
			Statement comando = (Statement) conn.createStatement();	
			ResultSet request = comando.executeQuery("Select id_bezeroa, izebez, abizbez, sexua, adina, nan, pasahitza from bezeroa where id_bezeroa = '"+ id_bez +"';");
			
			while(request.next()) {
				
				id_bezeroa = request.getString(1);
				izenbez = request.getString(2);
				abizbez = request.getString(3);
				sexua = request.getString(4);
				adina = Integer.parseInt(request.getString(5));
				nan = request.getString(6);
				pasahitza = request.getString(7);	
			}
			
			
			
			assertEquals(id_bezeroa, bezeroak_array[2].getId_bezero());
			assertEquals(izenbez, bezeroak_array[2].getIzenBez());
			assertEquals(abizbez, bezeroak_array[2].getAbizen());
			assertEquals(adina, bezeroak_array[2].getAdina());
			assertEquals(sexua, bezeroak_array[2].getSexua());
			assertEquals(nan, bezeroak_array[2].getNan());
			assertEquals(pasahitza, bezeroak_array[2].getPasahitza());
			conn.close();
		}catch(SQLException ex) {
			System.out.println("SQLException: "+ ex.getMessage());
			System.out.println("SQLState: "+ ex.getSQLState());
			System.out.println("ErrorCode: "+ ex.getErrorCode());
		}
	}

}