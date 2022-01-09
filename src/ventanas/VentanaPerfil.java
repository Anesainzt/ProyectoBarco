package ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

import BD.BD;
import clases.Usuario;
import javax.swing.border.EmptyBorder;

public class VentanaPerfil extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Container cp;
	protected JPanel panel,panelLabel,panelDni,panelNombre,panelApellido,panelEmail,panelUsuario,panelContrasenya,panelNcuenta,panelBotones,panelEditar,panelAceptar,panelBorrar,panelAtras;
	protected JTextField textoDni,textoNombre,textoApellido,textoEmail,textoUsuario,textoContrasenya,textoNcuenta;
	protected JLabel label,labelDni,labelNombre,labelApellido,labelEmail,labelUsuario,labelContrasenya,labelNcuenta;
	protected JButton botonEditar,botonAceptar,botonBorrar,botonAtras;
	protected BD bd = new BD();
	
	static Logger logger = Logger.getLogger(VentanaPerfil.class.getName());

	@SuppressWarnings("static-access")
	public VentanaPerfil(Usuario uActual) {
		addWindowListener( new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
            	//bd.ficheroLogger();
            }
          
        });
		
		cp = this.getContentPane();
		this.setTitle("Mi Perfil");
		//panelPrincip
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(14, 14, 14, 14));
		panel.setLayout(new GridLayout(9,1));
		
		//panelLabel
		panelLabel = new JPanel();
		label = new JLabel();
		label.setIcon(new ImageIcon("images/BETH.png"));
		
		//panelDni
		panelDni = new JPanel();
		panelDni.setLayout(new GridLayout(2,1));
		textoDni = new JTextField();
		textoDni.setPreferredSize(new Dimension (400, 25));
		textoDni.setText(uActual.getDni());
		textoDni.setEnabled(false);
		
		labelDni = new JLabel("DNI:");

		//panelNombre
		panelNombre = new JPanel();
		panelNombre.setLayout(new GridLayout(2,1));
		textoNombre = new JTextField();
		textoNombre.setPreferredSize(new Dimension (200, 25));
		textoNombre.setText(uActual.getNombre());
		textoNombre.setEnabled(false);
		
		labelNombre = new JLabel("Nombre:");
		
		//panelApellido
		panelApellido = new JPanel();
		panelApellido.setLayout(new GridLayout(2,1));
		textoApellido = new JTextField();
		textoApellido.setPreferredSize(new Dimension (200, 25));
		textoApellido.setText(uActual.getApellido());
		textoApellido.setEnabled(false);
		
		labelApellido = new JLabel("Apellido:");
		
		//panelEmail
		panelEmail = new JPanel();
		panelEmail.setLayout(new GridLayout(2,1));
		textoEmail = new JTextField();
		textoEmail.setPreferredSize(new Dimension (200, 25));
		textoEmail.setText(uActual.getEmail());
		textoEmail.setEnabled(false);
		
		labelEmail = new JLabel("Email:");
		
		//panelUsuario
		panelUsuario = new JPanel();
		panelUsuario.setLayout(new GridLayout(2,1));
		textoUsuario = new JTextField();
		textoUsuario.setPreferredSize(new Dimension (200, 25));
		textoUsuario.setText(uActual.getLogin());
		textoUsuario.setEnabled(false);
		
		labelUsuario = new JLabel("Usuario/Login:");
		
		//panelContrasenya --> visible al usuario asiq textfield normal
		panelContrasenya = new JPanel();
		panelContrasenya.setLayout(new GridLayout(2,1));
		textoContrasenya = new JTextField();
		textoContrasenya.setPreferredSize(new Dimension (200, 25));
		textoContrasenya.setText(uActual.getContrasenya());
		textoContrasenya.setEnabled(false);
		
		labelContrasenya = new JLabel("Contrasenya:");
		
		//panelNCuenta
		panelNcuenta = new JPanel();
		panelNcuenta.setLayout(new GridLayout(2,1));
		textoNcuenta = new JTextField();
		textoNcuenta.setPreferredSize(new Dimension (200, 25));
		textoNcuenta.setText(uActual.getTarjeta());
		textoNcuenta.setEnabled(false);
		
		labelNcuenta = new JLabel("Número de cuenta:");
		
		//panelBotones
		panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(2,2));
		
		//panel EDITAR perfil
		panelEditar = new JPanel();
		panelEditar.setLayout(new FlowLayout());
		botonEditar = new JButton("Editar");
		botonEditar.setPreferredSize(new Dimension(85, 25));
		botonEditar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				textoNombre.setEnabled(true);
				textoApellido.setEnabled(true);
				textoEmail.setEnabled(true);
				textoUsuario.setEnabled(true);
				textoContrasenya.setEnabled(true);
				textoNcuenta.setEnabled(true);
				
			}
		});
		
		//panel ACEPTAR
		panelAceptar = new JPanel();
		panelAceptar.setLayout(new FlowLayout());
		botonAceptar = new JButton("Aceptar");
		botonAceptar.setPreferredSize(new Dimension(85, 25));
		botonAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BD bd = new BD();
				bd.connect();
				
				String nombre = textoNombre.getText();
				String apellido = textoApellido.getText();
				String dni = textoDni.getText();
				String tarjeta = textoNcuenta.getText();
				String login = textoUsuario.getText();
				String contrasenya = textoContrasenya.getText();
				String email = textoEmail.getText();
				
				Usuario u = new Usuario(nombre, apellido, dni, tarjeta, login, contrasenya, email,0, null);
				//llamar al método
				try {
					bd.editarUsuario(u);
					textoNombre.setText(u.getNombre()); 
					textoApellido.setText(u.getApellido());
					textoDni.setText(u.getDni());
					textoNcuenta.setText(u.getTarjeta());
					textoUsuario.setText(u.getLogin());
					textoContrasenya.setText(u.getContrasenya());
					textoEmail.setText(u.getEmail());
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					logger.log(Level.INFO, "No se ha podido editar el usuario");
				}
				
			}
		});
		
		
		//panel BORRAR perfil
		panelBorrar = new JPanel();
		panelBorrar.setLayout(new FlowLayout());
		botonBorrar = new JButton("Eliminar");
		botonBorrar.setPreferredSize(new Dimension(85, 25));
		botonBorrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
                try {
                    JOptionPane.showMessageDialog(null, "¡Su perfil ha sido borrado con exito!");
                    bd.borrarUsuario(uActual);
                    try {
                        new VentanaInicio();

                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                } catch (SQLException e) {
                    logger.log( Level.INFO, "No se ha podido borrar su perfil" );
                    JOptionPane.showMessageDialog(null, "No se ha podido borrar su perfil");
                }
				
			}
		});
		
		panelAtras = new JPanel();
		panelAtras.setLayout(new FlowLayout());
		botonAtras = new JButton("Volver");
		botonAtras.setPreferredSize(new Dimension(85, 25));
		botonAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaViaje(uActual);
				dispose();				
			}
		});
		
	
		

		cp.add(panel);
		
		panel.add(panelLabel);
		panel.add(panelDni);
		panel.add(panelNombre);
		panel.add(panelApellido);
		panel.add(panelEmail);
		panel.add(panelUsuario);
		panel.add(panelContrasenya);//HACER
		panel.add(panelNcuenta);
		panel.add(panelBotones);
		
		panelLabel.add(label);
		panelDni.add(labelDni);
		panelDni.add(textoDni);
		panelNombre.add(labelNombre);
		panelNombre.add(textoNombre);
		panelApellido.add(labelApellido);
		panelApellido.add(textoApellido);
		panelEmail.add(labelEmail);
		panelEmail.add(textoEmail);
		panelUsuario.add(labelUsuario);
		panelUsuario.add(textoUsuario);
		panelContrasenya.add(labelContrasenya);
		panelContrasenya.add(textoContrasenya);
		panelNcuenta.add(labelNcuenta);
		panelNcuenta.add(textoNcuenta);
		panelBotones.add(panelEditar);
		panelBotones.add(panelAceptar);
		panelBotones.add(panelBorrar);
		panelBotones.add(panelAtras);
	
		panelEditar.add(botonEditar);
		panelAceptar.add(botonAceptar);
		panelBorrar.add(botonBorrar);
		panelAtras.add(botonAtras);
		
		setVisible(true);
		pack();
		setSize(350,630);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	
}
