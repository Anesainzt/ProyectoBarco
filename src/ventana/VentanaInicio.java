package ventana;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.*;
import javax.swing.*;

import Clases.Usuario;
import BD.BD;

public class VentanaInicio extends JFrame {
	
	protected Container cp;
	protected JPanel panel, panelIzqda, panelDcha, panel1, panel2, panel3, panel4;
	protected JLabel label1, labelUsuario, labelContrasenya;
	protected JTextField textoUsuario,textoContrasenya;
	//protected JPasswordField textoContrasenya;
	protected JButton botonLogin, botonRegistro;
	
	public VentanaInicio() throws IOException {
		
		cp = this.getContentPane();
		this.setTitle("Inicio");

		//panelPrincipal
		panel = new JPanel();
		panel.setLayout(new GridLayout(1,2)); //1 fila 2 columnas
		
		
		//panelIzqda
		panelIzqda = new JPanel();
		panelIzqda.setLayout(new GridLayout(4,1));
		//panel1
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(2,1));
		
		//label1 = new JLabel("Login");
		//label1.setFont(new Font("Times New Roman", Font.LAYOUT_NO_LIMIT_CONTEXT, 24));
		
		//panel2
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(2,1));
		
		labelUsuario = new JLabel("Introduzca su usuario:");
		textoUsuario = new JTextField();
		//panel3
		panel3 = new JPanel();
		panel3.setLayout(new GridLayout(2,1));
		
		labelContrasenya = new JLabel("Introduzca su contraseña:");
		//textoContrasenya = new JPasswordField();
		textoContrasenya = new JPasswordField();
		//panel4
		panel4 = new JPanel();
		panel4.setLayout(new FlowLayout());
		
		botonLogin = new JButton("Iniciar sesión");
		botonLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				BD bd = new BD();
				bd.connect();
				if(bd.comprobarLogin(textoUsuario.getText(), textoContrasenya.getText())) {
					try {
						new VentanaViaje();
						dispose();
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					bd.disconnect();
					
				}
				
			}
		});
		
		botonRegistro = new JButton("Registrarme");
		botonRegistro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new VentanaRegistro();
				
			}
		});
		
		//panelDcha
		panelDcha = new JPanel();
		
		BufferedImage bufferedImage = ImageIO.read(new File("images/yate.jpg"));
		Image image = bufferedImage.getScaledInstance(600, 400, Image.SCALE_DEFAULT);
		JLabel label = new JLabel(new ImageIcon(image));
		 
		
		
		
		cp.add(panel);
		panel.add(panelIzqda);
		panel.add(panelDcha); 
		
		panelIzqda.add(panel1);
		panelIzqda.add(panel2);
		panelIzqda.add(panel3);
		panelIzqda.add(panel4);
		
		panelDcha.add(label);
		
		//panel1.add(label1);
		
		panel2.add(labelUsuario);
		panel2.add(textoUsuario);
		
		panel3.add(labelContrasenya);
		panel3.add(textoContrasenya);
		
		panel4.add(botonLogin);
		panel4.add(botonRegistro);
		
		setVisible(true);
		pack();
		setSize(700,450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) throws IOException {
		new VentanaInicio();

	}

}
