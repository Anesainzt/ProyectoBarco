package ventana;


import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

public class VentanaViaje extends JFrame {
	
	Container cp;
	JLabel viaje;
	JPanel pPrinc,p1, p2;
	JRadioButton idaVuelta, soloIda, viajesProgramados;//Programados desde la fecha y la hora de hoy
	JComboBox origen, destino;
	JLabel lblNewLabel1, lblNewLabel2, lblNewLabel3;
	
	
	public VentanaViaje() {
				
		cp = this.getContentPane();
		
		//panelPrincp
		pPrinc = new JPanel();
		pPrinc.setLayout(new GridLayout(1,2));
		
		//Panel de la izquierda
		p1 = new JPanel();
		p1.setLayout(new GridLayout(4, 1));
		
		viaje = new JLabel("Tu viaje empieza aquí");
		idaVuelta = new JRadioButton("Ida y Vuelta");
		soloIda = new JRadioButton("Solo ida");
		viajesProgramados = new JRadioButton("Viajes Largos programados");
		
		
		//Panel de la derecha
		p2 = new JPanel();
		p2.setLayout(new GridLayout(4, 1));
		
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
		
		cp.add(pPrinc);
		
		pPrinc.add(p1);
		pPrinc.add(p2);
		
		p1.add(viaje);
		p1.add(idaVuelta);
		p1.add(soloIda);
		p1.add(viajesProgramados);
		
		p2.add(lblNewLabel1);
		lblNewLabel1.setVisible(false);
		p2.add(lblNewLabel2);
		lblNewLabel2.setVisible(false);
		p2.add(lblNewLabel3);
		lblNewLabel3.setVisible(false);
		
		
		setTitle("Billetes");
		pack();
		setSize(700,450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new VentanaViaje();
	}
	

}
