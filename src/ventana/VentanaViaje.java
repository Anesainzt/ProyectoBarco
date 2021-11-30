package ventana;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import clases.Usuario;
public class VentanaViaje extends JFrame {
	
	Container cp;
	JPanel contentPane;
	JDateChooser calendarioIda, calendarioVuelta;
	static JDateChooser calendarioActividades;
	SimpleDateFormat sdf;
	static JCalendar cact;
	static JSpinner spinnerAct;
	DefaultListModel<String> lista;
	JList<String> listaViajes;
	JScrollPane scrollListaViajes;
	
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem itemPerfil, itemGaleria, itemSesion, itemSalir;
	
	public static void main(String[] args) {
		new VentanaViaje(null);
	}
	
	public VentanaViaje(Usuario uActual) {
				
		sdf = new SimpleDateFormat("dd-MM-yyyy");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		//menú
		menuBar = new JMenuBar();
		menu = new JMenu("Más opciones");
	
		itemPerfil = new JMenuItem("Mi perfil", new ImageIcon("images/perfil.png"));
		itemPerfil.setBackground(Color.WHITE);
		itemPerfil.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new VentanaPerfil(uActual);
				dispose();
				
			}
		});
		
		itemGaleria = new JMenuItem("Galería", new ImageIcon("images/galeria.png"));
		itemGaleria.setBackground(Color.WHITE);
		itemGaleria.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					new VentanaGaleria();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});

		itemSesion = new JMenuItem("Cerrar Sesión", new ImageIcon("images/sesion.png"));
		itemSesion.setBackground(Color.WHITE);
		itemSesion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					JOptionPane.showMessageDialog(null, "¡Hasta pronto!");
					new VentanaInicio();
					dispose();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

		itemSalir = new JMenuItem("Salir", new ImageIcon("images/salir.png"));
		itemSalir.setBackground(Color.WHITE);
		itemSalir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					JOptionPane.showMessageDialog(null, "¡Nos vemos pronto!");
					dispose();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});


		
		setJMenuBar(menuBar);
		menuBar.add(menu);
		menu.add(itemPerfil);
		menu.add(itemGaleria);
		menu.add(itemSesion);
		menu.add(itemSalir);
		
		JPanel panelTitulo = new JPanel();
		contentPane.add(panelTitulo, BorderLayout.NORTH);
		
		
		JPanel panel_3 = new JPanel();
		panelTitulo.add(panel_3);
		
		JLabel lblTitulo = new JLabel("TU VIAJE EMPIEZA AQUÍ");
		panel_3.add(lblTitulo);
		
		JComboBox<String> cbOrigen = new JComboBox<String>();
		cbOrigen.addItem("Bilbao");
		cbOrigen.addItem("Barcelona");
		cbOrigen.addItem("Malaga");
		cbOrigen.addItem("Vigo");
		cbOrigen.addItem("Lisboa");
		cbOrigen.addItem("Valencia");
		
		
		JComboBox<String> cbDestino = new JComboBox<String>();
		cbDestino.addItem("Bilbao");
		cbDestino.addItem("Barcelona");
		cbDestino.addItem("Malaga");
		cbDestino.addItem("Vigo");
		cbDestino.addItem("Lisboa");
		cbDestino.addItem("Valencia");
		
		JPanel panelAbajo = new JPanel();
		contentPane.add(panelAbajo, BorderLayout.CENTER);
		
		JPanel panelRadioB = new JPanel();
		panelAbajo.add(panelRadioB, BorderLayout.NORTH);
		
		JRadioButton rbIda = new JRadioButton("Ida");
		panelRadioB.add(rbIda);
		
		JRadioButton rbIdaVuelta = new JRadioButton("Ida y vuelta");
		panelRadioB.add(rbIdaVuelta);
		
		JRadioButton rbVuelosProgramados = new JRadioButton("Vuelos Programados");
		panelRadioB.add(rbVuelosProgramados);
		
		JPanel panelOpciones = new JPanel();
		panelOpciones.setLayout(new GridLayout(1,2));
		panelAbajo.add(panelOpciones, BorderLayout.CENTER);
		
		JPanel panelDYO = new JPanel();
		panelDYO.setLayout(new GridLayout(2, 2));
		panelOpciones.add(panelDYO);
		
		JLabel lblOrigen = new JLabel("Origen:");
		panelDYO.add(lblOrigen);
		
		JComboBox<String> Origen = new JComboBox<String>();
		panelDYO.add(Origen);
		
		JLabel lblDestino = new JLabel("Destino:");
		panelDYO.add(lblDestino);
		
		JComboBox<String> Destino = new JComboBox<String>();
		panelDYO.add(Destino);
		
		JPanel panelCalendario = new JPanel();		
		panelCalendario.setLayout(new GridLayout(2,2));
		panelOpciones.add(panelCalendario);
		
		calendarioIda = new JDateChooser();
		panelCalendario.add(calendarioIda);
		JCalendar calIda = calendarioIda.getJCalendar();
		calIda.setMinSelectableDate(new Date(System.currentTimeMillis()));
		
		calendarioVuelta = new JDateChooser();
		JCalendar calVuelta = calendarioVuelta.getJCalendar();

		JButton btnSeleccionarIda = new JButton("Fecha ida");
		btnSeleccionarIda.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
		    	 calVuelta.setMinSelectableDate(calendarioIda.getDate());
			}
			
		});
		JButton btnSeleccionarVuelta = new JButton("Fecha vuelta");
		panelCalendario.add(btnSeleccionarIda);
		panelCalendario.add(calendarioVuelta);
		panelCalendario.add(btnSeleccionarVuelta);
		
		JPanel panel = new JPanel();
		panelAbajo.add(panel);
		
		
	
		
		lista = new DefaultListModel<>();
		listaViajes =  new JList<String>(lista);
		scrollListaViajes = new JScrollPane(listaViajes);
		
		panel.add(scrollListaViajes);
		
		lista.addElement("Viaje programado en las fechas seleccionadas");
		lista.addElement("2");
		lista.addElement("3");
		
		
		spinnerAct = new JSpinner();
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		panel.add(spinner);
		
		JPanel panel_1 = new JPanel();
		panelAbajo.add(panel_1);
		
		JButton btnNewButton = new JButton("New button");
		panel_1.add(btnNewButton);
		
		JButton btnIraActividad = new JButton("Aceptar billete");
		panel_1.add(btnIraActividad);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		calendarioActividades = new JDateChooser();
		cact = calendarioActividades.getJCalendar();
		
		btnIraActividad.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new VentanaActividades();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				cact.setMinSelectableDate(calendarioIda.getDate());
				cact.setMaxSelectableDate(calendarioVuelta.getDate());
				spinnerAct.setModel(new SpinnerNumberModel(0, 0,(Comparable<?>) spinner.getValue(), 1));
				
				dispose();
				
			}
			
		});
		
		
		setVisible(true);
		
	}
	
}