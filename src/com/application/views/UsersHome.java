package com.application.views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.application.controllers.UserController;
import com.application.models.User;
import javax.swing.ListSelectionModel;


@SuppressWarnings("serial")
public class UsersHome extends JFrame {

	private JPanel contentPane;
	private JTable usersTable;
	private UserController usuario = new UserController();
	private List<User> listaUsuarios = new ArrayList<User>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsersHome frame = new UsersHome();
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
	public UsersHome() {
		setType(Type.POPUP);
		setResizable(false);
		setTitle("Aplicacion registro de usuarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 988, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		JLabel lblListaUsuarios = new JLabel("Lista de Usuarios registrados");
		lblListaUsuarios.setFont(new Font("SpaceMono NF", Font.BOLD, 18));
		lblListaUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaUsuarios.setBounds(10, 0, 928, 45);
		contentPane.add(lblListaUsuarios);
		
		JButton btnAgregar = new JButton("Agregar ");
		btnAgregar.addActionListener(new ActionListener() {
			//Creamos objeto del formulario
			addUsers registro = new addUsers();
			public void actionPerformed(ActionEvent e) {
				
				//LLamar al formulario agregar.
				registro.setVisible(true);
				registro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				dispose(); //Cerramos la ventana actual.
			}
		});
		btnAgregar.setFont(new Font("SpaceMono NF", Font.BOLD, 15));
		btnAgregar.setBounds(784, 159, 178, 45);
		contentPane.add(btnAgregar);
		 	
		JButton btnEditar = new JButton("Editar");
		
		btnEditar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int i = usersTable.getSelectedRow();
				if(i>-1)
				{	
					User usuario = new User();
					editUsers editar = new editUsers();
					
					usuario.setIdUsuario( (int) (usersTable.getValueAt(i, 0)));
					usuario.setNombre(usersTable.getValueAt(i, 1).toString());
					usuario.setApellidoPaterno((usersTable.getValueAt(i, 2).toString()));
					usuario.setApellidoMaterno((usersTable.getValueAt(i, 3).toString()));
					usuario.setCorreoUsuario((usersTable.getValueAt(i, 4).toString()));
					usuario.setPasswordUsuario((usersTable.getValueAt(i, 5).toString()));
					
					editUsers.getUsuarioForm(usuario,(ArrayList<User>) listaUsuarios);
					editar.setVisible(true);
					//editar.setAlwaysOnTop(true);
					//dispose();
				}else {
					JOptionPane.showMessageDialog(btnEditar, "Debe seleccionar un usuario a editar.");
				}
			}
		});
		btnEditar.setFont(new Font("SpaceMono NF", Font.BOLD, 15));
		btnEditar.setBounds(784, 215, 178, 45);
		contentPane.add(btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("SpaceMono NF", Font.BOLD, 15));
		btnEliminar.setBounds(784, 273, 178, 45);
		contentPane.add(btnEliminar);
		
		JButton btnActualizarLista = new JButton("Actualizar Lista");
		btnActualizarLista.setFont(new Font("SpaceMono NF", Font.BOLD, 15));
		btnActualizarLista.setBounds(784, 103, 178, 45);
		contentPane.add(btnActualizarLista);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}
		});
		btnSalir.setFont(new Font("SpaceMono NF", Font.BOLD, 15));
		btnSalir.setBounds(784, 429, 178, 45);
		contentPane.add(btnSalir);
		
		usersTable = new JTable();
		usersTable.setDefaultEditor(Object.class, null);
		usersTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		usersTable.setColumnSelectionAllowed(true);
		
		try {
			usuario.listUsersBD();
			listaUsuarios = usuario.listUsers();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Object[] roww= new Object[6];
		String[] titulos = {"ID Usuario", "Nombre", "Apellido Paterno", "Apellido Materno", "Email", "Contrase\u00F1a"};
		
		DefaultTableModel modelo = new DefaultTableModel(null,titulos);
		
		for(User u : listaUsuarios) {
			roww[0] = u.getIdUsuario();
			roww[1] = u.getNombre();
			roww[2] = u.getApellidoPaterno();
			roww[3] = u.getApellidoMaterno();
			roww[4] = u.getCorreoUsuario();
			roww[5] = u.getPasswordUsuario();
			
			modelo.addRow(roww);
		}	
		usersTable.setModel(modelo);
		usersTable.setToolTipText("");
		usersTable.setFont(new Font("SpaceMono Nerd Font", Font.BOLD, 13));
		usersTable.setBounds(10, 103, 764, 371);
		contentPane.add(usersTable);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("SpaceMono Nerd Font Mono", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 72, 91, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("SpaceMono Nerd Font Mono", Font.BOLD, 13));
		lblNombre.setBounds(112, 72, 91, 20);
		contentPane.add(lblNombre);
		
		JLabel lblApellidoPaterno = new JLabel("Apellido Paterno");
		lblApellidoPaterno.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellidoPaterno.setFont(new Font("SpaceMono Nerd Font Mono", Font.BOLD, 13));
		lblApellidoPaterno.setBounds(226, 72, 145, 20);
		contentPane.add(lblApellidoPaterno);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido Materno");
		lblApellidoMaterno.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellidoMaterno.setFont(new Font("SpaceMono Nerd Font Mono", Font.BOLD, 13));
		lblApellidoMaterno.setBounds(368, 72, 151, 20);
		contentPane.add(lblApellidoMaterno);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorreo.setFont(new Font("SpaceMono Nerd Font Mono", Font.BOLD, 13));
		lblCorreo.setBounds(506, 72, 91, 20);
		contentPane.add(lblCorreo);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setFont(new Font("SpaceMono Nerd Font Mono", Font.BOLD, 13));
		lblContrasea.setBounds(637, 72, 91, 20);
		contentPane.add(lblContrasea);
	}
}
