package ventana;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BD.BD;
import clases.Actividad;



public class VentanaTabla extends JFrame{
	 JTable tDatos;
	 DefaultTableModel modeloDeDatos;
	 BD bd = new BD();
	 ArrayList<Actividad> actividades;
	 
	public VentanaTabla() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(640,400);
		setTitle("Lista de Actividades");
		setVisible(true);
		
		addWindowListener( new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				bd.connect();
				//verProductos();  // Según se inicia la ventana se visualizan los productos
			}
			@Override
			public void windowClosed(WindowEvent e) {
				bd.disconnect();
			}
		});
		
		JButton b = new JButton( "Actividades" );
		b.setFont( new Font( "Arial", Font.PLAIN, 12 ) );
		b.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				verActividades();
			}
		});
	}
		private void verActividades() {
			Vector<String> cabeceras = new Vector<String>( Arrays.asList( "Codigo", "Actividad", "Aforo", "Instructor", "Ubicacion", "Descripcion") );
			modeloDeDatos = new DefaultTableModel(  // Inicializa el modelo
					new Vector<Vector<Object>>(),  // Datos de la jtable (vector de vectores) - vacíos de momento
					cabeceras  // Cabeceras de la jtable
				);
			tDatos.setModel(modeloDeDatos);
			// Pone tamaños a las columnas de la tabla
			tDatos.getColumnModel().getColumn(0).setMinWidth(40);
			tDatos.getColumnModel().getColumn(0).setMaxWidth(40);
			tDatos.getColumnModel().getColumn(1).setMinWidth(40);
			tDatos.getColumnModel().getColumn(1).setMaxWidth(40);
			tDatos.getColumnModel().getColumn(3).setMinWidth(40);
			tDatos.getColumnModel().getColumn(3).setMaxWidth(40);		
			tDatos.getColumnModel().getColumn(4).setMinWidth(40);
			tDatos.getColumnModel().getColumn(4).setMaxWidth(40);
			tDatos.getColumnModel().getColumn(5).setMinWidth(120);
			tDatos.getColumnModel().getColumn(5).setMaxWidth(120);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new VentanaTabla();
	
	}

}
