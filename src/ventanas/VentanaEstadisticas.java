package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import BD.BD;
import clases.Actividad;
import clases.Buceo;
import clases.Ski;

public class VentanaEstadisticas extends JFrame {

	private JPanel contentPane;
	protected static BD bd = new BD();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEstadisticas frame = new VentanaEstadisticas();
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
	public VentanaEstadisticas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		bd.connect();
		ArrayList<Actividad> ret = bd.getActividadesHijas();
		HashMap<String, Integer> hm = new HashMap<>();
		for(Actividad a: ret) {
			String nombre;
			if(a instanceof Buceo)
				nombre = "Buceo";
			else if (a instanceof Ski)
				nombre = "Ski";
			else
				nombre = "Surf";
			if(!hm.containsKey(nombre))
				hm.put(nombre, 1);
			else {
				int valor = hm.get(nombre) + 1;
				hm.put(nombre, valor);
			}
		}
		String texto = "";
		for(String nombre: hm.keySet()) {
			texto = texto + nombre + ": " + hm.get(nombre) + "\n";
		}
		JTextArea area = new JTextArea(texto);
		contentPane.add(new JScrollPane(area),BorderLayout.CENTER);
	}

}
