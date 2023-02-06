package Controlador;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Model.Aretoa;
import Model.Bezero;
import Model.Erosketa;
import Model.Filma;
import Model.Saioa;
import Model.Sarrera;
import Model.Zinema;

public class Metodoak {
	
	public Zinema[] ZinemakKargatu() {
		Zinema[] zinemak= new Zinema[0];
		Aretoa[] aretoak= new Aretoa[0];
		
		Connection conn;					
		try {
			String url = "jdbc:mysql://localhost:3306/db_zinema";
			conn = (Connection) DriverManager.getConnection (url, "root","");
			Statement comando = (Statement) conn.createStatement();	
			ResultSet request = comando.executeQuery("Select Id_zinema,IzenZin, Kokalekua from zinema;");
			
			//Zinema bakoitzaren informazioa gorde
			while(request.next()) {
				Zinema zinema = new Zinema();
				int id_zinema = 1;
				
				zinema.setId_zinema(Integer.parseInt(request.getString(1)));
				zinema.setIzenZin(request.getString(2));
				zinema.setKokalekua(request.getString(3));
				
				Connection conn2;
				try {	
					conn2 = (Connection) DriverManager.getConnection (url, "root","");
					Statement comando2 = (Statement) conn2.createStatement();	
					ResultSet request2 = comando2.executeQuery("Select Id_aretoa, IzenAret from aretoa a join zinema z ON a.Id_zinema=z.Id_zinema WHERE a.id_zinema='"+id_zinema+"';");		
					aretoak= new Aretoa[0];
					//Zinema bakoitzean dauden aretoen informazioa gorde
					while(request2.next()) {
						Aretoa areto = new Aretoa();
						
						areto.setId_areto(Integer.parseInt(request2.getString(1)));
						areto.setIzenAret(request2.getString(2));
						
						//Aretoen array-a berridazten du
						Aretoa[] areto_prov = new Aretoa[aretoak.length+1];
						for(int i =0;i<aretoak.length;i++){
							areto_prov[i]=aretoak[i];
						}
						areto_prov[aretoak.length] = areto;
						aretoak = areto_prov;
					}
					conn2.close();
				}catch(SQLException ex) {
						System.out.println("SQLException: "+ ex.getMessage());
						System.out.println("SQLState: "+ ex.getSQLState());
						System.out.println("ErrorCode: "+ ex.getErrorCode());
				}			
				zinema.setAreto(aretoak);
				
				//Zinemen array-a berridazten du
				Zinema[] zinemak_prov = new Zinema[zinemak.length+1];				
				for(int i=0;i<zinemak.length;i++) {
					zinemak_prov[i]=zinemak[i];					
				}	
				zinemak_prov[zinemak.length] = zinema;				
				zinemak=zinemak_prov;
				id_zinema++;
			}			
			conn.close();
		}catch(SQLException ex) {
			System.out.println("SQLException: "+ ex.getMessage());
			System.out.println("SQLState: "+ ex.getSQLState());
			System.out.println("ErrorCode: "+ ex.getErrorCode());
		}
		return zinemak;
	}
	
	public Aretoa[] AretoakKargatu() {
		Aretoa[] aretoak = new Aretoa[0];
		
		Connection conn;					
		try {
			String url = "jdbc:mysql://localhost:3306/db_zinema";
			conn = (Connection) DriverManager.getConnection (url, "root","");
			Statement comando = (Statement) conn.createStatement();	
			ResultSet request = comando.executeQuery("Select Id_aretoa, IzenAret from aretoa;");
			
			//Zinema bakoitzean dauden aretoen informazioa gorde
			while(request.next()) {
				Aretoa areto = new Aretoa();
				
				areto.setId_areto(Integer.parseInt(request.getString(1)));
				areto.setIzenAret(request.getString(2));
				
				//Aretoen array-a berridazten du
				Aretoa[] areto_prov = new Aretoa[aretoak.length+1];
				for(int i =0;i<aretoak.length;i++){
					areto_prov[i]=aretoak[i];
				}
				areto_prov[aretoak.length] = areto;
				aretoak = areto_prov;
			}
		}catch(SQLException ex) {
				System.out.println("SQLException: "+ ex.getMessage());
				System.out.println("SQLState: "+ ex.getSQLState());
				System.out.println("ErrorCode: "+ ex.getErrorCode());
		}		
		return aretoak;
	}
	
