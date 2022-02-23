/**
 * @apiNote Mira
 * public static void main(String[] args) throws SQLException {
 * 
 * System.out.println("probando conexion"); Connection con = null;
 * 
 * try { con = getConnection(); System.out.println("Test");
 * System.out.println("Test2"); } catch (Exception e) { // TODO Auto-generated
 * catch block e.printStackTrace(); } System.out.println("OK");
 * if(!con.isClosed()) con.close();
 * 
 * }
 **/

package com.application.connections;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author ledes
 *
 */
public class ConnectionMYSQL {
	
	/*** Configuración de la BD.*/
	private static String USR = "root";
	private static String PASSWRD = "sa";
	private static String DATABASE = "library";
	private static String PORT = "3306";
	private static String MYSQLWARNIG = "?autoReconnect=true&useSSL=false";
	private static String urlMySQL  = "jdbc:mysql://localhost:"+ PORT +"/" + DATABASE + MYSQLWARNIG;
	
	public static  Connection getConnection() {
		
		java.lang.System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
		
		Connection con = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");	
			con = (Connection) DriverManager.getConnection(urlMySQL, USR, PASSWRD);
		} 
		catch (ClassNotFoundException e)	{
			// TODO: handle exception
			System.out.println("Exception 1 " + e.getMessage());
		} 
		catch(Exception e)	{
			System.out.println("Exception 2 " + e.getMessage());
		}
		return con;
	}
}
