package ventanas;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BD.BD;
import clases.Actividad;
import clases.Usuario;
import clases.Viaje;

public class VentanaActividades extends JFrame{
	
	
	private static final long serialVersionUID = 1L;
	BD bd = new BD();
	protected double tarifaTotal = 0.00;
	protected List<Actividad> listaActividadesSeleccionadas = new ArrayList<Actividad>();
	protected List<Actividad> listaActividades = new ArrayList<Actividad>();
	protected List<Actividad> listaActividadesViajeVuelta = new ArrayList<Actividad>();

	public VentanaActividades(Usuario uActual, Viaje viajeIda, Viaje viajeVuelta, int numeroPersonas) throws IOException {
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(4, 15, 15, 15));
		JPanel panelIzquierdo = new JPanel();
		JPanel panelMedio = new JPanel();
		JPanel panelDerecho = new JPanel();
		
		JPanel panelTit = new JPanel();
		JPanel panelTipo = new JPanel();
		JPanel panelFecha = new JPanel();
		JPanel panelSiguiente = new JPanel();
		JPanel panelCantidad = new JPanel();
		JPanel panelCantSpinn = new JPanel();
		JPanel panelTarifa = new JPanel();
		JPanel panelFoto = new JPanel();
		
		
		JComboBox<String> combobox = new JComboBox<String>();
		JLabel label1 = new JLabel("¿Desea alguna actividad? ");
		JLabel label2 = new JLabel("Cantidad de Personas");
		JLabel label3 = new JLabel("Tarifa: " + tarifaTotal + "€");
		//QUITAR Y CUANDO ESCOJA ELEGIR CANTIDAD DE PERSONAS QUE APAREZCA ESA VENTANA Y DESPUES DE SELECIONAR LAS PERSONAS IR A LA VENTANA QUE ESTÁ CREANDO ANDREA
		JButton botonSiguiente = new JButton("Ir a pago");
		
		BufferedImage bufferedImage = ImageIO.read(new File("images/yate2.jpg"));
		Image imagenBarco = bufferedImage.getScaledInstance(400, 200, Image.SCALE_DEFAULT);
		JLabel lblFoto = new JLabel(new ImageIcon(imagenBarco));

		try {
			listaActividadesSeleccionadas = new ArrayList<Actividad>();
			listaActividades = viajeIda.getListaActividades();
	//		listaActividadesViajeVuelta = viajeVuelta.getListaActividades();

			for (Actividad actividad : listaActividadesViajeVuelta) {
				listaActividades.add(actividad);
			}

			for (Actividad actividad : listaActividades) {
				combobox.addItem(actividad.getNombre() + " - " + actividad.getUbicacion());
			}
		} catch (Exception e) {
			bd.ficheroLogger();
			bd.logger.log(Level.INFO, "No se han guardado correctamente las actividades.");
			bd.closeLogger();
		}
		
		panelPrincipal.setLayout(new GridLayout(1,3));
		panelIzquierdo.setLayout(new GridLayout(4,1));
		panelMedio.setLayout(new GridLayout(4,1));
		panelTit.setLayout(new GridLayout(2,1));
		panelTipo.setLayout(new GridLayout(2,1));
		panelFecha.setLayout(new GridLayout(2,1));
		
		panelSiguiente.setLayout(new FlowLayout());
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
		panelIzquierdo.add(panelSiguiente);
		
		panelMedio.add(panelCantidad);
		panelMedio.add(panelCantSpinn);
		panelMedio.add(panelTarifa);
		
		panelDerecho.add(panelFoto);
		
		panelTit.add(label1);
		panelTipo.add(combobox);
		// panelFecha.add(VentanaViaje.calendarioActividades);
		panelSiguiente.add(botonSiguiente);
		
		panelTarifa.add(label3);
		
		JPanel panelBtnBien = new JPanel();
		panelMedio.add(panelBtnBien);
		
		JButton botonRegAct = new JButton("Registrar actividad");
		botonRegAct.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				listaActividadesSeleccionadas.add(listaActividades.get(combobox.getSelectedIndex()));
				tarifaTotal += listaActividades.get(combobox.getSelectedIndex()).getPrecio();
				JOptionPane.showMessageDialog(null, "Se ha registrado la Actividad");
			}
		});
		
		panelBtnBien.add(botonRegAct);

		panelFoto.add(lblFoto);
		
		botonSiguiente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				new VentanaPago(uActual, viajeIda, viajeVuelta, numeroPersonas, listaActividadesSeleccionadas);
				dispose();
			}
		});
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ventana Actividades");
		pack();
		setVisible(true);
	}

	// main de prueba
	public static void main(String[] args) {
		try {
			new VentanaActividades(null, null, null, 0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
