package ventana;

import javax.swing.*;

import com.toedter.calendar.JCalendar;

import Clases.Usuario;

import BD.BD;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;


public class Calendario extends JFrame{
	
	Container cp;
	JCalendar calendario;
	JTextField fecha;
	JButton fechaInicio;
	JButton fechaFin;
	JLabel info;
	Date d1;
	Date d2;
	Date hoy;
	JPanel p, p1, p2, p11, p111;
	BD bd;
	
	
	static  String fechaInc;
	static Logger logger = Logger.getLogger(Calendario.class.getName());
	
	public Calendario(Usuario usuario) {
		
		cp = this.getContentPane();
		
		p = new JPanel();
		p.setLayout(new GridLayout(2,1));//fila, columna
		
		//Panel de arriba
		p1 = new JPanel();
		p1.setLayout(new GridLayout(2,1));
		
		//Dentro del panel de arriba Arriba
		p11 = new JPanel();
		p11.setLayout(new GridLayout(1,2));
		info = new JLabel("Fecha de viaje:");
		fecha=new JTextField(30);
		
		//Dentro del panel de arriba Abajo
		p111 = new JPanel();
		fechaInicio = new JButton("Fecha Inicio");
		fechaFin = new JButton("Fecha Fin");
		

		//Panel de abajo
		p2 = new JPanel();
		calendario = new JCalendar();
		bd = new BD();
		//IMPEDIMOS QUE SE PUEDAN COMPRAR BILLETES ANTERIORES AL DIA DE HOY
		hoy = calendario.getDate();
		calendario.setMinSelectableDate(hoy);
		
		
		//PRIMERO SELECCIONAS UN DIA, Y CLICAS EL BOTON FECHA INICIO PARA GUARDAR ESA FECHA COMO EL DIA DE ENTRADA
		fechaInicio.addActionListener(new ActionListener(){

//		     @Override
		     public void actionPerformed(ActionEvent e) {
		    	 String year = Integer.toString(calendario.getCalendar().get(java.util.Calendar.YEAR));
		    	 String mes = Integer.toString(calendario.getCalendar().get(java.util.Calendar.MONTH) + 1);
		    	 String dia = Integer.toString(calendario.getCalendar().get(java.util.Calendar.DATE));
		    	 fecha.setText(dia + "-" + mes + "-" + year);
		    	 if (Integer.parseInt(mes) < 10 && Integer.parseInt(dia) < 10) {
		    		 fechaInc = year + "-0" + mes + "-0" + dia;
		    	 } else if (Integer.parseInt(mes) < 10 && Integer.parseInt(dia) >= 10) {
					 fechaInc = year + "-0" + mes + "-" + dia;
		    	 } else if (Integer.parseInt(mes) >= 10 && Integer.parseInt(dia) < 10) {
					 fechaInc = year + "-" + mes + "-0" + dia;
		    	 } else {
					 fechaInc = year + "-" + mes + "-" + dia;
		    	 }
		    	 
		    	 p111.add(fechaFin);
		    	 p111.remove(fechaInicio);
		    	 setVisible(true);
		    	 
		    	 d1 = calendario.getDate();
		    	 
		    	 //CREAMOS LA RESTRICCION DE NO PODER VOLVER A ESCOGER LA FECHA INICIO PARA LA FECHA FINAL
		    	 int minYear = Integer.parseInt(year);
		    	 int minMes = Integer.parseInt(mes);
		    	 int minDia = Integer.parseInt(dia);
		    	 
		    	 //SE RESTA 1900 PORQUE LA LIBRER�A EMPIEZA A CONTAR DESDE 1900
		    	 //SE RESTA 1 AL MES PORQUE EMPIEZA A CONTAR DESDE 0 Y ANTES LE HEMOS SUMADO 1 PARA ESCRIBIR BIEN LA FECHA
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
				fecha.setText(dia + "-" + mes + "-" + year);
				String fechaEndBD = year + "-" + mes + "-" + dia;
				d2 = calendario.getDate();
				
				//bd.connect();
				//GUARDAMOS LOS DIAS QUE HA RESERVADO EN LA BASE DE DATOS
				//bd.calendario(type, dia, mes , year, fechaInc);
				
				
		        dispose();	       
			}
		});
		
		cp.add(p);
		
		p.add(p1);
		p.add(p2);
		
		p1.add(p11);
		p1.add(p111);
		
		p11.add(info);
		p11.add(fecha);
		
		p111.add(fechaInicio);
		
		p2.add(calendario);
		
		
		
		// Cambiar color de letra del numero de d�a 
		calendario.setForeground(Color.BLACK);
		 
		// Cambiar color de letra de semana
		calendario.setWeekdayForeground(Color.BLUE);
		
		// No mostramos la semana del a�o que es
		calendario.setWeekOfYearVisible(false);
		
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Calendario");
		setSize(300, 400);
		setVisible(true);
		
		
		
	}
	public static void main(String[] args) {
		new Calendario(null);
	}
	
	
}
