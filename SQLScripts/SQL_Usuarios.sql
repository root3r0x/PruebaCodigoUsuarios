USE library;
CREATE TABLE Usuarios(
	idUsuario 			INT auto_increment not null primary KEY,
	Nombre 				VARCHAR(50),
    Apellido_Paterno 	VARCHAR(50),
    Apellido_Materno 	VARCHAR(50),
    Correo_Usuario	 	VARCHAR(50),
    Password_Usuario 	VARCHAR(50)
);
SELECT * FROM USUARIOS;

SELECT idUsuario as 'Código',
	Nombre as 'Nombre', 
	Apellido_Materno as 'Apellido Paterno',
	Apellido_Materno as 'Apellido Materno', 
	Correo_Usuario as 'Email', 
	Password_Usuario as 'Contraseña' 
FROM usuarios;

DELETE FROM USUARIOS
WHERE idUsuario != 0;

INSERT INTO Usuarios(Nombre,Apellido_Paterno,Apellido_Materno,Correo_Usuario,Password_Usuario)
VALUES ('MIGUEL GUADALUPE', 'LEDESMA', 'DUARTE', 'miguel@gmail.com', 'gmeigel');

UPDATE usuarios SET 
	Nombre='Root3r0x',
	Apellido_Paterno='Faber',
    Apellido_Materno='Zaner',
    Correo_Usuario='faber@protonmail.com', 
    Password_Usuario='Root3r0x123'
WHERE idUsuario=9;

SELECT * FROM LIBROS_TEST;