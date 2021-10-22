package ventana;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

public class VentanaVuelo extends JFrame {

	JLabel viaje;
	JRadioButton idaVuelta, soloIda, viajesProgramados;//Programados desde la fecha y la hora de hoy
	JComboBox origen, destino;
	JLabel lblNewLabel1, lblNewLabel2, lblNewLabel3;
	
	
	public VentanaVuelo() {
	
		getContentPane().setLayout(new GridLayout(7, 3));
		
		viaje = new JLabel("Tu viaje empieza aquí");
		idaVuelta = new JRadioButton("Ida y Vuelta");
		soloIda = new JRadioButton("Solo ida");
		viajesProgramados = new JRadioButton("Viajes Largos programados");
		lblNewLabel1 = new JLabel("Calendario1");
		lblNewLabel2 = new JLabel("Calendario2");
		lblNewLabel3 = new JLabel("Calendario3");
		
		
		ButtonGroup grupo1 = new ButtonGroup();
		grupo1.add(idaVuelta);
		grupo1.add(soloIda);
		grupo1.add(viajesProgramados);
		
		
		
		idaVuelta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lblNewLabel1.setVisible(true);
				lblNewLabel2.setVisible(false);
				lblNewLabel3.setVisible(false);
			
				
			}
			
		});
		soloIda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lblNewLabel1.setVisible(false);
				lblNewLabel2.setVisible(true);
				lblNewLabel3.setVisible(false);
				
			}
			
		});
		viajesProgramados.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lblNewLabel1.setVisible(false);
				lblNewLabel2.setVisible(false);
				lblNewLabel3.setVisible(true);
			
				
			}
			
		});
		
		
	
		
		
		getContentPane().add(viaje);
		getContentPane().add(idaVuelta);
		getContentPane().add(soloIda);
		getContentPane().add(viajesProgramados);
		add(lblNewLabel1);
		lblNewLabel1.setVisible(false);
		add(lblNewLabel2);
		lblNewLabel2.setVisible(false);
		add(lblNewLabel3);
		lblNewLabel3.setVisible(false);
		
		
		pack();
		setSize(700,450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		new VentanaVuelo();
	}
	

}
