/**
 * 
 */
package com.application.controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.application.connections.ConnectionMYSQL;
import com.application.models.User;
import com.mysql.jdbc.PreparedStatement;

/**
 * @author ledes
 *
 */
public class UserController extends ConnectionMYSQL{
	
	//Connection necesaria para realizar la conexion de la BD.
	Connection con = null;
	PreparedStatement ps;
	ResultSet rs;
	
	//Lista de usuarios.
	public static List<User> UsersList = new ArrayList<User>();
	User usersObj;
	
	//Agregar usuarios.
	public void addUsers(String nombre, String apellidoP, String apellidoM, String correoUsuario, String passwordUsuario) {
		
		try {
			
			con = getConnection();
			String sql = "INSERT INTO Usuarios(Nombre,Apellido_Paterno,Apellido_Materno,Correo_Usuario,Password_Usuario)"
					+ "VALUES (?, ?, ?, ?, ?);";
			ps = (PreparedStatement) con.prepareStatement(sql);
			
			ps.setString(1, nombre);
			ps.setString(2, apellidoP);
			ps.setString(3, apellidoM);
			ps.setString(4, correoUsuario);
			ps.setString(5, passwordUsuario);
			
			ps.executeUpdate();
			
			if(!con.isClosed())
				con.close();
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	
	//Editar usuarios.
	public void editUsers(int idUsuario, String nombre, String apellidoP, String apellidoM, String correoUsuario, String passwordUsuario) {
			
	}
	
	//Eliminar usuarios.
	public void deleteUsers(int idUsuario, String nombre, String correoUsuario) {
			
	}
	
	//Agregar a la lista.
	public void addUsers(User user) throws Exception {
		if(user.getNombre().isEmpty()) {
			System.out.println("Usuario vacio.");
		}else {
			UsersList.add(user);
		}
	}
	
	//Listar usuarios.
	public void listUsers(int idUsuario, String nombre, String apellidoP, String apellidoM, String correoUsuario, String passwordUsuario) {
		
	}
	
	public void listUsersBD()  throws Exception {
		
		UsersList.clear();
		try {
		
			con = getConnection();
			String sql  = "SELECT * FROM USUARIOS;";
			ps = (PreparedStatement) con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				usersObj = new User();
				
				usersObj.setIdUsuario(rs.getInt("idUsuario")); 
				usersObj.setNombre(rs.getString("Nombre"));
				usersObj.setApellidoPaterno(rs.getString("Apellido_Paterno"));
				usersObj.setApellidoMaterno(rs.getString("Apellido_Materno"));
				usersObj.setCorreoUsuario(rs.getString("Correo_Usuario"));
				usersObj.setPasswordUsuario(rs.getString("Password_Usuario"));
							
				UsersList.add(usersObj);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}finally {
			System.gc();
		}
			
	}
	
	//Listar usuarios.
	public List<User> listUsers() throws Exception{
			listUsersBD(); //Cargamos tabla en BD.
			return UsersList; //Mandamos lista.
		}
}
