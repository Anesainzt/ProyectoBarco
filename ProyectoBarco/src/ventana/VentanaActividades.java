package ventana;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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

	public VentanaActividades() {
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
		JPanel panel9 = new JPanel();
		
		
		
		
		JLabel label1 = new JLabel("¿Desea alguna actividad? ");
		JLabel label2 = new JLabel("Cantidad de Personas");
		JLabel label3 = new JLabel("Horario");
		JButton boton1 = new JButton("Aceptar");
		JButton boton2 = new JButton("No quiero nada");
		JButton boton3 = new JButton("Elegir cantidad de personas");
		JTextField texto = new JTextField("",10);
		texto.setText("yyyy/mm/dd");
		JComboBox<String> combobox = new JComboBox();
		
		combobox.addItem("Surf");
		combobox.addItem("Ski Acuático");
		combobox.addItem("Buceo");
		
		JComboBox<String> combobox2 = new JComboBox();
		
		combobox2.addItem("10:00");
		combobox2.addItem("13:00");
		combobox2.addItem("15:00");
		combobox2.addItem("17:00");
		combobox2.addItem("19:00");
		
		
		
		panelPrincipal.setLayout(new GridLayout(1,3));
		panelIzquierdo.setLayout(new GridLayout(4,1));
		panelMedio.setLayout(new GridLayout(6,1));
		panelDerecho.setLayout(new FlowLayout());
		panel1.setLayout(new GridLayout(2,1));
		panel2.setLayout(new GridLayout(2,1));
		panel3.setLayout(new GridLayout(2,1));
		
		panel5.setLayout(new FlowLayout());
		panel6.setLayout(new FlowLayout());
		panel7.setLayout(new FlowLayout());
		
		
		add(panelPrincipal);
		panelPrincipal.add(panelIzquierdo);
		panelPrincipal.add(panelMedio);
	
		panelIzquierdo.add(panel1);
		panelIzquierdo.add(panel2);
		panelIzquierdo.add(panel3);
		panelIzquierdo.add(panel4);
		
		panelMedio.add(panel5);
		panelMedio.add(panel6);
		panelMedio.add(panel7);
		panelMedio.add(panel8);
		
		panelDerecho.add(panel9);
		
	
		
		panel1.add(label1);
		panel2.add(combobox);
		panel3.add(texto);
		panel4.add(boton1);
		panel4.add(boton2);
		
		panel5.add(label2);
		panel6.add(boton3);
		panel7.add(label3);
		panel8.add(combobox2);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 450);
		setTitle("Ventana Actividades");
		setVisible(true);
		
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new VentanaActividades();
	}
}