	public Saioa[] SaioakKargatu() {
		Saioa[] saioak = new Saioa[0];
		
		Connection conn;					
		try {
			String url = "jdbc:mysql://localhost:3306/db_zinema";
			conn = (Connection) DriverManager.getConnection (url, "root","");
			Statement comando = (Statement) conn.createStatement();	
			ResultSet request = comando.executeQuery("Select Id_saioa, Ordua, Data, f.Id_filma,Izenburua, Generoa, iraupena, prezioa, a.Id_aretoa,IzenAret from saioa s JOIN filma f ON s.id_filma=f.id_filma JOIN aretoa a ON s.id_aretoa=a.id_aretoa;");
			
			while(request.next()) {
				Saioa saio = new Saioa();
				
				saio.setId_saioa(Integer.parseInt(request.getString(1)));
				
				//Ordua 
				String ordua = request.getString(2);
				String[] ordua_array = ordua.split(":");
				Calendar cal = Calendar.getInstance();
				cal.set(Calendar.HOUR,Integer.parseInt(ordua_array[0]));
				cal.set(Calendar.MINUTE,Integer.parseInt(ordua_array[1]));
				
				//Data
				String data = request.getString(3);
				String[] data_array = data.split("-");
				cal.set(Calendar.YEAR,Integer.parseInt(data_array[0]));
				cal.set(Calendar.MONTH,Integer.parseInt(data_array[1]));
				cal.set(Calendar.DAY_OF_MONTH,Integer.parseInt(data_array[2]));
				saio.setOrdua(cal);
				
				//Filma
				Filma filma = new Filma(Integer.parseInt(request.getString(4)),request.getString(5),request.getString(6),Integer.parseInt(request.getString(7)),Float.parseFloat(request.getString(8)));
				saio.setFilma(filma);
			
				//Aretoa
				Aretoa areto = new Aretoa();
				areto.setId_areto(Integer.parseInt(request.getString(9)));
				areto.setIzenAret(request.getString(10));
				saio.setAretoa(areto);
				
				//Saioen array-a berridazten du
				Saioa[] saio_prov = new Saioa[saioak.length+1];
				for(int i =0;i<saioak.length;i++){
					saio_prov[i]=saioak[i];
				}
				saio_prov[saioak.length] = saio;
				saioak = saio_prov;
			}
		}catch(SQLException ex) {
				System.out.println("SQLException: "+ ex.getMessage());
				System.out.println("SQLState: "+ ex.getSQLState());
				System.out.println("ErrorCode: "+ ex.getErrorCode());
		}
		return saioak;
	}
	
	public Bezero[] BezeroakKargatu() {
		Bezero[] bezeroak = new Bezero[0];
		
		Connection conn;					
		try {
			String url = "jdbc:mysql://localhost:3306/db_zinema";
			conn = (Connection) DriverManager.getConnection (url, "root","");
			Statement comando = (Statement) conn.createStatement();	
			ResultSet request = comando.executeQuery("Select id_bezeroa, izebez, abizbez, sexua, adina, nan, pasahitza from bezeroa;");
			
			while(request.next()) {
				Bezero bezero = new Bezero();
				
				bezero.setId_bezero(request.getString(1));
				bezero.setIzenBez(request.getString(2));
				bezero.setAbizen(request.getString(3));
				bezero.setSexua(request.getString(4));
				bezero.setAdina(Integer.parseInt(request.getString(5)));
				bezero.setNan(request.getString(6));
				bezero.setPasahitza(request.getString(7));
				
				//Bezeroen array-a berridazten du
				Bezero[] bezero_prov = new Bezero[bezeroak.length+1];
				for(int i =0;i<bezeroak.length;i++){
					bezero_prov[i]=bezeroak[i];
				}
				bezero_prov[bezeroak.length] = bezero;
				bezeroak = bezero_prov;
				
			}
		}catch(SQLException ex) {
			System.out.println("SQLException: "+ ex.getMessage());
			System.out.println("SQLState: "+ ex.getSQLState());
			System.out.println("ErrorCode: "+ ex.getErrorCode());
		}
		
		return bezeroak;
	}
	
