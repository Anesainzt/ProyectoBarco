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
	JPanel pPrinc,p1, p2, p22, p11;
	JRadioButton idaVuelta, soloIda, viajesProgramados;//Programados desde la fecha y la hora de hoy
	JComboBox origen, destino;
	JLabel calendarioIV, calendarioSI, calendarioVP;
	DefaultListModel<String> lista;
	JList<String> listaViajes;
	JScrollPane scrollListaViajes;
	JButton personas;
	
	
	public VentanaViaje() {
				
		cp = this.getContentPane();
		
		//panelPrincp
		pPrinc = new JPanel();
		pPrinc.setLayout(new GridLayout(1,2));
		
		//Panel de la izquierda
		p1 = new JPanel();
		p1.setLayout(new GridLayout(5, 1));
		
		viaje = new JLabel("Tu viaje empieza aquí");
		idaVuelta = new JRadioButton("Ida y Vuelta");
		soloIda = new JRadioButton("Solo ida");
		viajesProgramados = new JRadioButton("Viajes Largos programados");
		
		p11 = new JPanel();
		pPrinc.setLayout(new GridLayout(1,2));
		
		
		//Panel de la derecha
		p2 = new JPanel();
		p2.setLayout(new GridLayout(6, 1));
		
		//Panel de la derecha con panel arriba 
		p22 = new JPanel();
		p22.setLayout(new GridLayout(1, 2));
		
		//Poner los destinos que haya creado el admin............................
		origen= new JComboBox();
		origen.addItem("Bilbao");
		origen.addItem("Barcelona");
		origen.addItem("Malaga");
		origen.addItem("Vigo");
		origen.addItem("Lisboa");
		origen.addItem("Valencia");
		
		destino= new JComboBox();
		destino.addItem("Bilbao");
		destino.addItem("Barcelona");
		destino.addItem("Malaga");
		destino.addItem("Vigo");
		destino.addItem("Lisboa");
		destino.addItem("Valencia");
		
		calendarioIV = new JLabel("Calendario1");
		calendarioSI = new JLabel("Calendario2");
		calendarioVP = new JLabel("Calendario3");
		
		lista = new DefaultListModel<>();
		listaViajes =  new JList<String>(lista);
		scrollListaViajes = new JScrollPane(listaViajes);
		lista.addElement("1");
		
		
		personas = new JButton("¿Cuantas personas?");
		
		personas.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaPersonas();
			}
		});
		
		
		ButtonGroup grupo1 = new ButtonGroup();
		grupo1.add(idaVuelta);
		grupo1.add(soloIda);
		grupo1.add(viajesProgramados);
		
		
		
		idaVuelta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				origen.setVisible(true);
				destino.setVisible(true);
				calendarioIV.setVisible(true);
				calendarioSI.setVisible(false);
				calendarioVP.setVisible(false);
				scrollListaViajes.setVisible(false);
				personas.setVisible(true);
			}
		});
		
		soloIda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				origen.setVisible(true);
				destino.setVisible(true);
				calendarioIV.setVisible(false);
				calendarioSI.setVisible(true);
				calendarioVP.setVisible(false);	
				scrollListaViajes.setVisible(false);
				personas.setVisible(true);
				
			}
		});
		
		viajesProgramados.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				origen.setVisible(true);
				destino.setVisible(true);
				calendarioIV.setVisible(false);
				calendarioSI.setVisible(false);
				calendarioVP.setVisible(true);	
				scrollListaViajes.setVisible(true);
				personas.setVisible(true);
			}
		});
		
		cp.add(pPrinc);
		
		pPrinc.add(p1);
		pPrinc.add(p2);
		
		p1.add(viaje);
		p1.add(idaVuelta);
		p1.add(soloIda);
		p1.add(viajesProgramados);
		
		p2.add(p22);
		p22.add(origen);
		origen.setVisible(false);
		p22.add(destino);
		destino.setVisible(false);
		
		p2.add(calendarioIV);
		calendarioIV.setVisible(false);
		p2.add(calendarioSI);
		calendarioSI.setVisible(false);
		p2.add(calendarioVP);
		calendarioVP.setVisible(false);
		p2.add(scrollListaViajes);
		scrollListaViajes.setVisible(false);
		
		p2.add(personas);
		personas.setVisible(false);
		
		//desactivarBotones();
		setTitle("Billetes");
		pack();
		setSize(700,450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	/*private void desactivarBotones() {
		personas.setEnabled(false);
	}
	private void activarBotones() {
		personas.setEnabled(true);
	}*/
	
	
	public static void main(String[] args) {
		new VentanaViaje();
	}
	

}
