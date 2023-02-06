package Controlador;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Metodoak {
	public static String[][] FilmQuery(int aukera){
		String[][] film_array= new String[0][0];
		Connection conn;					
		try {
			String url = "jdbc:mysql://localhost:3306/db_zinema";
			conn = (Connection) DriverManager.getConnection (url, "root","");
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
