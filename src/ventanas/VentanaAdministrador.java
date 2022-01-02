package ventanas;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import BD.BD;
import clases.Actividad;
import clases.Usuario;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;

public class VentanaAdministrador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTable tDatos;
	DefaultTableModel modeloDeDatos;
	JPanel panelCentral, panelCentralAdmin, panelTitbot, panelbotonUsuarios, panelBotonActividades, panel_1, panelTitulo, panelAbajo, panelOpciones;
	JButton botonUsuarios, botonActividades, botonCerrarSesion, btnAñadirAct, btnQuitarAct, botonSalir;
	JTextPane txtpnMenuAdministrador;
	static Logger logger = Logger.getLogger( "VentanaAdministrador" );
	 
	BD bd = new BD();
	
	public VentanaAdministrador(Usuario uActual) {
		
		setSize(700,500);
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
            	bd.ficheroLogger();
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
		txtpnMenuAdministrador.setEditable(false);
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
					logger.log( Level.INFO, "No se ha podido cargar la VentanaInicio" );
				}
				
			}
			
		});
		
		btnAñadirAct = new JButton("Añadir Actividad");
		btnQuitarAct = new JButton("Quitar Actividad");
		btnQuitarAct.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				bd.connect();
				int fill = tDatos.getSelectedRow();
				if(fill!=-1) {
					String codi = (String) modeloDeDatos.getValueAt(fill, 0);
					try {
						bd.borrarActividad(codi);
					} catch (SQLException e1) {
						logger.log( Level.INFO, "No se ha podido borrar la actividad de la tabla" );
					}
					modeloDeDatos.removeRow(fill);
					
				}
				bd.disconnect();
				
				
			}
			
		});
		
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
		JScrollPane scrollPane = new JScrollPane(tDatos);
		panel_1.add(scrollPane);
		
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
		bd.connect();
		Vector<String> cabeceras = new Vector<String>( Arrays.asList( "Codigo", "Actividad", "Aforo", "Instructor", "Ubicacion", "Descripcion", "Imagen") );
		modeloDeDatos = new DefaultTableModel(  // Inicializa el modelo
				new Vector<Vector<Object>>(),  // Datos de la jtable (vector de vectores) - vacíos de momento
				cabeceras  // Cabeceras de la jtable
			){
			public boolean isCellEditable(int row, int column) {
				if(column==0)
					return false;
				return true;
			}
		};
		ArrayList<Actividad> actividades = bd.getActividades();
		for (Actividad a : actividades) {
			modeloDeDatos.addRow( new Object[] { a.getCodigo(), a.getNombre(), a.getAforo(), a.getInstructor(), a.getUbicacion(), a.getDescripcion(), a.getImagen()} );
		}
		tDatos.setModel(modeloDeDatos);
		
		tDatos.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				
				int fil = e.getFirstRow();
				String cod = (String) modeloDeDatos.getValueAt(fil, 0);
				String nombre = (String) modeloDeDatos.getValueAt(fil, 1);
				int aforo = (int) modeloDeDatos.getValueAt(fil, 2);
				String instructor = (String) modeloDeDatos.getValueAt(fil, 3);
				String ubicacion = (String) modeloDeDatos.getValueAt(fil, 4);
				String descripcion = (String) modeloDeDatos.getValueAt(fil, 5);
				String imagen = (String) modeloDeDatos.getValueAt(fil, 6);
				
				try {
					bd.modificarActividad(cod, nombre, aforo, instructor, ubicacion, descripcion, imagen);
				} catch (SQLException e1) {
					logger.log( Level.INFO, "No se ha podido modificar la actividad" );
				}
			}
		});
		
		
		
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
	private void verUsuarios() {
		bd.connect();
		Vector<String> cabeceras = new Vector<String>( Arrays.asList( "Nombre", "Apellido", "Dni", "Tarjeta", "Login", "Contrasenya", "Email", "Administrador") );
		modeloDeDatos = new DefaultTableModel(  // Inicializa el modelo
				new Vector<Vector<Object>>(),  // Datos de la jtable (vector de vectores) - vacíos de momento
				cabeceras  // Cabeceras de la jtable
			){
			public boolean isCellEditable(int row, int column) {
				if(column==7)
					return false;
				return true;
			}
		};
		ArrayList<Usuario> usuarios = bd.getUsuarios();
		for (Usuario u : usuarios) {
			modeloDeDatos.addRow( new Object[] { u.getNombre(), u.getApellido(), u.getDni(), u.getTarjeta(), u.getLogin(), u.getContrasenya(), u.getEmail(), u.getAdministrador()} );
		}
		tDatos.setModel(modeloDeDatos);
		
		tDatos.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				 bd.connect();
				int fil = e.getFirstRow();
				String nom = (String) modeloDeDatos.getValueAt(fil, 0);
				String apellido = (String) modeloDeDatos.getValueAt(fil, 1);
				String dni = (String) modeloDeDatos.getValueAt(fil, 2);
				String tarjeta = (String) modeloDeDatos.getValueAt(fil, 3);
				String login = (String) modeloDeDatos.getValueAt(fil, 4);
				String contrasenya = (String) modeloDeDatos.getValueAt(fil, 5);
				String email = (String) modeloDeDatos.getValueAt(fil, 6);
				
				try {
					bd.modificarUsuario(nom, apellido, dni, tarjeta, login, contrasenya, email);
				} catch (SQLException e1) {
					logger.log( Level.INFO, "No se ha podido modificar el usuario" );
				}
				bd.disconnect();
			}
		});
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
		tDatos.getColumnModel().getColumn(5).setMinWidth(30);
		tDatos.getColumnModel().getColumn(5).setMaxWidth(30);
		tDatos.getColumnModel().getColumn(6).setMinWidth(100);
		tDatos.getColumnModel().getColumn(6).setMaxWidth(100);
		tDatos.getColumnModel().getColumn(7).setMinWidth(40);
		tDatos.getColumnModel().getColumn(7).setMaxWidth(40);
		bd.disconnect();
		
	}
}