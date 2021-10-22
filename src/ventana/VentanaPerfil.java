package ventana;

import java.awt.*;
import javax.swing.*;

public class VentanaPerfil extends JFrame {

	protected Container cp;
	protected JPanel panel,panelLabel,panelDni,panelNombre,panelApellido,panelEmail,panelUsuario,panelContrasenya,panelNcuenta,panelBotones;
	protected JTextField textoDni,textoNombre,textoApellido,textoEmail,textoUsuario,textoContrasenya,textoNcuenta;
	protected JLabel label;
	protected JButton botonEditar,botonAceptar;

	public VentanaPerfil() {

		cp = this.getContentPane();
		this.setTitle("Mi Perfil");
		//panelPrincip
		panel = new JPanel();
		panel.setLayout(new GridLayout(9,1));
		
		//panelLabel
		panelLabel = new JPanel();
		label = new JLabel("A continuación puede ver su información personal:");
		
		//panelDni
		panelDni = new JPanel();
		textoDni = new JTextField();
		textoDni.setPreferredSize(new Dimension (200, 25));
		
		//panelNombre
		panelNombre = new JPanel();
		textoNombre = new JTextField();
		textoNombre.setPreferredSize(new Dimension (200, 25));
		
		//panelApellido
		panelApellido = new JPanel();
		textoApellido = new JTextField();
		textoApellido.setPreferredSize(new Dimension (200, 25));
		
		//panelEmail
		panelEmail = new JPanel();
		textoEmail = new JTextField();
		textoEmail.setPreferredSize(new Dimension (200, 25));
		
		//panelUsuario
		panelUsuario = new JPanel();
		textoUsuario = new JTextField();
		textoUsuario.setPreferredSize(new Dimension (200, 25));
		
		//panelContrasenya --> visible al usuario asiq textfield normal
		panelContrasenya = new JPanel();
		textoContrasenya = new JTextField();
		textoContrasenya.setPreferredSize(new Dimension (200, 25));
		
		//panelNCuenta
		panelNcuenta = new JPanel();
		textoNcuenta = new JTextField();
		textoNcuenta.setPreferredSize(new Dimension (200, 25));
		
		//panelBotones
		panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(1,2));
		
		botonEditar = new JButton("Editar");
		botonAceptar = new JButton("Aceptar");
	
		

		cp.add(panel);
		
		panel.add(panelLabel);
		panel.add(panelDni);
		panel.add(panelNombre);
		panel.add(panelApellido);
		panel.add(panelEmail);
		panel.add(panelUsuario);
		panel.add(panelNcuenta);
		panel.add(panelBotones);
		
		panelLabel.add(label);
		panelDni.add(textoDni);
		panelNombre.add(textoNombre);
		panelApellido.add(textoApellido);
		panelEmail.add(textoEmail);
		panelUsuario.add(textoUsuario);
		panelContrasenya.add(textoContrasenya);
		panelNcuenta.add(textoNcuenta);
		panelBotones.add(botonEditar);
		panelBotones.add(botonAceptar);
		
		setVisible(true);
		pack();
		setSize(350,550);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new VentanaPerfil();

	}

}
