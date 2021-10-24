package ventana;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaActividades extends JFrame{

	
	public VentanaActividades() throws IOException {
		
		JPanel panelPrincipal = new JPanel();
		JPanel panelIzquierdo = new JPanel();
		JPanel panelMedio = new JPanel();
		JPanel panelDerecho = new JPanel();
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		JPanel panel6 = new JPanel();
		JPanel panel7 = new JPanel();
		JPanel panel8 = new JPanel();
		
		
		
		JComboBox<String> combobox = new JComboBox();
		JLabel label1 = new JLabel("¿Desea alguna actividad? ");
		JLabel label2 = new JLabel("Cantidad de Personas");
		JLabel label3 = new JLabel("Tarifa");
		JButton boton1 = new JButton("Aceptar");
		JButton boton2 = new JButton("No quiero nada");
		JButton boton3 = new JButton("Elegir cantidad de personas");
		JTextField txt2 = new JTextField("",10);
		
		BufferedImage imagenBarco = ImageIO.read(new File("images/yate2.jpg"));
		JLabel label4 = new JLabel(new ImageIcon(imagenBarco));
		
		txt2.setText("yyyy/mm/dd");
		
		combobox.addItem("Surf");
		combobox.addItem("Ski Acuático");
		combobox.addItem("Buceo");
		
		panelPrincipal.setLayout(new GridLayout(1,3));
		panelIzquierdo.setLayout(new GridLayout(4,1));
		panelMedio.setLayout(new GridLayout(4,1));
		panel1.setLayout(new GridLayout(2,1));
		panel2.setLayout(new GridLayout(2,1));
		panel3.setLayout(new GridLayout(2,1));
		
		panel4.setLayout(new FlowLayout());
		panel5.setLayout(new FlowLayout());
		panel6.setLayout(new FlowLayout());
		panel7.setLayout(new FlowLayout());
		
		
		add(panelPrincipal);
		panelPrincipal.add(panelIzquierdo);
		panelPrincipal.add(panelMedio);
		panelPrincipal.add(panelDerecho);
	
		panelIzquierdo.add(panel1);
		panelIzquierdo.add(panel2);
		panelIzquierdo.add(panel3);
		panelIzquierdo.add(panel4);
		
		panelMedio.add(panel5);
		panelMedio.add(panel6);
		panelMedio.add(panel7);
		
		panelDerecho.add(panel8);
		
		panel1.add(label1);
		panel2.add(combobox);
		panel3.add(txt2);
		panel4.add(boton1);
		panel4.add(boton2);
		
		panel5.add(label2);
		panel6.add(boton3);
		panel7.add(label3);
		
		panel8.add(label4);
		
		boton3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			new VentanaPersonas();	
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ventana Actividades");
		pack();
		setVisible(true);
		
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new VentanaActividades();
	}
}


