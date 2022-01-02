package ventanas;

import javax.swing.*;

import BD.BD;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class VentanaTicket extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Container cp;
    private JPanel panelPrincipal;
    BD bd = new BD();

    public VentanaTicket(){
    	 addWindowListener( new WindowAdapter() {
             @Override
             public void windowOpened(WindowEvent e) {
            	 bd.ficheroLogger();
             }

         });

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
    
}
