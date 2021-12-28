package ventana;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BD.BD;
import clases.Actividad;
import clases.Usuario;

import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class VentanaAdministrador extends JFrame {

	private JPanel contentPane;
	JTable tDatos;
	DefaultTableModel modeloDeDatos;
	ArrayList<Actividad> actividades;
	JPanel panelPrincipal;
	 
	BD bd = new BD();
	
	public VentanaAdministrador(Usuario uActual) {
		
		setSize(600,400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	
		
		JPanel panelGeneral = new JPanel();

		panelGeneral.setLayout(new GridLayout(1,2)); 
		
		contentPane.add(panelGeneral);
				
		JPanel panel = new JPanel();
		panelGeneral.add(panel);
		JPanel panelTitbot = new JPanel();
		panel.add(panelTitbot);
		
		panelTitbot.setLayout(new GridLayout(3,1)); 
		
		JPanel panelbotonUsuarios = new JPanel();
		panel.add(panelbotonUsuarios);
		
		JButton botonUsuarios = new JButton("Usuarios Registrados");
		panelbotonUsuarios.add(botonUsuarios);
		
		JPanel panelBotonActividades = new JPanel();
		panel.add(panelBotonActividades);
		
		JButton botonActividades = new JButton("Actividades Ofrecidas");
		botonActividades.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				verActividades();
				
			}
		});
		panelBotonActividades.add(botonActividades);
						
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		tDatos = new JTable();
	    tDatos.setFont( new Font( "Arial", Font.PLAIN, 14 ) );
	    panel_1.add(new JScrollPane(tDatos));
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
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.NORTH);
		
		JTextPane txtpnMenuAdministrador = new JTextPane();
		panel_2.add(txtpnMenuAdministrador);
		txtpnMenuAdministrador.setText("MENU ADMINISTRADOR");
		txtpnMenuAdministrador.setBackground(getForeground());
		txtpnMenuAdministrador.setFont(new Font("Consolas", Font.BOLD, 18));
		txtpnMenuAdministrador.setForeground(Color.DARK_GRAY);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.SOUTH);
		
		JPanel panelCerrar = new JPanel();
		panel_3.add(panelCerrar);
		
		JButton botonCerrarSesion = new JButton("Cerrar Sesion");
		botonCerrarSesion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new VentanaInicio();
					dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		panelCerrar.add(botonCerrarSesion);
		
		JButton botonSalir = new JButton("Salir");
		botonSalir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		
		panelCerrar.add(botonSalir);
		
		setVisible(true);
		
	}
	
	private void verActividades() {
		bd.connect();
		Vector<String> cabeceras = new Vector<String>( Arrays.asList( "Codigo", "Actividad", "Aforo", "Instructor", "Ubicacion", "Descripcion", "Imagen") );
		modeloDeDatos = new DefaultTableModel(  // Inicializa el modelo
				new Vector<Vector<Object>>(),  // Datos de la jtable (vector de vectores) - vacíos de momento
				cabeceras  // Cabeceras de la jtable
			);
		ArrayList<Actividad> actividades = bd.getActividades();
		for (Actividad a : actividades) {
			modeloDeDatos.addRow( new Object[] { a.getCodigo(), a.getNombre(), a.getAforo(), a.getInstructor(), a.getUbicacion(), a.getDescripcion(), a.getImagen()} );
		}
		tDatos.setModel(modeloDeDatos);
		// Pone tamaños a las columnas de la tabla
		tDatos.getColumnModel().getColumn(0).setMinWidth(60);
		tDatos.getColumnModel().getColumn(0).setMaxWidth(60);
		tDatos.getColumnModel().getColumn(1).setMinWidth(60);
		tDatos.getColumnModel().getColumn(1).setMaxWidth(60);
		tDatos.getColumnModel().getColumn(2).setMinWidth(35);
		tDatos.getColumnModel().getColumn(2).setMaxWidth(35);
		tDatos.getColumnModel().getColumn(3).setMinWidth(60);
		tDatos.getColumnModel().getColumn(3).setMaxWidth(60);		
		tDatos.getColumnModel().getColumn(4).setMinWidth(60);
		tDatos.getColumnModel().getColumn(4).setMaxWidth(60);
		tDatos.getColumnModel().getColumn(5).setMinWidth(65);
		tDatos.getColumnModel().getColumn(5).setMaxWidth(65);
		tDatos.getColumnModel().getColumn(6).setMinWidth(110);
		tDatos.getColumnModel().getColumn(6).setMaxWidth(110);
		
		 bd.disconnect();	
	}
	

}
