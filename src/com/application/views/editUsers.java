package com.application.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class editUsers extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombreR;
	private JTextField txtAPaternoRegistrado;
	private JTextField txtApellidoMRegistrado;
	private JTextField txtCorreoRegistrado;
	private JTextField txtContraRegistrada;
	private JTextField txtNuevoNombre;
	private JTextField txtApellidoPNuevo;
	private JTextField txtApellidoMNuevo;
	private JTextField txtCorreoNuevo;
	private JTextField txtConfirmaCorreoNuevo;
	private JLabel lblNewLabel_2;
	private JLabel lblNombre;
	private JLabel lblApellidoP;
	private JLabel lblApellidoM;
	private JSeparator separator_1;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JPasswordField JPFContraNueva;
	private JPasswordField JPFConfirmaContraNueva;
	private JButton btnCancelar;
	private JButton btnActualizar;

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
		
		JComboBox cmbUsuarios = new JComboBox();
		cmbUsuarios.setFont(new Font("SpaceMono Nerd Font", Font.BOLD, 13));
		
		JLabel lblNewLabel = new JLabel("Seleccione c\u00F3digo de usuario.");
		lblNewLabel.setFont(new Font("SpaceMono Nerd Font", Font.BOLD, 16));
		
		JSeparator separator = new JSeparator();
		
		JLabel lblNewLabel_1 = new JLabel("Datos registrados");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("SpaceMono Nerd Font", Font.BOLD | Font.ITALIC, 13));
		
		lblNewLabel_2 = new JLabel("Datos actualizados");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("SpaceMono Nerd Font", Font.BOLD | Font.ITALIC, 13));
		
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
		
		lblNewLabel_6 = new JLabel("Correo Registrado");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("SpaceMono Nerd Font", Font.BOLD | Font.ITALIC, 13));
		
		lblNewLabel_7 = new JLabel("Contrase\u00F1a Registrada");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("SpaceMono Nerd Font", Font.BOLD | Font.ITALIC, 13));
		
		lblNewLabel_8 = new JLabel("Nuevo Correo");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("SpaceMono Nerd Font", Font.BOLD | Font.ITALIC, 13));
		
		lblNewLabel_9 = new JLabel("Nueva Contrase\u00F1a");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("SpaceMono Nerd Font", Font.BOLD | Font.ITALIC, 13));
		
		lblNewLabel_10 = new JLabel("Confirmar Correo");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("SpaceMono Nerd Font", Font.BOLD | Font.ITALIC, 13));
		
		lblNewLabel_11 = new JLabel("Confirmar Contrase\u00F1a");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setFont(new Font("SpaceMono Nerd Font", Font.BOLD | Font.ITALIC, 13));
		
		JPFContraNueva = new JPasswordField();
		JPFContraNueva.setFont(new Font("SpaceMono Nerd Font", Font.BOLD, 13));
		
		JPFConfirmaContraNueva = new JPasswordField();
		JPFConfirmaContraNueva.setFont(new Font("SpaceMono Nerd Font", Font.BOLD, 13));
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("SpaceMono Nerd Font Mono", Font.BOLD, 14));
		
		btnActualizar = new JButton("Actualizar");
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
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))
							.addComponent(txtNuevoNombre, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
							.addComponent(txtApellidoPNuevo, Alignment.LEADING)))
					.addGap(22))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 655, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(cmbUsuarios, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(29)))
					.addContainerGap(12, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 627, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(40, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_10, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(31, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnActualizar, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
							.addGap(12))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
							.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_11, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)))
					.addGap(19))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(7)
							.addComponent(cmbUsuarios, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)))
					.addGap(7)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
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
								.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addGap(12)
							.addComponent(txtContraRegistrada, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_10, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(JPFConfirmaContraNueva, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addComponent(JPFContraNueva, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_11, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnActualizar, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
