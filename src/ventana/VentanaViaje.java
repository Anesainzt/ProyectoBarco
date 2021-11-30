package ventana;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import clases.Usuario;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class VentanaViaje extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	JDateChooser calendarioIda, calendarioVuelta;
	static JDateChooser calendarioActividades;
	SimpleDateFormat sdf;
	static JCalendar cact;
	static JSpinner spinnerAct;
	DefaultListModel<String> lista;
	JList<String> listaViajes;
	JScrollPane scrollListaViajes;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaViaje frame = new VentanaViaje(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaViaje(Usuario uActual) {
		sdf = new SimpleDateFormat("dd-MM-yyyy");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelTitulo = new JPanel();
		contentPane.add(panelTitulo, BorderLayout.NORTH);
		
		JLabel lblTitulo = new JLabel("TU VIAJE EMPIEZA AQUÍ");
		panelTitulo.add(lblTitulo);
		
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
