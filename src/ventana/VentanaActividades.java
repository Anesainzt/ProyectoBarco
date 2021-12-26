package ventana;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VentanaActividades extends JFrame{

	
	private static final long serialVersionUID = 1L;
	public VentanaActividades() throws IOException {
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(4, 15, 15, 15));
		JPanel panelIzquierdo = new JPanel();
		JPanel panelMedio = new JPanel();
		JPanel panelDerecho = new JPanel();
		
		JPanel panelTit = new JPanel();
		JPanel panelTipo = new JPanel();
		JPanel panelFecha = new JPanel();
		JPanel panelNada = new JPanel();
		JPanel panelCantidad = new JPanel();
		JPanel panelCantSpinn = new JPanel();
		JPanel panelTarifa = new JPanel();
		JPanel panelFoto = new JPanel();
		
		
		JComboBox<String> combobox = new JComboBox<String>();
		JLabel label1 = new JLabel("¿Desea alguna actividad? ");
		
		JLabel label2 = new JLabel("Cantidad de Personas");
		
		
		JLabel label3 = new JLabel("Tarifa");
		//QUITAR Y CUANDO ESCOJA ELEGIR CANTIDAD DE PERSONAS QUE APAREZCA ESA VENTANA Y DESPUES DE SELECIONAR LAS PERSONAS IR A LA VENTANA QUE ESTÁ CREANDO ANDREA
		JButton botonNada = new JButton("No quiero nada");
		
		
		
		BufferedImage bufferedImage = ImageIO.read(new File("images/yate2.jpg"));
		Image imagenBarco = bufferedImage.getScaledInstance(400, 200, Image.SCALE_DEFAULT);
		JLabel lblFoto = new JLabel(new ImageIcon(imagenBarco));
		
		
		combobox.addItem("Surf");
		combobox.addItem("Ski Acuático");
		combobox.addItem("Buceo");
		
		panelPrincipal.setLayout(new GridLayout(1,3));
		panelIzquierdo.setLayout(new GridLayout(4,1));
		panelMedio.setLayout(new GridLayout(4,1));
		panelTit.setLayout(new GridLayout(2,1));
		panelTipo.setLayout(new GridLayout(2,1));
		panelFecha.setLayout(new GridLayout(2,1));
		
		panelNada.setLayout(new FlowLayout());
		panelCantidad.setLayout(new FlowLayout());
		panelCantSpinn.setLayout(new FlowLayout());
		panelTarifa.setLayout(new FlowLayout());
		
		
		getContentPane().add(panelPrincipal);
		panelPrincipal.add(panelIzquierdo);
		panelPrincipal.add(panelMedio);
		panelPrincipal.add(panelDerecho);
	
		panelIzquierdo.add(panelTit);
		panelIzquierdo.add(panelTipo);
		panelIzquierdo.add(panelFecha);
		panelIzquierdo.add(panelNada);
		
		panelMedio.add(panelCantidad);
		panelMedio.add(panelCantSpinn);
		panelMedio.add(panelTarifa);
		
		panelDerecho.add(panelFoto);
		
		panelTit.add(label1);
		panelTipo.add(combobox);
		panelFecha.add(VentanaViaje.calendarioActividades);
		panelNada.add(botonNada);
		
		panelCantidad.add(label2);
		panelCantSpinn.add(VentanaViaje.spinnerAct);
		
		panelTarifa.add(label3);
		
		JPanel panelBtnBien = new JPanel();
		panelMedio.add(panelBtnBien);
		
		JButton botonRegAct = new JButton("RegistrarActividad");
		botonRegAct.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				new VentanaPago();
				dispose();
			}
		});
	
		
		panelBtnBien.add(botonRegAct);
		
		panelFoto.add(lblFoto);
		
		botonNada.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				new VentanaPago();
				dispose();
			}
		});
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ventana Actividades");
		pack();
		setVisible(true);
		
		
	}
}

