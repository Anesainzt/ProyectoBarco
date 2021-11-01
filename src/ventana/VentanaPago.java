package ventana;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class VentanaPago extends JFrame{

    private Container cp;
    private JPanel panelPrincipal;

    public VentanaPago() {

        cp = this.getContentPane();
        this.setTitle("Prueba");
        this.setSize(1000, 600);

        panelPrincipal = new JPanel(new GridLayout(0, 2));
        panelPrincipal.setSize(1000, 600);

        JLabel labelContraseña1 = new JLabel("Introduzca la contraseña: ");
        JTextField textContraseña1 = new JPasswordField();
        JLabel labelContraseña2 = new JLabel("Vuelva a introducir la contraseña: ");
        JTextField textContraseña2 = new JPasswordField();
        JButton botonAceptar = new JButton("Aceptar");
        //textContraseña2.setPreferredSize(new Dimension (200, 25));
        //labelContraseña1.setSize(10, 20);

        panelPrincipal.add(labelContraseña1);
        panelPrincipal.add(textContraseña1);
        panelPrincipal.add(labelContraseña2);
        panelPrincipal.add(textContraseña2);
        panelPrincipal.add(botonAceptar);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(panelPrincipal);
        panelPrincipal.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
		new VentanaPago();
	}
}
