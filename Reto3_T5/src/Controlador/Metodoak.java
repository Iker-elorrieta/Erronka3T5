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
	
	/**
	 * Datu basean dauden zinema guztiak kargatzen ditu array batean.
	 * @return Zinema guztien array bat
	 */
	public Zinema[] ZinemakKargatu() {
		Zinema[] zinemak= new Zinema[0];
		Aretoa[] aretoak= new Aretoa[0];
		
		Connection conn;					
		try {
			String url = "jdbc:mysql://localhost:3306/db_zinema";
			conn = (Connection) DriverManager.getConnection (url, "root","");
			Statement comando = (Statement) conn.createStatement();	
			ResultSet request = comando.executeQuery("Select Id_zinema,IzenZin, Kokalekua from zinema;");

			int id_zinema = 1;
			//Zinema bakoitzaren informazioa gorde
			while(request.next()) {
				Zinema zinema = new Zinema();
				
				zinema.setId_zinema(Integer.parseInt(request.getString(1)));
				zinema.setIzenZin(request.getString(2));
				zinema.setKokalekua(request.getString(3));
				
				Connection conn2;
				try {	
					conn2 = (Connection) DriverManager.getConnection (url, "root","");
					Statement comando2 = (Statement) conn2.createStatement();	
					ResultSet request2 = comando2.executeQuery("Select Id_aretoa, IzenAret from aretoa a join zinema z ON a.Id_zinema=z.Id_zinema WHERE a.id_zinema="+id_zinema+";");		
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
	
	/**
	 * Datu basean dauden areto guztiak kargatzen ditu array batean.
	 * @return Areto guztien array bat
	 */
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
			conn.close();
		}catch(SQLException ex) {
				System.out.println("SQLException: "+ ex.getMessage());
				System.out.println("SQLState: "+ ex.getSQLState());
				System.out.println("ErrorCode: "+ ex.getErrorCode());
		}		
		return aretoak;
	}
	
	/**
	 * Datu basean dauden saio guztiak kargatzen ditu array batean.
	 * @return Saio guztien array bat
	 */
	public Saioa[] SaioakKargatu() {
		Saioa[] saioak = new Saioa[0];
		
		Connection conn;					
		try {
			String url = "jdbc:mysql://localhost:3306/db_zinema";
			conn = (Connection) DriverManager.getConnection (url, "root","");
			Statement comando = (Statement) conn.createStatement();	
			ResultSet request = comando.executeQuery("Select Id_saioa, Ordua, Data, f.Id_filma,Izenburua, Generoa, iraupena, prezioa, a.Id_aretoa,IzenAret from saioa s JOIN filma f ON s.id_filma=f.id_filma JOIN aretoa a ON s.id_aretoa=a.id_aretoa order by data,ordua;");
			
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
			conn.close();
		}catch(SQLException ex) {
				System.out.println("SQLException: "+ ex.getMessage());
				System.out.println("SQLState: "+ ex.getSQLState());
				System.out.println("ErrorCode: "+ ex.getErrorCode());
		}
		return saioak;
	}
	
	/**
	 * Datu basean dauden bezero guztiak kargatzen ditu array batean.
	 * @return Bezero guztien array bat
	 */
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
			conn.close();
		}catch(SQLException ex) {
			System.out.println("SQLException: "+ ex.getMessage());
			System.out.println("SQLState: "+ ex.getSQLState());
			System.out.println("ErrorCode: "+ ex.getErrorCode());
		}
		
		return bezeroak;
	}
	
	/**
	 * Datu basean dauden filma guztiak kargatzen ditu array batean.
	 * @return Filma guztien array bat
	 */
	public Filma[] FilmakKargatu() {
		Filma[] filmak = new Filma[0];
		
		Connection conn;					
		try {
			String url = "jdbc:mysql://localhost:3306/db_zinema";
			conn = (Connection) DriverManager.getConnection (url, "root","");
			Statement comando = (Statement) conn.createStatement();	
			ResultSet request = comando.executeQuery("Select f.id_filma,izenburua,generoa,iraupena,prezioa from filma f JOIN saioa s ON f.id_filma=s.id_filma group by f.id_filma order by data,ordua;");
			
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
			conn.close();
		}catch(SQLException ex) {
			System.out.println("SQLException: "+ ex.getMessage());
			System.out.println("SQLState: "+ ex.getSQLState());
			System.out.println("ErrorCode: "+ ex.getErrorCode());
		}
		return filmak;
	}

	/**
	 * Datu basean dauden sarrera guztiak kargatzen ditu array batean.
	 * @return Sarrera guztien array bat
	 */
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
					sarrera.setId_sarrera(Integer.parseInt(request.getString(1)));
					
					Saioa saio = new Saioa();				
					saio.setId_saioa(Integer.parseInt(request.getString(2)));
					
					//Ordua 
					String ordua = request.getString(3);
					String[] ordua_array = ordua.split(":");
					
					Calendar cal = Calendar.getInstance();
					cal.set(Calendar.HOUR,Integer.parseInt(ordua_array[0]));
					cal.set(Calendar.MINUTE,Integer.parseInt(ordua_array[1]));
					
					//Data
					String data = request.getString(4);
					String[] data_array = data.split("-");
					cal.set(Calendar.YEAR,Integer.parseInt(data_array[0]));
					cal.set(Calendar.MONTH,Integer.parseInt(data_array[1]));
					cal.set(Calendar.DAY_OF_MONTH,Integer.parseInt(data_array[2]));
					saio.setOrdua(cal);
					
					//Filma
					Filma filma = new Filma(Integer.parseInt(request.getString(5)),request.getString(6),request.getString(7),Integer.parseInt(request.getString(8)),Float.parseFloat(request.getString(9)));
					saio.setFilma(filma);
				
					//Aretoa
					Aretoa areto = new Aretoa();
					areto.setId_areto(Integer.parseInt(request.getString(10)));
					areto.setIzenAret(request.getString(11));
					saio.setAretoa(areto);					
					sarrera.setSaioa(saio);
					
					//Filmens array-a berridazten du
					Sarrera[] sarrerak_prov = new Sarrera[sarrerak.length+1];
					for(int i =0;i<sarrerak.length;i++){
						sarrerak_prov[i]=sarrerak[i];
					}
					sarrerak_prov[sarrerak.length] = sarrera;
					sarrerak = sarrerak_prov;
				}
				conn.close();
			}catch(SQLException ex) {
				System.out.println("SQLException: "+ ex.getMessage());
				System.out.println("SQLState: "+ ex.getSQLState());
				System.out.println("ErrorCode: "+ ex.getErrorCode());
			}
		 
		 return sarrerak;
	}
	
	/**
	 * Datu basean dauden erosketa guztiak kargatzen ditu array batean.
	 * @return Erosketa guztien array bat
	 */
	public Erosketa[] ErosketakKargatu() {
		Erosketa[] erosketak = new Erosketa[0];	

		 Connection conn;					
			try {
				String url = "jdbc:mysql://localhost:3306/db_zinema";
				conn = (Connection) DriverManager.getConnection (url, "root","");
				Statement comando = (Statement) conn.createStatement();	
				ResultSet request = comando.executeQuery("Select id_erosketa,e.id_bezeroa, izebez, abizbez, sexua, adina, nan, pasahitza, deskontua, totala from erosketa e,bezeroa b WHERE e.id_bezeroa=b.id_bezeroa;");
				
				while(request.next()) {
					Erosketa erosketa = new Erosketa();
					erosketa.setId_erosketa(Integer.parseInt(request.getString(1)));
					
					Bezero bezero = new Bezero();
					bezero.setId_bezero(request.getString(2));
					bezero.setIzenBez(request.getString(3));
					bezero.setAbizen(request.getString(4));
					bezero.setSexua(request.getString(5));
					bezero.setAdina(Integer.parseInt(request.getString(6)));
					bezero.setNan(request.getString(7));
					bezero.setPasahitza(request.getString(8));
					
					erosketa.setBezero(bezero);
					
					erosketa.setDeskontua(Float.parseFloat(request.getString(9)));
					erosketa.setTotala(Float.parseFloat(request.getString(10)));
					
					Sarrera[] sarrerak = new Sarrera[0];
					Connection conn2;					
					try {
						conn2 = (Connection) DriverManager.getConnection (url, "root","");
						Statement comando2 = (Statement) conn2.createStatement();	
						ResultSet request2 = comando2.executeQuery("Select id_sarrera, s.Id_saioa, Ordua, Data, f.Id_filma,Izenburua, Generoa, iraupena, prezioa, a.Id_aretoa,IzenAret from saioa s JOIN filma f ON s.id_filma=f.id_filma JOIN aretoa a ON s.id_aretoa=a.id_aretoa JOIN sarrera sa ON sa.id_saioa=s.id_saioa JOIN erosketa e ON e.id_erosketa=sa.id_erosketa WHERE e.id_erosketa='"+Integer.parseInt(request.getString(1))+"';");
						
						while(request2.next()) {
							Sarrera sarrera = new Sarrera();					
							sarrera.setId_sarrera(Integer.parseInt(request2.getString(1)));
							Saioa saio = new Saioa();				
							saio.setId_saioa(Integer.parseInt(request2.getString(2)));
							
							//Ordua 
							String ordua = request2.getString(3);
							String[] ordua_array = ordua.split(":");
							
							Calendar cal = Calendar.getInstance();
							cal.set(Calendar.HOUR,Integer.parseInt(ordua_array[0]));
							cal.set(Calendar.MINUTE,Integer.parseInt(ordua_array[1]));
							
							//Data
							String data = request2.getString(4);
							String[] data_array = data.split("-");
							cal.set(Calendar.YEAR,Integer.parseInt(data_array[0]));
							cal.set(Calendar.MONTH,Integer.parseInt(data_array[1]));
							cal.set(Calendar.DAY_OF_MONTH,Integer.parseInt(data_array[2]));
							saio.setOrdua(cal);
							
							//Filma
							Filma filma = new Filma(Integer.parseInt(request2.getString(5)),request2.getString(6),request2.getString(7),Integer.parseInt(request2.getString(8)),Float.parseFloat(request2.getString(9)));
							saio.setFilma(filma);
						
							//Aretoa
							Aretoa areto = new Aretoa();
							areto.setId_areto(Integer.parseInt(request2.getString(10)));
							areto.setIzenAret(request2.getString(11));
							saio.setAretoa(areto);					
							sarrera.setSaioa(saio);
							
							//Filmens array-a berridazten du
							Sarrera[] sarrerak_prov = new Sarrera[sarrerak.length+1];
							for(int i =0;i<sarrerak.length;i++){
								sarrerak_prov[i]=sarrerak[i];
							}
							sarrerak_prov[sarrerak.length] = sarrera;
							sarrerak = sarrerak_prov;
						}
						conn2.close();
					}catch(SQLException ex) {
						System.out.println("SQLException: "+ ex.getMessage());
						System.out.println("SQLState: "+ ex.getSQLState());
						System.out.println("ErrorCode: "+ ex.getErrorCode());
					}
					erosketa.setSarrera(sarrerak);
					
					//Erosketen array-a berridazten du
					Erosketa[] erosketak_prov = new Erosketa[erosketak.length+1];
					for(int i =0;i<erosketak.length;i++){
						erosketak_prov[i]=erosketak[i];
					}
					erosketak_prov[erosketak.length] = erosketa;
					erosketak = erosketak_prov;
				}
				conn.close();
			}catch(SQLException ex) {
				System.out.println("SQLException: "+ ex.getMessage());
				System.out.println("SQLState: "+ ex.getSQLState());
				System.out.println("ErrorCode: "+ ex.getErrorCode());
			}		
		return erosketak;
	}
	
	/**
	 * Aukeratutako zinemaren filmak array bidimentzional batean gordetzen ditu
	 * @param filmak Datu baseko filmak dituen arraya
	 * @param zinemak Datu baseko zinemak dituen arraya
	 * @param aretoak Datu baseko aretoak dituen arraya
	 * @param saioak Datu baseko saioak dituen arraya
	 * @param aukera Aukeratutako zinema
	 * @return Aukeratutako zinemaren filmak array bidimentzional batean
	 */
	public String[][] ZinemarenFilmak(Filma[] filmak,Zinema[] zinemak, Aretoa[] aretoak, Saioa[] saioak, int aukera){
		String[][] filmak_array = new String[0][4];
		boolean aurkituta=false;
		//Filmak aztertzen ditu
		for(int i=0;i<filmak.length;i++) {
			int id_filma= filmak[i].getId_filma();
			aurkituta=false;
			//Saioak aztertzen ditu
			for(int j=0;j<saioak.length && !aurkituta;j++) {
				if(id_filma==saioak[j].getFilma().getId_filma()) {
					int id_aretoa_saioa= saioak[j].getAretoa().getId_areto();
						Aretoa[] areto_zinema = zinemak[aukera-1].getAretoa();
						//Zinemen aretoak aztertzen ditu
						for(int g=0;g<areto_zinema.length && !aurkituta;g++) {
							if(id_aretoa_saioa==areto_zinema[g].getId_areto() && zinemak[aukera-1].getId_zinema()==aukera) {								
								//Filmen array-a berridazten du
								String[][] filmak_array_prov = new String[filmak_array.length+1][4];
								for(int f =0;f<filmak_array.length && !aurkituta;f++){
									for(int d=0;d<filmak_array[f].length;d++) {
										filmak_array_prov[f][d]=filmak_array[f][d];
									}
								}
								filmak_array_prov[filmak_array.length][0] = filmak[i].getIzenburu();
								filmak_array_prov[filmak_array.length][1] = filmak[i].getGenero();
								filmak_array_prov[filmak_array.length][2] = String.valueOf(filmak[i].getIraupena());
								filmak_array_prov[filmak_array.length][3] = String.valueOf(filmak[i].getPrezioa());
								filmak_array = filmak_array_prov;
								aurkituta=true;
							
						}
					}
				}
			}
		}
		
		return filmak_array;
	}
	
	public int IdFilma(String izenburua, Filma[] filmak) {
		int id_filma=0;
		boolean aurkituta=false;
		
		for(int i=0;i<filmak.length && !aurkituta;i++) {
			if(filmak[i].getIzenburu().equals(izenburua)) {
				id_filma=filmak[i].getId_filma();
				aurkituta=true;
			}
		}		
		return id_filma;
	}
	
	public String[][] SaioOrduakId(int id_filma, String data, Saioa[] saioak) {
		String[][] orduak= new String[0][2];
		
		for(int i=0;i<saioak.length;i++) {
			int eguna = saioak[i].getOrdua().get(Calendar.DAY_OF_MONTH);
			int hila = saioak[i].getOrdua().get(Calendar.MONTH);
			int urtea = saioak[i].getOrdua().get(Calendar.YEAR);
			String data_saio= eguna+"-"+hila+"-"+urtea;
			int id_film_saioa = saioak[i].getFilma().getId_filma();
			if(saioak[i].getFilma().getId_filma()==id_filma && data.equals(data_saio)) {
				
				//Orduak array-a berridazten du
				String[][] orduak_prov = new String[orduak.length+1][2];
				for(int j =0;j<orduak.length;j++){
					for(int k=0;k<orduak[j].length;k++) {
						orduak_prov[j][k]=orduak[j][k];
					}
				}
				orduak_prov[orduak.length][0] =(saioak[i].getOrdua().get(Calendar.HOUR)+12)+":"+saioak[i].getOrdua().get(Calendar.MINUTE);
				orduak_prov[orduak.length][1] = String.valueOf(saioak[i].getId_saioa());
				orduak = orduak_prov;
			}
		}		
		return orduak;
	}
	
	public String[] SaioOrduak(String[][] ordu_id) {
		String[] orduak = new String[0];
		
		for(int i=0; i<ordu_id.length;i++) {			
			//Filmens array-a berridazten du
			String[] orduak_prov = new String[orduak.length+1];
			for(int j =0;j<orduak.length;j++){
				orduak_prov[j]=orduak[j];
			}
			orduak_prov[orduak.length] = (orduak.length+1)+". "+ordu_id[i][0];
			orduak = orduak_prov;			
		}		
		return orduak;
	}
	
	public String SaioAretoak(String[][] array_ordu_id, int index, Saioa[] saioak) {
		String aretoa = "";		
		String id_saioa=array_ordu_id[index][1];
		
		for(int i=0;i<saioak.length;i++) {
			if(saioak[i].getId_saioa()== Integer.parseInt(id_saioa)) {
				aretoa=saioak[i].getAretoa().getIzenAret();
			}
		}
		
		return aretoa;
	}
	
	public float FilmPrezioa(String izenburua, Filma[] filmak) {
		float prezioa=0;
		
		for(int i=0;i<filmak.length;i++) {
			if(filmak[i].getIzenburu().equals(izenburua)) {
				prezioa= filmak[i].getPrezioa();
			}
		}			
		return prezioa;
	}
	
	public String[][] SaioaGorde(String[][] saioak, String izenburua, String aretoa,String data, String ordua, String prezioa){
		
		//Filmens array-a berridazten du
		String[][] saioak_prov = new String[saioak.length+1][5];
		for(int i =0;i<saioak.length;i++){
			saioak_prov[i]=saioak[i];
		}
		saioak_prov[saioak.length][0] = izenburua;
		saioak_prov[saioak.length][1] = data;
		saioak_prov[saioak.length][2] = ordua;
		saioak_prov[saioak.length][3] = aretoa;
		saioak_prov[saioak.length][4] = prezioa;
		saioak = saioak_prov;		
		return saioak;
	}
	
	public String PrezioTotalaKalkulatu(String[][] saioak) {
		String totala="";
		float prezioa=0;
		String[] prob = new String[0];
		
		for(int i=0;i<saioak.length;i++) {
			prob=saioak[i][4].split("€");
			prezioa+= Float.parseFloat(prob[0]);
		}
		totala = String.valueOf(prezioa);
		return totala;
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
