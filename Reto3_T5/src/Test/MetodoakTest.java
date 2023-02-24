package Test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import org.junit.Test;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Controlador.Metodoak;
import Model.Bezero;
import Model.Erosketa;
import Model.Saioa;
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
		assertEquals("Gizona", bezeroak_array[0].getSexua());
		assertEquals(54, bezeroak_array[0].getAdina());
		assertEquals("12345678R", bezeroak_array[0].getNan());
		assertEquals("1234", bezeroak_array[0].getPasahitza());
	}
	
	@Test
	public void ErosketakKargatuTest() {
		Metodoak metodoak = new Metodoak();
		Erosketa[] erosketak_array = metodoak.ErosketakKargatu();
		
		assertEquals(1, erosketak_array[0].getId_erosketa());
		assertEquals("ibai0", erosketak_array[0].getBezero().getId_bezero());
		assertEquals("Ibai", erosketak_array[0].getBezero().getIzenBez());
		assertEquals("Alvarez", erosketak_array[0].getBezero().getAbizen());
		assertEquals(22, erosketak_array[0].getBezero().getAdina());
		assertEquals("Gizona", erosketak_array[0].getBezero().getSexua());
		assertEquals("12345678D", erosketak_array[0].getBezero().getNan());
		assertEquals("1234", erosketak_array[0].getBezero().getPasahitza());
		assertEquals(0, erosketak_array[0].getDeskontua(), 0.01);
		assertEquals(4.5, erosketak_array[0].getTotala(), 0.01);
		assertEquals(1, erosketak_array[0].getSarrera()[0].getId_sarrera());
		assertEquals(1, erosketak_array[0].getSarrera()[0].getSaioa().getId_saioa());
		assertEquals(2, erosketak_array[0].getSarrera()[0].getSaioa().getOrdua().get(Calendar.HOUR));
		assertEquals(0, erosketak_array[0].getSarrera()[0].getSaioa().getOrdua().get(Calendar.MINUTE));
		assertEquals(1, erosketak_array[0].getSarrera()[0].getSaioa().getFilma().getId_filma());
		assertEquals("Handia", erosketak_array[0].getSarrera()[0].getSaioa().getFilma().getIzenburu());
		assertEquals("Drama", erosketak_array[0].getSarrera()[0].getSaioa().getFilma().getGenero());
		assertEquals(116, erosketak_array[0].getSarrera()[0].getSaioa().getFilma().getIraupena());
		assertEquals(4.5, erosketak_array[0].getSarrera()[0].getSaioa().getFilma().getPrezioa(), 0.01);
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
	public void FilmBatenDatakTest(){
		Metodoak metodoak = new Metodoak();
		Zinema[] zinemak_array = metodoak.ZinemakKargatu();
		Zinema zinema = zinemak_array[0];
		String[] datak = metodoak.FilmBatenDatak(zinemak_array,"Handia",zinema);
		
		assertEquals("2023-2-3", datak[1]);
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
	public void SaioakGordeTest(){
		Metodoak metodoak = new Metodoak();
		Zinema[] zinemak_array = metodoak.ZinemakKargatu();
		Zinema zinema = zinemak_array[0];
		Saioa[] saioak_array = new Saioa[0];
		saioak_array = metodoak.SaioakGorde(saioak_array, zinema, zinemak_array, 1);
		
		assertEquals(1, saioak_array[0].getId_saioa());
		assertEquals(2, saioak_array[0].getOrdua().get(Calendar.HOUR));
		assertEquals(0, saioak_array[0].getOrdua().get(Calendar.MINUTE));
		assertEquals(1, saioak_array[0].getFilma().getId_filma());
		assertEquals("Handia", saioak_array[0].getFilma().getIzenburu());
		assertEquals("Drama", saioak_array[0].getFilma().getGenero());
		assertEquals(116, saioak_array[0].getFilma().getIraupena());
		assertEquals(4.5, saioak_array[0].getFilma().getPrezioa(), 0.01);
	}
	
	@Test
	public void SaioakErakutsiTest(){
		Metodoak metodoak = new Metodoak();
		Zinema[] zinemak_array = metodoak.ZinemakKargatu();
		Zinema zinema = zinemak_array[0];
		Saioa[] saioak_array = new Saioa[0];
		saioak_array = metodoak.SaioakGorde(saioak_array, zinema, zinemak_array, 1);
		String[][] laburpen_array = new String[0][7];
		laburpen_array = metodoak.SaioakErakutsi(saioak_array,zinemak_array);
		
		assertEquals("Cinesa Zubiarte",laburpen_array[0][0]);
		assertEquals("Handia",laburpen_array[0][1]);
		assertEquals("2023-2-1",laburpen_array[0][2]);
		assertEquals("14:00",laburpen_array[0][3]);
		assertEquals("Areto 1",laburpen_array[0][4]);
		assertEquals("4.5€",laburpen_array[0][5]);
		assertEquals("1",laburpen_array[0][6]);
	}
	
	@Test
	public void PrezioTotalaKalkulatuTest(){
		Metodoak metodoak = new Metodoak();
		Zinema[] zinemak_array = metodoak.ZinemakKargatu();
		Zinema zinema = zinemak_array[0];
		Saioa[] saioak_array = new Saioa[0];
		saioak_array = metodoak.SaioakGorde(saioak_array, zinema, zinemak_array, 1);
		assertEquals("4,50", metodoak.PrezioTotalaKalkulatu(saioak_array));
	}
	
	@Test
	public void DeskotuKalkulatu0Test(){
		Metodoak metodoak = new Metodoak();
		Zinema[] zinemak_array = metodoak.ZinemakKargatu();
		Zinema zinema = zinemak_array[0];
		Saioa[] saioak_array = new Saioa[0];
		saioak_array = metodoak.SaioakGorde(saioak_array, zinema, zinemak_array, 445);
		assertEquals(0, metodoak.DeskotuKalkulatu(saioak_array));
	}
	
	@Test
	public void DeskotuKalkulatu20Test(){
		Metodoak metodoak = new Metodoak();
		Zinema[] zinemak_array = metodoak.ZinemakKargatu();
		Zinema zinema = zinemak_array[0];
		Saioa[] saioak_array = new Saioa[0];
		saioak_array = metodoak.SaioakGorde(saioak_array, zinema, zinemak_array, 445);
		saioak_array = metodoak.SaioakGorde(saioak_array, zinema, zinemak_array, 21);
		assertEquals(20, metodoak.DeskotuKalkulatu(saioak_array));
	}
	
	@Test
	public void DeskotuKalkulatu30Test(){
		Metodoak metodoak = new Metodoak();
		Zinema[] zinemak_array = metodoak.ZinemakKargatu();
		Zinema zinema = zinemak_array[0];
		Saioa[] saioak_array = new Saioa[0];
		saioak_array = metodoak.SaioakGorde(saioak_array, zinema, zinemak_array, 445);
		saioak_array = metodoak.SaioakGorde(saioak_array, zinema, zinemak_array, 21);
		saioak_array = metodoak.SaioakGorde(saioak_array, zinema, zinemak_array, 207);
		assertEquals(30, metodoak.DeskotuKalkulatu(saioak_array));
	}
	
	@Test
	public void PrezioTotalaKalkulatuDeskontuarekinTest(){
		Metodoak metodoak = new Metodoak();
		Zinema[] zinemak_array = metodoak.ZinemakKargatu();
		Zinema zinema = zinemak_array[0];
		Saioa[] saioak_array = new Saioa[0];
		saioak_array = metodoak.SaioakGorde(saioak_array, zinema, zinemak_array, 445);
		saioak_array = metodoak.SaioakGorde(saioak_array, zinema, zinemak_array, 21);
		saioak_array = metodoak.SaioakGorde(saioak_array, zinema, zinemak_array, 207);
		assertEquals("11,55", metodoak.PrezioTotalaKalkulatuDeskontuarekin(saioak_array));
	}
	
	@Test
	public void LoginBalidatuTest(){
		Metodoak metodoak = new Metodoak();
		Bezero[] bezeroak_array = metodoak.BezeroakKargatu();
		assertTrue(metodoak.LoginBalidatu("ibai0","1234", bezeroak_array));
	}
	
	@Test
	public void NanBalidatuTest(){
		assertTrue(Metodoak.NanBalidatu("78950146R"));
	}
	
	@Test
	public void RegistroaEginTest(){
		Metodoak metodoak = new Metodoak();
		Bezero[] bezeroak_array = new Bezero[0];
		metodoak.RegistroaEgin(bezeroak_array,"juan3","Juan","Martinez",32,"Gizona","12345678J","1234");
		bezeroak_array = metodoak.BezeroakKargatu();
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
	
	@Test
	public void ErosketaSortuTest(){
		Metodoak metodoak = new Metodoak();
		Zinema[] zinemak_array = metodoak.ZinemakKargatu();
		Zinema zinema = zinemak_array[0];
		Saioa[] saioak_array = new Saioa[0];
		saioak_array = metodoak.SaioakGorde(saioak_array, zinema, zinemak_array, 445);
		Bezero[] bezeroak_array = metodoak.BezeroakKargatu();
		Erosketa erosketa = new Erosketa();
		erosketa = metodoak.ErosketaSortu("aingeru1", bezeroak_array, saioak_array);
			
		String[] des_prov = erosketa.getDeskontua().toString().split("\\.");
			
		assertEquals("aingeru1", erosketa.getBezero().getId_bezero());
		assertEquals("4.5", erosketa.getTotala().toString());
		assertEquals("0", des_prov[0]);

	}
	
	@Test
	public void ErosketaGordeTest(){
		Metodoak metodoak = new Metodoak();
		Zinema[] zinemak_array = metodoak.ZinemakKargatu();
		Zinema zinema = zinemak_array[0];
		Saioa[] saioak_array = new Saioa[0];
		saioak_array = metodoak.SaioakGorde(saioak_array, zinema, zinemak_array, 445);
		Bezero[] bezeroak_array = metodoak.BezeroakKargatu();
		Erosketa erosketa = new Erosketa();
		erosketa = metodoak.ErosketaSortu("aingeru1", bezeroak_array, saioak_array);
		metodoak.ErosketaGorde(erosketa,"aingeru1");
		
		String id_bez = "aingeru1";
		String deskontua = "";
		String totala = "";
		String id_bezeroa = "";
		
		Connection conn;					
		try {
			String url = "jdbc:mysql://localhost:3306/db_zinema";
			conn = (Connection) DriverManager.getConnection (url, "root","");
			Statement comando = (Statement) conn.createStatement();	
			ResultSet request = comando.executeQuery("Select deskontua, totala, id_bezeroa from erosketa where id_bezeroa = '"+ id_bez +"' order by id_erosketa desc limit 1;");
			
			while(request.next()) {
				deskontua = request.getString(1);
				totala = request.getString(2);
				id_bezeroa = request.getString(3);
			}
			
			String[] des_prov = erosketa.getDeskontua().toString().split("\\.");
			
			assertEquals(id_bezeroa, erosketa.getBezero().getId_bezero());
			assertEquals(totala, erosketa.getTotala().toString());
			assertEquals(deskontua, des_prov[0]);
			conn.close();
		}catch(SQLException ex) {
			System.out.println("SQLException: "+ ex.getMessage());
			System.out.println("SQLState: "+ ex.getSQLState());
			System.out.println("ErrorCode: "+ ex.getErrorCode());
		}
	}
	
	@Test
	public void ErosketenSarrerakSortuTest(){
		Metodoak metodoak = new Metodoak();
		Zinema[] zinemak_array = metodoak.ZinemakKargatu();
		Zinema zinema = zinemak_array[0];
		Saioa[] saioak_array = new Saioa[0];
		saioak_array = metodoak.SaioakGorde(saioak_array, zinema, zinemak_array, 445);
		Bezero[] bezeroak_array = metodoak.BezeroakKargatu();
		Erosketa erosketa = new Erosketa();
		erosketa = metodoak.ErosketaSortu("aingeru1", bezeroak_array, saioak_array);
		metodoak.ErosketaGorde(erosketa,"aingeru1");
		Erosketa[] erosketak_array = new Erosketa[0];
		erosketak_array = metodoak.ErosketakKargatu();
		erosketak_array = metodoak.ErosketenSarrerakSortu(erosketak_array, erosketa,saioak_array);
		
		assertEquals(1, erosketak_array[0].getId_erosketa());
		assertEquals("ibai0", erosketak_array[0].getBezero().getId_bezero());
		assertEquals("Ibai", erosketak_array[0].getBezero().getIzenBez());
		assertEquals("Alvarez", erosketak_array[0].getBezero().getAbizen());
		assertEquals(22, erosketak_array[0].getBezero().getAdina());
		assertEquals("Gizona", erosketak_array[0].getBezero().getSexua());
		assertEquals("12345678D", erosketak_array[0].getBezero().getNan());
		assertEquals("1234", erosketak_array[0].getBezero().getPasahitza());
		assertEquals(0, erosketak_array[0].getDeskontua(), 0.01);
		assertEquals(4.5, erosketak_array[0].getTotala(), 0.01);
		assertEquals(1, erosketak_array[0].getSarrera()[0].getId_sarrera());
		assertEquals(1, erosketak_array[0].getSarrera()[0].getSaioa().getId_saioa());
		assertEquals(2, erosketak_array[0].getSarrera()[0].getSaioa().getOrdua().get(Calendar.HOUR));
		assertEquals(0, erosketak_array[0].getSarrera()[0].getSaioa().getOrdua().get(Calendar.MINUTE));
		assertEquals(1, erosketak_array[0].getSarrera()[0].getSaioa().getFilma().getId_filma());
		assertEquals("Handia", erosketak_array[0].getSarrera()[0].getSaioa().getFilma().getIzenburu());
		assertEquals("Drama", erosketak_array[0].getSarrera()[0].getSaioa().getFilma().getGenero());
		assertEquals(116, erosketak_array[0].getSarrera()[0].getSaioa().getFilma().getIraupena());
		assertEquals(4.5, erosketak_array[0].getSarrera()[0].getSaioa().getFilma().getPrezioa(), 0.01);
	}
	
	@Test
	public void SarrerakGordeTest(){
		Metodoak metodoak = new Metodoak();
		Zinema[] zinemak_array = metodoak.ZinemakKargatu();
		Zinema zinema = zinemak_array[0];
		Saioa[] saioak_array = new Saioa[0];
		saioak_array = metodoak.SaioakGorde(saioak_array, zinema, zinemak_array, 445);
		Bezero[] bezeroak_array = metodoak.BezeroakKargatu();
		Erosketa erosketa = new Erosketa();
		erosketa = metodoak.ErosketaSortu("aingeru1", bezeroak_array, saioak_array);
		metodoak.ErosketaGorde(erosketa,"aingeru1");
		Erosketa[] erosketak_array = new Erosketa[0];
		erosketak_array = metodoak.ErosketakKargatu();
		erosketak_array = metodoak.ErosketenSarrerakSortu(erosketak_array, erosketa,saioak_array);
		metodoak.SarrerakGorde(erosketak_array);
		erosketak_array = metodoak.ErosketakKargatu();
		
		int id_erosketa = erosketak_array[erosketak_array.length-1].getId_erosketa();
		int id_sarrera = 0;
		int id_saioa = 0;
		
		Connection conn;					
		try {
			String url = "jdbc:mysql://localhost:3306/db_zinema";
			conn = (Connection) DriverManager.getConnection (url, "root","");
			Statement comando = (Statement) conn.createStatement();	
			ResultSet request = comando.executeQuery("Select id_sarrera, id_saioa from sarrera where id_erosketa = " +id_erosketa+ ";");
			
			while(request.next()) {
				id_sarrera = Integer.parseInt(request.getString(1));
				id_saioa = Integer.parseInt(request.getString(2));
			}
			assertEquals(id_sarrera, erosketak_array[erosketak_array.length-1].getSarrera()[0].getId_sarrera());
			assertEquals(id_saioa, erosketak_array[erosketak_array.length-1].getSarrera()[0].getSaioa().getId_saioa());
			conn.close();
		}catch(SQLException ex) {
			System.out.println("SQLException: "+ ex.getMessage());
			System.out.println("SQLState: "+ ex.getSQLState());
			System.out.println("ErrorCode: "+ ex.getErrorCode());
		}
	}
	
	@Test
	public void TiketaGordeTest(){
		Metodoak metodoak = new Metodoak();
		Zinema[] zinemak_array = metodoak.ZinemakKargatu();
		Erosketa[] erosketak_array = new Erosketa[0];
		Erosketa[] eros_test = new Erosketa[1];
		
		erosketak_array = metodoak.ErosketakKargatu();
		eros_test[0] = erosketak_array[0];
		
		metodoak.TiketaGorde(eros_test,zinemak_array,"4.5","4.5",0);
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.AM_PM, Calendar.AM);
		String cal_s = cal.get(Calendar.YEAR)+"_"+cal.get(Calendar.MONTH)+"_"+cal.get(Calendar.DAY_OF_MONTH)+"_"+cal.get(Calendar.HOUR)+"_"+cal.get(Calendar.MINUTE);
		BufferedReader fichero;
		File file = new File(cal_s+".txt");
		try {
		fichero = new BufferedReader(new FileReader(file));
		
		assertEquals("Zinema: Cinesa Zubiarte, Aretoa :Areto 1, Ordua=14:0, data=1-2-2023, Izenburua=Handia, genero=Drama, iraupena=116, prezioa=4.5", fichero.readLine());
		
		fichero.close();
		
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}