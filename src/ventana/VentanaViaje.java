package ventana;


import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import com.toedter.calendar.JCalendar;

public class VentanaViaje extends JFrame {
	
	Container cp;
	JLabel viaje;
	JPanel pPrinc,p1, p2, p22, p11;
	JRadioButton idaVuelta, soloIda, viajesProgramados;//Programados desde la fecha y la hora de hoy
	JComboBox origen, destino;
	DefaultListModel<String> lista;
	JList<String> listaViajes;
	JScrollPane scrollListaViajes;
	JButton personas;
	
	JCalendar calendario;
	JButton fechaInicio, fechaFin;
	Date d1, d2, hoy;
	JPanel cPanel;
	String fechaInc;
	Logger logger = Logger.getLogger(Calendario.class.getName());
	
	
	public VentanaViaje() {
				
		cp = this.getContentPane();
		
		//panelPrincp
		pPrinc = new JPanel();
		pPrinc.setLayout(new GridLayout(1,2));
		
		//Panel de la izquierda
		p1 = new JPanel();
		p1.setLayout(new GridLayout(5, 1));
		
		viaje = new JLabel("TU VIAJE EMPIEZA AQUÍ");
		idaVuelta = new JRadioButton("Ida y Vuelta");
		soloIda = new JRadioButton("Solo ida");
		viajesProgramados = new JRadioButton("Viajes Largos programados");
		
		p11 = new JPanel();
		pPrinc.setLayout(new GridLayout(1,2));
		
		
		//Panel de la derecha
		p2 = new JPanel();
		p2.setLayout(new GridLayout(5, 1));
		
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
		
		//Panel del calendario
		cPanel = new JPanel();
		cPanel.setLayout(new GridLayout(2,1));//fila, columna
		fechaInicio = new JButton("Fecha Inicio");
		fechaFin = new JButton("Fecha Fin");
		calendario = new JCalendar();
		//bd = new BD();
		//IMPEDIMOS QUE SE PUEDAN COMPRAR BILLETES ANTERIORES AL DIA DE HOY
		hoy = calendario.getDate();
		calendario.setMinSelectableDate(hoy);
		
		fechaInicio.addActionListener(new ActionListener(){

//		     @Override
		     public void actionPerformed(ActionEvent e) {
		    	 String year = Integer.toString(calendario.getCalendar().get(java.util.Calendar.YEAR));
		    	 String mes = Integer.toString(calendario.getCalendar().get(java.util.Calendar.MONTH) + 1);
		    	 String dia = Integer.toString(calendario.getCalendar().get(java.util.Calendar.DATE));
		    	 if (Integer.parseInt(mes) < 10 && Integer.parseInt(dia) < 10) {
		    		 fechaInc = year + "-0" + mes + "-0" + dia;
		    	 } else if (Integer.parseInt(mes) < 10 && Integer.parseInt(dia) >= 10) {
					 fechaInc = year + "-0" + mes + "-" + dia;
		    	 } else if (Integer.parseInt(mes) >= 10 && Integer.parseInt(dia) < 10) {
					 fechaInc = year + "-" + mes + "-0" + dia;
		    	 } else {
					 fechaInc = year + "-" + mes + "-" + dia;
		    	 }
		    	 
		    	 cPanel.add(fechaFin);
		    	 cPanel.remove(fechaInicio);
		    	 setVisible(true);
		    	 
		    	 d1 = calendario.getDate();
		    	 
		    	 //CREAMOS LA RESTRICCION DE NO PODER VOLVER A ESCOGER LA FECHA INICIO PARA LA FECHA FINAL
		    	 int minYear = Integer.parseInt(year);
		    	 int minMes = Integer.parseInt(mes);
		    	 int minDia = Integer.parseInt(dia);
		    	 
		    	 Date minNoche = new Date(Date.UTC(minYear-1900, minMes-1, minDia +1, 0, 0, 0));
		    	 
		    	 calendario.setMinSelectableDate(minNoche);
		     }
		});
		
		//A CONTINUACION SELECCIONAS OTRA FECHA PARA SELECCIONAR EL DIA DE LA VUELTA
		fechaFin.addActionListener(new ActionListener(){
					
			@Override
			public void actionPerformed(ActionEvent e) {
				String year = Integer.toString(calendario.getCalendar().get(java.util.Calendar.YEAR));
				String mes = Integer.toString(calendario.getCalendar().get(java.util.Calendar.MONTH) + 1);
				String dia = Integer.toString(calendario.getCalendar().get(java.util.Calendar.DATE));
				String fechaEndBD = year + "-" + mes + "-" + dia;
				d2 = calendario.getDate();
						
				//bd.connect();
				//GUARDAMOS LOS DIAS QUE HA RESERVADO EN LA BASE DE DATOS
				//bd.calendario(type, dia, mes , year, fechaInc);
						
				 dispose();	       
			}
		});
		
		lista = new DefaultListModel<>();
		listaViajes =  new JList<String>(lista);
		scrollListaViajes = new JScrollPane(listaViajes);
		lista.addElement("1");
		lista.addElement("2");
		lista.addElement("3");
		
		
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
				fechaInicio.setVisible(true);
				calendario.setVisible(true);
				scrollListaViajes.setVisible(false);
				personas.setVisible(true);
			}
		});
		
		soloIda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				origen.setVisible(true);
				destino.setVisible(true);
				fechaInicio.setVisible(true);
				calendario.setVisible(true);
				scrollListaViajes.setVisible(false);
				personas.setVisible(true);
				
			}
		});
		
		viajesProgramados.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				origen.setVisible(true);
				destino.setVisible(true);
				fechaInicio.setVisible(true);
				calendario.setVisible(true);
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
		
		p2.add(cPanel);
		cPanel.add(fechaInicio);
		cPanel.add(calendario);
		fechaInicio.setVisible(false);
		calendario.setVisible(false);
		
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
	private void desactivarBotones() {
		personas.setEnabled(false);
	}
	private void activarBotones() {
		personas.setEnabled(true);
	}
	
	
	public static void main(String[] args) {
		new VentanaViaje();
	}
	

}
