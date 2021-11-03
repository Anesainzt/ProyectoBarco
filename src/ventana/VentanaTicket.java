package ventana;

import javax.swing.*;
import java.awt.*;

public class VentanaTicket extends JFrame {

    private Container cp;
    private JPanel panelPrincipal;

    public VentanaTicket(){

        cp = this.getContentPane();
        this.setTitle("Ticket");
        this.setSize(1000, 600);
        
        panelPrincipal = new JPanel(new GridLayout(3, 1));
        panelPrincipal.setSize(1000, 2000);

        JLabel labelTexto = new JLabel("¿Como quiere recibir el billete?");
        JButton botonCorreo = new JButton("Correo");
        JButton botonImprimir = new JButton("Imprimir");

        cp.add(panelPrincipal);
        panelPrincipal.add(labelTexto);
        panelPrincipal.add(botonCorreo);
        panelPrincipal.add(botonImprimir);

        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static void main(String[] args) {
		new VentanaTicket();

	}
    
}
