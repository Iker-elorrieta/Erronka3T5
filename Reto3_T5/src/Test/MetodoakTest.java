package Test;

import static org.junit.Assert.*;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import org.junit.Test;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Controlador.Metodoak;
import Model.Aretoa;
import Model.Bezero;
import Model.Erosketa;
import Model.Filma;
import Model.Saioa;
import Model.Sarrera;
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
	public void AretoakKargatuTest() {
		Metodoak metodoak = new Metodoak();
		Aretoa[] aretoak_array = metodoak.AretoakKargatu();
		
		assertEquals(1,aretoak_array[0].getId_areto());
		assertEquals("Areto 1",aretoak_array[0].getIzenAret());
	}
	
	@Test
	public void SaioakKargatuTest() {
		Metodoak metodoak = new Metodoak();
		Saioa[] saioak_array = metodoak.SaioakKargatu();
		
		assertEquals(216,saioak_array[2].getId_saioa());
		assertEquals(2,saioak_array[2].getOrdua().get(Calendar.HOUR));
		assertEquals(0,saioak_array[2].getOrdua().get(Calendar.MINUTE));
		assertEquals(16,saioak_array[2].getFilma().getId_filma());
		assertEquals("Cisne negro",saioak_array[2].getFilma().getIzenburu());
		assertEquals("Beldurra",saioak_array[2].getFilma().getGenero());
		assertEquals(110,saioak_array[2].getFilma().getIraupena());
		assertEquals(6.5,saioak_array[2].getFilma().getPrezioa(), 0.01);
		assertEquals(2,saioak_array[2].getAretoa().getId_areto());
		assertEquals("Areto 2",saioak_array[2].getAretoa().getIzenAret());
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
	
	@Test
	public void FilmakKargatuTest() {
		Metodoak metodoak = new Metodoak();
		Filma[] filmak_array = metodoak.FilmakKargatu();
		
		assertEquals(1, filmak_array[0].getId_filma());
		assertEquals("Handia", filmak_array[0].getIzenburu());
		assertEquals("Drama", filmak_array[0].getGenero());
		assertEquals(116, filmak_array[0].getIraupena());
		assertEquals(4.5, filmak_array[0].getPrezioa(), 0.01);
	}
	
	// No hay datos
//	@Test
//	public void SarrerakKargatuTest() {
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
//	}
	
	// nN hay datos
//	@Test
//	public void ErosketakKargatuTest() {
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
//	}
	
	@Test
	public void ZinemarenFilmakTest(){
		Metodoak metodoak = new Metodoak();
		Filma[] filmak_array = metodoak.FilmakKargatu();
		Zinema[] zinemak_array = metodoak.ZinemakKargatu();
		Aretoa[] aretoak_array = metodoak.AretoakKargatu();
		Saioa[] saioak_array = metodoak.SaioakKargatu();
		String[][] filma_array = metodoak.ZinemarenFilmak(filmak_array, zinemak_array, aretoak_array, saioak_array,1);
		assertEquals("Handia", filma_array[0][0]);
		assertEquals("Drama", filma_array[0][1]);
		assertEquals("116", filma_array[0][2]);
		assertEquals("4.5", filma_array[0][3]);
	}
	
	@Test
	public void IdFilmaTest(){
		Metodoak metodoak = new Metodoak();
		Filma[] filmak_array = metodoak.FilmakKargatu();
		assertEquals(1, metodoak.IdFilma("Handia",filmak_array));
	}
	
	@Test
	public void SaioOrduakIdTest(){
		Metodoak metodoak = new Metodoak();
		Saioa[] saioak_array = metodoak.SaioakKargatu();
		String[][] ordua_id = metodoak.SaioOrduakId(1, "6-2-2023",saioak_array);
		assertEquals("14:0", ordua_id[0][0]);
		assertEquals("445", ordua_id[0][1]);
	}
	
	@Test
	public void SaioOrduakTest(){
		Metodoak metodoak = new Metodoak();
		Saioa[] saioak_array = metodoak.SaioakKargatu();
		String[][] ordua_id = metodoak.SaioOrduakId(1, "6-2-2023",saioak_array);
		String[] orduak = metodoak.SaioOrduak(ordua_id);
		String[] ordua = orduak[0].split(" ");
		assertEquals("14:0", ordua[1]);
	}
	
	@Test
	public void SaioAretoakTest(){
		Metodoak metodoak = new Metodoak();
		Saioa[] saioak_array = metodoak.SaioakKargatu();
		String[][] ordua_id = metodoak.SaioOrduakId(1, "6-2-2023",saioak_array);
		assertEquals("Areto 3", metodoak.SaioAretoak(ordua_id, 0,saioak_array));
	}
	
	@Test
	public void FilmPrezioaTest(){
		Metodoak metodoak = new Metodoak();
		Filma[] filmak_array = metodoak.FilmakKargatu();
		assertEquals(4.5f, metodoak.FilmPrezioa("Handia",filmak_array), 0.01);
	}
	
	@Test
	public void SaioaGordeTest(){
		Metodoak metodoak = new Metodoak();
		String[][] laburpena = new String [0][5];
		laburpena = metodoak.SaioaGorde(laburpena,"Handia","Areto 3", "6-2-2023", "1. 14:0", "4.5");
		assertEquals("Handia", laburpena[0][0]);
		assertEquals("6-2-2023", laburpena[0][1]);
		assertEquals("14:0", laburpena[0][2]);
		assertEquals("Areto 3", laburpena[0][3]);
		assertEquals("4.5", laburpena[0][4]);
	}
	
	@Test
	public void PrezioTotalaKalkulatuTest(){
		Metodoak metodoak = new Metodoak();
		String[][] laburpena = new String [0][5];
		laburpena = metodoak.SaioaGorde(laburpena,"Cisne negro","Areto 2", "6-2-2023", "1. 14:0", "6.5");
		assertEquals("6,50", metodoak.PrezioTotalaKalkulatu(laburpena));
	}
	
	@Test
	public void LoginBalidatuTest(){
		Metodoak metodoak = new Metodoak();
		Bezero[] bezeroak_array = metodoak.BezeroakKargatu();
		for(int i = 0; i < bezeroak_array.length; i ++){
			System.out.println(bezeroak_array[i]);
		}
		assertTrue(Metodoak.LoginBalidatu("ibai0","1234", bezeroak_array));
	}
	
	@Test
	public void RegistroaEginTest(){
		Metodoak metodoak = new Metodoak();
		Metodoak.RegistroaEgin("juan3","Juan","Martinez",32,"gizon","12345678J","1234");
		Bezero[] bezeroak_array = metodoak.BezeroakKargatu();
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