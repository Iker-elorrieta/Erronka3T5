package Controlador;

import java.awt.Image;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;

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
		Saioa[] saioak= new Saioa[0];
		int id_aretoa = 1;
		
		Connection conn;					
		try {
			String url = "jdbc:mysql://localhost:3306/db_zinema";
			conn = (Connection) DriverManager.getConnection (url, "root","");
			Statement comando = (Statement) conn.createStatement();	
			ResultSet request = comando.executeQuery("Select Id_zinema,IzenZin, Kokalekua, Bounds, Route from zinema;");

			int id_zinema = 1;
			//Zinema bakoitzaren informazioa gorde
			while(request.next()) {
				Zinema zinema = new Zinema();
				
				zinema.setId_zinema(Integer.parseInt(request.getString(1)));
				zinema.setIzenZin(request.getString(2));
				zinema.setKokalekua(request.getString(3));
				zinema.setBounds(request.getString(4));
				zinema.setRoute(request.getString(5));
				
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
						
						//Zinema bakoitzena dauden aretoen Saioak kargatzen ditu
						Connection conn3;
						try {	
							conn3 = (Connection) DriverManager.getConnection (url, "root","");
							Statement comando3 = (Statement) conn3.createStatement();	
							ResultSet request3 = comando3.executeQuery("Select Id_aretoa, Id_saioa, Ordua, Data, f.Id_filma,Izenburua, Generoa, iraupena, prezioa from saioa s join filma f using(id_filma) join aretoa using (id_aretoa) where id_aretoa="+id_aretoa+" order by data,ordua;");		
							saioak= new Saioa[0];
							
							//Zinema bakoitzena dauden aretoen Saioak gordetzen ditu
							while(request3.next()) {
								Saioa saioa = new Saioa();
								
								saioa.setId_saioa(Integer.parseInt(request3.getString(2)));
								
								//Ordua 
								String ordua = request3.getString(3);
								String[] ordua_array = ordua.split(":");
								Calendar cal = Calendar.getInstance();
								cal.set(Calendar.HOUR,Integer.parseInt(ordua_array[0]));
								cal.set(Calendar.MINUTE,Integer.parseInt(ordua_array[1]));
								
								//Data
								String data = request3.getString(4);
								String[] data_array = data.split("-");
								cal.set(Calendar.YEAR,Integer.parseInt(data_array[0]));
								cal.set(Calendar.MONTH,Integer.parseInt(data_array[1]));
								cal.set(Calendar.DAY_OF_MONTH,Integer.parseInt(data_array[2]));
								saioa.setOrdua(cal);
								
								//Filma
								Filma filma = new Filma(Integer.parseInt(request3.getString(5)),request3.getString(6),request3.getString(7),Integer.parseInt(request3.getString(8)),Float.parseFloat(request3.getString(9)));
								saioa.setFilma(filma);
								
								//Aretoen array-a berridazten du
								Saioa[] saioak_prov = new Saioa[saioak.length+1];
								for(int i =0;i<saioak.length;i++){
									saioak_prov[i]=saioak[i];
								}
								saioak_prov[saioak.length] = saioa;
								saioak = saioak_prov;								
								
							}
							conn3.close();
						}catch(SQLException ex) {
							System.out.println("SQLException: "+ ex.getMessage());
							System.out.println("SQLState: "+ ex.getSQLState());
							System.out.println("ErrorCode: "+ ex.getErrorCode());
						}
						
						areto.setSaioak(saioak);
						
						//Aretoen array-a berridazten du
						Aretoa[] areto_prov = new Aretoa[aretoak.length+1];
						for(int i =0;i<aretoak.length;i++){
							areto_prov[i]=aretoak[i];
						}
						areto_prov[aretoak.length] = areto;
						aretoak = areto_prov;
						id_aretoa++;
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
	 * Zinemen botoien arraya betetzen du
	 * @param zinemak Zinema objetuen arraya
	 * @return Zinemen botoien konfigurazioa duen array bidimentzionala
	 */
	public 	String[][] BotoiakKargatu(Zinema[] zinemak){
		String[][] botoi_zinemak = new String[0][2];
		 int kont=0;
		while(kont<zinemak.length) {
			
			String[][] botones_prov = new String[botoi_zinemak.length+1][2];
			
			for(int i=0;i<botoi_zinemak.length;i++) {
				for(int k=0;k<botoi_zinemak[i].length;k++) {
					botones_prov[i][k]=botoi_zinemak[i][k];
				}
			}
			
			botones_prov[botoi_zinemak.length][0]=zinemak[kont].getBounds();
			botones_prov[botoi_zinemak.length][1]=zinemak[kont].getRoute();
			
			botoi_zinemak = new String[botones_prov.length][2];
			for(int i=0;i<botones_prov.length;i++) {
				for(int k=0;k<botones_prov[i].length;k++) {
					botoi_zinemak[i][k]=botones_prov[i][k];
				}
			}
			kont++;
		}
		return botoi_zinemak;
	}

	public ImageIcon ZinemaArgazkia(String[][] botoi_zinemak, int kont) {
		ImageIcon logo_cine = new ImageIcon(new ImageIcon(botoi_zinemak[kont][1]).getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT));
		return logo_cine;
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
	public String[][] ZinemarenFilmak(Zinema[] zinemak, int aukera){
		String[][] filmak_array = new String[0][4];
		boolean aurkituta=false;
		
		for(int i=0;i<zinemak[aukera-1].getAretoa().length;i++) {
			for(int j=0;j<zinemak[aukera-1].getAretoa()[i].getSaioak().length;j++) {
				String izenburu= zinemak[aukera-1].getAretoa()[i].getSaioak()[j].getFilma().getIzenburu();
				for(int k=0;k<filmak_array.length && !aurkituta;k++) {
					if(filmak_array[k][0].equals(izenburu)) {
						aurkituta=true;
					}
				}
				if(!aurkituta) {					
					//Saioen array-a berridazten du
					String[][] filmak_array_prov = new String[filmak_array.length+1][4];
					for(int h =0;h<filmak_array.length;h++){
						for(int l=0;l<filmak_array[h].length;l++){
							filmak_array_prov[h][l]=filmak_array[h][l];
						}
					}
					filmak_array_prov[filmak_array.length][0]= izenburu;
					filmak_array_prov[filmak_array.length][1]= zinemak[aukera-1].getAretoa()[i].getSaioak()[j].getFilma().getGenero();
					filmak_array_prov[filmak_array.length][2]= String.valueOf(zinemak[aukera-1].getAretoa()[i].getSaioak()[j].getFilma().getIraupena());
					filmak_array_prov[filmak_array.length][3]= String.valueOf(zinemak[aukera-1].getAretoa()[i].getSaioak()[j].getFilma().getPrezioa());
					filmak_array = filmak_array_prov;					
					
				}
				
			}
		}
		
		return filmak_array;
	}
	
	public int IdFilma(String izenburua, Zinema[] zinemak,int id_zinema) {
		int id_filma=0;
		boolean aurkituta=false;
		
		for(int i=0;i<zinemak[id_zinema-1].getAretoa().length && !aurkituta;i++) {
			for(int j=0;j<zinemak[id_zinema-1].getAretoa()[i].getSaioak().length && !aurkituta;j++) {
				String izen= zinemak[id_zinema-1].getAretoa()[i].getSaioak()[j].getFilma().getIzenburu();
				if(izenburua.equals(izen)) {
					id_filma=zinemak[id_zinema-1].getAretoa()[i].getSaioak()[j].getFilma().getId_filma();
					aurkituta=true;
				}
			}
		}		
		return id_filma;
	}
	
	public boolean FilmarenDataBalidatu(Zinema[] zinemak, String data, int id_filma) {
		boolean aurkituta= false;
				
		for(int i=0;i<zinemak.length && !aurkituta;i++) {
			for(int j=0;j<zinemak[i].getAretoa().length && !aurkituta;j++) {
				for(int k=0;k<zinemak[i].getAretoa()[j].getSaioak().length && !aurkituta;k++) {
					int eguna = zinemak[i].getAretoa()[j].getSaioak()[k].getOrdua().get(Calendar.DAY_OF_MONTH)-1;
					int hila = zinemak[i].getAretoa()[j].getSaioak()[k].getOrdua().get(Calendar.MONTH);
					int urtea = zinemak[i].getAretoa()[j].getSaioak()[k].getOrdua().get(Calendar.YEAR);
					String data_saio= eguna+"-"+hila+"-"+urtea;
					if(data_saio.equals(data) && zinemak[i].getAretoa()[j].getSaioak()[k].getFilma().getId_filma()==id_filma) {
						aurkituta=true;
					}
				}
			}
		}
		
		return aurkituta;
	}
	
	public String[][] SaioOrduakId(int id_filma, String data, Zinema[] zinemak, int id_zinema) {
		String[][] orduak= new String[0][2];
		
		for(int j=0;j<zinemak[id_zinema-1].getAretoa().length;j++) {
			for(int k=0;k<zinemak[id_zinema-1].getAretoa()[j].getSaioak().length;k++) {
				int eguna = zinemak[id_zinema-1].getAretoa()[j].getSaioak()[k].getOrdua().get(Calendar.DAY_OF_MONTH)-1;
				int hila = zinemak[id_zinema-1].getAretoa()[j].getSaioak()[k].getOrdua().get(Calendar.MONTH);
				int urtea = zinemak[id_zinema-1].getAretoa()[j].getSaioak()[k].getOrdua().get(Calendar.YEAR);
				String data_saio= eguna+"-"+hila+"-"+urtea;
				if(data_saio.equals(data) && zinemak[id_zinema-1].getAretoa()[j].getSaioak()[k].getFilma().getId_filma()==id_filma) {
					//Orduak array-a berridazten du
					String[][] orduak_prov = new String[orduak.length+1][2];
					for(int l =0;l<orduak.length;l++){
						for(int h=0;h<orduak[l].length;h++) {
							orduak_prov[l][h]=orduak[l][h];
						}
					}
					orduak_prov[orduak.length][0] = (zinemak[id_zinema-1].getAretoa()[j].getSaioak()[k].getOrdua().get(Calendar.HOUR)+12)+":"+zinemak[id_zinema].getAretoa()[j].getSaioak()[k].getOrdua().get(Calendar.MINUTE);
					orduak_prov[orduak.length][1] = String.valueOf(zinemak[id_zinema-1].getAretoa()[j].getSaioak()[k].getId_saioa());
					orduak = orduak_prov;
				}
			}
		}	
		
		String[][] placeholder= new String[1][2];
		for(int i=0;i<orduak.length-1;i++) {
			String[] array_prov = orduak[i][0].split(":");
			String[] array_prov_2 = orduak[i+1][0].split(":");
			if(Integer.valueOf(array_prov[0])>Integer.valueOf(array_prov_2[0]) && Integer.valueOf(array_prov[1])>=Integer.valueOf(array_prov_2[1])) {
				placeholder[0] = orduak[i];
				orduak[i] = orduak[i+1];
				orduak[i+1]=placeholder[0];
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
	
	public String SaioAretoak(String[][] array_ordu_id, int index, Zinema[] zinemak, int id_zinema) {
		String aretoa = "";		
		String id_saioa=array_ordu_id[index][1];
		boolean aurkituta=false;
		
		for(int i=0;i<zinemak[id_zinema-1].getAretoa().length && !aurkituta;i++) {
			for(int j=0;j<zinemak[id_zinema-1].getAretoa()[i].getSaioak().length && !aurkituta;j++) {
				if(zinemak[id_zinema-1].getAretoa()[i].getSaioak()[j].getId_saioa()== Integer.parseInt(id_saioa)) {
					aretoa=zinemak[id_zinema-1].getAretoa()[i].getIzenAret();
					aurkituta=true;
				}				
			}
		}		
		return aretoa;
	}
	
	public float FilmPrezioa(String izenburua, Zinema[] zinemak, int id_zinema) {
		float prezioa=0;
		boolean aurkituta= false;	
		
		for(int i=0;i<zinemak[id_zinema-1].getAretoa().length && !aurkituta;i++) {
			for(int j=0;j<zinemak[id_zinema-1].getAretoa()[i].getSaioak().length && !aurkituta;j++) {
				if(zinemak[id_zinema-1].getAretoa()[i].getSaioak()[j].getFilma().getIzenburu().equals(izenburua)) {
					prezioa= zinemak[id_zinema-1].getAretoa()[i].getSaioak()[j].getFilma().getPrezioa();
					aurkituta=true;
				}				
			}
		}	
		
		return prezioa;
	}
	
	public String[][] SaioaGorde(String[][] saioak_laburpen,Zinema[] zinemak, int id_zinema, String izenburua, String aretoa,String data, String ordua, String prezioa, int id_saioa){
		String[] ordua_string = ordua.split(" ");
		String zinema= "";
		for(int i=0;i<zinemak.length;i++) {
			if(zinemak[i].getId_zinema()==id_zinema) {
				zinema=zinemak[i].getIzenZin();
			}
		}
		
		//Filmens array-a berridazten du
		String[][] saioak_prov = new String[saioak_laburpen.length+1][7];
		for(int i =0;i<saioak_laburpen.length;i++){
			saioak_prov[i]=saioak_laburpen[i];
		}
		saioak_prov[saioak_laburpen.length][0] = zinema;
		saioak_prov[saioak_laburpen.length][1] = izenburua;
		saioak_prov[saioak_laburpen.length][2] = data;
		saioak_prov[saioak_laburpen.length][3] = ordua_string[1];
		saioak_prov[saioak_laburpen.length][4] = aretoa;
		saioak_prov[saioak_laburpen.length][5] = prezioa;
		saioak_prov[saioak_laburpen.length][6] = String.valueOf(id_saioa);
		saioak_laburpen = saioak_prov;		
		return saioak_laburpen;
	}
	
	public String PrezioTotalaKalkulatu(String[][] saioak) {
		float totala=0;
		String[] prob = new String[0];
		
		DecimalFormat formato1 = new DecimalFormat("#.00");
		
		for(int i=0;i<saioak.length;i++) {
			prob=saioak[i][5].split("???");
			totala+= Float.parseFloat(prob[0]);
		}
		return formato1.format(totala);
	}
	
	public int DeskotuKalkulatu(String[][] saio_laburpen) {
		int deskontu = 0;
		
		if(saio_laburpen.length==2) {
			deskontu=20;
		}else if(saio_laburpen.length>=3) {
			deskontu=30;
		}		
		return deskontu;
	}

	public String PrezioTotalaKalkulatuDeskontuarekin(String[][] saio_laburpen) {
		float prezio_totala= 0;

		DecimalFormat formato1 = new DecimalFormat("#.00");
		
		for(int i=0;i<saio_laburpen.length;i++) {
			String[] prezio = saio_laburpen[i][5].split("???");
			prezio_totala+=Float.parseFloat(prezio[0]);
		}		
		prezio_totala = (prezio_totala*(100-DeskotuKalkulatu(saio_laburpen)))/100;
		return formato1.format(prezio_totala);
	}
	
	public  boolean LoginBalidatu(String erabiltzaile, String pasahitza, Bezero[] bezeroak) {
		boolean balidatu= false;
		
		for(int i=0;i<bezeroak.length && !balidatu;i++) {
			if(bezeroak[i].getId_bezero().equalsIgnoreCase(erabiltzaile) && bezeroak[i].getPasahitza().equals(pasahitza)) {
				balidatu=true;
			}
		}
		return balidatu;
	}
	
	public  boolean RegistroaEgin(Bezero[] bezeroak, String id, String izen, String abizen, int adina, String sexua, String nan, String pass) {
		boolean erregistratuta = false;
		boolean existitu=false;
		
		for(int i=0;i<bezeroak.length && !existitu;i++) {
			if(bezeroak[i].getId_bezero().equalsIgnoreCase(id)) {
				existitu=true;
			}
		}
		if(!existitu) {
			Connection conn;					
			try {
				String url = "jdbc:mysql://localhost:3306/db_zinema";
				conn = (Connection) DriverManager.getConnection (url, "root","");
				Statement comando = (Statement) conn.createStatement();						
										
				comando.executeUpdate( "INSERT INTO bezeroa VALUES ('"+id+"','"+izen+"','"+abizen+"',"+adina+",'"+sexua+"','"+nan+"','"+pass+"');");
				erregistratuta=true;
				conn.close();
			}catch(SQLException ex) {
					System.out.println("SQLException: "+ ex.getMessage());
					System.out.println("SQLState: "+ ex.getSQLState());
					System.out.println("ErrorCode: "+ ex.getErrorCode());
			}
		}
		return erregistratuta;
	}

	public Erosketa ErosketaSortu(String[][] laburpen_array, String bezeroa, Bezero[] bezeroak) {
		Erosketa erosketa = new Erosketa();
		boolean aurkituta= false; 
		
		erosketa.setDeskontua(DeskotuKalkulatu(laburpen_array));		
		String[] array_prob = PrezioTotalaKalkulatuDeskontuarekin(laburpen_array).split(",");
		String totala_s = array_prob[0]+"."+array_prob[1];	
		int i=0;
		while(!aurkituta) {
			if(bezeroak[i].getId_bezero().equals(bezeroa)) {
				aurkituta=true;
			}
			i++;
		}
		erosketa.setTotala(Float.parseFloat(totala_s));
		erosketa.setBezero(bezeroak[i-1]);		
		return erosketa;
	}
	
	public void ErosketaGorde(Erosketa erosketa) {
		
		Connection conn;					
		try {
			String url = "jdbc:mysql://localhost:3306/db_zinema";
			conn = (Connection) DriverManager.getConnection (url, "root","");
			Statement comando = (Statement) conn.createStatement();		
		
			comando.executeUpdate( "INSERT INTO erosketa (Deskontua,Totala,Id_bezeroa) VALUES ("+erosketa.getDeskontua()+","+erosketa.getTotala()+",'"+erosketa.getBezero().getId_bezero()+"');");
			conn.close();
		}catch(SQLException ex) {
				System.out.println("SQLException: "+ ex.getMessage());
				System.out.println("SQLState: "+ ex.getSQLState());
				System.out.println("ErrorCode: "+ ex.getErrorCode());
		}		
	}
	
	public Erosketa[] ErosketenSarrerakSortu(Erosketa[] erosketak,Erosketa erosketa, String[][] laburpen_array,int id_saioa) {
		Sarrera[] sarrerak= new Sarrera[0];
		
		for(int i=0;i<laburpen_array.length;i++) {
			Sarrera sarrera = new Sarrera();
			Saioa saioa = new Saioa();
			
			saioa.setId_saioa(Integer.parseInt(laburpen_array[i][6]));
			sarrera.setSaioa(saioa);
			
			Sarrera[] sarrerak_prob= new Sarrera[sarrerak.length+1];
			for(int j=0;j<sarrerak.length;j++) {
				sarrerak_prob[j]=sarrerak[j];
			}
			sarrerak_prob[sarrerak.length]=sarrera;
			sarrerak=sarrerak_prob;
		}
		erosketa.setSarrera(sarrerak);
		erosketak[erosketak.length-1].setSarrera(erosketa.getSarrera());
		return erosketak;
	}
	
	public void SarrerakGorde(Erosketa[] erosketak) {
		int i=0;
		
		Connection conn;					
		try {
			String url = "jdbc:mysql://localhost:3306/db_zinema";
			conn = (Connection) DriverManager.getConnection (url, "root","");
			Statement comando = (Statement) conn.createStatement();		
			while(i<erosketak[erosketak.length-1].getSarrera().length) {
				comando.executeUpdate( "INSERT INTO sarrera (id_saioa,id_erosketa) VALUES ("+erosketak[erosketak.length-1].getSarrera()[i].getId_sarrera()+","+erosketak[erosketak.length-1].getId_erosketa()+");");
				i++;
			}
			conn.close();
		}catch(SQLException ex) {
				System.out.println("SQLException: "+ ex.getMessage());
				System.out.println("SQLState: "+ ex.getSQLState());
				System.out.println("ErrorCode: "+ ex.getErrorCode());
		}		
		
	}
}
