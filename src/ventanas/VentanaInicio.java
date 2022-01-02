package ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.*;
import javax.swing.*;

import BD.BD;
import clases.Usuario;

public class VentanaInicio extends JFrame {

	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Container cp;
	protected JPanel panel, panelIzqda, panelDcha, panel1, panel2, panel3, panel4;
	protected JLabel labelWelcome,labelUsuario,labelContrasenya;
	public static JTextField textoUsuario;
	public static JTextField textoContrasenya;
	//protected JPasswordField textoContrasenya;
	protected JButton botonLogin, botonRegistro;
	protected static BD bd = new BD();
	
	static Logger logger = Logger.getLogger(VentanaInicio.class.getName());
	
	public VentanaInicio() throws IOException {
		
		addWindowListener( new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
            	bd.guardarLogger();
            }
          
        });
		
		//crear usuarioActual
		Usuario uActual = new Usuario();
		
		cp = this.getContentPane();
		this.setTitle("Inicio");

		//panelPrincipal
		panel = new JPanel();
		panel.setLayout(new GridLayout(1,2)); //1 fila 2 columnas
		
		
		//panelIzqda
		panelIzqda = new JPanel();
		panelIzqda.setLayout(new GridLayout(4,1));
		//panel1
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(1,11));
		panel1.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0)); //TOC

		labelWelcome = new JLabel(new ImageIcon("images/welcome.png"));
		panel1.setBackground(Color.white);
		
		//panel2
		panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		
		labelUsuario = new JLabel("Usuario:");
		textoUsuario = new JTextField();
		textoUsuario.setPreferredSize(new Dimension(200, 25));
		
		panel2.setBackground(Color.white);
		
		//panel3
		panel3 = new JPanel();
		panel3.setLayout(new FlowLayout());
		
		labelContrasenya = new JLabel("Contraseña:");
		textoContrasenya = new JPasswordField();
		textoContrasenya.setPreferredSize(new Dimension(200, 25));
		
		panel3.setBackground(Color.white);
		
		//panel4
		panel4 = new JPanel();
		panel4.setLayout(new FlowLayout());
		
		botonLogin = new JButton("Iniciar sesión");
		botonLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				bd.connect();
			
				if(bd.comprobarLogin(textoUsuario.getText(), textoContrasenya.getText())) {
					if(bd.esAdministrador(textoUsuario.getText())){
						//Ir a otra ventana que sea la parte del administrador.
						new VentanaAdministrador(bd.getuActual());
						dispose();
						
					}else {
						try {
							uActual.setLogin(textoUsuario.getText());
							new VentanaViaje(bd.getuActual());
							dispose();
						} catch (Exception e) {
							logger.log(Level.INFO, "No se ha podido abrir la ventana");//METER LA INFO DEL ERROR
						}
						
					}
					
					bd.disconnect();
				}
			}
		});
		
		botonRegistro = new JButton("Registrarme");
		botonRegistro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new VentanaRegistro();
				dispose();
				
			}
		});
		
		panel4.setBackground(Color.white);
		
		//panelDcha
		panelDcha = new JPanel();
		panelDcha.setBackground(Color.white);
		
		BufferedImage bufferedImage = ImageIO.read(new File("images/yate.jpg"));
		Image image = bufferedImage.getScaledInstance(250, 260, Image.SCALE_DEFAULT);
		JLabel label = new JLabel(new ImageIcon(image));
		 
		
		
		
		cp.add(panel);
		panel.add(panelIzqda);
		panel.add(panelDcha); 
		
		panelIzqda.add(panel1);
		panelIzqda.add(panel2);
		panelIzqda.add(panel3);
		panelIzqda.add(panel4);
		
		panelDcha.add(label);
		
		panel1.add(labelWelcome);	
		
		panel2.add(labelUsuario);
		panel2.add(textoUsuario);
		
		panel3.add(labelContrasenya);
		panel3.add(textoContrasenya);
		
		panel4.add(botonLogin);
		panel4.add(botonRegistro);
		
		setVisible(true);
		pack();
		setSize(600,310);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) throws IOException {
		new VentanaInicio();

	}

}
