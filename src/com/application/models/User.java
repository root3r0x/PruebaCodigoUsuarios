/**
 * 
 */
package com.application.models;

/**
 * @author ledes
 *
 */
public class User {
	
	private String nombre = "";
	private String apellidoPaterno = "";
	private String apellidoMaterno = "";
	private String correoUsuario = "";
	private String passwordUsuario = "";
	private int 	idUsuario = 0;
	
	
	public User() {
		
	}
	
	public User(int IdUsuarios, String Nombre, String APaterno, String AMaterno, String Correo, String Contra, int Edad) {
		IdUsuarios 	= 0;
		Nombre 		= "Usuario";
		APaterno 	= "Apellido Paterno";
		AMaterno 	= "Apellido Materno";
		Correo 		= "usuario@empresa.em";
		Contra 		= "password123";
		Edad 		= 0;
	}
	
	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * @return the apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	
	/**
	 * @param apellidoPaterno the apellidoPaterno to set
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	
	/**
	 * @return the apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	
	/**
	 * @param apellidoMaterno the apellidoMaterno to set
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	
	/**
	 * @return the correoUsuario
	 */
	public String getCorreoUsuario() {
		return correoUsuario;
	}
	
	/**
	 * @param correoUsuario the correoUsuario to set
	 */
	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}
	
	/**
	 * @return the passwordUsuario
	 */
	public String getPasswordUsuario() {
		return passwordUsuario;
	}
	
	/**
	 * @param passwordUsuario the passwordUsuario to set
	 */
	public void setPasswordUsuario(String passwordUsuario) {
		this.passwordUsuario = passwordUsuario;
	}
	
	/**
	 * @return the idUsuario
	 */
	public int getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
}
