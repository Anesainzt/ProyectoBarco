package ventanas;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import clases.Surf;

import javax.swing.JButton;

public class VentanaEstadisticas extends JFrame {

	JPanel contentPane;
	BD bd = new BD();
	
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
			else if (a instanceof Surf)
				nombre = "Surf";
			else
				nombre = "ActividadExtra";
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
		area.setEditable(false);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnVolver = new JButton("Volver");
		
		btnVolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaAdministrador(null);
				dispose();
			}
			
		});
		panel.add(btnVolver);
		setVisible(true);
	}

}
