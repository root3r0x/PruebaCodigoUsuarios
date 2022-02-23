package com.application.views;

import static java.awt.Color.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.application.controllers.UserController;
import com.application.models.User;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class addUsers extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JTextField txtApellidoP;
	private JLabel lblPaterno;
	private JLabel lblMaterno;
	private JTextField txtApellidoM;
	private JLabel lblConfirmarEmail;
	private JTextField txtConfirmEmail;
	private JLabel lblIngresarContrasea;
	private JLabel lblConfirmarContrasea;
	private JLabel lblIngresarNombre;
	private JTextField txtNombre;
	private JButton btnCancelar;
	private JLabel lblEmail;
	private JPasswordField JPFConfirmaContra;
	private JPasswordField JPFContra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addUsers frame = new addUsers();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void limpiarCampos() {
		txtApellidoM.setText("");
		txtApellidoP.setText("");
		JPFContra.setText("");
		JPFConfirmaContra.setText("");
		txtNombre.setText("");
		txtConfirmEmail.setText("");
		txtEmail.setText("");
	}
	
	/**
	 * Create the frame.
	 */
	public addUsers() {
		
		setResizable(false);
		setTitle("Registrar Usuarios.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//Aqui va el codigo del aceptar.
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String Email 			= txtEmail.getText();
				String ConfirmaEmail 	= txtConfirmEmail.getText();
				
				char[] jpfContra 		= JPFContra.getPassword();
				char[] jpfCContra		= JPFConfirmaContra.getPassword();
				
				String Contra 			= String.valueOf(jpfContra);
				String ConfirmaContra 	= String.valueOf(jpfCContra);
				
				String Nombre 			= txtNombre.getText();
				String APaterno 		= txtApellidoP.getText();
				String AMaterno 		= txtApellidoM.getText();
				
				Boolean agrega 			= true;
				
				try {
					
					/**Validaciones de las cajas de texto.**/
					
					//Validar campos vacios.
					if(Email.isEmpty() 	|| ConfirmaEmail.isEmpty() || Email.isBlank() || ConfirmaEmail.isBlank()){
						
						Email = JOptionPane.showInputDialog("Campo Email vacio ingrese un valor.");
						ConfirmaEmail = Email;
						
						txtEmail.setText(Email);
						txtConfirmEmail.setText(Email);
						
						agrega = false;
					}

					if(Contra.isEmpty() || ConfirmaContra.isEmpty() || Contra.isBlank() || ConfirmaContra.isBlank()) {
						
						Contra =	JOptionPane.showInputDialog(btnAceptar,"Campo Password vacio ingrese un valor.");
						ConfirmaContra = Contra;
					
						JPFContra.setText(Contra);
						JPFConfirmaContra.setText(Contra);
						
						agrega = false;
						//throw new StringConcatException(ConfirmaContra, null); //Mensaje null -> objeto.
					}
					
					if(Nombre.isEmpty() || Nombre.equals("") || Nombre.isBlank()) {
						Nombre = JOptionPane.showInputDialog(btnAceptar,"Ingrese un Nombre(s):");
						txtNombre.setText(Nombre);
						
						agrega = false;
					}
					
					if(APaterno.isEmpty() || APaterno.isBlank() || APaterno.equals("")) {
						APaterno = JOptionPane.showInputDialog(btnAceptar,"Ingrese Apellido[P]:");
						txtApellidoP.setText(APaterno);
						
						agrega = false;
					}
					
					if(AMaterno.isEmpty() || AMaterno.isBlank() || AMaterno.equals("")) {
						AMaterno = JOptionPane.showInputDialog(btnAceptar,"Ingrese Apellido[M]:");
						txtApellidoM.setText(AMaterno);
						
						agrega = false;
					}
					
					//Valida igualdades en confimaciones
					if(!Email.equals(ConfirmaEmail))
					{
						lblConfirmarEmail.setForeground(RED);
						JOptionPane.showMessageDialog(btnAceptar, "Verificar email.");
						txtEmail.setText(null);
						txtConfirmEmail.setText(null);
						
						agrega = false;	
					}
					
					if(!Contra.equals(ConfirmaContra)) {
						lblConfirmarContrasea.setForeground(RED);
						JOptionPane.showMessageDialog(btnAceptar, "Verificar contraseña.");
						
						JPFContra.setText(null);
						JPFConfirmaContra.setText(null);
						
						agrega = false;
					}
					if(agrega==true) {
						
						//0 = YES, 1 = NO, 2 = Cancel.
						int op = JOptionPane.showConfirmDialog(btnAceptar, "¿Son correctos los datos?");
					
						//Objeto para usar metodos.
						UserController userC = new UserController();
						
						if(op==0) {
							
							User usuario = new User();
							usuario.setNombre(Nombre);
							usuario.setApellidoPaterno(APaterno);
							usuario.setApellidoMaterno(AMaterno);
							usuario.setCorreoUsuario(Email);
							usuario.setPasswordUsuario(Contra);
							
							userC.addUsers(usuario);
							userC.addUsers(Nombre, APaterno, AMaterno, Email, Contra);
							userC.listUsersBD();
							limpiarCampos();
							JOptionPane.showMessageDialog(btnAceptar, "Usuario: " + Nombre + " ¡agregado exitosamente!.");
						}
						
						if(op==2) {
							limpiarCampos();
						}
						
					}
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showInputDialog(" Error: " + e2.getMessage());
					System.out.println("Error tipo: " + e2.getMessage());
				}
				System.gc();
			}
		});
		btnAceptar.setFont(new Font("SpaceMono NF", Font.BOLD, 15));
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("SpaceMono Nerd Font", Font.BOLD, 14));
		txtEmail.setColumns(10);
		
		txtApellidoP = new JTextField();
		txtApellidoP.setFont(new Font("SpaceMono Nerd Font", Font.BOLD, 14));
		txtApellidoP.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Apellidos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("SpaceMono Nerd Font", Font.BOLD, 15));
		
		lblPaterno = new JLabel("Paterno");
		lblPaterno.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaterno.setFont(new Font("SpaceMono Nerd Font Mono", Font.BOLD, 15));
		
		lblMaterno = new JLabel("Materno");
		lblMaterno.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaterno.setFont(new Font("SpaceMono Nerd Font Mono", Font.BOLD, 15));
		
		txtApellidoM = new JTextField();
		txtApellidoM.setFont(new Font("SpaceMono Nerd Font", Font.BOLD, 14));
		txtApellidoM.setColumns(10);
		
		lblConfirmarEmail = new JLabel("Confirmar Email");
		lblConfirmarEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmarEmail.setFont(new Font("SpaceMono Nerd Font Mono", Font.BOLD, 15));
		
		//Borrar esto.
		lblEmail = new JLabel("Confirmar Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("SpaceMono Nerd Font Mono", Font.BOLD, 15));
		
		txtConfirmEmail = new JTextField();
		txtConfirmEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				lblConfirmarEmail.setForeground(BLACK);
			}
		});
		//aqui va el codigo del evento
		txtConfirmEmail.setFont(new Font("SpaceMono Nerd Font", Font.BOLD, 14));
		txtConfirmEmail.setColumns(10);
		
		lblIngresarContrasea = new JLabel("Ingresar Contrase\u00F1a");
		lblIngresarContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresarContrasea.setFont(new Font("SpaceMono Nerd Font Mono", Font.BOLD, 15));
		
		lblConfirmarContrasea = new JLabel("Confirmar Contrase\u00F1a");
		lblConfirmarContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmarContrasea.setFont(new Font("SpaceMono Nerd Font Mono", Font.BOLD, 15));
		
		lblIngresarNombre = new JLabel("Ingresar Nombre");
		lblIngresarNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIngresarNombre.setFont(new Font("SpaceMono Nerd Font Mono", Font.BOLD, 15));
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("SpaceMono Nerd Font", Font.BOLD, 14));
		txtNombre.setColumns(10);
		
		btnCancelar = new JButton("Cancelar");
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//Creamos objeto del formulario principal.
				UsersHome home = new UsersHome();
				
				//Objeto para usar metodos.
				UserController userC = new UserController();
				
				home.setVisible(true);
				
				try {
					userC.listUsersBD();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				dispose();
				System.gc();
				
			}
		});
		btnCancelar.setFont(new Font("SpaceMono NF", Font.BOLD, 15));
		
		JPFConfirmaContra = new JPasswordField();
		JPFConfirmaContra.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				lblConfirmarContrasea.setForeground(BLACK);
			}
		});
		JPFConfirmaContra.setFont(new Font("SpaceMono Nerd Font", Font.BOLD, 14));
		
		JPFContra = new JPasswordField();
		JPFContra.setFont(new Font("SpaceMono Nerd Font", Font.BOLD, 14));
		
		JLabel lblIngresaEmail = new JLabel("Ingrese Email");
		lblIngresaEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresaEmail.setFont(new Font("SpaceMono Nerd Font Mono", Font.BOLD, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnCancelar, GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblPaterno, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtApellidoP, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblMaterno, GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
										.addComponent(txtApellidoM, GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)))
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblIngresaEmail, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE))
									.addGap(10)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblConfirmarEmail, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE))
										.addComponent(txtConfirmEmail, GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(JPFContra, Alignment.LEADING)
											.addComponent(lblIngresarContrasea, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblIngresarNombre, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(18)
											.addComponent(lblConfirmarContrasea, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(txtNombre, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
												.addComponent(JPFConfirmaContra, GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE))))))))
					.addGap(19))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblConfirmarEmail, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIngresaEmail, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtConfirmEmail, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIngresarContrasea, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblConfirmarContrasea, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(JPFContra, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(JPFConfirmaContra, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIngresarNombre, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(31)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtApellidoP, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtApellidoM, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblMaterno, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblPaterno, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
