package Controlador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
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
	final String url = "jdbc:mysql://localhost:3306/db_zinema";
	final String erabiltzaile = "root";
	final String pass="";
	//Zinema
	final String id_zine= "Id_zinema";
	final String izenZin = "IzenZin";
	final String kokalekua = "Kokalekua";
	final String bounds = "Bounds";
	final String route = "Route";
	//Erosketa
	final String id_erosketa = "id_erosketa";
	final String deskontua = "deskontua";
	final String totala = "totala";
	//Bezeroa
	final String izebez = "izebez";
	final String abizbez = "abizbez";
	final String sexua = "sexua";
	final String adina= "adina";
	final String nan= "nan";
	final String pasahitza="pasahitza";
	final String id_bezeroa ="id_bezeroa";
	//Saioa
	final String id_saioa="id_saioa";
	final String ordua = "ordua";
	final String data="data";
	//Filma
	final String id_filma="id_filma";
	final String izenburua="izenburua";
	final String generoa = "generoa";
	final String iraupena = "iraupena";
	final String prezioa ="prezioa";	
	//Aretoa
	final String id_areto = "id_aretoa";
	final String izenAret = "izenAret";
	//Sarrera
	final String id_sarrera = "id_sarrera";
	
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
			conn = (Connection) DriverManager.getConnection (url, erabiltzaile,pass);
			Statement comando = (Statement) conn.createStatement();	
			ResultSet request = comando.executeQuery("Select "+id_zine+","+izenZin+","+kokalekua+","+bounds+","+route+" from zinema;");

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
					
					conn2 = (Connection) DriverManager.getConnection (url, erabiltzaile,pass);
					Statement comando2 = (Statement) conn2.createStatement();	
					ResultSet request2 = comando2.executeQuery("Select "+id_areto+","+izenAret+" from aretoa a join zinema z ON a."+id_zine+"= z."+id_zine+" WHERE a."+id_zine+"="+id_zinema+";");		
					aretoak= new Aretoa[0];
					
					//Zinema bakoitzean dauden aretoen informazioa gorde
					while(request2.next()) {
						Aretoa areto = new Aretoa();
						
						areto.setId_areto(Integer.parseInt(request2.getString(1)));
						areto.setIzenAret(request2.getString(2));
						
						//Zinema bakoitzena dauden aretoen Saioak kargatzen ditu
						Connection conn3;
							
							conn3 = (Connection) DriverManager.getConnection (url, erabiltzaile,pass);
							Statement comando3 = (Statement) conn3.createStatement();	
							ResultSet request3 = comando3.executeQuery("Select "+id_areto+","+id_saioa+","+ordua+","+data+",f."+id_filma+","+izenburua+","+generoa+","+iraupena+","+prezioa+" from saioa s join filma f using("+id_filma+") join aretoa using ("+id_areto+") where "+id_areto+"="+id_aretoa+" order by "+data+","+ordua+";");		
							saioak= new Saioa[0];
							
							//Zinema bakoitzena dauden aretoen Saioak gordetzen ditu
							while(request3.next()) {
								Saioa saioa = new Saioa();
								
								saioa.setId_saioa(Integer.parseInt(request3.getString(2)));
								
								//Ordua 
								String ordua = request3.getString(3);
								String[] ordua_array = ordua.split(":");
								Calendar cal = Calendar.getInstance();
								cal.set(Calendar.AM_PM, Calendar.AM);
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
			conn = (Connection) DriverManager.getConnection (url, erabiltzaile,pass);
			Statement comando = (Statement) conn.createStatement();	
			ResultSet request = comando.executeQuery("Select "+id_bezeroa+","+izebez+","+abizbez+","+sexua+","+adina+","+nan+","+pasahitza+" from bezeroa;");
			
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
	 * Datu basean dauden erosketa guztiak kargatzen ditu array batean.
	 * @return Erosketa guztien array bat
	 */
	public Erosketa[] ErosketakKargatu() {
		Erosketa[] erosketak = new Erosketa[0];	

		 Connection conn;					
			try {
				conn = (Connection) DriverManager.getConnection (url, erabiltzaile,pass);
				Statement comando = (Statement) conn.createStatement();	
				ResultSet request = comando.executeQuery("Select "+id_erosketa+",e."+id_bezeroa+"," +izebez+","+abizbez+","+sexua+","+adina+","+nan+","+pasahitza+","+deskontua+","+totala+" from erosketa e,bezeroa b WHERE e."+id_bezeroa+"=b."+id_bezeroa+" order by "+id_erosketa+";");
				
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
						conn2 = (Connection) DriverManager.getConnection (url, erabiltzaile,pass);
						Statement comando2 = (Statement) conn2.createStatement();	
						ResultSet request2 = comando2.executeQuery("Select "+id_sarrera+",s."+id_saioa+","+ordua+","+data+",f."+id_filma+","+izenburua+","+generoa+","+iraupena+","+prezioa+",a."+id_areto+","+izenAret+" from saioa s JOIN filma f ON s."+id_filma+"= f."+id_filma+" JOIN aretoa a ON s."+id_areto+"= a."+id_areto+" JOIN sarrera sa ON sa."+id_saioa+"=s."+id_saioa+" JOIN erosketa e ON e."+id_erosketa+"= sa."+id_erosketa+" WHERE e."+id_erosketa+"='"+Integer.parseInt(request.getString(1))+"';");
						
						while(request2.next()) {
							Sarrera sarrera = new Sarrera();					
							sarrera.setId_sarrera(Integer.parseInt(request2.getString(1)));
							Saioa saio = new Saioa();				
							saio.setId_saioa(Integer.parseInt(request2.getString(2)));
							
							//Ordua 
							String ordua = request2.getString(3);
							String[] ordua_array = ordua.split(":");
							
							Calendar cal = Calendar.getInstance();
							cal.set(Calendar.AM_PM, Calendar.AM);
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
	
	/**
	 * Aukeratutako zinemaren filmak array bidimentzional batean gordetzen ditu
	 * @param zinemak Datu baseko zinemak dituen arraya
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
	
	/**
	 * Film baten datak bueltatzen ditu array batean.
	 * @param zinemak Zinema guztiak dituen array-a.
	 * @param izenburua Filmaren izenburua.
	 * @param zinema Zinema objetua.
	 * @return Filmaren datak array batean.
	 */
	public String[] FilmBatenDatak(Zinema[] zinemak, String izenburua,Zinema zinema) {
		String[] datak = new String[0];	
		boolean badago = false;
		
		for(int i=0;i<zinemak.length;i++) {
			if(zinemak[i].equals(zinema)) {
				for(int h=0;h<zinema.getAretoa().length;h++) {
					for(int j=0;j<zinema.getAretoa()[h].getSaioak().length;j++) {
						if(zinema.getAretoa()[h].getSaioak()[j].getFilma().getIzenburu().equals(izenburua)) {
							badago=false;
							for(int w=0;w<datak.length && !badago;w++) {
								String data = zinema.getAretoa()[h].getSaioak()[j].getOrdua().get(Calendar.YEAR)+"-"+zinema.getAretoa()[h].getSaioak()[j].getOrdua().get(Calendar.MONTH)+"-"+zinema.getAretoa()[h].getSaioak()[j].getOrdua().get(Calendar.DAY_OF_MONTH);
								if(datak[w].equals(data)) {
									badago=true;
								}
							}
							if(!badago) {
								String[] datak_prob = new String[datak.length+1];
								for(int l=0;l<datak.length;l++) {
									datak_prob[l] = datak[l];
								}
								datak_prob[datak.length]=zinema.getAretoa()[h].getSaioak()[j].getOrdua().get(Calendar.YEAR)+"-"+zinema.getAretoa()[h].getSaioak()[j].getOrdua().get(Calendar.MONTH)+"-"+zinema.getAretoa()[h].getSaioak()[j].getOrdua().get(Calendar.DAY_OF_MONTH);
								datak = datak_prob;
							}
						}
					}
				}
			}			
		}
		
		return datak;
	}
	
	/**
	 * Aukeratutako filmaren id-a bilatu eta bueltatzen du.
	 * @param izenburua Filmaren izenburua
	 * @param zinemak Zinema guztien array-a
	 * @param id_zinema Aukeratutako zinemaren id-a.
	 * @return Aukeratutako filmaren id-a.
	 */
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
	
	/**
	 * Aukeratutako filmaren saiorik badaude aukeratutako egunean balidaten du.
	 * @param zinemak Zinemen array-a.
	 * @param data Aukeratutako data.
	 * @param id_filma Aukeratutako filmaren id-a.
	 * @return <b>True</b> filmaren saiorik badago, eta <b>False</b> ez badago saiorik.
	 */
	public boolean FilmarenDataBalidatu(Zinema[] zinemak, String data, int id_filma) {
		boolean aurkituta= false;
				
		for(int i=0;i<zinemak.length && !aurkituta;i++) {
			for(int j=0;j<zinemak[i].getAretoa().length && !aurkituta;j++) {
				for(int k=0;k<zinemak[i].getAretoa()[j].getSaioak().length && !aurkituta;k++) {
					int eguna = zinemak[i].getAretoa()[j].getSaioak()[k].getOrdua().get(Calendar.DAY_OF_MONTH);
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
	
	/**
	 * Aukeratutako filma, eta aukeratutako egunean dauden saioen orduak bere id-rekin.
	 * @param id_filma Aukeratutako filmaren id-a.
	 * @param data Aukeratutako data.
	 * @param zinemak Zinema guztien array-ak.
	 * @param id_zinema Aukeratutako zinemaren id-a.
	 * @return Array bidimentsionala, non lehenengo zutabea orduak dira eta bigarrena saioaren id-a.
	 */
	public String[][] SaioOrduakId(int id_filma, String data, Zinema[] zinemak, int id_zinema) {
		String[][] orduak= new String[0][2];
		
		for(int j=0;j<zinemak[id_zinema-1].getAretoa().length;j++) {
			for(int k=0;k<zinemak[id_zinema-1].getAretoa()[j].getSaioak().length;k++) {
				int eguna = zinemak[id_zinema-1].getAretoa()[j].getSaioak()[k].getOrdua().get(Calendar.DAY_OF_MONTH);
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
					orduak_prov[orduak.length][0] = (zinemak[id_zinema-1].getAretoa()[j].getSaioak()[k].getOrdua().get(Calendar.HOUR)+12)+":"+zinemak[id_zinema-1].getAretoa()[j].getSaioak()[k].getOrdua().get(Calendar.MINUTE);
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
	
	/**
	 * Saioen orduak array batean gordetzen ditu.
	 * @param ordu_id Saioen orduak eta id-ak dituen array bidimentzionala.
	 * @return Saioen orduak array batean.
	 */
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
	
	/**
	 * Aukeratutako saioaren aretoa bilatu eta bueltatzen du.
	 * @param array_ordu_id Saioen orduak eta id-ak dituen array bidimentzionala.
	 * @param index Aukeratutako index-a.
	 * @param zinemak Zinema guztien array-a.
	 * @param id_zinema Aukeratutako zinemaren array-a.
	 * @return Aukeratutako saioaren aretoaren izena.
	 */
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
	
	/**
	 * Aukeratutako filmaren prezioa lortu.
	 * @param izenburua Filmaren izenburua.
	 * @param zinemak Zinema guztien array-a.
	 * @param id_zinema Aukeratutako zinemaren id-a.
	 * @return Aukeratutako filmaren prezioa.
	 */
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
	
	public Saioa[] SaioakGorde(Saioa[] saioak, Zinema zinema,Zinema[] zinemak,int id_saioa) {
		boolean aurkituta = false;
		
		for(int i=0;i<zinemak.length;i++) {
			if(zinemak[i].equals(zinema)) {		
				for(int k=0;k<zinema.getAretoa().length && !aurkituta;k++) {
					for(int j=0;j<zinema.getAretoa()[k].getSaioak().length && !aurkituta;j++) {
						if(zinema.getAretoa()[k].getSaioak()[j].getId_saioa()== id_saioa) {
							Saioa[] saioak_prob = new Saioa[saioak.length+1];
							for(int l=0;l<saioak.length;l++) {
								saioak_prob[l]= saioak[l];
							}						
							saioak_prob[saioak.length]=zinema.getAretoa()[k].getSaioak()[j];
							saioak = saioak_prob;
							aurkituta = true;
						}				
					}
				}
			}
		}
		return saioak;
	}
	
	public String[][] SaioakErakutsi(Saioa[] saioak, Zinema[] zinemak){
		String[][] laburpen_array = new String[0][7];
		boolean aurkituta = false;
		
		for(int l=0;l<saioak.length;l++) {
			aurkituta=false;
			for(int i=0;i<zinemak.length && !aurkituta;i++) {			
				for(int j=0;j<zinemak[i].getAretoa().length && !aurkituta;j++) {
					for(int h=0;h<zinemak[i].getAretoa()[j].getSaioak().length;h++) {
						if(zinemak[i].getAretoa()[j].getSaioak()[h].getId_saioa()==(saioak[l].getId_saioa())) {
							String[][] array_prob= new String[laburpen_array.length+1][7];
							for(int k=0;k<laburpen_array.length;k++) {
								for(int n=0;n<laburpen_array[k].length;n++) {
									array_prob[k][n]= laburpen_array[k][n];
								}
							}
							array_prob[laburpen_array.length][0]= zinemak[i].getIzenZin();
							array_prob[laburpen_array.length][1]= saioak[l].getFilma().getIzenburu();
							array_prob[laburpen_array.length][2]= saioak[l].getOrdua().get(Calendar.YEAR)+"-"+saioak[l].getOrdua().get(Calendar.MONTH)+"-"+saioak[l].getOrdua().get(Calendar.DAY_OF_MONTH);
							String ordua = String.format("%02d:%02d", (saioak[l].getOrdua().get(Calendar.HOUR)+12), saioak[l].getOrdua().get(Calendar.MINUTE));
							array_prob[laburpen_array.length][3]= ordua;
							array_prob[laburpen_array.length][4]= zinemak[i].getAretoa()[j].getIzenAret();
							array_prob[laburpen_array.length][5]= saioak[l].getFilma().getPrezioa()+"€";
							array_prob[laburpen_array.length][6]= String.valueOf(saioak[l].getId_saioa());
							laburpen_array = array_prob;
							aurkituta=true;							
						}
					}
				}
			}
		}
		
		return laburpen_array;
	}
	
	/**
	 * Erosketaren prezio totala deskonturik gabe.
	 * @param saioak Saio guztien array-a.
	 * @return Filmen prezioaren batuketa.
	 */
	public String PrezioTotalaKalkulatu(Saioa[] saioak) {
		float totala=0;
		
		DecimalFormat formato1 = new DecimalFormat("#.00");
		
		for(int i=0;i<saioak.length;i++) {
			totala+= saioak[i].getFilma().getPrezioa();
		}
		return formato1.format(totala);
	}
	
	/**
	 * Erosketaren deskontua kalkulatu.
	 * @param saio_laburpen Saioen arraya.
	 * @return <b>0</b> film bat badago, <b>20</b> film 2 badaude edo <b>30</b> hiru film edo gehiago badaude.
	 */
	public int DeskotuKalkulatu(Saioa[] saioak) {
		int deskontu = 0;
		
		if(saioak.length==2) {
			deskontu=20;
		}else if(saioak.length>=3) {
			deskontu=30;
		}		
		return deskontu;
	}

	/**
	 * Erosketaren prezio totala deskontuarekin.
	 * @param saio_laburpen Saioen array-a.
	 * @return Erosketaren prezioa deskontuarekin.
	 */
	public String PrezioTotalaKalkulatuDeskontuarekin(Saioa[] saioak) {
		float prezio_totala= 0;

		DecimalFormat formato1 = new DecimalFormat("#.00");
		
		for(int i=0;i<saioak.length;i++) {
			prezio_totala+=saioak[i].getFilma().getPrezioa();
		}		
		prezio_totala = (prezio_totala*(100-DeskotuKalkulatu(saioak)))/100;
		return formato1.format(prezio_totala);
	}
	
	/**
	 * Sartutako erabiltzailearen logina balidatzen du.
	 * @param erabiltzaile Sartutako erabiltzailea.
	 * @param pasahitza Sartutako pasahitza.
	 * @param bezeroak Bezero guztien array-a.
	 * @return <b>True</b> logina balidoa bada edo <b>False</b> logina okerra bada.
	 */
	public  boolean LoginBalidatu(String erabiltzaile, String pasahitza, Bezero[] bezeroak) {
		boolean balidatu= false;
		
		for(int i=0;i<bezeroak.length && !balidatu;i++) {
			if(bezeroak[i].getId_bezero().equalsIgnoreCase(erabiltzaile) && bezeroak[i].getPasahitza().equals(pasahitza)) {
				balidatu=true;
			}
		}
		return balidatu;
	}
	
	/**
	 * Erabiltzaile baten NAN-a balidatzen du.
	 * @param nan Erabiltzaileak sartutako NAN-a.
	 * @return <b>True</b> nan-a balidoa bada eta <b>False</b> nan-a ez bada balidoa.s
	 */
	public static boolean NanBalidatu(String nan) {
		boolean balidoa= false;
		
		String[] hizkiak = {"T", "R", "W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
		if(nan.length()==9){
			String[] holder = nan.split(String.valueOf(nan.charAt(8)));
		    int hondarra = Integer.parseInt(holder[0])%23;
		    if(hizkiak[hondarra].equals(String.valueOf(nan.charAt(8)).toUpperCase())){
		    	balidoa = true;
		    }
		}		
		return balidoa;
	}
	
	/**
	 * Sartutako erabilzaile berria balidatu eta erregistratzen du.
	 * @param bezeroak Bezero guztien array-a.
	 * @param id Bezeroaren id-a.
	 * @param izen Bezeroaren izena.
	 * @param abizen Bezeroaren abizena.
	 * @param adina Bezeroaren adina.
	 * @param sexua Bezeroaren sexua.
	 * @param nan Bezeroaren nan-a.
	 * @param pass Bezeroaren pasahitza.
	 * @return <b>True</b> erregistroa zuzena izan bada edo <b>False</b> erregistroa okerra izan bada.
	 */
	public  boolean RegistroaEgin(Bezero[] bezeroak, String id, String izen, String abizen, int adina, String sexua, String nan, String passa) {
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
				conn = (Connection) DriverManager.getConnection (url, erabiltzaile,pass);
				Statement comando = (Statement) conn.createStatement();						
										
				comando.executeUpdate( "INSERT INTO bezeroa VALUES ('"+id+"','"+izen+"','"+abizen+"',"+adina+",'"+sexua+"','"+nan+"','"+passa+"');");
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

	/**
	 * Erosketa objetu bat sortzen du.
	 * @param laburpen_array Erosketaren laburpenaren array-a.
	 * @param bezeroa Bezeroaren id-a.
	 * @param bezeroak Bezero guztien array-a.
	 * @return Erosketa objetua sarrerarik gabe.
	 */
	public Erosketa ErosketaSortu(String bezeroa, Bezero[] bezeroak,Saioa[] saioak) {
		Erosketa erosketa = new Erosketa();
		boolean aurkituta= false; 
		
		erosketa.setDeskontua(DeskotuKalkulatu(saioak));		
		String[] array_prob = PrezioTotalaKalkulatuDeskontuarekin(saioak).split(",");
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
	
	/**
	 * Erosketa datubasera pasatzen du.
	 * @param erosketa	Erosketa objetua.
	 * @param bezero_id Bezeroaren id-a.
	 */
	public void ErosketaGorde(Erosketa erosketa, String bezero_id) {
		
		Connection conn;					
		try {
			conn = (Connection) DriverManager.getConnection (url, erabiltzaile,pass);
			Statement comando = (Statement) conn.createStatement();		
		
			comando.executeUpdate( "INSERT INTO erosketa ("+deskontua+","+totala+","+id_bezeroa+") VALUES ("+erosketa.getDeskontua()+","+erosketa.getTotala()+",'"+bezero_id+"');");
			conn.close();
		}catch(SQLException ex) {
				System.out.println("SQLException: "+ ex.getMessage());
				System.out.println("SQLState: "+ ex.getSQLState());
				System.out.println("ErrorCode: "+ ex.getErrorCode());
		}		
	}
	
	/**
	 * Sortutako erosketaren sarrerak sortzen eta gordetzen ditu.
	 * @param erosketak Erosketa guztien array-a.
	 * @param erosketa Erosketa objetua.
	 * @param laburpen_array Erosketaren laburpenaren array-a.
	 * @param zinemak Zinema guztien array-a.
	 * @param id_zinema Zinemaren id-a.
	 * @return Erosketa guztien array-a azkeneko erosketaren sarrerekin.
	 */
	public Erosketa[] ErosketenSarrerakSortu(Erosketa[] erosketak,Erosketa erosketa,Saioa[] saioak) {
		Sarrera[] sarrerak= new Sarrera[0];
		
		for(int i=0;i<saioak.length;i++) {
			Sarrera sarrera = new Sarrera();
			Saioa saioa = saioak[i];			
			
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
	
	/**
	 * Sarrerak datu basera pasatzen du.
	 * @param erosketak Erosketa guztien array-a.
	 */
	public void SarrerakGorde(Erosketa[] erosketak) {
		int i=0;
		
		Connection conn;					
		try {
			conn = (Connection) DriverManager.getConnection (url, erabiltzaile,pass);
			Statement comando = (Statement) conn.createStatement();		
			while(i<erosketak[erosketak.length-1].getSarrera().length) {
				comando.executeUpdate("INSERT INTO sarrera ("+id_saioa+","+id_erosketa+") VALUES ("+erosketak[erosketak.length-1].getSarrera()[i].getSaioa().getId_saioa()+","+erosketak[erosketak.length-1].getId_erosketa()+");");
				i++;
			}
			conn.close();
		}catch(SQLException ex) {
				System.out.println("SQLException: "+ ex.getMessage());
				System.out.println("SQLState: "+ ex.getSQLState());
				System.out.println("ErrorCode: "+ ex.getErrorCode());
		}		
		
	}
	
	/**
	 * Azkenengo erosketaren tiketa sortzen du.
	 * @param erosketak Erosketa guztien array-a.
	 * @param zinemak Zinema guztien array-a.
	 */
	public void TiketaGorde(Erosketa[] erosketak, Zinema[] zinemak, String prezio_laburpen, String prezio_totala, int deskontua) {
		String zinema = "";
		String aretoa = "";
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.AM_PM, Calendar.AM);
		String cal_s = cal.get(Calendar.YEAR)+"_"+cal.get(Calendar.MONTH)+"_"+cal.get(Calendar.DAY_OF_MONTH)+"_"+cal.get(Calendar.HOUR)+"_"+cal.get(Calendar.MINUTE);
		File file = new File(cal_s+".txt");
		BufferedWriter fichero;
		
			try {
				fichero = new BufferedWriter(new FileWriter(file));
			for(int i =0;i<erosketak[erosketak.length-1].getSarrera().length;i++)
			{
				boolean aurkituta = false;
				for(int h=0;h<zinemak.length && !aurkituta;h++) {
					for(int k=0;k<zinemak[h].getAretoa().length && !aurkituta;k++) {
						for(int j=0;j<zinemak[h].getAretoa()[k].getSaioak().length && !aurkituta;j++) {
							if(zinemak[h].getAretoa()[k].getSaioak()[j].getId_saioa() == erosketak[erosketak.length-1].getSarrera()[i].getSaioa().getId_saioa()){
								zinema = zinemak[h].getIzenZin();
								aretoa = zinemak[h].getAretoa()[k].getIzenAret();
								aurkituta = true;
							}
						}
					}	
				}
				
				fichero.write("Zinema: "+zinema+", Aretoa :"+aretoa+", "+erosketak[erosketak.length-1].getSarrera()[i].toString()+"\n");
			}
			fichero.write("Prezio totala: "+prezio_laburpen+"€, Prezioa "+deskontua+"%-ko deskontuarekin: "+prezio_totala+"€\n");
			fichero.close();
			JOptionPane.showMessageDialog(null,
					"Tiketa sortu da "+cal_s+".txt fitxategian.",
					"Gordeta!",
					JOptionPane.INFORMATION_MESSAGE);
			
			} catch (IOException e1) {
				e1.printStackTrace();
			}			
	}
}
