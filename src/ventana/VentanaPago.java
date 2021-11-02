package ventana;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class VentanaPago extends JFrame{

    private Container cp;
    private JPanel panelPrincipal;
    private JPanel panelDerecha;
    private JPanel panelIzquierda;

    public VentanaPago() {

        cp = this.getContentPane();
        this.setTitle("Pago");
        this.setSize(1000, 600);

        panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setSize(1000, 600);

        panelDerecha = new JPanel(new GridLayout(6, 1));
        panelIzquierda = new JPanel(new GridLayout(3, 1));

        JLabel labelTicket = new JLabel("Ticket");
        labelTicket.setFont(new Font("Serif", Font.PLAIN, 30));
        JLabel labelPrueba = new JLabel("Prueba");
        JButton botonCancelar = new JButton("Cancelar");

        JLabel labelCuenta = new JLabel("numCuenta");
        JLabel labelContraseña1 = new JLabel("Introduzca la contraseña: ");
        JTextField textContraseña1 = new JPasswordField();
        JLabel labelContraseña2 = new JLabel("Vuelva a introducir la contraseña: ");
        JTextField textContraseña2 = new JPasswordField();
        JButton botonAceptar = new JButton("Aceptar");


        //textContraseña2.setPreferredSize(new Dimension (200, 25));
        //textContraseña2.setPreferredSize(new Dimension (200, 25));
        //labelContraseña1.setSize(10, 20);

        panelIzquierda.add(labelTicket);
        panelIzquierda.add(labelPrueba);
        panelIzquierda.add(botonCancelar);

        panelDerecha.add(labelCuenta);
        panelDerecha.add(labelContraseña1);
        panelDerecha.add(textContraseña1);
        panelDerecha.add(labelContraseña2);
        panelDerecha.add(textContraseña2);
        panelDerecha.add(botonAceptar);

        panelPrincipal.add(panelDerecha, BorderLayout.EAST);
        panelPrincipal.add(panelIzquierda, BorderLayout.WEST);

        cp.add(panelPrincipal);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();
    }

    public static void main(String[] args) throws IOException {
		new VentanaPago();
	}
}
