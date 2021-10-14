package ventana;

import java.awt.*;
import javax.swing.*;

public class VentanaInicio extends JFrame {
	
	protected JPanel panel, panelIzqda, panelDcha, panel1, panel2, panel3, panel4;
	protected JLabel label1, labelUsuario, labelContrasenya;
	protected JTextField textoUsuario, textoContrasenya;
	protected JButton botonLogin, botonRegistro;
	
	public VentanaInicio() {
		//panelPrincipal
		panel = new JPanel();
		panel.setLayout(new GridLayout(1,2)); //1 fila 2 columnas
		
		//panelIzqda
		panelIzqda = new JPanel();
		panelIzqda.setLayout(new GridLayout(4,1));
		//panel1
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(2,1));
		
		label1 = new JLabel("Login");
		
		//panel2
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(2,1));
		
		labelUsuario = new JLabel("Introduzca su usuario:");
		textoUsuario = new JTextField();
		//panel3
		panel3 = new JPanel();
		panel3.setLayout(new GridLayout(2,1));
		
		labelContrasenya = new JLabel("Introduzca su contraseña:");
		textoContrasenya = new JTextField();
		
		//panel4
		panel4 = new JPanel();
		panel4.setLayout(new FlowLayout());
		
		botonLogin = new JButton("Login");
		botonRegistro = new JButton("Registrarme");
		
		//panelDcha
		panelDcha = new JPanel();
		
		
		
		
		add(panel);
		panel.add(panelIzqda);
		panel.add(panelDcha); 
		
		panelIzqda.add(panel1);
		panelIzqda.add(panel2);
		panelIzqda.add(panel3);
		panelIzqda.add(panel4);
		
		panel1.add(label1);
		
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

	public static void main(String[] args) {
		new VentanaInicio();

	}

}
