package ventana;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import Clases.Usuario;
import BD.BD;

public class VentanaPerfil extends JFrame {

	protected Container cp;
	protected JPanel panel,panelLabel,panelDni,panelNombre,panelApellido,panelEmail,panelUsuario,panelContrasenya,panelNcuenta,panelBotones,panelEditar,panelAceptar,panelBorrar,panelAtras;
	protected JTextField textoDni,textoNombre,textoApellido,textoEmail,textoUsuario,textoContrasenya,textoNcuenta;
	protected JLabel label;
	protected JButton botonEditar,botonAceptar,botonBorrar,botonAtras;
	protected BD bd = new BD();

	public VentanaPerfil(Usuario uActual) {
		
		cp = this.getContentPane();
		this.setTitle("Mi Perfil");
		//panelPrincip
		panel = new JPanel();
		panel.setLayout(new GridLayout(9,1));
		
		//panelLabel
		panelLabel = new JPanel();
		label = new JLabel();
		label.setIcon(new ImageIcon("images/BETH.png"));
		
		//panelDni
		panelDni = new JPanel();
		textoDni = new JTextField();
		textoDni.setPreferredSize(new Dimension (200, 25));
		textoDni.setText(uActual.getDni());
		textoDni.setEnabled(false);
	
		
		//panelNombre
		panelNombre = new JPanel();
		textoNombre = new JTextField();
		textoNombre.setPreferredSize(new Dimension (200, 25));
		textoNombre.setText(uActual.getNombre());
		textoNombre.setEnabled(false);
		
		//panelApellido
		panelApellido = new JPanel();
		textoApellido = new JTextField();
		textoApellido.setPreferredSize(new Dimension (200, 25));
		textoApellido.setText(uActual.getApellido());
		textoApellido.setEnabled(false);
		
		//panelEmail
		panelEmail = new JPanel();
		textoEmail = new JTextField();
		textoEmail.setPreferredSize(new Dimension (200, 25));
		textoEmail.setText(uActual.getEmail());
		textoEmail.setEnabled(false);
		
		//panelUsuario
		panelUsuario = new JPanel();
		textoUsuario = new JTextField();
		textoUsuario.setPreferredSize(new Dimension (200, 25));
		textoUsuario.setText(uActual.getLogin());
		textoUsuario.setEnabled(false);
		
		//panelContrasenya --> visible al usuario asiq textfield normal
		panelContrasenya = new JPanel();
		textoContrasenya = new JTextField();
		textoContrasenya.setPreferredSize(new Dimension (200, 25));
		textoContrasenya.setText(uActual.getContrasenya());
		textoContrasenya.setEnabled(false);
		
		//panelNCuenta
		panelNcuenta = new JPanel();
		textoNcuenta = new JTextField();
		textoNcuenta.setPreferredSize(new Dimension (200, 25));
		textoNcuenta.setText(uActual.getTarjeta());
		textoNcuenta.setEnabled(false);
		
		//panelBotones
		panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(2,2));
		
		//panel EDITAR perfil
		panelEditar = new JPanel();
		panelEditar.setLayout(new FlowLayout());
		botonEditar = new JButton("Editar");
		botonEditar.setPreferredSize(new Dimension(85, 25));
		botonEditar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				textoNombre.setEnabled(true);
				textoApellido.setEnabled(true);
				textoEmail.setEnabled(true);
				textoUsuario.setEnabled(true);
				textoContrasenya.setEnabled(true);
				textoNcuenta.setEnabled(true);
				
			}
		});
		
		//panel ACEPTAR
		panelAceptar = new JPanel();
		panelAceptar.setLayout(new FlowLayout());
		botonAceptar = new JButton("Aceptar");
		botonAceptar.setPreferredSize(new Dimension(85, 25));
		botonAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BD bd = new BD();
				bd.connect();
				
				String nombre = textoNombre.getText();
				String apellido = textoApellido.getText();
				String dni = textoDni.getText();
				String tarjeta = textoNcuenta.getText();
				String login = textoUsuario.getText();
				String contrasenya = textoContrasenya.getText();
				String email = textoEmail.getText();
				
				Usuario u = new Usuario(nombre, apellido, dni, tarjeta, login, contrasenya, email);
				//llamar al método
				try {
					bd.editarUsuario(u);
					textoNombre.setText(u.getNombre()); 
					textoApellido.setText(u.getApellido());
					textoDni.setText(u.getDni());
					textoNcuenta.setText(u.getTarjeta());
					textoUsuario.setText(u.getLogin());
					textoContrasenya.setText(u.getContrasenya());
					textoEmail.setText(u.getEmail());
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		
		//panel BORRAR perfil
		panelBorrar = new JPanel();
		panelBorrar.setLayout(new FlowLayout());
		botonBorrar = new JButton("Eliminar");
		botonBorrar.setPreferredSize(new Dimension(85, 25));
		botonBorrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					textoDni.setText("");
					textoNombre.setText("");
					textoApellido.setText("");
					textoEmail.setText("");
					textoUsuario.setText("");
					textoContrasenya.setText("");
					textoNcuenta.setText("");
					
					bd.borrarUsuario(uActual);
					
					JOptionPane.showConfirmDialog(null, "¡Su perfil ha sido eliminado con éxito!");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "No se ha podido borrar su perfil");
				}
				
			}
		});
		
		panelAtras = new JPanel();
		panelAtras.setLayout(new FlowLayout());
		botonAtras = new JButton("Volver");
		botonAtras.setPreferredSize(new Dimension(85, 25));
		botonAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
	
		

		cp.add(panel);
		
		panel.add(panelLabel);
		panel.add(panelDni);
		panel.add(panelNombre);
		panel.add(panelApellido);
		panel.add(panelEmail);
		panel.add(panelUsuario);
		panel.add(panelNcuenta);
		panel.add(panelBotones);
		
		panelLabel.add(label);
		panelDni.add(textoDni);
		panelNombre.add(textoNombre);
		panelApellido.add(textoApellido);
		panelEmail.add(textoEmail);
		panelUsuario.add(textoUsuario);
		panelContrasenya.add(textoContrasenya);
		panelNcuenta.add(textoNcuenta);
		panelBotones.add(panelEditar);
		panelBotones.add(panelAceptar);
		panelBotones.add(panelBorrar);
		panelBotones.add(panelAtras);
	
		panelEditar.add(botonEditar);
		panelAceptar.add(botonAceptar);
		panelBorrar.add(botonBorrar);
		panelAtras.add(botonAtras);
		
		setVisible(true);
		pack();
		setSize(350,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
}
