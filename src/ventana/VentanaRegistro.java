package ventana;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.*;
import javax.swing.*;

import BD.BD;

import java.io.IOException;
import Clases.Usuario;

public class VentanaRegistro extends JFrame {

	protected Container cp;
	protected JPanel panel,panelIzqda,panelDcha,panel1,panel2,panel3,panel4,panel5,panel6,panel7,panel8,panel9,panel10,panel11,panel12,panel13,
	panel14,panel15,panel16,panel17;
	protected JLabel label1, label2,label3,label4,label5,label6,label7,label8,label9;
	protected JTextField texto1,texto2,texto3,texto4,texto5,texto6,texto7;
	protected JButton botonRegistro;

	public VentanaRegistro() {
		BD bd = new BD();
		bd.connect();
		
		//ContentPane
		cp = this.getContentPane();
		this.setTitle("Registro");
		//panelPrinc
		panel = new JPanel();
		panel.setLayout(new GridLayout(1,2));
		
		//panelIzqda
		panelIzqda = new JPanel();
		panelIzqda.setLayout(new GridLayout(9,1));
		
		//panelDcha
		panelDcha = new JPanel();
		panelDcha.setLayout(new GridLayout(9,1));

		//panel1
		panel1 = new JPanel();
		label1 = new JLabel("REGISTRO");
		//panel2
		panel2 = new JPanel();
		label2 = new JLabel("Introduzca sus datos para poder registrarse:");

		//panel3
		panel3 = new JPanel();	
		label3 = new JLabel("DNI:");
		
		//panel4
		panel4 = new JPanel();
		texto1 = new JTextField();
		texto1.setPreferredSize(new Dimension (200, 25));
		
		//panel5
		panel5 = new JPanel();
		label4 = new JLabel("Nombre");

		//panel6
		panel6 = new JPanel();
		texto2 = new JTextField();
		texto2.setPreferredSize(new Dimension (200, 25));

		//panel5
		panel7 = new JPanel();
		label5 = new JLabel("Apellido");

		//panel8
		panel8 = new JPanel();
		texto3 = new JTextField();
		texto3.setPreferredSize(new Dimension (200, 25));

		//panel9
		panel9 = new JPanel();
		label6 = new JLabel("Email");
		
		//panel10
		panel10 = new JPanel();
		texto4 = new JTextField();
		texto4.setPreferredSize(new Dimension (200, 25));

		//panel11
		panel11 = new JPanel();
		label7 = new JLabel("Usuario");

		//panel12
		panel12 = new JPanel();
		texto5 = new JTextField();
		texto5.setPreferredSize(new Dimension (200, 25));
		
		//panel13
		panel13 = new JPanel();
		label8 = new JLabel("Contraseña");
		
		//panel14
		panel14 = new JPanel();
		texto6 = new JTextField();
		texto6.setPreferredSize(new Dimension (200, 25));
		
		//panel15
		panel15 = new JPanel();
		label9 = new JLabel("Nº cuenta");
		
		//panel16
		panel16 = new JPanel();
		texto7 = new JTextField();
		texto7.setPreferredSize(new Dimension (200, 25));
		
		//panel17
		panel17 = new JPanel();
		botonRegistro = new JButton("Registrarme");
		
		

		cp.add(panel);
		panel.add(panelIzqda);
		panel.add(panelDcha);

		panelIzqda.add(panel1);
		panelDcha.add(panel2);
		panelIzqda.add(panel3);
		panelDcha.add(panel4);
		panelIzqda.add(panel5);
		panelDcha.add(panel6);
		panelIzqda.add(panel7);
		panelDcha.add(panel8);
		panelIzqda.add(panel9);
		panelDcha.add(panel10);
		panelIzqda.add(panel11);
		panelDcha.add(panel12);
		panelIzqda.add(panel13);
		panelDcha.add(panel14);
		panelIzqda.add(panel15);
		panelDcha.add(panel16);
		panelIzqda.add(panel17);



		panel1.add(label1);
		panel2.add(label2);
		panel3.add(label3);
		panel4.add(texto1);
		panel5.add(label4);
		panel6.add(texto2);
		panel7.add(label5);
		panel8.add(texto3);
		panel9.add(label6);
		panel10.add(texto4);
		panel11.add(label7);
		panel12.add(texto5);
		panel13.add(label8);
		panel14.add(texto6);
		panel15.add(label9);
		panel16.add(texto7);
		panel17.add(botonRegistro);

		botonRegistro.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String dni = texto1.getText();
				String nombre = texto2.getText();
				String apellido = texto3.getText();
				String email = texto4.getText();
				String login = texto5.getText();
				String contrasenya = texto6.getText();
				String tarjeta = texto7.getText();
				
				Usuario usuario = new Usuario(nombre, apellido, dni, tarjeta, login, contrasenya, email);
					
				if(bd.existeUsuario(usuario) == false) {
					bd.registrarUsuario(usuario);
					
					try {
						new VentanaViaje();
						dispose();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
			}
		});

		setVisible(true);
		pack();
		setSize(700,450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	

	public static void main(String[] args) {
		new VentanaRegistro();

	}

}