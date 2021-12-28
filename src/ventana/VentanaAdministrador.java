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

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTable tDatos;
	DefaultTableModel modeloDeDatos;
	JPanel panelCentral, panelCentralAdmin, panelTitbot, panelbotonUsuarios, panelBotonActividades, panel_1, panelTitulo, panelAbajo, panelOpciones;
	JButton botonUsuarios, botonActividades, botonCerrarSesion, btnAñadirAct, btnQuitarAct, botonSalir;
	JTextPane txtpnMenuAdministrador;
	 
	BD bd = new BD();
	
	public VentanaAdministrador(Usuario uActual) {
		
		setSize(600,400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	
		
		panelCentral = new JPanel();
		panelCentral.setLayout(new GridLayout(1,2)); 
				
		panelCentralAdmin = new JPanel();
		panelTitbot = new JPanel();
		
		panelTitbot.setLayout(new GridLayout(3,1)); 
		
		panelbotonUsuarios = new JPanel();
		
		botonUsuarios = new JButton("Usuarios Registrados");
		botonUsuarios.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				verUsuarios();
				btnAñadirAct.setEnabled(false);
				btnQuitarAct.setEnabled(false);
				
			}
		});

		panelBotonActividades = new JPanel();
		
		botonActividades = new JButton("Actividades Ofrecidas");
		botonActividades.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				verActividades();
				btnAñadirAct.setEnabled(true);
				btnQuitarAct.setEnabled(true);
				
			}
		});
						
		panel_1 = new JPanel();
		
		tDatos = new JTable();
	    tDatos.setFont( new Font( "Arial", Font.PLAIN, 14 ) );
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
		
	    panelTitulo = new JPanel();
		
		txtpnMenuAdministrador = new JTextPane();
		txtpnMenuAdministrador.setText("MENU ADMINISTRADOR");
		txtpnMenuAdministrador.setBackground(getForeground());
		txtpnMenuAdministrador.setFont(new Font("Consolas", Font.BOLD, 18));
		txtpnMenuAdministrador.setForeground(Color.DARK_GRAY);
		
		panelAbajo = new JPanel();
		
		panelOpciones = new JPanel();
		botonCerrarSesion = new JButton("Cerrar Sesion");
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
		
		btnAñadirAct = new JButton("Añadir Actividad");
		btnQuitarAct = new JButton("Quitar Actividad");
		
		botonSalir = new JButton("Salir");
		botonSalir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		contentPane.add(panelTitulo, BorderLayout.NORTH);
		contentPane.add(panelCentral);
		contentPane.add(panelAbajo, BorderLayout.SOUTH);
		
		panelTitulo.add(txtpnMenuAdministrador);
		
		panelCentral.add(panelCentralAdmin);
		
		panelCentralAdmin.add(panelTitbot);
		panelCentralAdmin.add(panelbotonUsuarios);
		panelCentralAdmin.add(panelBotonActividades);
		panelCentralAdmin.add(panel_1);
		
		panelbotonUsuarios.add(botonUsuarios);
		panelBotonActividades.add(botonActividades);
		panel_1.add(new JScrollPane(tDatos));
		
		panelAbajo.add(panelOpciones);
		
		panelOpciones.add(btnAñadirAct);
		panelOpciones.add(btnQuitarAct);
		btnAñadirAct.setEnabled(false);
		btnQuitarAct.setEnabled(false);
		
		panelOpciones.add(botonCerrarSesion);
		panelOpciones.add(botonSalir);
		
		setVisible(true);
		
	}
	
	private void verActividades() {
		
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
		
	}
	private void verUsuarios() {
		
		Vector<String> cabeceras = new Vector<String>( Arrays.asList( "Nombre", "Apellido", "Dni", "Tarjeta", "Login", "Contrasenya", "Email") );
		modeloDeDatos = new DefaultTableModel(  // Inicializa el modelo
				new Vector<Vector<Object>>(),  // Datos de la jtable (vector de vectores) - vacíos de momento
				cabeceras  // Cabeceras de la jtable
			);
		ArrayList<Usuario> usuarios = bd.getUsuarios();
		for (Usuario u : usuarios) {
			modeloDeDatos.addRow( new Object[] { u.getNombre(), u.getApellido(), u.getDni(), u.getTarjeta(), u.getLogin(), u.getContrasenya(), u.getEmail()} );
		}
		tDatos.setModel(modeloDeDatos);
		// Pone tamaños a las columnas de la tabla
		tDatos.getColumnModel().getColumn(0).setMinWidth(50);
		tDatos.getColumnModel().getColumn(0).setMaxWidth(50);
		tDatos.getColumnModel().getColumn(1).setMinWidth(55);
		tDatos.getColumnModel().getColumn(1).setMaxWidth(55);
		tDatos.getColumnModel().getColumn(2).setMinWidth(60);
		tDatos.getColumnModel().getColumn(2).setMaxWidth(60);
		tDatos.getColumnModel().getColumn(3).setMinWidth(60);
		tDatos.getColumnModel().getColumn(3).setMaxWidth(60);		
		tDatos.getColumnModel().getColumn(4).setMinWidth(60);
		tDatos.getColumnModel().getColumn(4).setMaxWidth(60);
		tDatos.getColumnModel().getColumn(5).setMinWidth(60);
		tDatos.getColumnModel().getColumn(5).setMaxWidth(60);
		tDatos.getColumnModel().getColumn(6).setMinWidth(110);
		tDatos.getColumnModel().getColumn(6).setMaxWidth(110);
		
	}
	

}
