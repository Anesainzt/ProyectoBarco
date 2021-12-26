package ventana;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Usuario;

import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class VentanaAdministrador extends JFrame {

	private JPanel contentPane;
	
	public VentanaAdministrador(Usuario uActual) {
		
		setSize(400,320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelGeneral = new JPanel();

		panelGeneral.setLayout(new GridLayout(2,1)); 
		JPanel panelTitbot = new JPanel();

		panelTitbot.setLayout(new GridLayout(3,1)); 
		
		contentPane.add(panelGeneral);
		
		panelGeneral.add(panelTitbot);
		
		JPanel panelTitulo = new JPanel();
		panelTitbot.add(panelTitulo);
		
		JTextPane txtpnMenuAdministrador = new JTextPane();
		panelTitulo.add(txtpnMenuAdministrador);
		txtpnMenuAdministrador.setText("MENU ADMINISTRADOR");
		txtpnMenuAdministrador.setBackground(getForeground());
		txtpnMenuAdministrador.setFont(new Font("Consolas", Font.BOLD, 18));
		txtpnMenuAdministrador.setForeground(Color.DARK_GRAY);
		
		JPanel panelbotonUsuarios = new JPanel();
		panelTitbot.add(panelbotonUsuarios);
		
		JButton botonUsuarios = new JButton("Usuarios Registrados");
		panelbotonUsuarios.add(botonUsuarios);
		
		JPanel panelBotonActividades = new JPanel();
		panelTitbot.add(panelBotonActividades);
		
		JButton botonActividades = new JButton("Actividades Ofrecidas");
		botonActividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelBotonActividades.add(botonActividades);
		
		JPanel panelCerrar = new JPanel();
		panelGeneral.add(panelCerrar);
		
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
	

}