	public Filma[] FilmakKargatu() {
		Filma[] filmak = new Filma[0];
		
		Connection conn;					
		try {
			String url = "jdbc:mysql://localhost:3306/db_zinema";
			conn = (Connection) DriverManager.getConnection (url, "root","");
			Statement comando = (Statement) conn.createStatement();	
			ResultSet request = comando.executeQuery("Select id_filma,izenburua,generoa,iraupena,prezioa from filma;");
			
			while(request.next()) {
				Filma filma = new Filma(Integer.parseInt(request.getString(1)),request.getString(2),request.getString(3),Integer.parseInt(request.getString(4)),Float.parseFloat(request.getString(5)));
			
				//Filmens array-a berridazten du
				Filma[] film_prov = new Filma[filmak.length+1];
				for(int i =0;i<filmak.length;i++){
					film_prov[i]=filmak[i];
				}
				film_prov[filmak.length] = filma;
				filmak = film_prov;
			}
		}catch(SQLException ex) {
			System.out.println("SQLException: "+ ex.getMessage());
			System.out.println("SQLState: "+ ex.getSQLState());
			System.out.println("ErrorCode: "+ ex.getErrorCode());
		}
		return filmak;
	}

	public Sarrera[] SarrerakKargatu() {
		 Sarrera[] sarrerak = new Sarrera[0];
		 
		 Connection conn;					
			try {
				String url = "jdbc:mysql://localhost:3306/db_zinema";
				conn = (Connection) DriverManager.getConnection (url, "root","");
				Statement comando = (Statement) conn.createStatement();	
				ResultSet request = comando.executeQuery("Select id_sarrera, s.Id_saioa, Ordua, Data, f.Id_filma,Izenburua, Generoa, iraupena, prezioa, a.Id_aretoa,IzenAret from saioa s JOIN filma f ON s.id_filma=f.id_filma JOIN aretoa a ON s.id_aretoa=a.id_aretoa JOIN sarrera sa ON sa.id_saioa=s.id_saioa;");
				
				while(request.next()) {
					Sarrera sarrera = new Sarrera();
					
					Saioa saio = new Saioa();					
					saio.setId_saioa(Integer.parseInt(request.getString(1)));
					
					//Ordua 
					String ordua = request.getString(2);
					String[] ordua_array = ordua.split(":");
					Calendar cal = Calendar.getInstance();
					cal.set(Calendar.HOUR,Integer.parseInt(ordua_array[0]));
					cal.set(Calendar.MINUTE,Integer.parseInt(ordua_array[1]));
					
					//Data
					String data = request.getString(3);
					String[] data_array = data.split("-");
					cal.set(Calendar.YEAR,Integer.parseInt(data_array[0]));
					cal.set(Calendar.MONTH,Integer.parseInt(data_array[1]));
					cal.set(Calendar.DAY_OF_MONTH,Integer.parseInt(data_array[2]));
					saio.setOrdua(cal);
					
					//Filma
					Filma filma = new Filma(Integer.parseInt(request.getString(4)),request.getString(5),request.getString(6),Integer.parseInt(request.getString(7)),Float.parseFloat(request.getString(8)));
					saio.setFilma(filma);
				
					//Aretoa
					Aretoa areto = new Aretoa();
					areto.setId_areto(Integer.parseInt(request.getString(9)));
					areto.setIzenAret(request.getString(10));
					saio.setAretoa(areto);					
				
					
					//Filmens array-a berridazten du
					Sarrera[] sarrerak_prov = new Sarrera[sarrerak.length+1];
					for(int i =0;i<sarrerak.length;i++){
						sarrerak_prov[i]=sarrerak[i];
					}
					sarrerak_prov[sarrerak.length] = sarrera;
					sarrerak = sarrerak_prov;
				}
			}catch(SQLException ex) {
				System.out.println("SQLException: "+ ex.getMessage());
				System.out.println("SQLState: "+ ex.getSQLState());
				System.out.println("ErrorCode: "+ ex.getErrorCode());
			}
		 
		 return sarrerak;
	}
	
