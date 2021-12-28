package ventana;

import java.awt.BorderLayout;
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
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BD.BD;
import clases.Actividad;




public class VentanaTabla extends JFrame{
	 JTable tDatos;
	 DefaultTableModel modeloDeDatos;
	 ArrayList<Actividad> actividades;
	 JPanel panelPrincipal;
	 
	public VentanaTabla() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(640,400);
        setTitle("Lista de Actividades");

        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);


        addWindowListener( new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                BD.connect();
                //verProductos();  // Según se inicia la ventana se visualizan los productos
            }
            @Override
            public void windowClosed(WindowEvent e) {
                BD.disconnect();
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

        panel.add(b);
        setVisible(true);
	}
	
	
		private void verActividades() {
			Vector<String> cabeceras = new Vector<String>( Arrays.asList( "Codigo", "Actividad", "Aforo", "Instructor", "Ubicacion", "Descripcion", "Imagen") );
			modeloDeDatos = new DefaultTableModel(  // Inicializa el modelo
					new Vector<Vector<Object>>(),  // Datos de la jtable (vector de vectores) - vacíos de momento
					cabeceras  // Cabeceras de la jtable
				);
			ArrayList<Actividad> actividades = BD.getActividades();
			for (Actividad a : actividades) {
				modeloDeDatos.addRow( new Object[] { a.getCodigo(), a.getNombre(), a.getAforo(), a.getInstructor(), a.getUbicacion(), a.getDescripcion(), a.getImagen()} );
			}
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
			tDatos.getColumnModel().getColumn(6).setMinWidth(40);
			tDatos.getColumnModel().getColumn(6).setMaxWidth(40);
			
			
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new VentanaTabla();
	
	
	}

}
