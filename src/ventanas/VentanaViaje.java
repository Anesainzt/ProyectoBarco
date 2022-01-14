package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import BD.BD;
import clases.Usuario;
import clases.Viaje;
public class VentanaViaje extends JFrame {
	
	private static final long serialVersionUID = 1L;
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
	JButton btnSeleccionarIda;
	JButton btnIraActividad;
	JButton btnSeleccionarVuelta;
	JButton btnIrATicket;
	JSpinner spinner;
	
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem itemPerfil, itemGaleria, itemSesion, itemSalir;
	
	ButtonGroup rg;
	BD bd = new BD();
		
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
					bd.logger.log(Level.INFO, "Se ha ejecutaddo correctamentes");
					dispose();
				} catch (IOException e) {
					bd.logger.log(Level.INFO, "No se ha podido ejecutar la ventana");
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
					bd.logger.log(Level.INFO, "No se ha podido ejecutar la ventana");
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
					bd.logger.log(Level.INFO, "No se ha podido cargar el JOptionPane");
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
		
		JPanel panelTituloInterno = new JPanel();
		
		JLabel lblTitulo = new JLabel("TU VIAJE EMPIEZA AQUÍ");
		
		btnIrATicket = new JButton("Ir al ticket");
		JRadioButton rbIda = new JRadioButton("Ida");
		rbIda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				calendarioIda.setVisible(true);
				btnSeleccionarIda.setVisible(true);
				calendarioVuelta.setVisible(false);
				btnSeleccionarVuelta.setVisible(false);
				scrollListaViajes.setVisible(false);
				spinner.setVisible(true);
				btnIraActividad.setVisible(false);
				btnIrATicket.setVisible(true);
			}
			
		});
		
		JRadioButton rbIdaVuelta = new JRadioButton("Ida y vuelta");
		rbIdaVuelta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				calendarioIda.setVisible(true);
				btnSeleccionarIda.setVisible(true);
				calendarioVuelta.setVisible(true);
				btnSeleccionarVuelta.setVisible(true);
				scrollListaViajes.setVisible(false);
				spinner.setVisible(true);
				btnIraActividad.setVisible(true);
				btnIrATicket.setVisible(false);
				
			}
			
		});
		rg = new ButtonGroup();
		rg.add(rbIda);
		rg.add(rbIdaVuelta);
		
		
		JLabel lblOrigen = new JLabel("Origen:");
		JComboBox<String> cbOrigen = new JComboBox<String>();
		cbOrigen.addItem("Bilbao");
		cbOrigen.addItem("Barcelona");
		cbOrigen.addItem("Malaga");
		cbOrigen.addItem("Vigo");
		cbOrigen.addItem("Lisboa");
		cbOrigen.addItem("Valencia");
		

		JLabel lblDestino = new JLabel("Destino:");
		JComboBox<String> cbDestino = new JComboBox<String>();
		cbDestino.addItem("Bilbao");
		cbDestino.addItem("Barcelona");
		cbDestino.addItem("Malaga");
		cbDestino.addItem("Vigo");
		cbDestino.addItem("Lisboa");
		cbDestino.addItem("Valencia");
		
		JPanel panelAbajo = new JPanel();
		
		JPanel panelRadioB = new JPanel();

		JPanel panelOpciones = new JPanel();
		panelOpciones.setLayout(new GridLayout(1,2));
		
		JPanel panelDYO = new JPanel();
		panelDYO.setLayout(new GridLayout(2, 2));
		
		JPanel panelCalendario = new JPanel();		
		panelCalendario.setLayout(new GridLayout(2,2));
		
		calendarioIda = new JDateChooser();
		JCalendar calIda = calendarioIda.getJCalendar();
		calIda.setMinSelectableDate(new Date(System.currentTimeMillis()));
		
		calendarioVuelta = new JDateChooser();
		JCalendar calVuelta = calendarioVuelta.getJCalendar();

		btnSeleccionarIda = new JButton("Fecha ida");
		btnSeleccionarIda.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
		    	 calVuelta.setMinSelectableDate(calendarioIda.getDate());
			}
			
		});
		btnSeleccionarVuelta = new JButton("Fecha vuelta");
		
		JPanel panelVPersonas = new JPanel();
		
		lista = new DefaultListModel<>();
		listaViajes =  new JList<String>(lista);
		scrollListaViajes = new JScrollPane(listaViajes);
		
		
		lista.addElement("Viaje programado en las fechas seleccionadas");
		lista.addElement("Viaje programado en las fechas seleccionadas");
		lista.addElement("Viaje programado en las fechas seleccionadas");
		
		
		spinnerAct = new JSpinner();
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		
		JPanel panelBotones = new JPanel();
		
		btnIraActividad = new JButton("Aceptar billete");
		//llamamos al método existeViaje
		// Falta que el calendario devuelva la fecha en TimiMillis
		//
		
		btnIraActividad.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println("aslfjsladkf");
					if (!rbIda.isSelected()) {
						System.out.println("he entrado en rbIdayvuelta");
						try {
							bd.connect();
							Viaje v = bd.existeViaje(cbOrigen.getSelectedItem().toString(), cbDestino.getSelectedItem().toString(), calendarioIda.getDate(), calendarioVuelta.getDate());
							System.out.println("eadfjdlskjfladks");
							if(!v.equals(null)) {
								int numeroPersonas = (int)spinner.getValue();
								System.out.println("he entrado");
								if (v.getLocalizador() != "") {
									//Mientras la fecha seleccionada esté en la base de datos y tenga el mismo orgen y destino se mostrará el ticket
									v.setListaActividades(bd.compararDestinoConUbicacion(v.getDestino()));
									new VentanaActividades(uActual, v, null, numeroPersonas);
								} else {
									JOptionPane.showMessageDialog(null, "No existe un viaje para esa fecha.");
									bd.logger.log(Level.INFO, "No existe un viaje para esa fecha");
								}
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else {
						Viaje viajeIda = new Viaje();
						Viaje viajeVuelta = new Viaje();
						int numeroPersonas = (int)spinner.getValue();
						// viajeIda = bd.getViaje((String)cbOrigen.getSelectedItem(), (String)cbDestino.getSelectedItem(),
						// 		calIda.getDate());
						// viajeVuelta = bd.getViaje((String)cbDestino.getSelectedItem(), (String)cbOrigen.getSelectedItem(),
						// 		calVuelta.getDate());
						
						if (viajeIda.getLocalizador() != "" && viajeVuelta.getLocalizador() != "") {
							//Mientras las fechas seleccionadas estén en la base de datos y tenga el mismo orgen y destino se mostrará la ventana actividades.
							
							
							
							new VentanaActividades(uActual, viajeIda, viajeVuelta, numeroPersonas);
						}else{
							JOptionPane.showMessageDialog(null, "No existen viajes para esas fechas.");
							bd.logger.log(Level.INFO, "No existe un viaje para esa fecha");
						}
					}
				} catch (IOException e1) {
					bd.logger.log(Level.INFO, "No se ha podido ejecutar la ventana actividades");
				}
				cact.setMinSelectableDate(calendarioIda.getDate());
				cact.setMaxSelectableDate(calendarioVuelta.getDate());
				spinnerAct.setModel(new SpinnerNumberModel(0, 0,(Comparable<?>) spinner.getValue(), 1));
				
				//dispose();	
			}
		});
	
		calendarioActividades = new JDateChooser();
		cact = calendarioActividades.getJCalendar();
		
		setVisible(true);
		
		contentPane.add(panelTitulo, BorderLayout.NORTH);
		contentPane.add(panelAbajo, BorderLayout.CENTER);
		
		panelTitulo.add(panelTituloInterno);
		panelTituloInterno.add(lblTitulo);
		
		panelAbajo.add(panelRadioB, BorderLayout.NORTH);
		panelAbajo.add(panelOpciones, BorderLayout.CENTER);
		panelAbajo.add(panelVPersonas);
		panelAbajo.add(panelBotones);
		
		panelRadioB.add(rbIda);
		panelRadioB.add(rbIdaVuelta);
		
		panelOpciones.add(panelDYO);
		panelOpciones.add(panelCalendario);
		
		panelDYO.add(lblOrigen);
		panelDYO.add(cbOrigen);
		panelDYO.add(lblDestino);
		panelDYO.add(cbDestino);
		
		panelCalendario.add(calendarioIda);
		panelCalendario.add(btnSeleccionarIda);
		calendarioIda.setVisible(false);
		btnSeleccionarIda.setVisible(false);
		
		panelCalendario.add(calendarioVuelta);
		panelCalendario.add(btnSeleccionarVuelta);
		calendarioVuelta.setVisible(false);
		btnSeleccionarVuelta.setVisible(false);
		
		panelVPersonas.add(scrollListaViajes);
		scrollListaViajes.setVisible(false);
		panelVPersonas.add(spinner);
		spinner.setVisible(false);
		panelBotones.add(btnIraActividad);
		panelBotones.add(btnIrATicket);
		btnIraActividad.setVisible(false);
		btnIrATicket.setVisible(false);
		
		
	}
	
}