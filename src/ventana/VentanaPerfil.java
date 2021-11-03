package ventana;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Clases.Usuario;

public class VentanaPerfil extends JFrame {

	protected Container cp;
	protected JPanel panel,panelLabel,panelDni,panelNombre,panelApellido,panelEmail,panelUsuario,panelContrasenya,panelNcuenta,panelBotones;
	protected JTextField textoDni,textoNombre,textoApellido,textoEmail,textoUsuario,textoContrasenya,textoNcuenta;
	protected JLabel label;
	protected JButton botonEditar,botonAceptar,botonBorrar;

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
		panelBotones.setLayout(new GridLayout(1,3));
		
		//botón EDITAR perfil
		botonEditar = new JButton("Editar");
		botonEditar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				textoDni.setEnabled(true);
				textoNombre.setEnabled(true);
				textoApellido.setEnabled(true);
				textoEmail.setEnabled(true);
				textoUsuario.setEnabled(true);
				textoContrasenya.setEnabled(true);
				textoNcuenta.setEnabled(true);
				
			}
		});
		
		//botón ACEPTAR
		botonAceptar = new JButton("Aceptar");
		
		//botón BORRAR perfil
		botonBorrar = new JButton("Borrar perfil");
		botonBorrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
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
		panelBotones.add(botonEditar);
		panelBotones.add(botonAceptar);
		
		setVisible(true);
		pack();
		setSize(350,550);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
}
