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
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class VentanaViaje extends JFrame {

	private JPanel contentPane;
	private JDateChooser calendarioIda, calendarioVuelta;
	private SimpleDateFormat sdf;
	DefaultListModel<String> lista;
	JList<String> listaViajes;
	JScrollPane scrollListaViajes;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
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
		
		JButton btnSeleccionarIda = new JButton("Fecha ida");
		
		panelCalendario.add(btnSeleccionarIda);
		
		calendarioVuelta = new JDateChooser();
		panelCalendario.add(calendarioVuelta);
		
		JButton btnSeleccionarVuelta = new JButton("Fecha vuelta");
		panelCalendario.add(btnSeleccionarVuelta);
		
		JPanel pViajes = new JPanel();
		pViajes.setLayout(new GridLayout(3,1));
		panelAbajo.add(pViajes);
	
		lista = new DefaultListModel<>();
	
		lista.addElement("1");
		lista.addElement("2");
		lista.addElement("3");
		
		JPanel panel_1 = new JPanel();
		pViajes.add(panel_1);
		
		lista = new DefaultListModel<>();
		listaViajes =  new JList<String>(lista);
		scrollListaViajes = new JScrollPane(listaViajes);
		lista.addElement("Viaje programado en las fechas seleccionadas");
		lista.addElement("2");
		lista.addElement("3");
		panel_1.add(scrollListaViajes);
		
		JPanel panel = new JPanel();
		panel_1.add(panel);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		panel.add(spinner);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		JButton btnNewButton = new JButton("New button");
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel_2.add(btnNewButton_1);
		
		
		
		
		
	}

}