	public static String[][] FilmQuery(int aukera){
		String[][] film_array= new String[0][0];
		Connection conn;					
		try {
			String url = "jdbc:mysql://10.5.14.232:3306/db_zinema";
			conn = (Connection) DriverManager.getConnection (url, "talde5","elorrieta");
			Statement comando = (Statement) conn.createStatement();						
			String query = "Select Izenburua,Generoa, Iraupena,Prezioa from filma join saioa using (id_filma) join aretoa using (id_aretoa) join zinema using (id_zinema) where id_zinema = (select id_zinema from zinema where id_zinema ="+aukera+") order by ordua;";
			ResultSet request = comando.executeQuery( query);
									
			while(request.next()) {
				String[][] array_prov = new String[film_array.length+1][4];
				for(int i=0;i<film_array.length;i++) {
					for(int j=0;j<film_array[i].length;j++) {
						array_prov[i][j]=film_array[i][j];
					}
				}				
				array_prov[film_array.length][0]=request.getString(1);
				array_prov[film_array.length][1]=request.getString(2);
				array_prov[film_array.length][2]=request.getString(3);
				array_prov[film_array.length][3]=request.getString(4)+"€";
				film_array=array_prov;
				
			}			
			conn.close();
		}catch(SQLException ex) {
			System.out.println("SQLException: "+ ex.getMessage());
			System.out.println("SQLState: "+ ex.getSQLState());
			System.out.println("ErrorCode: "+ ex.getErrorCode());
		}
		return film_array;
	}
	
	public static boolean LoginBalidatu(String erabiltzaile, String pasahitza) {
		boolean balidatu= false;
		Connection conn;					
		try {
			String url = "jdbc:mysql://localhost:3306/db_zinema";
			conn = (Connection) DriverManager.getConnection (url, "root","");
			Statement comando = (Statement) conn.createStatement();						
									
			ResultSet request = comando.executeQuery( "select NAN, Pasahitza from bezeroa where NAN='"+erabiltzaile+"' AND Pasahitza='"+pasahitza+"';");
			
			if(request.next()) {	
				balidatu=true;
			}else {
				JOptionPane.showMessageDialog(null, "Erabiltzailea edo pasahitza okerrak dira","Alerta", JOptionPane.INFORMATION_MESSAGE);
			}
		}catch(SQLException ex) {
			System.out.println("SQLException: "+ ex.getMessage());
			System.out.println("SQLState: "+ ex.getSQLState());
			System.out.println("ErrorCode: "+ ex.getErrorCode());
		}		
		return balidatu;
	}
	
	public static void RegistroaEgin(String id, String izen, String abizen, int adina, String sexua, String nan, String pass) {
		Connection conn;					
		try {
			String url = "jdbc:mysql://localhost:3306/db_zinema";
			conn = (Connection) DriverManager.getConnection (url, "root","");
			Statement comando = (Statement) conn.createStatement();						
									
			comando.executeUpdate( "INSERT INTO bezeroa VALUES ('"+id+"','"+izen+"','"+abizen+"',"+adina+",'"+sexua+"','"+nan+"','"+pass+"');");
		}catch(SQLException ex) {
				System.out.println("SQLException: "+ ex.getMessage());
				System.out.println("SQLState: "+ ex.getSQLState());
				System.out.println("ErrorCode: "+ ex.getErrorCode());
		}
	}
 }
