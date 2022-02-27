package com.application.views;

import static java.awt.Color.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.application.models.User;

import javax.swing.JTextField;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class editUsers extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField txtNombreR;
	private static JTextField txtAPaternoRegistrado;
	private static JTextField txtApellidoMRegistrado;
	private static JTextField txtCorreoRegistrado;
	private static JTextField txtContraRegistrada;
	private static JTextField txtNuevoNombre;
	private static JTextField txtApellidoPNuevo;
	private static JTextField txtApellidoMNuevo;
	private static JTextField txtCorreoNuevo;
	private static JTextField txtConfirmaCorreoNuevo;
	private static JPasswordField JPFContraNueva;
	private static JPasswordField JPFConfirmaContraNueva;
	
	private JLabel lblDatosActualizados;
	private JLabel lblNombre;
	private JLabel lblApellidoP;
	private JLabel lblApellidoM;
	private JSeparator separator_1;
	private JLabel lblCorreoRegistrado;
	private JLabel lblContraRegistrada;
	private JLabel lblCorreoNuevo;
	private JLabel lblNuevaContra;
	private JLabel lblConfirmarCorreo;
	private JLabel lblConfirmarContra;

	private JButton btnCancelar;
	private JButton btnActualizar;
	
	private static User usuarioEditar;
	private static List<User> listaUsuarios = new ArrayList<User>();
	
	private static JComboBox<String> cmbUsuarios = new JComboBox<String>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editUsers frame = new editUsers();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//Manejar por formulario.
	public static void getUsuarioForm(User usuario, ArrayList<User> Usuarios) {
		
		listaUsuarios.clear();
		
		usuarioEditar = usuario;
		listaUsuarios = Usuarios;	
		
		llenarCombo(usuario.getIdUsuario(), cmbUsuarios);
		cmbUsuarios.setSelectedItem(usuarioEditar.getIdUsuario() + " " + usuarioEditar.getNombre());
		
		
		
		System.out.println(usuario.getIdUsuario() + usuario.getNombre());
		
		
		txtNombreR.setText(usuarioEditar.getNombre());
		txtAPaternoRegistrado.setText(usuarioEditar.getApellidoPaterno());
		txtApellidoMRegistrado.setText(usuarioEditar.getApellidoMaterno());
		txtCorreoRegistrado.setText(usuarioEditar.getCorreoUsuario());
		txtContraRegistrada.setText(usuarioEditar.getPasswordUsuario());
		
		txtNuevoNombre.setText(usuarioEditar.getNombre());
		txtApellidoPNuevo.setText(usuarioEditar.getApellidoPaterno());
		txtApellidoMNuevo.setText(usuarioEditar.getApellidoMaterno());
		txtCorreoNuevo.setText(usuarioEditar.getCorreoUsuario());
		txtConfirmaCorreoNuevo.setText(usuarioEditar.getCorreoUsuario());
		
	}
	
	
	public static void llenarCombo(int idUser, JComboBox<String> cmbIDS) {
		for(User u: listaUsuarios) {
			cmbIDS.addItem(u.getIdUsuario() + " " + u.getNombre());
		}
	}
	
	public static void validaTextos(String valor, String msg, JTextField txtValor) {
		if(valor.isEmpty() || valor.isBlank()) {
			valor = JOptionPane.showInputDialog(msg);
			txtValor.setText(valor);
		}
	}
	
	public static void validaTextos(String valor, String Compara,String msg, JTextField txtValor, JTextField txtValorCompara, JLabel lblMensaje) {
	
		if(valor.isEmpty() || valor.isBlank()) {
			valor = JOptionPane.showInputDialog("¡" + msg + " invalido! Ingrese un valor: ");
			txtValor.setText(valor);
			txtValorCompara.setText(valor);
		}
		
		if(!valor.equals(Compara)) {
			JOptionPane.showMessageDialog(txtValor, "El valor "+ msg + " no puede ser igual al ya registrado.");
         lblMensaje.setForeground(RED);
         lblMensaje.setText("Revisar el dato ingresado.");
         txtValor.setFocusable(true);
	   }
   }
	/**
	 * Create the frame.
	 */
	public editUsers() {
		setTitle("Editar Usuario");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 598);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		txtNombreR = new JTextField();
		txtNombreR.setEditable(false);
		txtNombreR.setFont(new Font("SpaceMono NF", Font.BOLD, 13));
		txtNombreR.setColumns(10);
		
		txtAPaternoRegistrado = new JTextField();
		txtAPaternoRegistrado.setEditable(false);
		txtAPaternoRegistrado.setFont(new Font("SpaceMono NF", Font.BOLD, 13));
		txtAPaternoRegistrado.setColumns(10);
		
		txtApellidoMRegistrado = new JTextField();
		txtApellidoMRegistrado.setEditable(false);
		txtApellidoMRegistrado.setFont(new Font("SpaceMono NF", Font.BOLD, 13));
		txtApellidoMRegistrado.setColumns(10);
		
		txtCorreoRegistrado = new JTextField();
		txtCorreoRegistrado.setEditable(false);
		txtCorreoRegistrado.setFont(new Font("SpaceMono NF", Font.BOLD, 13));
		txtCorreoRegistrado.setColumns(10);
		
		txtContraRegistrada = new JTextField();
		txtContraRegistrada.setEditable(false);
		txtContraRegistrada.setFont(new Font("SpaceMono NF", Font.BOLD, 13));
		txtContraRegistrada.setColumns(10);
		
		txtNuevoNombre = new JTextField();
		txtNuevoNombre.setFont(new Font("SpaceMono NF", Font.BOLD, 13));
		txtNuevoNombre.setColumns(10);
		
		txtApellidoPNuevo = new JTextField();
		txtApellidoPNuevo.setFont(new Font("SpaceMono NF", Font.BOLD, 13));
		txtApellidoPNuevo.setColumns(10);
		
		txtApellidoMNuevo = new JTextField();
		txtApellidoMNuevo.setFont(new Font("SpaceMono NF", Font.BOLD, 13));
		txtApellidoMNuevo.setColumns(10);
		
		txtCorreoNuevo = new JTextField();
		txtCorreoNuevo.setFont(new Font("SpaceMono NF", Font.BOLD, 13));
		txtCorreoNuevo.setColumns(10);
		
		txtConfirmaCorreoNuevo = new JTextField();
		txtConfirmaCorreoNuevo.setFont(new Font("SpaceMono NF", Font.BOLD, 13));
		txtConfirmaCorreoNuevo.setColumns(10);
		
		cmbUsuarios.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				Object item = cmbUsuarios.getSelectedItem();  
				String itemString = item.toString();
				
				for(User u: listaUsuarios) {
					
					if(itemString.equals(u.getIdUsuario() + " " + u.getNombre())) {
						
						//usuarioEditar.setIdUsuario(u.getIdUsuario());
						//System.out.println("usuarioEditar= " + usuarioEditar.getIdUsuario());
						
						txtNombreR.setText(u.getNombre());
						txtAPaternoRegistrado.setText(u.getApellidoPaterno());
						txtApellidoMRegistrado.setText(u.getApellidoMaterno());
						txtCorreoRegistrado.setText(u.getCorreoUsuario());
						txtContraRegistrada.setText(u.getPasswordUsuario());
						  
						txtNuevoNombre.setText(u.getNombre());
						txtApellidoPNuevo.setText(u.getApellidoPaterno());
						txtApellidoMNuevo.setText(u.getApellidoMaterno());
						txtCorreoNuevo.setText(u.getCorreoUsuario());
						txtConfirmaCorreoNuevo.setText(u.getCorreoUsuario());
						}
					}
				//System.gc();
			}
		});
		
		cmbUsuarios.setFont(new Font("SpaceMono Nerd Font", Font.BOLD, 13));
		JLabel lblComboboxCodigoUsuaio = new JLabel("Seleccione c\u00F3digo de usuario.");
		lblComboboxCodigoUsuaio.setFont(new Font("SpaceMono Nerd Font", Font.BOLD, 16));
		
		JSeparator separator = new JSeparator();
		
		JLabel lblNewLabel_1 = new JLabel("Datos registrados");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("SpaceMono Nerd Font", Font.BOLD | Font.ITALIC, 13));
		
		lblDatosActualizados = new JLabel("Nuevos  Datos ");
		lblDatosActualizados.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosActualizados.setFont(new Font("SpaceMono Nerd Font", Font.BOLD | Font.ITALIC, 13));
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("SpaceMono Nerd Font", Font.BOLD | Font.ITALIC, 13));
		
		lblApellidoP = new JLabel("Apellido Paterno");
		lblApellidoP.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellidoP.setFont(new Font("SpaceMono Nerd Font", Font.BOLD | Font.ITALIC, 13));
		
		lblApellidoM = new JLabel("Apellido Materno");
		lblApellidoM.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellidoM.setFont(new Font("SpaceMono Nerd Font", Font.BOLD | Font.ITALIC, 13));
		
		separator_1 = new JSeparator();
		
		lblCorreoRegistrado = new JLabel("Correo Registrado");
		lblCorreoRegistrado.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorreoRegistrado.setFont(new Font("SpaceMono Nerd Font", Font.BOLD | Font.ITALIC, 13));
		
		lblContraRegistrada = new JLabel("Contrase\u00F1a Registrada");
		lblContraRegistrada.setHorizontalAlignment(SwingConstants.CENTER);
		lblContraRegistrada.setFont(new Font("SpaceMono Nerd Font", Font.BOLD | Font.ITALIC, 13));
		
		lblCorreoNuevo = new JLabel("Nuevo Correo");
		lblCorreoNuevo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorreoNuevo.setFont(new Font("SpaceMono Nerd Font", Font.BOLD | Font.ITALIC, 13));
		
		lblNuevaContra = new JLabel("Nueva Contrase\u00F1a");
		lblNuevaContra.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevaContra.setFont(new Font("SpaceMono Nerd Font", Font.BOLD | Font.ITALIC, 13));
		
		lblConfirmarCorreo = new JLabel("Confirmar Correo");
		lblConfirmarCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmarCorreo.setFont(new Font("SpaceMono Nerd Font", Font.BOLD | Font.ITALIC, 13));
		
		lblConfirmarContra = new JLabel("Confirmar Contrase\u00F1a");
		lblConfirmarContra.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmarContra.setFont(new Font("SpaceMono Nerd Font", Font.BOLD | Font.ITALIC, 13));
		
		JPFContraNueva = new JPasswordField();
		JPFContraNueva.setFont(new Font("SpaceMono Nerd Font", Font.BOLD, 13));
		
		JPFConfirmaContraNueva = new JPasswordField();
		JPFConfirmaContraNueva.setFont(new Font("SpaceMono Nerd Font", Font.BOLD, 13));
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UsersHome home = new UsersHome();
				home.setVisible(true);
				dispose();
				
			}
		});
		btnCancelar.setFont(new Font("SpaceMono Nerd Font Mono", Font.BOLD, 14));
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int 	IDUsuario 		= 0; //usuarioEditar.getIdUsuario();
				String 	nombre 			= txtNuevoNombre.getText();
				String 	APaterno 		= txtApellidoPNuevo.getText();
				String 	AMaterno 		= txtApellidoMNuevo.getText();
				
				String 	Email			= txtCorreoNuevo.getText();
				String 	ConfirmaEmail 	= txtConfirmaCorreoNuevo.getText();
				
				String 	Contra 			= JPFContraNueva.getPassword().toString();
				String 	ConfirmaContra 	= JPFConfirmaContraNueva.getPassword().toString();
				
				//System.out.println("IDUSUARIO: " + IDUsuario + " Nombre: " + nombre);
				
				//validaTextos(nombre,  "Nombre no valido, ingrese un nuevo valor: ",txtNuevoNombre);
				//validaTextos(APaterno,"A. Paterno no valido, ingrese nuevo valor: ", txtApellidoPNuevo);
				//validaTextos(AMaterno,"A. Materno no valido, ingrese nuevo valor: ", txtApellidoMNuevo);
				
				//validaTextos(Email, "Email no valido, ingrese un nuevo valor: ", txtCorreoNuevo);
				//validaTextos(ConfirmaEmail, "Debe confirmar el email: ", txtConfirmaCorreoNuevo);
				
				//validaTextos(Contra, " Password no valido, ingrese un nuevo valor: ", JPFContraNueva);
				//validaTextos(ConfirmaContra, JPFConfirmaContraNueva);
				
				//validaTextos(Contra, ConfirmaContra, JPFContraNueva, JPFConfirmaContraNueva);
				//validaTextos(Contra, JPFContraNueva, ConfirmaContra, JPFConfirmaContraNueva);
				
			}
		});
		btnActualizar.setFont(new Font("SpaceMono Nerd Font Mono", Font.BOLD, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtNombreR, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
							.addGap(15))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
							.addGap(214))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtAPaternoRegistrado, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblApellidoP, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(txtApellidoMRegistrado, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtCorreoRegistrado, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblApellidoM, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtCorreoNuevo, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(txtContraRegistrada, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(JPFContraNueva, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(txtConfirmaCorreoNuevo, 212, 212, 212)
							.addComponent(JPFConfirmaContraNueva, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(txtApellidoMNuevo)
								.addGap(2)))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(5)
								.addComponent(lblDatosActualizados, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))
							.addComponent(txtNuevoNombre, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
							.addComponent(txtApellidoPNuevo, Alignment.LEADING)))
					.addGap(22))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 655, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(12, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(cmbUsuarios, 0, 191, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(lblComboboxCodigoUsuaio, GroupLayout.PREFERRED_SIZE, 429, GroupLayout.PREFERRED_SIZE)
							.addGap(29))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 627, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(40, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCorreoRegistrado, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblCorreoNuevo, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblConfirmarCorreo, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(31, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnActualizar, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
							.addGap(12))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblContraRegistrada, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
							.addComponent(lblNuevaContra, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblConfirmarContra, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)))
					.addGap(19))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblComboboxCodigoUsuaio, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(7)
							.addComponent(cmbUsuarios, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)))
					.addGap(7)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDatosActualizados, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtNombreR, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtNuevoNombre, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtAPaternoRegistrado, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtApellidoPNuevo, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblApellidoP, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtApellidoMRegistrado, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblApellidoM, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtApellidoMNuevo, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtCorreoRegistrado, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCorreoNuevo, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtConfirmaCorreoNuevo, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCorreoRegistrado, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCorreoNuevo, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addGap(12)
							.addComponent(txtContraRegistrada, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblConfirmarCorreo, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(JPFConfirmaContraNueva, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addComponent(JPFContraNueva, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblContraRegistrada, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNuevaContra, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblConfirmarContra, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnActualizar, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
